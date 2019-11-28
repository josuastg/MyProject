import OrderReducer from "./Order/Reducer/OrderReducer";
import TransactionReducer from './Transaction/reducer/TransactionReducer';
import DrinkReducer from './Menu/Drink/Reducer/DrinkReducer';
import FoodReducer from './Menu/Food/reducer/FoodReducer';
import DeskReducer from './Desk/reducer/DeskReducer';

import {combineReducers} from "redux";

export default combineReducers({
    Order:OrderReducer,
    Transaction: TransactionReducer,
    Drink : DrinkReducer,
    Food : FoodReducer,
    Desk : DeskReducer  
});