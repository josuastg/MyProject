import React from 'react'
import { Switch, Route } from 'react-router-dom';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import DeskReducer from './reducer/DeskReducer.js';
import ListDesk from './ListDesk/ListDesk.js';

class DeskContainer extends React.Component {
    render() {
        console.log('MENU CONTAINER');
        return (
            <div>

                <div>
                    <Switch>
                        <Route path="/desk" component={ListDesk} />
                    </Switch>

                </div>

            </div>
        );
    }
}
export default DeskContainer;