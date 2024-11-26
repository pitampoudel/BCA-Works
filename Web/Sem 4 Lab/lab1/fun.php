<?php
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