<?php

session_start();
require 'credentials.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'];
    $password = $_POST['password'];

    if ($username === USERNAME && $password === PASSWORD) {
        $_SESSION['username'] = $username;
        header("Location: welcome.php");
        exit;
    } else {
        $error = "Invalid username or password.";
    }
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