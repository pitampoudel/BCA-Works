<?php
session_start();

if (!isset($_SESSION['username'])) {
    header("Location: login.php");
    exit;
}
?>

<!DOCTYPE html>
<html>

<body>
    <h2>Welcome, <?php echo $_SESSION['username']; ?>!</h2>
    <a href="logout.php">Logout</a>

    <footer>
        <p>Copyright &copy; 2024 Pitam Poudel All Rights Reserved</p>
    </footer>
</body>

</html>