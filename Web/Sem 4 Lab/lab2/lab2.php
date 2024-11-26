<!-- Lab 2: Implement $_GET, $_POST, $_REQUEST in PHP -->

<?php
$nameFromPost = $_POST['name'];
$nameFromGet = $_GET['name'];
$nameFromRequest = $_REQUEST['name'];

echo "$nameFromPost received from POST";
echo "$nameFromGet received from GET";
echo "$nameFromRequest received from REQUEST";

?>

<form method="POST">
    <input type="text" name="name" placeholder="Enter your name">
    <button type="submit">Submit</button>
</form>