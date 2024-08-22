<?php
include "db_connect.php";

$name = $address = $contact = $age = "";
$buttonText = "ADD";

if (isset($_GET["id"])) {
    $id = $_GET["id"];

    // Fetch the data for the given id
    $sql = "SELECT * FROM details WHERE id = '$id'";
    $result = mysqli_query($conn, $sql);

    if ($result && mysqli_num_rows($result) > 0) {
        $row = mysqli_fetch_assoc($result);
        $name = $row["name"];
        $address = $row["address"];
        $contact = $row["contact"];
        $age = $row["age"];
        $buttonText = "UPDATE";
    } else {
        die("Record not found.");
    }
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $id = $_POST["id"];
    $name = $_POST["name"];
    $address = $_POST["address"];
    $contact = $_POST["contact"];
    $age = $_POST["age"];

    $sql = "INSERT INTO details (id, name, address, contact, age)
VALUES ('$id', '$name', '$address', '$contact', '$age')
ON DUPLICATE KEY UPDATE
name = '$name',
address = '$address',
contact = '$contact',
age = '$age'";

    if (!mysqli_query($conn, $sql)) {
        die("Insert error: " . mysqli_error($conn));
    }
    header("location: students.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $buttonText; ?> Student</title>
</head>

<body>
    <form action="" method="post">
        <input type="hidden" name="id" value="<?php echo isset($id) ? $id : ''; ?>">
        <label for="name">Name</label><br>
        <input type="text" name="name" id="name" value="<?php echo $name; ?>">
        <br>
        <label for="address">Address</label><br>
        <input type="text" name="address" id="address" value="<?php echo $address; ?>">
        <br>
        <label for="contact">Contact</label><br>
        <input type="text" name="contact" id="contact" value="<?php echo $contact; ?>">
        <br>
        <label for="age">Age</label><br>
        <input type="text" name="age" id="age" value="<?php echo $age; ?>">
        <br>
        <br>

        <input type="submit" value="<?php echo $buttonText; ?>">
    </form>
</body>

</html>