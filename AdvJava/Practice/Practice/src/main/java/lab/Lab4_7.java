package lab;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

// Qn. Student Registration System
public class Lab4_7 extends JFrame {
    private final JTextField txtName = new JTextField();
    private final JTextField txtEmail = new JTextField();
    private final JTextArea txtAddress = new JTextArea(3, 20);
    private final JRadioButton rbMale = new JRadioButton("Male");
    private final JRadioButton rbFemale = new JRadioButton("Female");
    private final JRadioButton rbOther = new JRadioButton("Other");
    private final JCheckBox cbReading = new JCheckBox("Reading");
    private final JCheckBox cbSports = new JCheckBox("Sports");
    private final JCheckBox cbMusic = new JCheckBox("Music");

    public Lab4_7() {
        setTitle("Student Registration System");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(e -> System.exit(0));
        menuFile.add(menuExit);
        menuBar.add(menuFile);
        setJMenuBar(menuBar);

        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("Student Registration System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        formPanel.add(new JLabel("Name:"));
        formPanel.add(txtName);

        formPanel.add(new JLabel("Email:"));
        formPanel.add(txtEmail);

        formPanel.add(new JLabel("Address:"));
        formPanel.add(new JScrollPane(txtAddress));

        formPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        genderGroup.add(rbOther);

        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        genderPanel.add(rbOther);
        formPanel.add(genderPanel);

        formPanel.add(new JLabel("Hobbies:"));
        JPanel hobbyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hobbyPanel.add(cbReading);
        hobbyPanel.add(cbSports);
        hobbyPanel.add(cbMusic);
        formPanel.add(hobbyPanel);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton btnSubmit = new JButton("Submit");
        JButton btnClear = new JButton("Clear");

        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnClear);
        add(buttonPanel, BorderLayout.SOUTH);

        btnSubmit.addActionListener(e -> submitForm());
        btnClear.addActionListener(e -> clearForm());
    }

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

        String gender;
        if (rbMale.isSelected()) {
            gender = "Male";
        } else if (rbFemale.isSelected()) {
            gender = "Female";
        } else if (rbOther.isSelected()) {
            gender = "Other";
        } else {
            showError("Please select a gender.");
            return;
        }

        StringBuilder hobbies = new StringBuilder();
        if (cbReading.isSelected()) hobbies.append("Reading, ");
        if (cbSports.isSelected()) hobbies.append("Sports, ");
        if (cbMusic.isSelected()) hobbies.append("Music, ");

        if (hobbies.length() == 0) {
            showError("Please select at least one hobby.");
            return;
        }
        hobbies.setLength(hobbies.length() - 2);

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

    private boolean isValidEmail(String email) {
        return Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message,
                "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab4_7().setVisible(true));
    }
}
