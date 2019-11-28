import React from 'react';
import './Footer.css';
import Copyright from '@material-ui/icons/CopyrightOutlined'

export default class Footer extends React.Component {
    render() {
        return ( 
        <div className = "footer"> <Copyright className="c"/><h5> {this.props.footer} </h5></div>
        )
    }
}