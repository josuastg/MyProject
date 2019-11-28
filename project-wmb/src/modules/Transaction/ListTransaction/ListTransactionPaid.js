import React from 'react'
import {Link} from 'react-router-dom';
import {connect} from 'react-redux';
import * as TransactionServices from '../Services/TransactionServices'; //import semua yg ada di userlist
import ListTransactions from './ListTransaction.css'
import Button from '@material-ui/core/Button';

import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import { Paper, Tab } from '@material-ui/core';
class ListTransactionPaid extends React.Component{
  //componentDidMount
       loadTransactions(){
           console.log('load transactions');
            const {dispatch} = this.props;

            dispatch({type: 'FETCH_TRANSACTION'});
           TransactionServices.listPaid()
            .then((transactions)=>{
                // const { data : foods }= response;
                dispatch({type: 'FETCH_TRANSACTION_DONE', loading: false,transactions })
            })
            .catch((error)=> {
                dispatch({type: 'FETCH_TRANSACTION_DONE', loading: false, transactions: []});
            });
        }


        handleChange(){

        }
    
        componentDidMount(){ 
            console.log('CDM TRANSACTION PAID')   
            if(this.props.loading){
                this.loadTransactions();
            }
        }
    

    renderTransRows(transactions){
        return transactions.map((trans)=> {
            return (
                
                <TableRow key={trans.id}>
                    <TableCell>{trans.id}</TableCell>
                    <TableCell>{trans.name}</TableCell>
            <TableCell>{trans.qty_customer}</TableCell>
                    <TableCell>{trans.date}</TableCell>
                    <TableCell>{trans.total}</TableCell>
                    <TableCell>{trans.status}</TableCell>
                </TableRow>
            );
        });
    }
    render() {
        console.log('renderTransactions')
        const {transactions, loading } = this.props;
        let rows =(<tr><td colSpan={5}>LOADING...</td></tr>);

        if(!loading) {
            rows = this.renderTransRows(transactions);
        }

       
        return (
            <div>
{/*              
                <button className="button" onClick={()=> this.foods()}>Reload</button> */}
                <br/>
                <br/>
                <Table>
                <TableHead>
                    <TableRow>
                        <TableCell>ID</TableCell>
                        <TableCell>PIC Customer</TableCell>
                        <TableCell>Qty_customer</TableCell>
                        <TableCell>Date</TableCell>
                        <TableCell>Total</TableCell>
                        <TableCell>Status</TableCell>
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

function mapStateToProps(state){
    return {...state.Transaction};
}
export default connect (mapStateToProps) (ListTransactionPaid);