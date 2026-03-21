class EmployeeBean1 {

    // Private properties
    private int employeeId;
    private String name;
    private String department;
    private double salary;

    // No-argument constructor
    public EmployeeBean1() {
    }

    // Getter and Setter methods
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

// Main class
public class Lab4_1 {

    public static void main(String[] args) {

        // Create JavaBean object
        EmployeeBean emp = new EmployeeBean();

        // Set values
        emp.setEmployeeId(101);
        emp.setName("Saudeep Adhikari");
        emp.setDepartment("IT");
        emp.setSalary(55555000);

        // Display output
        System.out.println("        EmployeeBean Details");
        System.out.println("Employee ID   : " + emp.getEmployeeId());
        System.out.println("Name          : " + emp.getName());
        System.out.println("Department    : " + emp.getDepartment());
        System.out.println("Salary        : " + emp.getSalary());
    }
}
