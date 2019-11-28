        const initialState = {
    loading: true,
    foods: [],
    food: null
}
function FoodReducer(state = initialState, action) {
    const { type, foods, loading, food } = action;
    console.log('renderFoodreduce')

    switch (type) {
        case 'FETCH_FOODS':
            return { ...state, loading: true };
        case 'FETCH_FOODS_DONE':
            return { ...state, loading, foods };
        case "FETCH_FOOD":
            return {...state, food};
        default:
            return state;

    }
}

export default FoodReducer;