package lab;
abstract class Animal {
 abstract void makeSound();
}

class Dog extends Animal {
 void makeSound() {
     System.out.println("dog makes Woof sound");
 }
}

class Cat extends Animal {
 void makeSound() {
     System.out.println("cat makes Meow sound");
 }
}

public class lab10 {
 public static void main(String[] args) {
     Animal dog = new Dog();
     Animal cat = new Cat();

     dog.makeSound();
     cat.makeSound();
     System.out.println("Copyright Pitam Poudel");
 }
}
