export async function listFood() {
    return await fetch('http://localhost:8080/foods')
    .then((res)=> res.json());

}