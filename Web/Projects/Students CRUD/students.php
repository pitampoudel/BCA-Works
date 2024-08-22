<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Students</title>
</head>

<body>
    <h3>Student List</h3>
    <a href="add_student.php">ADD Student</a>
    <br>
    <br>
    <?php
require 'db_connect.php';
$sql = "SELECT * FROM details";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "<table border='1'>";
    echo "<tr><th>Name</th><th>Address</th><th>Contact</th><th>Age</th><th>Actions</th></tr>";
    while ($row = $result->fetch_assoc()) {
        $id = $row["id"];
        echo "<tr><td>" . $row["name"] . "</td><td>" . $row["address"] . "</td><td>" . $row["contact"] . "</td><td>" . $row["age"] . "</td><td>" . "<a href='add_student.php?id=$id'>Edit</a>  <a href='delete_student.php?id=$id'>Delete</a>" . "</td></tr>";
    }
    echo "</table>";
} else {
    echo "0 results";
}
?>
</body>

</html>