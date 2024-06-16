<?php

$server = "localhost";
$user = "root";
$pass = "";
$db = "demoapp";
$conn = new mysqli($server, $user, $pass, $db);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

session_start();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'];
    $password = $_POST['password'];

    $stmt = $conn->prepare("SELECT * FROM users WHERE username=?");
    $stmt->bind_param("s", $username);
    $stmt->execute();
    $stmt->store_result();

    if ($stmt->num_rows > 0) {
        $stmt->bind_result($id, $username, $hashed_password);
        $stmt->fetch();

        if (password_verify($password, $hashed_password)) {
            $_SESSION['userId'] = $id;
            header("location: welcome.php");
        } else {
            $error = "The password you entered was not valid.";
        }
    } else {
        $error = "No account found with that username.";
    }

    $stmt->close();
    $conn->close();

}
?>

<!DOCTYPE html>
<html>

<body>
    <h2>Login</h2>
    <?php if (isset($error)) {echo "<p style='color:red;'>$error</p>";}?>
    <form method="post" action="">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
    <footer>
        <p>Copyright &copy; 2024 Pitam Poudel All Rights Reserved</p>
    </footer>
</body>

</html>