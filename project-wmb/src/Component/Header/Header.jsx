import React from 'react';
import './Header.css';


export default class Header extends React.Component {
    render() {
        return ( 
        <div className = "direct"> <h3 className = "ory"> {this.props.head} </h3></div>
        )
    }
}