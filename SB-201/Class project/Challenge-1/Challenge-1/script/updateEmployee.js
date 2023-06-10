
let form = document.querySelector("form");

let ls = JSON.parse(localStorage.getItem("emps")) || {}
rounak();

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
    updatEmp(obj,obj.id);
})

function rounak (){

    document.getElementById("id").value= ls.id;
         document.getElementById("firstname").value=ls.firstName;
        document.getElementById("lastname").value=ls.lastName;
        document.getElementById("email").value=ls.email;
         document.getElementById("position").value=ls.position;

}

function updatEmp(obj,id){

    fetch("http://localhost:8080/employees/1/"+id,{
        method : "PUT",
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