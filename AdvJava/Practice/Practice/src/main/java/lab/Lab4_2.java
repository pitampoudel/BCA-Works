import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

// JavaBean class
class EmployeeBean2 {

    private int employeeId;
    private String name;
    private String department;
    private double salary;

    public EmployeeBean2() {
    }

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

public class Lab4_2 {

    public static void main(String[] args) {

        try {
            // Get BeanInfo using Introspector
            BeanInfo beanInfo = Introspector.getBeanInfo(EmployeeBean.class);

            System.out.println("Saudeep Adhikari ");
            System.out.println("JavaBean Introspection Report");

            // Properties Section
            System.out.println("\nProperties...");
            for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
                System.out.println("Property Name : " + pd.getName());
            }

            // Methods Section
            System.out.println("\n Methods...");
            for (MethodDescriptor md : beanInfo.getMethodDescriptors()) {
                System.out.println("Method Name : " + md.getMethod().getName());
            }

            // Events Section
            System.out.println("\nEvents... ");
            EventSetDescriptor[] events = beanInfo.getEventSetDescriptors();
            if (events.length == 0) {
                System.out.println("No events supported by this bean.");
            } else {
                for (EventSetDescriptor ed : events) {
                    System.out.println("Event Name : " + ed.getName());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
