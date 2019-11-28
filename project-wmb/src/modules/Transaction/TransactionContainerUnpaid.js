import React from 'react'
import { Switch, Route } from 'react-router-dom';
import ListTransUnpaid from './ListTransaction/ListTransactionUnpaid.js';

import DetailTransaction from './DetailTransaction/DetailTransaction';
class TransactionContainerUnpaid extends React.Component{
    render(){
        return(
            <div >
                {/* <CardTransaction> */}
                    <Switch>
                        
                    <Route path="/trans/unpaid/:id" component={DetailTransaction}/>
                    <Route path="/trans/unpaid" component={ListTransUnpaid}/>
                        


                    </Switch>
                    {/* </CardTransaction> */}

            </div>
        );
    }
}
export default TransactionContainerUnpaid;