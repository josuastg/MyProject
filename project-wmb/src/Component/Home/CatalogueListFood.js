import React, { Component } from 'react';
import { connect } from 'react-redux';

function mapStateToProps(state) {
    return {...state.Food};
}

class CatalogueListFood extends Component {

    loadFood() {
        console.log('loadfood');
        const { dispatch } = this.props;

        dispatch({ type: 'FETCH_FOODS' });
        FoodServices.listFood()
            .then((foods) => {
                // const { data : foods }= response;
                dispatch({ type: 'FETCH_FOODS_DONE', loading: false, foods })
            })
            .catch((error) => {
                dispatch({ type: 'FETCH_FOODS_DONE', loading: false, foods: [] });
            });
    }
    componentDidMount() {
        console.log('CDM FOOD')
        if (this.props.loading) {
            this.loadFood();
        }
    }
    renderFoodRows(foods) {

        return foods.map((food) => {
            return (

                <TableRow key={food.id}>
                    <TableCell>{food.id}</TableCell>
                    <TableCell>{food.name}</TableCell>
                    <TableCell>{food.price}</TableCell>
                    <TableCell>{food.stock}</TableCell>
                    <TableCell><Button onClick={e => this.props.dispatch({ type: "FETCH_FOOD", food })}>Choose</Button></TableCell>
                </TableRow>
                
            );
        });
    }   

    render() {
        return (
            <div>
                
            </div>
        );
    }
}

export default connect(mapStateToProps)(CatalogueListFood);