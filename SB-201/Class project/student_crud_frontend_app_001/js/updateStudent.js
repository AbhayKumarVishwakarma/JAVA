const urlParams = new URLSearchParams(window.location.search);
const name = urlParams.get('name');
const address = urlParams.get('address');
const marks = urlParams.get('marks');

// Use the parameter values to populate form fields or perform other actions
document.getElementById('name').value = name;
document.getElementById('address').value = address;
document.getElementById('marks').value = marks;


function updateStudent() {



}