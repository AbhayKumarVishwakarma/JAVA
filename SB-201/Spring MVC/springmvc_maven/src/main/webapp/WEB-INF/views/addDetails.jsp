<head>
	<meta charset="ISO-8859-1">
	<title>Employee</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>

	<div class="container mt-5">

		<div class="raw">

			<div class="col-Lg-6 col-md-6 col-sm-6 container justify-content-center card">
				<h1 class="text-center mt-4">Create new Employee</h1>
				<div class="card-body">

					<form action="processForm" method="POST">

						<div class="form-group">

							<label for="username">UserName</label> <input type="text" name="username"
								placeholder="enter username" class="form-control">

						</div>

						<div class="form-group">

                            <label for="email">Email</label> <input type="text" name="email" placeholder="enter email"
                                class="form-control">

                        </div>

						<div class="form-group">

							<label for="password">Password</label> <input type="password" name="password"
								placeholder="enter password" class="form-control">

						</div>

						<div class="box-footer">

							<button type="submit" class="btn btn-primary"> Submit </button>

						</div>

					</form>

				</div>
			</div>
		</div>

	</div>



</body>


</html>