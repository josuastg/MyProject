const initialState = {
    loading: true,
    drinks: [],
    drink: null
}
function DrinkReducer(state = initialState, action) {
    const { type, drinks, drink , loading } = action;
    console.log('renderFoodreduce')

    switch (type) {
        case 'FETCH_DRINKS':
            return { ...state, loading: true };
        case 'FETCH_DRINKS_DONE':
            return { ...state, loading, drinks };
        case 'FETCH_DRINK':
            return {...state, drink };
        default:
            return state;

    }
}

export default DrinkReducer;