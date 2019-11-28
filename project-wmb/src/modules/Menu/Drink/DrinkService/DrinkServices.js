export async function listDrink() {
    return await fetch('http://localhost:8080/drinks')
    .then((res)=> res.json());

}