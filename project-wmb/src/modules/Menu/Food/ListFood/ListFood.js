import React from 'react'
import { connect } from 'react-redux';
import * as FoodServices from '../FoodService/FoodService.js'; //import semua yg ada di userlist
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import './ListFood.css';
// import '../ListFood/';

import TableRow from '@material-ui/core/TableRow';
import { Paper, Button, TextField } from '@material-ui/core';




class ListFood extends React.Component {
    //componentDidMount

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
                        {/* <TableCell><Button onClick={e => this.props.dispatch({ type: "FETCH_FOOD", food })}>Choose</Button></TableCell> */}
                    </TableRow>
                    
                );
            });
        }
    render() {
        console.log('renderfood')
        const { foods, loading } = this.props;
        let rows = (<tr><td colSpan={5}>LOADING...</td></tr>);

        if (!loading) {
            rows = this.renderFoodRows(foods);
        }


        return (
            <div className="listfood">
                {/*                 
                <button className="button" onClick={()=> this.foods()}>Reload</button> */}
                <Table >
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell>Name</TableCell>
                            <TableCell>Price</TableCell>
                            <TableCell>Stock</TableCell>
                            {/* <TableCell>Action</TableCell> */}
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows}
                    </TableBody>
                </Table>
                {/* <div>   
                    <Button color="inherit" variant="outlined"> Save </Button>
                </div> */}
            </div>
        );
    }
}

function mapStateToProps(state) {
    return { ...state.Food };
}
export default connect(mapStateToProps)(ListFood);