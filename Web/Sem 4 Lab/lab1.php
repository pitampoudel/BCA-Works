<?php
/*
Implement basic syntaxt on php
 * Variable declaration
 * PHP operator
 * If-Else statement
 * while/do while/for/for each loops
 * Function: Parameter and non parameter
 */

$name = "John";
$age = 25;
echo "Name: $name, Age: $age";

$a = 10;
$b = 20;
$sum = $a + $b;
echo "Sum: $sum";

$number = 5;
if ($number > 0) {
    echo "Positive Number";
} else {
    echo "Negative Number";
}

// WHILE
$i = 0;
while ($i < 5) {
    echo "Number: $i<br>";
    $i++;
}
// DO WHILE
do {
    echo "Number: $i<br>";
    $i++;
} while ($i < 5);

// FOR EACH
$array = [1, 2, 3, 4, 5];
foreach ($array as $value) {
    echo "Value: $value<br>";
}

// FOR
for ($i = 0; $i < 5; $i++) {
    echo "Number: $i<br>";
}

// Parameterized

function greet($name)
{
    return "Hello, $name!";
}
echo greet("John");

// Non-Parameterized
function sayHello()
{
    echo "Hello, World!";
}
sayHello();

echo "<br><br>© 2025 Pitam. All rights reserved.";
