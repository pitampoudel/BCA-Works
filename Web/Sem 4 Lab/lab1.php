<?php
/*
Lab 1: Basic PHP Syntax
Author: Pitam
 */

/*
Implement basic syntax in PHP:
 * Variable declaration
 * PHP operator
 * If-Else statement
 * while/do while/for/for each loops
 * Function: Parameterized and non-parameterized
 */

echo "<h2>Lab 1: Basic PHP Syntax</h2>";
echo "<h3>Variable Declaration</h3>";
$name = "John";
$age = 25;
echo "Name: $name, Age: $age<br><br>";

echo "<h3>PHP Operators</h3>";
$a = 10;
$b = 20;
$sum = $a + $b;
echo "a = $a<br>b = $b<br>Sum: $sum<br><br>";

echo "<h3>If-Else Statement</h3>";
$number = 5;
if ($number > 0) {
    echo "Number $number is Positive.<br><br>";
} else {
    echo "Number $number is Negative.<br><br>";
}

echo "<h3>Loops</h3>";
echo "<h4>While Loop</h4>";
$i = 0;
while ($i < 5) {
    echo "Number: $i<br>";
    $i++;
}
echo "<br>";

echo "<h4>Do-While Loop</h4>";
do {
    echo "Number: $i<br>";
    $i++;
} while ($i < 5);
echo "<br>";

echo "<h4>For Each Loop</h4>";
$array = [1, 2, 3, 4, 5];
foreach ($array as $value) {
    echo "Value: $value<br>";
}
echo "<br>";

echo "<h4>For Loop</h4>";
for ($i = 0; $i < 5; $i++) {
    echo "Number: $i<br>";
}
echo "<br>";

echo "<h3>Functions</h3>";
echo "<h4>Parameterized Function</h4>";
function greet($name)
{
    return "Hello, $name!<br>";
}
echo greet("John");

echo "<h4>Non-Parameterized Function</h4>";
function sayHello()
{
    echo "Hello, World!<br>";
}
sayHello();

echo "<br><br><strong>© 2025 Pitam. All rights reserved.</strong>";