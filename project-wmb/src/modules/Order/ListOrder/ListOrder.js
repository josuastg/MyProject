import React from 'react'
import { connect } from 'react-redux';
import listOrders from './ListOrder.css'
import * as OrderServices from '../OrderServices/OrderServices.js'; //import semua yg ada di userlist
import { TableCell, TableRow, Paper, Table, TableHead, TableBody } from '@material-ui/core';
import AddOrder from '../AddOrder/AddOrder';
import FormAdd from '../Add/FormAdd';
class ListOrder extends React.Component {
    //componentDidMount
    loadOrder() {
        console.log('loadorders');
        const { dispatch } = this.props;

        dispatch({ type: 'FETCH_ORDERS' });
        OrderServices.listOrder()
            .then((orders) => {
                // const { data : foods }= response;
                dispatch({ type: 'FETCH_ORDERS_DONE', loading: false, orders })
            })
            .catch((error) => {
                dispatch({ type: 'FETCH_ORDERS_DONE', loading: false, orders: [] });
            });
    }

    componentDidMount() {
        console.log('CDM ORDERS')
        if (this.props.loading) {
            this.loadOrder();
        }
    }


    renderOrderRows(orders) {
        return orders.map((order) => {
            return (

                <TableRow key={order.id}>
                    <TableCell>{order.id}</TableCell>
                    <TableCell>{order.foods.name}</TableCell>
                    <TableCell>{order.foods.price}</TableCell>
                    <TableCell>{order.qty_foods}</TableCell>
                    <TableCell>{order.drinks.name}</TableCell>
                    <TableCell>{order.drinks.price}</TableCell>
                    <TableCell>{order.qty_drinks}</TableCell>
                    <TableCell>{order.subTotal}</TableCell>
                </TableRow>
            );
        });
    }
    render() {
        console.log('renderOrder')
        const { orders, loading } = this.props;
        let rows = (<tr><td colSpan={5}>LOADING...</td></tr>);

        if (!loading) {
            rows = this.renderOrderRows(orders);
        }


        return (
            <div>
                <h3> List Order </h3>
                {/*                   
                <button className="button" onClick={()=> this.foods()}>Reload</button> */}
                {/* <FormAdd/> */}
                    <Table className="listorder">
                        <TableHead>
                            <TableRow>
                                <TableCell>ID</TableCell>
                                <TableCell>Food</TableCell>
                                <TableCell>Food Price</TableCell>
                                <TableCell>Qty Food</TableCell>
                                <TableCell>Drink</TableCell>
                                <TableCell>Drink Price</TableCell>
                                <TableCell>Qty Drink</TableCell>
                                <TableCell>Subtotal</TableCell>
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
    return { ...state.Order };
}
export default connect(mapStateToProps)(ListOrder);