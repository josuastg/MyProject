
import API_Order from '../../../API';
export async function listOrder() {
    return await API_Order.get(`order`)
    .then((res)=> res.data)

}

export async function save(param){
    return await API_Order.post(`trans/`,  param)
    .then((res)=> res.data)
}


// export async function save(order, method = 'POST') {
//     const body = new FormData();
  
//     for (const [ key, value ] of Object.entries(order)) {
//       body.append(key, value);
//     }
  
//     console.log('before-request:', order, ', method:', method);
//     return await fetch(
//         `http://10.10.12.133:8080/kasir/add`,
//         {
//           method,
//           body
//         }
//       ).then((res) => {
//         return res.json();
//       });
//   }
  


