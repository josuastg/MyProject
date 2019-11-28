import React from 'react'
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import * as TransactionServices from '../Services/TransactionServices'; //import semua yg ada di userlist
import ListTransactions from './ListTransaction.css'
import Button from '@material-ui/core/Button';

import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import { Paper, Tab } from '@material-ui/core';
class ListTransactionUnpaid extends React.Component {
    //componentDidMount
    loadTransactions() {
        console.log('loadtransunpaid');
        const { dispatch } = this.props;
        let id = this.props.match.params.id;
        dispatch({ type: 'FETCH_TRANSACTION' });
        TransactionServices.listUnpaid()
            .then((transactions2) => {
                // const { data : foods }= response;
                dispatch({ type: 'FETCH_TRANSACTION_DONE_UNPAID', loading2: false, transactions2 })
            })
            TransactionServices.patchPay(id)
            .then((trans)=>{
             alert('Payment Succesfull') // dispatch({type : 'FETCH_PATCH_TRANSACTION', trans})
              
            })
            .catch((error) => {
                dispatch({ type: 'FETCH_TRANSACTION_DONE_UNPAID', loading2: false, transactions2: [] });
            });
    }


    handleChange() {

    }

    componentDidMount() {
        console.log('CDM TRANS UNPAID')
        if (this.props.loading2) {
            this.loadTransactions();
        }
    }


    renderTransRows(transactions2) {
        return transactions2.map((trans) => {
            return (
                trans.orders.map((det)=>{
                    return(
                        
                <TableRow key={trans.id}>
                    <TableCell>{trans.id}</TableCell>
                    <TableCell>{trans.name}</TableCell>
                    <TableCell>{trans.qty_customer}</TableCell>
                    <TableCell>{trans.date}</TableCell>
                    <TableCell>{trans.total}</TableCell>
                    <TableCell>{trans.status}</TableCell>
                    <TableCell>{trans.tables.name}</TableCell>
                    <TableCell>{det.qty_foods}</TableCell>
                    <TableCell>{det.qty_drinks}</TableCell>
                 <TableCell><Link to={`/trans/unpaid/${trans.id}`}><Button variant="contained">Pay</Button> </Link></TableCell>

                  
                </TableRow>
                      
                );
            })
            );
        });
    }
    render() {
        console.log('renderTransactionsunpaid')
        const { transactions2, loading2 } = this.props;
        let rows = (<tr><td colSpan={5}>LOADING...</td></tr>);

        if (!loading2) {
            rows = this.renderTransRows(transactions2);
        }


        return (
            <div>
                {/*                 
                <button className="button" onClick={()=> this.foods()}>Reload</button> */}
                <br />
                <br />
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell>PIC Customer</TableCell>
                            <TableCell>Qty_customer</TableCell>
                            <TableCell>Date</TableCell>
                            <TableCell>Total</TableCell>
                            <TableCell>Status</TableCell>
                            <TableCell>Desk ID</TableCell>
                            <TableCell>Qty Foods</TableCell>
                            <TableCell>Qty Drinks</TableCell>
                            <TableCell>Action</TableCell>
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
    return { ...state.Transaction };
}
export default connect(mapStateToProps)(ListTransactionUnpaid);