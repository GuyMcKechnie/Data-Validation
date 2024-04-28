package ABCHospital;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static javax.swing.UIManager.setLookAndFeel;

public class MainMenu extends JFrame {
    private JPanel contentPane;
    private JLabel hospitalName;
    public JTextField fullNameInputField;
    private JLabel firstNameAndSurname;
    public JTextField identificationNumber;
    public JLabel identificationNumberLabel;
    public JLabel dateOfBirthJLabel;
    private JTextField yearDateInputField;
    private JButton loginButton;
    private JPanel mainPanel;
    private JTextField dayDateInputField;
    private JTextField monthDateInputField;

    public MainMenu() {
        main main = new main();
        try {
            setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //Centering
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation(screenSize.width/2-350, screenSize.height/2-300);
        } catch (Exception e) {
            System.out.println(e);
        }
        setContentPane(contentPane);
        setTitle("National Baseline Test");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InputValidation validation = new InputValidation();
                if (validation.validationOfFullName(fullNameInputField.getText()).equals(false)) { //If returned false | If empty
                    firstNameAndSurname.setForeground(Color.RED);
                    firstNameAndSurname.setText("The name inputted is blank!");
                } else {
                    main.output = main.output + "\nFull Name: " + fullNameInputField.getText();
                    firstNameAndSurname.setForeground(Color.BLACK);
                    firstNameAndSurname.setText("Enter your Full Name");
                }
                if (validation.validationOfIdentificationNumber(identificationNumber.getText()).equals(false)) {
                    identificationNumberLabel.setForeground(Color.RED);
                    identificationNumberLabel.setText("The ID inputted is invalid!");
                } else {
                    main.output = main.output + "\nID Number: " + identificationNumber.getText();
                    identificationNumberLabel.setForeground(Color.BLACK);
                    identificationNumberLabel.setText("Enter your 8 Digit ID number");
                }
                try {
                    //Format Check
                    String dateString = yearDateInputField.getText()+"/"+monthDateInputField.getText()+"/"+dayDateInputField.getText();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate date = LocalDate.parse(dateString, formatter);
                    if (!yearDateInputField.getText().isEmpty() || !monthDateInputField.getText().isEmpty() || !dayDateInputField.getText().isEmpty()) { //Presence Check
                        if (validation.birthDateValidation(date).equals(false)) {
                            if (date.getYear() > ((LocalDate.now().getYear()) - 18) && (date.isBefore(LocalDate.now()))) { //Less than 18 years old
                                dateOfBirthJLabel.setForeground(Color.BLUE);
                                dateOfBirthJLabel.setText("You must be older than 18 years!");
                            } else if (date.getYear() > 0) {
                                dateOfBirthJLabel.setForeground(Color.RED);
                                dateOfBirthJLabel.setText("The inputted date is negative!");
                            } else {
                                dateOfBirthJLabel.setForeground(Color.RED);
                                dateOfBirthJLabel.setText("The inputted date is invalid!");
                            }
                        } else {
                            main.output = main.output + "\nDate Of Birth: " + dateString;
                            dateOfBirthJLabel.setForeground(Color.BLACK);
                            dateOfBirthJLabel.setText("Enter your Date of Birth");
                        }
                    } else {
                        dateOfBirthJLabel.setForeground(Color.RED);
                        dateOfBirthJLabel.setText("The inputted date is blank!");
                    }
                }catch (Exception exception){
                    dateOfBirthJLabel.setForeground(Color.RED);
                    dateOfBirthJLabel.setText("The inputted date is invalid!");
                }
                if(validation.isValid()){
                    hospitalName.setText("Welcome");
                }
                System.out.println(main.output);
            }
        });
    }
}
