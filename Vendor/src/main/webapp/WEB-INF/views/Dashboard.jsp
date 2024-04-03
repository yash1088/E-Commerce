<!DOCTYPE html>
<html>

<head>
    <title>eCommerce Dashboard</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 15px;
            text-align: center;
        }

        .container {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            padding: 20px;
        }

        .sidebar {
            flex: 1;
            background-color: #f4f4f4;
            padding: 20px;
            transition: all 0.3s;
            transform: translateX(-100%);
        }

        .container:hover .sidebar {
            transform: translateX(0);
        }

        .main-content {
            flex: 3;
            padding: 20px;
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>

<body>
    <header>
        <h1>FreshDaily Dashboard</h1>
    </header>
    <div class="container">
        <div class="sidebar" id="sidebar">
            <h2>Sidebar</h2>
            <ul>
                <li><a href="dashboard">Dashboard</a></li>
                <li><a href="products">Products</a></li>
                <li><a href="orders">Orders</a></li>
                <li><a href="customers">Customers</a></li>
                <li><a href="settings">Settings</a></li>
            </ul>
        </div>
        <div class="main-content">
            <h2>Main Content Area</h2>
            <p>Welcome to the eCommerce Dashboard!</p>
            <h3>Sample Data:</h3>
            <div id="dataDisplay"></div>
        </div>
    </div>
    <footer>
        <p>&copy; 2023 eCommerce Dashboard</p>
    </footer>

    <script>
        // Sample data
        const data = [
            { name: 'Product 1', price: 24.99 },
            { name: 'Product 2', price: 19.99 },
            { name: 'Product 3', price: 34.99 }
        ];

        // Displaying data in the main content area
        const dataDisplay = document.getElementById('dataDisplay');
        data.forEach(item => {
            const itemElement = document.createElement('div');
            itemElement.innerHTML = `<p><strong>${item.name}</strong> - $${item.price}</p>`;
            dataDisplay.appendChild(itemElement);
        });
    </script>
</body>

</html>
