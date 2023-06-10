
let body = document.getElementById("body");
let form = document.querySelector("form");

form.addEventListener("submit",e => {
    e.preventDefault();
    let id = document.getElementById("id").value;
    console.log(id)
    fetchEmp(id);
})


function fetchEmp(id){

    fetch("http://localhost:8080/employees/"+id).then(respo => {
        return respo.json()
    }).then(data => {
        console.log(data)
        getAllEmpl(data)
    })

}


function getAllEmpl(emp){
            body.innerHTML=null;
        let row = document.createElement("tr");

        row.innerHTML = `
        <td>${emp.id}</td> 
        <td>${emp.firstName}</td>
        <td>${emp.lastName}</td>
        <td>${emp.email}</td>
        <td>${emp.position}</td>
       
        `
        body.append(row);
    
}