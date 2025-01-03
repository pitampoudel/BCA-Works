<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab 4: Implement Session and Cookies in PHP</title>
</head>

<body>
    <h2>Lab 4: Implement Session and Cookies in PHP</h2>

    <?php
// Start the session
session_start();

// SESSIONS
$_SESSION['username'] = 'Pitam';
echo "<h3>Session:</h3>";
echo "Session set for: <strong>" . $_SESSION['username'] . "</strong><br><br>";

// COOKIES
setcookie('user', 'Pitam', time() + 3600, '/'); // 1 hour expiration
if (isset($_COOKIE['user'])) {
    echo "<h3>Cookie:</h3>";
    echo "Cookie set for user: <strong>" . $_COOKIE['user'] . "</strong><br><br>";
} else {
    echo "<p style='color: red;'>Cookie not set. Make sure cookies are enabled.</p>";
}

echo "<br><br><strong>© 2025 Pitam. All rights reserved.</strong>";
?>

</body>

</html>