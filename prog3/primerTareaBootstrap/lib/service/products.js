export function getAllProducts(){
    return fetch('http://localhost:3000/tasks')
            .then(res=>res.json())
            .then(json=>json)
}