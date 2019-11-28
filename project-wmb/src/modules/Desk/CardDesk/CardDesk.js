import React from 'react'
import CardDes from './CardDesk.css';
import TextField from '@material-ui/core/TextField';
class CardDesk extends React.Component{
    render() {
        return(
<div className="carddesk">
  
{/* <TextField
          id="standard-read-only-input"
          margin="normal"
          InputProps={{
            readOnly: true,
          }}
        />  */}
    <h3>{this.props.number}</h3>
    


</div>
        );
    }
}
export default CardDesk;