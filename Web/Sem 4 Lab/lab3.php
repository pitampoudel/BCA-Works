<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab 3: MySQL Insert, Update, and Delete with Form</title>
</head>

<body>
    <h2>Lab 3: Implement Insert, Edit/Update, and Delete MySQL Query in PHP</h2>

    <?php
    // Establishing Database Connection
    $conn = new mysqli('localhost', 'root', '', 'test');

    // Check Connection
    if ($conn->connect_error) {
        die("<p style='color: red;'>Connection failed: " . $conn->connect_error . "</p>");
    }

    // Process Form Submission
    if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        $action = $_POST['action'];

        if ($action == 'insert') {
            // INSERT Query
            $name = $_POST['name'];
            $email = $_POST['email'];
            $sql = "INSERT INTO users (name, email) VALUES ('$name', '$email')";
            if ($conn->query($sql) === true) {
                echo "<p style='color: green;'>Record inserted successfully.</p>";
            } else {
                echo "<p style='color: red;'>Error inserting record: " . $conn->error . "</p>";
            }
        } elseif ($action == 'update') {
            // UPDATE Query
            $name = $_POST['name'];
            $email = $_POST['email'];
            $sql = "UPDATE users SET email='$email' WHERE name='$name'";
            if ($conn->query($sql) === true) {
                echo "<p style='color: green;'>Record updated successfully.</p>";
            } else {
                echo "<p style='color: red;'>Error updating record: " . $conn->error . "</p>";
            }
        } elseif ($action == 'delete') {
            // DELETE Query by ID
            $id = $_POST['id'];
            $sql = "DELETE FROM users WHERE id=$id";
            if ($conn->query($sql) === true) {
                echo "<p style='color: green;'>Record deleted successfully.</p>";
            } else {
                echo "<p style='color: red;'>Error deleting record: " . $conn->error . "</p>";
            }
        }
    }

    // Display All Records
    $result = $conn->query("SELECT * FROM users");

    if ($result->num_rows > 0) {
        echo "<h3>Current Records in the Database:</h3>";
        echo "<table border='1' cellpadding='10'>";
        echo "<tr><th>ID</th><th>Name</th><th>Email</th></tr>";

        while ($row = $result->fetch_assoc()) {
            echo "<tr><td>{$row['id']}</td><td>{$row['name']}</td><td>{$row['email']}</td></tr>";
        }

        echo "</table>";
    } else {
        echo "<p style='color: blue;'>No records found in the database.</p>";
    }

    // Close Connection
    $conn->close();
    ?>

    <h3>Database Actions</h3>
    <form method="POST" action="">
        <!-- Insert/Update Section -->
        <fieldset>
            <legend>Insert/Update Record</legend>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter name"><br><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="Enter email"><br><br>
            <button type="submit" name="action" value="insert">Insert</button>
            <button type="submit" name="action" value="update">Update</button>
        </fieldset>
        <br>

        <!-- Delete Section -->
        <fieldset>
            <legend>Delete Record</legend>
            <label for="id">Record ID:</label>
            <input type="number" id="id" name="id" placeholder="Enter ID to delete" required><br><br>
            <button type="submit" name="action" value="delete">Delete</button>
        </fieldset>
    </form>

    <br><br>
    <strong>© 2025 Pitam. All rights reserved.</strong>
</body>

</html>