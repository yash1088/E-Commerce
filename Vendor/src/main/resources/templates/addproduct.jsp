<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Employee</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title text-center mb-4">Add New Employee</h2>
                        <form action="products" method="post">
                            <div class="form-group">
                                <label for="lastName">Name</label>
                                <input type="text" class="form-control" id="lastName" name="Name" placeholder="Enter last name" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Price</label>
                                <input type="text" class="form-control" id="email" name="Price" placeholder="Enter email" required>
                            </div>
                            <div class="form-group">
                                <label for="department">Category</label>
                                <input type="text" class="form-control" id="department" name="Category" placeholder="Enter department" required>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary btn-block mt-4">Add Employee</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
