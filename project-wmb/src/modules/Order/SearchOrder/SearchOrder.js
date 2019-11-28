import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles(theme => ({
    container: {
      display: 'flex',
      flexWrap: 'wrap',
    },
    textField: {
      marginLeft: theme.spacing(1),
      marginRight: theme.spacing(1),
      width: 200,
    },
  }));

export default  function SearchOrder (){
    const classes = useStyles();
   return (
            <div className="search" >
 
        <TextField
           
           id="filled-basic"  
           className={classes.textField}
           label="Search Orders"
           margin="normal"  
        />
 

            </div>
        )
    
}