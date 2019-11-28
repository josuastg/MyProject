import React from 'react';
import { Switch, Route } from 'react-router-dom';
import ListOrder from './ListOrder/ListOrder';
import './OrderContainer.css';
import AddOrder from './AddOrder/AddOrder.js';
import ListDrink from '../Menu/Drink/ListDrink/ListDrink';
import ListFood from '../Menu/Food/ListFood/ListFood';
class OrderContainer extends React.Component {
    render() {
        return (


            <div className="order-ctr">
                <h3>List Food</h3>
                <ListFood />
                <h3>List Drink </h3>
                <ListDrink />
                <div>
                    <AddOrder />
                </div>
                <div>
                    <Switch>
                        <Route path="/order" component={ListOrder} />

                        {/* <Route path="/order/:id" component={SearchOrder} /> */}
                    </Switch>
                </div>
            </div>
        )
    }
}

export default OrderContainer;