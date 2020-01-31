import { FETCH_ALL_USERS, FETCH_ALL_USERS_ERROR, FETCH_ALL_USERS_SUCCESS, FETCH_DETAIL_USER, FETCH_DETAIL_USER_ERROR, FETCH_DETAIL_USER_SUCCESS, HANDLE_AGE_USER, HANDLE_FIRSTNAME_USER, HANDLE_LASTNAME_USER, HANDLE_PHOTO_USER, HANDLE_ID_USER } from '../../action/Contact.js';



export function findAllContact(state = { data: [], loading: false, error: null }, action) {
    switch (action.type) {
        case FETCH_ALL_USERS:
            return {
                ...state,
                data: [],
                loading: true
            };
        case FETCH_ALL_USERS_SUCCESS:
            return {
                ...state,
                data: action.data.data,
                loading: false,
                error: null,
            };
        case FETCH_ALL_USERS_ERROR:
            return {
                ...state,
                loading: false,
                data: [],
                error: action.error
            };
        default:
            return state;
    }
}

export function findDetailContact(state = { data: null, loading: false }, action) {
    switch (action.type) {
        case FETCH_DETAIL_USER:
            return {
                ...state,
                data: null,
                loading: true,
                error: null
            };
        case FETCH_DETAIL_USER_SUCCESS:
            return {
                ...state,
                data: action.data.data,
                loading: false,
                error: null,
            };
        case FETCH_DETAIL_USER_ERROR:
            return {
                ...state,
                loading: false,
                error: action.error
            };
        default:
            return state;
    }
}

export function saveContact(state = { data: { firstName: '', lastName: '', age: null, photo: '' } }, action) {
    const { contact, type } = action;
    switch (type) {
        case HANDLE_PHOTO_USER:
            return {
                ...state, data: {
                    ...state.data, photo: contact
                }
            }
        case HANDLE_FIRSTNAME_USER:
            return {
                ...state, data: {
                    ...state.data, firstName: contact
                }
            }
        case HANDLE_LASTNAME_USER:
            return {
                ...state, data: {
                    ...state.data, lastName: contact
                }
            }
        case HANDLE_AGE_USER:
            return {
                ...state, data: {
                    ...state.data, age: Number(contact)
                }
            }

        default:
            return state;
    }
}