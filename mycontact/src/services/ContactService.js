import utils from '../utils/Constant.js';


export async function list() {
    return await utils.get('contact')
        .then((res) => res.data)
}

export async function detailContact(id) {
    return await utils.get(`contact/${id}`)
        .then((res) => res.data)
}

export async function postContact(data) {
    try {
        const response = await utils.post('contact', data)
        alert(response.data.message);
        return response;
    } catch (error) {
        console.log(error.response.data.message);
        alert(error.response.data.message);
    }
}

export async function deleteContact(id) {
    try {
        const response = await utils.delete(`contact/${id}`)
        console.log(response);
        return response;
    } catch (error) {
        alert(error.response.data.message);

    }
}

export async function putContact(id, data) {
    const payload = {
        firstName: data.firstName,
        lastName: data.lastName,
        age: data.age,
        photo: data.photo
    }
    return await utils.put(`contact/${id}`, payload)
        .then((res) => {
            if (res.status === 201) {
                alert(res.data.message)
                return res.data;
            }
        }).catch((error) => {
            alert(error.response.data.message);
        })

}