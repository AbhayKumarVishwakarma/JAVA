function f1() {

    const studentTableBody = document.getElementById('student-table-body');

    fetch("http://localhost:8080/students").then(response => {
        if (response.status == 201 | response.status == 200) {
            response.json().then(data => {

                data.forEach(student => {

                    const row = document.createElement('tr');
                    row.innerHTML = `
                                    <td>${student.roll}</td> 
                                    <td>${student.name}</td>
                                    <td>${student.address}</td>
                                    <td>${student.marks}</td>
                                    <td><button button style ="background-color:yellow" onclick="updateRecord('${student.name}','${student.address}','${student.marks}')">UPDATE</button> </td>
                                    <td><button style ="background-color:red" onclick="deleteRecord(${student.roll})">DELETE</button> </td>
                                    `;
                    studentTableBody.appendChild(row);

                })
            })
        } else {
            response.json().then(data => alert(data.message));
        }
    })

}

function deleteRecord(roll) {

    let choice = confirm("Are You Sure ?");

    if (choice) {
        fetch("http://localhost:8080/students/" + roll, {

            method: "DELETE"

        }).then(response => {
            if (response.status == 201 | response.status == 200) {
                response.json().then(data => {
                    alert("Student sucessfully deleted: ");
                    location.reload();
                });
            } else {
                response.json().then(data => alert(data.message));
            }
        })
    }

}


function updateRecord(name, address, marks) {

    const url = `updateStudent.html?name=${name}&address=${address}&marks=${marks}`;

    location.href = url;


}

