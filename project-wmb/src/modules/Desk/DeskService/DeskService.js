export async function listDesk() {
    return await fetch('http://localhost:8080/tables')
    .then((res)=> res.json());

}