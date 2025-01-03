<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab 2: $_GET, $_POST, $_REQUEST in PHP</title>
</head>

<body>
    <h2>Lab 2: Implement $_GET, $_POST, $_REQUEST in PHP</h2>

    <?php
// Handling $_GET, $_POST, $_REQUEST
$nameFromPost = isset($_POST['name']) ? $_POST['name'] : "Not provided";
$nameFromGet = isset($_GET['name']) ? $_GET['name'] : "Not provided";
$nameFromRequest = isset($_REQUEST['name']) ? $_REQUEST['name'] : "Not provided";

echo "<h3>Results:</h3>";
echo "<p><strong>POST:</strong> $nameFromPost received from POST</p>";
echo "<p><strong>GET:</strong> $nameFromGet received from GET</p>";
echo "<p><strong>REQUEST:</strong> $nameFromRequest received from REQUEST</p>";
?>

    <h3>Enter Your Name:</h3>
    <form method="POST" action="">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter your name">
        <button type="submit">Submit</button>
    </form>

    <br><br>
    <strong>© 2025 Pitam. All rights reserved.</strong>
</body>

</html>