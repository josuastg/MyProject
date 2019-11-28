import API from "../../../API";

export async function listUnpaid() {
    return await API.get(`/trans/unpaid`)
    .then((res)=> res.data)
}

export async function listPaid() {
    return await API.get(`/trans/paid`)
    .then((res)=> res.data)
}

export async function patchPay(id) {
    return await API.patch(`/trans/unpaid/${id}`)
    .then((res)=> res.data)
}



export async function getTrans(id) {
    return await fetch(`http://localhost:8080/trans/unpaid/${id}`)
    .then((res)=> res.json());

}