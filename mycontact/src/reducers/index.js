import {combineReducers} from 'redux';
import {findAllContact, findDetailContact,saveContact} from './contact/Contact.js'; 

export default combineReducers({
    findAllContact,
    findDetailContact,
    saveContact,
})