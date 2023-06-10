let body = document.getElementById("body");
// let ls = localStorage.getItem("emps") || {};

function fetchEmp(){

    fetch("http://localhost:8080/employees").then(respo => {
        return respo.json()
    }).then(data => {
        getAllEmpl(data)
    })

}

fetchEmp();


function getAllEmpl(data){

    data.forEach(emp => {
        let row = document.createElement("tr");

        row.innerHTML = `
        <td>${emp.id}</td> 
        <td>${emp.firstName}</td>
        <td>${emp.lastName}</td>
        <td>${emp.email}</td>
        <td>${emp.position}</td>
        <td><button id="update"  onclick="updateEmployee('${emp.id}','${emp.firstName}','${emp.lastName}','${emp.email}','${emp.position}')">UPDATE</button> </td>
        <td><button id="delete" onclick="deleteEmployee(${emp.id})">DELETE</button> </td> 
        `
        body.append(row);
    })
}

function updateEmployee(id,firstName,lastName,email,position){
    let obj = {
        id : id,
        firstName : firstName,
        lastName : lastName,
        email : email,
        position : position
    }
    localStorage.setItem("emps",JSON.stringify(obj))
    location.href = "./updateEmployee.html";
}


function deleteEmployee(id){
    fetch("http://localhost:8080/employees/"+id, {
        method : "DELETE",

    }).then(res => {
        return res.json();
    }).then(data => {
        alert("Employee deleted successfully");
        location.reload();
    })
}