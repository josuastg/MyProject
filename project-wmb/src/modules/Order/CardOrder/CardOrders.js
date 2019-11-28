import React from 'react'
import CardOrder from './CardOrders.css'
import SearchOrder from '../SearchOrder/SearchOrder';

class CardOrders extends React.Component{
    render() {
        return(
<div className="card">
<SearchOrder/>


</div>
        );
    }
}
export default CardOrders;