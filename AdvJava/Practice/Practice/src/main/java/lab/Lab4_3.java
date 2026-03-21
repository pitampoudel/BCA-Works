import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// JavaBean with bound property
class SalaryBean {

    private double salary;
    private PropertyChangeSupport pcs;

    // Constructor
    public SalaryBean() {
        pcs = new PropertyChangeSupport(this);
    }

    // Getter
    public double getSalary() {
        return salary;
    }

    // Setter (Bound Property)
    public void setSalary(double newSalary) {
        double oldSalary = this.salary;
        this.salary = newSalary;

        // Fire property change event
        pcs.firePropertyChange("salary", oldSalary, newSalary);
    }

    // Register listener
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}

// Main class
public class Lab4_3 {

    public static void main(String[] args) {
        System.out.println("Saudeep Adhikari\n");
        SalaryBean bean = new SalaryBean();

        // Register PropertyChangeListener
        bean.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("\nProperty Change Event Occurred...");
                System.out.println("Property Name : " + evt.getPropertyName());
                System.out.println("Old Value     : " + evt.getOldValue());
                System.out.println("New Value     : " + evt.getNewValue());
            }
        });

        // Display initial value
        System.out.println("Initial Salary : " + bean.getSalary());

        // Change property value
        bean.setSalary(50000);
        bean.setSalary(65000);
    }
}
