<!DOCTYPE html>
<html>

<head>
    <title>Orders</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Add custom styles here */
    </style>
</head>

<body>

    <nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top">
        <a class="navbar-brand" href="#">FreshDaily Dashboard</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="dashboard">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="products">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="orders">Orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="customers">Customers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="settings">Settings</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-5">
        <h2>Orders</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Order Number</th>
                    <th>Date</th>
                    <th>Total</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>ORD-001</td>
                    <td>2023-10-01</td>
                    <td>$124.75</td>
                    <td>Shipped</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>ORD-002</td>
                    <td>2023-10-10</td>
                    <td>$67.50</td>
                    <td>Delivered</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>ORD-003</td>
                    <td>2023-10-15</td>
                    <td>$210.00</td>
                    <td>Processing</td>
                </tr>
            </tbody>
        </table>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
