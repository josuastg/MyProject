import React from 'react';
import './Sidebar.css';
import { Route, Link, BrowserRouter as Router, Switch } from 'react-router-dom'
import LocalCafeIcon from '@material-ui/icons/LocalCafeOutlined';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCartOutlined';
import AccountBoxIcon from '@material-ui/icons/AccountBox';
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import TableChartIcon from '@material-ui/icons/TableChart';
import HomeIcon from '@material-ui/icons/HomeOutlined';
import RestaurantMenuOutlinedIcon from '@material-ui/icons/RestaurantMenuOutlined';
import AccountBalanceWalletOutlinedIcon from '@material-ui/icons/AccountBalanceWalletOutlined';

export default function SideBar(){
    return(
        <div className="sidebar-wmb">
             <List>
             <List> 
                <Link to="/home"> <HomeIcon color="action" /> </Link><br/><br/>
              </List>
              <List> 
                <Link to="/order"> <ShoppingCartIcon color="action" /> </Link><br/>
              </List>
              {/* <List>
                <Link to="/food">  <RestaurantMenuOutlinedIcon color="action" /> </Link>
              </List>
              <List>
                <Link to="/drink"> <LocalCafeIcon color="action"/></Link>
              </List> */}
              <List>
                <Link to="/trans/paid"><AccountBalanceWalletOutlinedIcon color="action"/> </Link>
              </List>
              <List>
                <Link to="/trans/unpaid"><AccountBalanceWalletOutlinedIcon color="action"/> </Link>
              </List>
              {/* <Link to="/trans/paid">
                <ListItem >
                  <ListItemIcon><AccountBalanceWalletOutlinedIcon />  </ListItemIcon>
                  <ListItemText primary="Transaction" />
  
                </ListItem>
              </Link> */}
            </List>
            <List>
              <Link to="/desk"><TableChartIcon color="action"/></Link>
               {/* <Link to="/account"><AccountBoxIcon color="action"/></Link> */}
            </List>
        </div>
    )
}