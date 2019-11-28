const initialState = {
    loading : true,
    loading2 : true,
    transactions : [],
    transactions2 : [],
    trans : null
}
function TransactionReducer ( state = initialState, action){
    const {type, transactions,transactions2, loading2, trans,loading} = action;
    console.log('renderTransactionreducer')

    switch (type) {
        case 'FETCH_TRANSACTION':
            return {...state, loading: true};
        case 'FETCH_TRANSACTION_DONE':
            return {...state, loading, transactions };
            case 'FETCH_TRANSACTION_DONE_UNPAID':
                return {...state, loading2, transactions2 };
        case 'FETCH_PATCH_TRANSACTION':
            return {...state, loading , trans};
        case 'FETCH_DETAIL_TRANSACTION':
            return {...state,loading2, trans };
           default:
            return state;
        
    }
}  

export default TransactionReducer;