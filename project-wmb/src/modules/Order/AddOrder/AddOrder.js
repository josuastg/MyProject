import React from 'react';
import { connect } from 'react-redux';

import './AddOrder.css';
import * as OrderServices from '../OrderServices/OrderServices.js';
import { TextField, Input, FormControl, Button, FormGroup, InputLabel } from '@material-ui/core';
import { Link } from 'react-router-dom';



class AddOrder extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      people: null
    }


    this.handleChange = this.handleChange.bind(this);
    this.handleChangeQtyfoods = this.handleChangeQtyfoods.bind(this);
    this.handleChangeQtydrinks = this.handleChangeQtydrinks.bind(this);
    this.handleChangeFood = this.handleChangeFood.bind(this);
    this.handleChangeDrink = this.handleChangeDrink.bind(this);

    this.handleSave = this.handleSave.bind(this);
  }

  handleChange(event) {
    console.log("test", event.target);
    console.log("ini handleChange", event)
    event.preventDefault();
    const name = event.target.name;
    const value = event.target.value;
    this.props.dispatch({ type: 'STORE_ORDER', order: { ...this.props.order, [name]: value } })
    // console.log('HandleChange', order);
  }

  handleChangeQtyfoods(event) {
    console.log('ini qty foods', event)
    event.preventDefault();
    const value = event.target.value;
    this.props.dispatch({ type: 'FETCH_QTY_MENU_FOOD', qtyfood: value })


  }

  handleChangeQtydrinks(event) {
    console.log('ini qty drinks', event)
    event.preventDefault();
    const value = event.target.value;
    this.props.dispatch({ type: 'FETCH_QTY_MENU_DRINK', qtydrink: value })


  }
  handleChangeFood(event) {
    console.log('ini qty drinks', event)
    event.preventDefault();
    const value = event.target.value;
    this.props.dispatch({ type: 'FETCH_FOODS', food: value })


  } handleChangeDrink(event) {
    console.log('ini qty drinks', event)
    event.preventDefault();
    const value = event.target.value;
    this.props.dispatch({ type: 'FETCH_DRINKS', drink: value })


  }


  handleSubmit(event) {
    event.preventDefault();
    const { dispatch, desk: tables, order, food, drink } = this.props;
    dispatch({ type: "SUBMIT_ORDER", tables, order, drink, food });

    console.log('HandleSubmit', order)

  }




  handleSave(e) {
    e.preventDefault();
    const { order } = this.props;
    console.log('save :', order);
    OrderServices.save(order)
      .then((response) => {
        alert("Succesfull add order");
        // dispatch({ type: 'SUBMIT_ORDER', order: response, loading: true });
      }).catch((erorr) => {
        alert('Unsuccesfull add order');
      })
  }

  // }
  render() {

    const { desk: tables, order, qty_customer: qty_cust, dispatch, food, drink } = this.props;
    console.log("DATA MASUK HANDLE STORE", order);
    console.log(this.props.order)
    return (
      <div className="addcust">
        <form onSubmit={this.handleSubmit}>
          <h3>Order Menu</h3>

          <FormGroup>
            <FormControl>
              <InputLabel htmlFor="my-input">PIC</InputLabel>
              <Input
                name="name"
                onChange={this.handleChange}
                id="my-input"
                aria-describedby="my-helper-text" />
            </FormControl>
            <FormControl>
              <InputLabel htmlFor="my-input">Qty Customer</InputLabel>
              <Input
                name="qty_customer"
                type="number"
                margin="normal"
                onChange={e => dispatch({ type: "SUBMIT_QTYCUSTOMER", qty_cust: Number(e.target.value) })}
                id="my-input" aria-describedby="my-helper-text" />
            </FormControl>
            <FormControl>
              <InputLabel htmlFor="my-input">Table</InputLabel>
              {tables ? <Input
                value={` ${tables.name}`}
                id="my-input" aria-describedby="my-helper-text" /> : null}
            </FormControl>              <br /><br />
            <FormControl>
              <InputLabel htmlFor="my-input">Table Capacity</InputLabel>
              {tables ? <Input
                value={` ${tables.capacity}`}
                id="my-input" aria-describedby="my-helper-text" /> : null}
            </FormControl>              <br /><br />
            <FormControl>
              <InputLabel htmlFor="my-input">Table Status</InputLabel>
              {tables ? <Input
                value={` ${tables.status}`}
                id="my-input" aria-describedby="my-helper-text" /> : null}
            </FormControl>   
           <br /><br />
          </FormGroup>
          <FormGroup>
            <FormControl>
              <InputLabel htmlFor="my-input"></InputLabel>
              <Input
                type="number"
                name="food"
                placeholder="Input ID Food"
                onChange={this.handleChangeFood}
                id="my-input" />
            </FormControl>
            <FormControl>
              <InputLabel htmlFor="my-input">Qty_Food</InputLabel>
              <Input
                type="number"
                name="qty_food"
                onChange={this.handleChangeQtyfoods}
                id="my-input" aria-describedby="my-helper-text" />
            </FormControl>
            <FormControl>
              <InputLabel htmlFor="my-input"></InputLabel>
              <Input
                type="number"
                placeholder="Input ID Drink"
                onChange={this.handleChangeDrink}
                name="drink"
                id="my-input" aria-describedby="my-helper-text" />
            </FormControl>
            <FormControl>
              <InputLabel htmlFor="my-input">Qty Drink</InputLabel>
              <Input
                type="number"
                name="qty_drinks"
                onChange={this.handleChangeQtydrinks} id="my-input" aria-describedby="my-helper-text" />
            </FormControl>
          </FormGroup>







       

          <div><br></br><br></br>
            <Button variant="outlined" color="primary" onClick={e => this.handleSubmit(e)}>Submit</Button>&nbsp;&nbsp; &nbsp;
            <Button variant="outlined" color="secondary" onClick={e => this.handleSave(e)}>SAVE</Button>&nbsp;&nbsp; &nbsp;
            {/* <Button variant="outlined" onClick={e => this.handleSave(e)} > <Link to="/desk">Add</Link></Button> */}
          </div>

        </form>
      </div>
    )

  }

}

function mapStateToProps(state) {
  return { ...state.Order, ...state.Desk, ...state.Transaction };
}

export default connect(mapStateToProps)(AddOrder);
