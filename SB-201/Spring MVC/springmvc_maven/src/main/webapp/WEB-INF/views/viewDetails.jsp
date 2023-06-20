<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Student Management System</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>

	<div class="container">
		<div class="row mt-4">
			<h1>List Employees</h1>
		</div>


		<table class="table table-dark table-bordered mt-15">
			<thead class="table-dark">
				<tr>
					<th>UserName</th>
					<th>Email</th>
					<th>Password</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td text="">${username}</td>
					<td text="">${email}</td>
					<td text="">${password}</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>

</html>
