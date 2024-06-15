package lab;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class MyObject implements Serializable {
    int id;
    String name;

    public MyObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "MyObject [id=" + id + ", name=" + name + "]";
    }
}

	public class lab20 {
    public static void main(String[] args) {

        MyObject obj = new MyObject(1, "Pitam Poudel");

        // Serialization
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("myObject.ser"))) {
            objectOutputStream.writeObject(obj);
            System.out.println("MyObject object has been serialized.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        MyObject deserializedObj = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("myObject.ser"))) {
            deserializedObj = (MyObject) objectInputStream.readObject();
            System.out.println("MyObject object has been deserialized:\n " + deserializedObj);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        System.out.println("Copyright Pitam Poudel");
    }
}
