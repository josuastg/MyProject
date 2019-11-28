import React from 'react'
import { connect } from 'react-redux';
import * as DrinkServices from '../DrinkService/DrinkServices.js'; //import semua yg ada di userlist
import ListDrinks from './ListDrink.css'
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import { Paper, Button, TextField } from '@material-ui/core';
class ListDrink extends React.Component {
    //componentDidMount
    loadFood() {
        console.log('loaddrink');
        const { dispatch } = this.props;

        dispatch({ type: 'FETCH_DRINKS' });
        DrinkServices.listDrink()
            .then((drinks) => {
                // const { data : foods }= response;
                dispatch({ type: 'FETCH_DRINKS_DONE', loading: false, drinks })
            })
            .catch((error) => {
                dispatch({ type: 'FETCH_DRINKS_DONE', loading: false, drinks: [] });
            });
    }

    componentDidMount() {
        console.log('CDM DRINK')
        if (this.props.loading) {
            this.loadFood();
        }
    }


    renderDrinksRows(drinks) {
        return drinks.map((drink) => {
            return (

                <TableRow key={drink.id}>
                    <TableCell>{drink.id}</TableCell>
                    <TableCell>{drink.name}</TableCell>
                    <TableCell>{drink.price}</TableCell>
                    <TableCell>{drink.stock}</TableCell>
                    {/* <TableCell><Button onClick={e => this.props.dispatch({ type: "FETCH_DRINK", drink })}>Choose</Button>
                    </TableCell> */}
                </TableRow>
            );
        });
    }
    render() {
        console.log('renderdrink')
        const { drinks, loading } = this.props;
        let rows = (<tr><td colSpan={5}>LOADING...</td></tr>);

        if (!loading) {
            rows = this.renderDrinksRows(drinks);
        }


        return (
            <div>
                {/*                 

    
                <button className="button" onClick={()=> this.foods()}>Reload</button> */}
                <Table className="tableDrink">
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
            </div>
        );
    }
}

function mapStateToProps(state) {
    return { ...state.Drink };
}
export default connect(mapStateToProps)(ListDrink);