import React from 'react';
import { Route, Link, BrowserRouter as Router, Switch } from 'react-router-dom'
import './App.css';
import Transaction from './modules/Transaction/TransactionContainer';
import Desk from './modules/Desk/DeskContainer';
import FoodContainer from './modules/Menu/Food/FoodContainer';
import DrinkContainer from './modules/Menu/Drink/DrinkContainer';
import OrderContainer from './modules/Order/OrderContainer';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import CombineReduser from './modules/CombineReducer';
import TransactionContainerUnpaid from './modules/Transaction/TransactionContainerUnpaid.js';
import Header from './Component/Header/Header';
import SideBar from './Component/Sidebar/Sidebar';
import Footer from './Component/Footer/Footer';
import Home from './Component/Home/Home';

export default function App() {
  return (
    //  Makes the Redux store available to the connect() calls in the component hierarchy below.
    <Provider store={createStore(CombineReduser)}>
      <Router>

        <body className="App-wmb">
          
            <Header head="Hoka Hokanigma"/>
          
            <SideBar />
          <main className="body-wmb">
              <Switch>
                <Route exact path="/order"><OrderContainer /></Route>
                {/* <Route path="/food"><FoodContainer /></Route> */}
                {/* <Route path="/drink"><DrinkContainer /></Route> */}
                <Route path="/trans"><Transaction /></Route>
                <Route path="/trans/unpaid"><TransactionContainerUnpaid /></Route>
                <Route path="/desk"><Desk/></Route>
                <Route path="/home"><Home/></Route>
              </Switch>
          </main>
          {/* <Footer footer="opycenter by enigmacamp"/> */}
        </body>
      </Router>
    </Provider>
  );

}
