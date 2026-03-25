package lab;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class SalaryBean {
    private double salary;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public SalaryBean() {}

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        double oldSalary = this.salary;
        this.salary = newSalary;
        pcs.firePropertyChange("salary", oldSalary, newSalary);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}

// Qn. Bound Property Implementation
public class Lab4_3 {
    public static void main(String[] args) {
        SalaryBean bean = new SalaryBean();

        bean.addPropertyChangeListener((PropertyChangeEvent evt) -> {
            System.out.println("\nProperty Change Event Occurred...");
            System.out.println("Property Name : " + evt.getPropertyName());
            System.out.println("Old Value     : " + evt.getOldValue());
            System.out.println("New Value     : " + evt.getNewValue());
        });

        System.out.println("Initial Salary : " + bean.getSalary());
        bean.setSalary(50000);
        bean.setSalary(65000);
    }
}
