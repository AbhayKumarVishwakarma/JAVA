
let form = document.querySelector("form");

form.addEventListener("submit", e=> {
    e.preventDefault();
    let obj = {
        id : document.getElementById("id").value,
        firstName : document.getElementById("firstname").value,
        lastName : document.getElementById("lastname").value,
        email : document.getElementById("email").value,
        position : document.getElementById("position").value
    }

    console.log(obj);
    getEmployee(obj);
})



function getEmployee(obj){

    fetch("http://localhost:8080/employees/1",{
        method : "POST",
        headers: {
            "Content-Type": "application/json",
          },
        body : JSON.stringify(obj)
    }).then(res=>{
        return res.json()
    }).then(data=>{
        console.log(data)
    })
}