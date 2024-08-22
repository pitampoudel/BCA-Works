<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    include "db_connect.php";

    $studentId = $_REQUEST["studentId"];
    $nm = $_REQUEST["nm"];
    $se = $_REQUEST["se"];
    $sc = $_REQUEST["sc"];
    $os = $_REQUEST["os"];

    $sql = "INSERT INTO marks (studentId, se,sc, nm, os) VALUES('$studentId', '$se','$sc','$nm','$os')";
    if (!mysqli_query($conn, $sql)) {
        die("Insert error" . mysqli_error($conn));
    }
    die("Inserted successfully");
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ADD Marks</title>
</head>

<body>
    <form action="" method="post">
        <label for="student">Student</label><br>
        <input type="text" name="studentId" id="student">
        <br>
        <label for="se">SE</label><br>
        <input type="text" name="se" id="se">
        <br>
        <label for="sc">SC</label><br>
        <input type="text" name="sc" id="sc">
        <br>
        <label for="nm">NM</label><br>
        <input type="text" name="nm" id="nm">
        <br>
        <label for="os">OS</label><br>
        <input type="text" name="os" id="os">
        <br>
        <br>
        <input type="submit" value="ADD">
    </form>
</body>

</html>
