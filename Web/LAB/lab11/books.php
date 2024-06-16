<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "demoapp";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Create
if (isset($_POST['create'])) {
    $title = $_POST['title'];
    $author = $_POST['author'];
    $year = $_POST['year'];
    $price = $_POST['price'];
    $conn->query("INSERT INTO books (title, author, year, price) VALUES ('$title', '$author', '$year', '$price')");
}

// Update
if (isset($_POST['update'])) {
    $id = $_POST['id'];
    $title = $_POST['title'];
    $author = $_POST['author'];
    $year = $_POST['year'];
    $price = $_POST['price'];
    $conn->query("UPDATE books SET title='$title', author='$author', year='$year', price='$price' WHERE id=$id");
}

// Delete
if (isset($_GET['delete'])) {
    $id = $_GET['delete'];
    $conn->query("DELETE FROM books WHERE id=$id");
}

// Read
$books = $conn->query("SELECT * FROM books");

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Bookstore CRUD</title>

</head>

<body>
    <h1>Bookstore CRUD</h1>

    <form method="post" action="">
        <input type="hidden" name="id" value="">
        <input type="text" name="title" placeholder="Title" required>
        <input type="text" name="author" placeholder="Author" required>
        <input type="number" name="year" placeholder="Year" required>
        <input type="number" step="0.01" name="price" placeholder="Price" required>
        <button type="submit" name="create">Add Book</button>
    </form>

    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Year</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <?php while ($book = $books->fetch_assoc()): ?>
        <tr>
            <td><?=$book['id']?></td>
            <td><?=$book['title']?></td>
            <td><?=$book['author']?></td>
            <td><?=$book['year']?></td>
            <td><?=$book['price']?></td>
            <td>
                <a href="?edit=<?=$book['id']?>">Edit</a>
                <a href="?delete=<?=$book['id']?>" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
        <?php endwhile;?>
    </table>

    <?php
// Edit form
if (isset($_GET['edit'])):
    $id = $_GET['edit'];
    $book = $conn->query("SELECT * FROM books WHERE id=$id")->fetch_assoc();
    ?>
    <h2>Edit Book</h2>
    <form method="post" action="">
        <input type="hidden" name="id" value="<?=$book['id']?>">
        <input type="text" name="title" value="<?=$book['title']?>" required>
        <input type="text" name="author" value="<?=$book['author']?>" required>
        <input type="number" name="year" value="<?=$book['year']?>" required>
        <input type="number" step="0.01" name="price" value="<?=$book['price']?>" required>
        <button type="submit" name="update">Update Book</button>
    </form>
    <?php endif;?>
</body>

</html>

<?php $conn->close();?>