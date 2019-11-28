// import React from 'react';
// import { connect } from 'react-redux';
// import { TextField, Input, FormControl, FormHelperText, Button, FormGroup, InputLabel, FormLabel } from '@material-ui/core';
// import './FormAdd.css';



// export default class FormAdd extends React.Component {
//   render() {
//     return (
//       <form onSubmit={this.handleSubmit}>
//         {/* <FormGroup> */}
//           <FormControl>
//             <InputLabel htmlFor="my-input">PIC</InputLabel>
//             <Input
//               name="name"
//               onChange={this.handleChange}
//               id="my-input" aria-describedby="my-helper-text" />
//           </FormControl>
//           <FormControl>
//             <InputLabel htmlFor="my-input">Qty Customer</InputLabel>
//             <Input
//               name="qty_customer"
//               type="number"
//               margin="normal"
//               onChange={e => dispatch({ type: "SUBMIT_QTYCUSTOMER", qty_cust: Number(e.target.value) })}
//               id="my-input" aria-describedby="my-helper-text" />
//           </FormControl>
//           <FormControl>
//             <InputLabel htmlFor="my-input">Table</InputLabel>
//             {tables ? <Input
//               value={` ${tables.name}`}
//               id="my-input" aria-describedby="my-helper-text" /> : null}
//           </FormControl>
//           <FormControl>
//             <InputLabel htmlFor="my-input">Table Status</InputLabel>
//             {tables ? <Input
//               value={` ${tables.capacity}`}
//               id="my-input" aria-describedby="my-helper-text" /> : null}
//           </FormControl>
//           <FormControl>
//             <InputLabel htmlFor="my-input">Table</InputLabel>
//             {tables ? <Input
//               value={` ${tables.status}`}
//               id="my-input" aria-describedby="my-helper-text" /> : null}
//           </FormControl>
//         </FormGroup>
//         <br /><br />
//         {order.orders.map((item) => {
//           console.log(item)
//           return (
//             <FormGroup>
//               <FormControl>
//                 <InputLabel htmlFor="my-input">Food</InputLabel>
//                 {item.foods ? <Input
//                   name="food"
//                   value={food.name}
//                   onChange={this.handleChange}
//                   id="my-input" aria-describedby="my-helper-text" />
//                   : null}
//               </FormControl>
//               <FormControl>
//                 <InputLabel htmlFor="my-input">Qty food</InputLabel>
//                 {item.qty_foods ? <Input
//                   name="qty_food"
//                   onChange={this.handleChange}
//                   id="my-input" aria-describedby="my-helper-text" /> : null}
//               </FormControl>
//               <FormControl>
//                 <InputLabel htmlFor="my-input">Drink</InputLabel>
//                 {item.drinks ? <Input
//                   value={item.drinks.name}
//                   onChange={this.handleChange}
//                   name="drink"
//                   id="my-input" aria-describedby="my-helper-text" /> : null}
//               </FormControl>
//               <FormControl>
//                 <InputLabel htmlFor="my-input">Qty Drink</InputLabel>
//                 <Input
//                   type="number"
//                   name="qty_drinks"
//                   onChange={this.handleChange} id="my-input" aria-describedby="my-helper-text" />
//               </FormControl>
//             </FormGroup>
//           )
//         })}

//         <div>
//           <Button variant="outlined" color="primary" onClick={e => this.handleSubmit(e)}>Submit</Button>
//           <Button variant="outlined" color="primary" onClick={e => this.handleSave(e)}>SAVE</Button>
//         </div>

//       </form>
//     )
//   }
// }