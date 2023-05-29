package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SignDialog extends JDialog {
    private final ActionListener actionListener;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JButton acceptButton;

    public SignDialog(ActionListener actionListener) {
        this.actionListener = actionListener;
        setVisible(false);
        setModal(true);
        setLayout(null);
        setSize(300, 300);
        initComp();
        locateComp();
        setEvents();
        addComp();
    }

    private void setEvents() {
        acceptButton.addActionListener(actionListener);
        acceptButton.setActionCommand("SIGN_USER");
        passwordField.addActionListener(actionListener);
        passwordField.setActionCommand("SIGN_USER");
    }

    private void initComp() {
        nameLabel = new JLabel("Ingrese un nombre de usuario");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameTextField = new JTextField();
        passwordLabel = new JLabel("Ingrese su nueva contraseña");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField = new JTextField();
        acceptButton = new JButton("Aceptar");
    }

    private void locateComp() {
        nameLabel.setBounds(50, 50, 200, 20);
        nameTextField.setBounds(50, 70, 200, 20);
        passwordLabel.setBounds(50, 110, 200, 20);
        passwordField.setBounds(50, 130, 200, 20);
        acceptButton.setBounds(105, 170, 90, 20);
    }

    private void addComp() {
        add(nameLabel);
        add(nameTextField);
        add(passwordLabel);
        add(passwordField);
        add(acceptButton);
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JTextField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }

    public void setAcceptButton(JButton acceptButton) {
        this.acceptButton = acceptButton;
    }
}
