<!-- Lab 4: Implement session and cookies in PHP -->

<?php
// SESSIONS
session_start();
$_SESSION['username'] = 'JohnDoe';
echo "Session set for " . $_SESSION['username'];

// COOKIES
setcookie('user', 'JohnDoe', time() + 3600, '/');
echo "Cookie set for user: " . $_COOKIE['user'];