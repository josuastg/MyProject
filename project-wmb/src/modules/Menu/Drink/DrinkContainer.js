import React from 'react'
import { Switch, Route } from 'react-router-dom';
import ListDrink from './ListDrink/ListDrink';
import './Drink.css';

class DrinkContainer extends React.Component {
    render() {
        console.log('MENU CONTAINER');
        return (
            <div className="carddrink">
                <Switch>
                    <Route path="/drink" component={ListDrink} />
                </Switch>
            </div>
        );
    }
}
export default DrinkContainer;