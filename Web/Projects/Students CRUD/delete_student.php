<?php

include "db_connect.php";

$id = $_REQUEST["id"];

$sql = "DELETE FROM details WHERE id = $id";
if (!mysqli_query($conn, $sql)) {
    die("Delete error" . mysqli_error($conn));
}
header("location: students.php");
