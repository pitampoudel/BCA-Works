<!-- Lab 3: Implement insert, edit/update, and delete MySQL query in PHP -->

<?php

//INSERT
$conn = new mysqli('localhost', 'root', '', 'test_db');
$sql = "INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com')";
$conn->query($sql);

// UPDATE
$sql = "UPDATE users SET email='john.doe@example.com' WHERE name='John Doe'";
$conn->query($sql);

// DELETE
$sql = "DELETE FROM users WHERE name='John Doe'";
$conn->query($sql);