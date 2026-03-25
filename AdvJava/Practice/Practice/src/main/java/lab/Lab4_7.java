package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class Lab4_7 extends JFrame {

    // Form components
    private JTextField txtName, txtEmail;
    private JTextArea txtAddress;
    private JRadioButton rbMale, rbFemale, rbOther;
    private JCheckBox cbReading, cbSports, cbMusic;
    private JButton btnSubmit, btnClear;

    public Lab4_7() {

        // JFrame settings
        setTitle("Student Registration System");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // MENU BAR
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuExit = new JMenuItem("Exit");

        menuExit.addActionListener(e -> System.exit(0));

        menuFile.add(menuExit);
        menuBar.add(menuFile);
        setJMenuBar(menuBar);

        // TOP PANEL
        JPanel topPanel = new JPanel(new GridLayout(1, 1));
        JLabel titleLabel = new JLabel("Student Registration System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // MAIN FORM PANEL
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Name
        formPanel.add(new JLabel("Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        // Email
        formPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        formPanel.add(txtEmail);

        // Address
        formPanel.add(new JLabel("Address:"));
        txtAddress = new JTextArea(3, 20);
        JScrollPane addressScroll = new JScrollPane(txtAddress);
        formPanel.add(addressScroll);

        // Gender
        formPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        rbOther = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        genderGroup.add(rbOther);

        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        genderPanel.add(rbOther);
        formPanel.add(genderPanel);

        // Hobbies
        formPanel.add(new JLabel("Hobbies:"));
        JPanel hobbyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cbReading = new JCheckBox("Reading");
        cbSports = new JCheckBox("Sports");
        cbMusic = new JCheckBox("Music");

        hobbyPanel.add(cbReading);
        hobbyPanel.add(cbSports);
        hobbyPanel.add(cbMusic);
        formPanel.add(hobbyPanel);

        add(formPanel, BorderLayout.CENTER);

        // BUTTON PANEL
        JPanel buttonPanel = new JPanel();
        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");

        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnClear);
        add(buttonPanel, BorderLayout.SOUTH);

        // EVENT HANDLING
        btnSubmit.addActionListener(e -> submitForm());
        btnClear.addActionListener(e -> clearForm());
    }

    // FORM VALIDATION & SUBMISSION
    private void submitForm() {
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String address = txtAddress.getText().trim();

        if (name.isEmpty()) {
            showError("Name is required.");
            return;
        }

        if (email.isEmpty() || !isValidEmail(email)) {
            showError("Please enter a valid email address.");
            return;
        }

        if (address.isEmpty()) {
            showError("Address cannot be empty.");
            return;
        }

        String gender = "";
        if (rbMale.isSelected()) gender = "Male";
        else if (rbFemale.isSelected()) gender = "Female";
        else if (rbOther.isSelected()) gender = "Other";
        else {
            showError("Please select a gender.");
            return;
        }

        String hobbies = "";
        if (cbReading.isSelected()) hobbies += "Reading, ";
        if (cbSports.isSelected()) hobbies += "Sports, ";
        if (cbMusic.isSelected()) hobbies += "Music, ";

        if (hobbies.isEmpty()) {
            showError("Please select at least one hobby.");
            return;
        }

        hobbies = hobbies.substring(0, hobbies.length() - 2);

        //SUMMARY DIALOG
        String summary =
                "Student Registration Summary\n\n" +
                        "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Address: " + address + "\n" +
                        "Gender: " + gender + "\n" +
                        "Hobbies: " + hobbies;

        JOptionPane.showMessageDialog(this, summary,
                "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
    }

    // CLEAR FORM
    private void clearForm() {
        txtName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        rbMale.setSelected(false);
        rbFemale.setSelected(false);
        rbOther.setSelected(false);
        cbReading.setSelected(false);
        cbSports.setSelected(false);
        cbMusic.setSelected(false);
    }

    // EMAIL VALIDATION
    private boolean isValidEmail(String email) {

        return Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message,
                "Input Error", JOptionPane.ERROR_MESSAGE);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Lab4_7().setVisible(true);
        });
    }
}
