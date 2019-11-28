import React from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import { makeStyles } from '@material-ui/core/styles';
import * as TransService from '../Services/TransactionServices.js';
import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails';
import Typography from '@material-ui/core/Typography';
import { TextField,  Button } from '@material-ui/core';
import ListTrans from '../ListTransaction/ListTransaction.css';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';




class DetailTransaction extends React.Component {
  componentDidMount() {
    // const { match: { params } } = this.props;

    // console.log(params);
    // this.props.dispatch({ type: 'FETCH_USERS_DETAIL', idUsers: Number(params.id) });
    const {dispatch} = this.props
    let id = this.props.match.params.id;
    console.log('id : ', id );
    dispatch({type : 'FETCH_TRANSACTION'});
   TransService.getTrans(id)
    .then((trans)=> {
      // const{data : trans} = response;
      setTimeout(()=>
      dispatch({type : 'FETCH_DETAIL_TRANSACTION', loading : false, trans}),2000
      )
      })
      .catch((error)=> {
        dispatch({type: 'FETCH_DETAIL_TRANSACTION', loading: false, trans:[]})
      });
      TransService.patchPay(id)
      .then((trans)=>{
       alert('Payment Succesfull') // dispatch({type : 'FETCH_PATCH_TRANSACTION', trans})
        
      })
    }

  render() {
    console.log('render detail ');
    console.log(this.props);
    const { trans , loading } = this.props;
    let transDetail = (<p></p>);
    if (!loading && trans) {
      transDetail = (
        <div>        
          <ExpansionPanel>
        <ExpansionPanelSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel1a-content"
          id="panel1a-header"
        >
          <Typography>Detail Transac  tion</Typography>
        </ExpansionPanelSummary>
        <ExpansionPanelDetails>
          <div >
         <font color="black" className="font"> ID : </font> 
        <div className="readOnly">
        <TextField
          id="standard-read-only-input"
          value={trans.id}
          margin="normal"
          InputProps={{
            readOnly: true,
          }}
        />
        </div>
        </div>
        <div>
        <font color="black" className="font2"> PIC Customer : </font> 
        <div className="readOnly2">
        <TextField
          id="standard-read-only-input"
          value={trans.name}
          margin="normal"
          InputProps={{
            readOnly: true,
          }}
        />
        </div>
        </div>
        <div>
        <font color="black" className="font3"> Date : </font> 
        <div className="readOnly3"> 
        <TextField
          id="standard-read-only-input"
          value={trans.date}
          margin="normal"
          InputProps={{
            readOnly: true,
          }}
        />
        </div>
        </div>
        <div>
        <font color="black"> Total : </font> 
        <div>
        <TextField
          id="standard-read-only-input"
          value={trans.total}
          margin="normal"
          InputProps={{
            readOnly: true,
          }}
        />
        </div>
        </div>
        <div>
        <font color="black"> Status : </font> 
        <div>
        <TextField
          id="standard-read-only-input"
          value={trans.status}
          margin="normal"
          InputProps={{
            readOnly: true,
          }}
        />
        </div>
</div>
<div>
<Button variant="contained" color="primary" ><Link to={`/trans/paid`}>Pay</Link></Button>
</div>
<div>
         <Button variant="contained" color="primary"> <Link to="/trans"> <font color="white">RETURN</font></Link></Button>
        </div>
        </ExpansionPanelDetails>
        
        </ExpansionPanel>
        </div>

      );
    }
    return (
      <div>
     <Button variant="contained" color="primary"> <Link to="/trans/paid"> <font color="white">RETURN</font></Link></Button>

        <div>
          {transDetail}
        </div>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { ...state.Transaction };
}

export default connect(mapStateToProps)(DetailTransaction);
