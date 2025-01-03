<?php
// LAB 10: Implementing Inheritance in PHP
echo "<h2>LAB 10: Implementing Inheritance in PHP</h2>";

// Parent class
class Animal
{
    public function speak()
    {
        return "animal makes a sound<br>";
    }
}

// Child class inheriting from Animal
class Dog extends Animal
{
    public function speak()
    {
        return "dog barks<br>";
    }
}

// Create objects
$dog = new Dog();

echo $dog->speak();

echo "<br>© 2025 Pitam. All rights reserved.";
