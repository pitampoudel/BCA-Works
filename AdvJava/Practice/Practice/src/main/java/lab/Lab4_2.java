package lab;

import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

// Qn. Java Bean Introspection

class EmployeeBean2 {
    private int employeeId;
    private String name;

    public EmployeeBean2() {}

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

}

public class Lab4_2 {
    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(EmployeeBean2.class);
            System.out.println("JavaBean Introspection Report");
            System.out.println("\nProperties...");
            for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
                System.out.println("Property Name : " + pd.getName());
            }

            System.out.println("\nMethods...");
            for (MethodDescriptor md : beanInfo.getMethodDescriptors()) {
                System.out.println("Method Name : " + md.getMethod().getName());
            }

            System.out.println("\nEvents...");
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
