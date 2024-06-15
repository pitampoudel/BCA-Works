package lab;
public class lab14 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello ");

        sb.append("Pitam Poudel");
        System.out.println("StringBuffer after appending: " + sb);

        sb.insert(8, "Pitam ");
        System.out.println("StringBuffer after inserting: " + sb);

        sb.delete(1, 2);
        System.out.println("StringBuffer after deleting: " + sb);

        sb.reverse();
        System.out.println("StringBuffer after reversing: " + sb);

        sb.setLength(10);
        System.out.println("StringBuffer after setting length: " + sb);
    }
}
