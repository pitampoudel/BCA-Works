<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "test";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$action = $_POST['action'] ?? '';

if ($action == 'create') {
    $name = $_POST['name'];
    $email = $_POST['email'];
    $sql = "INSERT INTO users (name, email) VALUES ('$name', '$email')";
    if ($conn->query($sql) === true) {
        echo "User created successfully!";
    } else {
        echo "Error: " . $conn->error;
    }
} elseif ($action == 'read') {
    $sql = "SELECT * FROM users";
    $result = $conn->query($sql);
    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            echo "<div>
                    <input type='text' id='name_{$row['id']}' value='{$row['name']}'>
                    <input type='email' id='email_{$row['id']}' value='{$row['email']}'>
                    <button onclick='updateUser({$row['id']})'>Update</button>
                    <button onclick='deleteUser({$row['id']})'>Delete</button>
                  </div>";
        }
    } else {
        echo "No users found!";
    }
} elseif ($action == 'update') {
    $id = $_POST['id'];
    $name = $_POST['name'];
    $email = $_POST['email'];
    $sql = "UPDATE users SET name='$name', email='$email' WHERE id='$id'";
    if ($conn->query($sql) === true) {
        echo "User updated successfully!";
    } else {
        echo "Error: " . $conn->error;
    }
} elseif ($action == 'delete') {
    $id = $_POST['id'];
    $sql = "DELETE FROM users WHERE id='$id'";
    if ($conn->query($sql) === true) {
        echo "User deleted successfully!";
    } else {
        echo "Error: " . $conn->error;
    }
}

$conn->close();
