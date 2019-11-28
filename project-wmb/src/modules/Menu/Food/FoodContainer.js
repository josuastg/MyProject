import React from 'react'
import { Switch, Route } from 'react-router-dom';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import FoodReducer from './reducer/FoodReducer';
import ListFood from './ListFood/ListFood';
import './Food.css';

class FoodContainer extends React.Component {
    render() {
        console.log('MENU CONTAINER');
        return (
            <div className="cardfood">
                <Switch>
                    <Route path="/food" component={ListFood} />
                </Switch>
            </div>
        );
    }
}
export default FoodContainer;