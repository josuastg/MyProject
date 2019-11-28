const previousState = {
    form:[],
    loading: true,
    orders: [],
    order: {
        name: "",
        qty_customer: null,
        cashier: {
            id: 2,
            name: 'Josua',
        },
        orders: [
            {
                qty_foods: null,
                qty_drinks: null,
                foods: null,
                drinks: null
            },
        ],
        tables: null
    }
}



function OrderReducer(state = previousState, action) {
    const { orders, order, loading, food, type, drink, tables, qty_cust, qtyfood, qtydrink} = action;
    switch (type) {
        case 'STORE_ORDER':
            console.log('DATA ORDER REDUSER ', order);
            return { ...state, order };
        case 'SUBMIT_ORDER':
            console.log('SUBMIT_ORDER', order);
            return { ...state, order :{...state.order, tables}}
        case 'SUBMIT_QTYCUSTOMER':
            console.log(' reducer tampil qty customer ', Number(qty_cust));
            return { ...state, order: { ...state.order, qty_customer: qty_cust } }
        case 'FETCH_ORDERS':
            return { ...state, loading: true, orders }             
        case 'FETCH_ORDERS_DONE':
            return { ...state, loading, orders };
        case 'FETCH_QTY_MENU_FOOD':
            return{ ...state, order: {...state.order, orders: state.order.orders.map((det)=>{
                    return (
                        {...det, qty_foods :Number(qtyfood) }
                    )
                })}
            }
            case 'FETCH_QTY_MENU_DRINK':
                    return{ ...state, order: {...state.order, orders: state.order.orders.map((det)=>{
                            return (
                                {...det, qty_drinks : Number(qtydrink) }
                            )
                        })}
                    }

        case 'FETCH_FOODS':
            return{
                ...state, order : {...state.order, orders: state.order.orders.map((det)=>{
                    return(
                        {...det, foods : Number(food) }
                    )
                })}
            }    
            case 'FETCH_DRINKS':
                    return{ ...state, order: {...state.order, orders: state.order.orders.map((det)=>{
                            return (
                                {...det, drinks : Number(drink) }
                            )
                        })}
                    }

        default:
            return state;


    }
}
export default OrderReducer;