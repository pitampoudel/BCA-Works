package lab;

class EmployeeBean1 {
    private int employeeId;
    private String name;
    private String department;
    private double salary;

    public EmployeeBean1() {}

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

// Qn. JavaBean Creation and property access
public class Lab4_1 {
    public static void main(String[] args) {
        EmployeeBean1 emp = new EmployeeBean1();
        emp.setEmployeeId(101);
        emp.setName("Saudeep Adhikari");
        emp.setDepartment("IT");
        emp.setSalary(55555000);

        System.out.println("        EmployeeBean Details");
        System.out.println("Employee ID   : " + emp.getEmployeeId());
        System.out.println("Name          : " + emp.getName());
        System.out.println("Department    : " + emp.getDepartment());
        System.out.println("Salary        : " + emp.getSalary());
    }
}
