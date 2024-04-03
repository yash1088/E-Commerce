<!DOCTYPE html>
<html>

<head>
    <title>eCommerce Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            padding: 20px;
        }

        .product {
            border: 1px solid #eaeaea;
            padding: 10px;
            margin: 10px;
            display: inline-block;
            width: 200px;
        }

        .product img {
            width: 100%;
        }

        .product-title {
            font-weight: bold;
            margin: 5px 0;
        }

        .product-price {
            color: green;
            font-weight: bold;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>eCommerce Dashboard</h1>
        <div class="row">
            <div class="col-md-4">
                <div class="product">
                    <img src="https://via.placeholder.com/150" alt="Sample Product">
                    <div class="product-title">Sample Product 1</div>
                    <div class="product-price">$19.99</div>
                    <button class="btn btn-primary">Add to Cart</button>
                </div>
            </div>
            <div class="col-md-4">
                <div class="product">
                    <img src="https://via.placeholder.com/150" alt="Sample Product">
                    <div class="product-title">Sample Product 2</div>
                    <div class="product-price">$29.99</div>
                    <button class="btn btn-primary">Add to Cart</button>
                    
                </div>
            </div>
            <div class="col-md-4">
                <div class="product">
                    <img src="https://via.placeholder.com/150" alt="Sample Product">
                    <div class="product-title">Sample Product 3</div>
                    <div class="product-price">$39.99</div>
                    <button class="btn btn-primary">Add to Cart</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
