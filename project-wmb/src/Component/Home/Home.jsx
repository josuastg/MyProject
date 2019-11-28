import React from 'react';
import './Home.css';


export default class Home extends React.Component {
    render() {
        return ( 
        <div className = "home"> <h3>ABC{this.props.head}</h3></div>
        )
    }
}