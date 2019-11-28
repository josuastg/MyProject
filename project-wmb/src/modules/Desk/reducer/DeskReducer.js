const initialState = {
    loading: true,
    desks: [],
    desk: null
}
function DeskReducer(state = initialState, action) {
    const { type, desks, desk, loading } = action;
    console.log('renderDeskreduce')

    switch (type) {
        case 'FETCH_DESKS':
            return { ...state, loading: true };
        case 'FETCH_DESK':
            return { ...state, desk };
        case 'FETCH_DESKS_DONE':
            return { ...state, loading, desks };
        default:
            return state;

    }
}

export default DeskReducer;