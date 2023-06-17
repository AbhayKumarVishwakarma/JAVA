function registerStudent() {

    let sname = document.getElementById("name").value;
    let saddress = document.getElementById("address").value;
    let smarks = document.getElementById("marks").value;

    fetch("http://localhost:8080/students", {

        method: "POST",
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify({
            "name": sname,
            "address": saddress,
            "marks": smarks
        })
    }).then(response => {
        if (response.status == 201 | response.status == 200) {
            response.json().then(data => {
                alert("Student sucessfully registered with Roll: " + data.roll)
            });
        } else {
            response.json().then(data => alert(data.message));
        }
    })


}