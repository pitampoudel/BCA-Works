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
    $name = $_POST['name'];
    $email = $_POST['email'];

    if ($action == 'insert') {
        // INSERT Query
        $sql = "INSERT INTO users (name, email) VALUES ('$name', '$email')";
        if ($conn->query($sql) === true) {
            echo "<p style='color: green;'>Record inserted successfully.</p>";
        } else {
            echo "<p style='color: red;'>Error inserting record: " . $conn->error . "</p>";
        }
    } elseif ($action == 'update') {
        // UPDATE Query
        $sql = "UPDATE users SET email='$email' WHERE name='$name'";
        if ($conn->query($sql) === true) {
            echo "<p style='color: green;'>Record updated successfully.</p>";
        } else {
            echo "<p style='color: red;'>Error updating record: " . $conn->error . "</p>";
        }
    } elseif ($action == 'delete') {
        // DELETE Query
        $sql = "DELETE FROM users WHERE name='$name'";
        if ($conn->query($sql) === true) {
            echo "<p style='color: green;'>Record deleted successfully.</p>";
        } else {
            echo "<p style='color: red;'>Error deleting record: " . $conn->error . "</p>";
        }
    }
}

// Close Connection
$conn->close();
?>

    <h3>Database Actions</h3>
    <form method="POST" action="">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter name" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Enter email"><br><br>
        <label for="action">Action:</label>
        <select id="action" name="action" required>
            <option value="insert">Insert</option>
            <option value="update">Update</option>
            <option value="delete">Delete</option>
        </select><br><br>
        <button type="submit">Submit</button>
    </form>

    <br><br>
    <strong>© 2025 Pitam. All rights reserved.</strong>
</body>

</html>