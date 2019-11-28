import React from 'react'
import {Provider} from 'react-redux';
import {createStore} from 'redux';
import { Switch, Route } from 'react-router-dom';
import './Transaction.css';
import ListTransUnpaid from './ListTransaction/ListTransactionUnpaid.js';
import ListTransPaid from './ListTransaction/ListTransactionPaid.js';

import DetailTransaction from './DetailTransaction/DetailTransaction';
class Transaction extends React.Component{
    render(){
        return(
            <div className="paid">
                {/* <CardTransaction> */}
                    <Switch>   
                    <Route path="/trans/unpaid/:id" component={DetailTransaction}/>
                    <Route path="/trans/unpaid" component={ListTransUnpaid}/>
                    <Route path="/trans" component={ListTransPaid}/>
                    </Switch>
                    {/* </CardTransaction> */}
            </div>
        );
    }
}
export default Transaction;