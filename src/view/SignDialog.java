package view;

import javax.swing.*;

public class SignDialog extends JDialog{
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JButton aceptButton;

    public SignDialog(){
        setVisible(false);
        setModal(false);
        setLayout(null);
        setSize(300, 300);
        initComp();
        locateComp();
        addComp();
    }

    private void initComp(){
        nameLabel = new JLabel("Ingrese un nombre de usuario");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameTextField = new JTextField();
        passwordLabel = new JLabel("Ingrese su nueva contraseña");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField = new JTextField();
        aceptButton = new JButton("Aceptar");
    }
    private void locateComp(){
        nameLabel.setBounds(50, 50, 200, 20);
        nameTextField.setBounds(50, 70, 200, 20);
        passwordLabel.setBounds(50, 110, 200, 20);
        passwordField.setBounds(50, 130, 200, 20);
        aceptButton.setBounds(105, 170, 90, 20);
    }
    private void addComp(){
        add(nameLabel);
        add(nameTextField);
        add(passwordLabel);
        add(passwordField);
        add(aceptButton);
    }
}
