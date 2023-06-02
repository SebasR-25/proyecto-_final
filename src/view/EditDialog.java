package view;

import java.awt.event.ActionListener;

import javax.swing.*;

public class EditDialog extends JDialog {
    private ActionListener actionListener;
    private JLabel editText;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel statusLabel;
    private JTextField statusField;
    private JLabel seasonsLabel;
    private JTextField seasonsField;
    private JLabel chapsLabel;
    private JTextField chapsField;
    private JLabel broadcastLabel;
    private JTextField broadcastField;
    private JLabel genresLabel;
    private JTextField genresField;
    private JLabel descrption;
    private JTextArea descriptionArea;
    private JButton aceptButton;

    public EditDialog(ActionListener actionListener) {
        this.actionListener = actionListener;
        setSize(300, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        labels();
        textFields();
        button();
    }

    private void initLabels() {
        editText = new JLabel("Editar serie");
        nameLabel = new JLabel("Nombre:");
        statusLabel = new JLabel("Estado:");
        seasonsLabel = new JLabel("Temporadas:");
        chapsLabel = new JLabel("Cápitulos:");
        broadcastLabel = new JLabel("Emisión:");
        genresLabel = new JLabel("Géneros");
        descrption = new JLabel("Descrpción:");
    }

    private void locateLabels() {
        editText.setBounds(100, 20, 100, 20);
        nameLabel.setBounds(20, 60, 50, 20);
        statusLabel.setBounds(20, 100, 50, 20);
        seasonsLabel.setBounds(20, 140, 80, 20);
        chapsLabel.setBounds(20, 180, 80, 20);
        broadcastLabel.setBounds(20, 220, 80, 20);
        genresLabel.setBounds(20, 260, 80, 20);
        descrption.setBounds(20, 300, 80, 20);
    }

    private void addLabels() {
        add(editText);
        add(nameLabel);
        add(statusLabel);
        add(seasonsLabel);
        add(chapsLabel);
        add(broadcastLabel);
        add(genresLabel);
        add(descrption);
    }

    private void labels() {
        initLabels();
        locateLabels();
        addLabels();
    }

    private void initFields() {
        nameTextField = new JTextField();
        statusField = new JTextField();
        seasonsField = new JTextField();
        chapsField = new JTextField();
        broadcastField = new JTextField();
        genresField = new JTextField();
        descriptionArea = new JTextArea();
        descriptionArea.setLineWrap(true); 
        descriptionArea.setWrapStyleWord(true);
    }

    private void locateFields() {
        nameTextField.setBounds(20, 80, 200, 20);
        statusField.setBounds(20, 120, 200, 20);
        seasonsField.setBounds(20, 160, 200, 20);
        chapsField.setBounds(20, 200, 200, 20);
        broadcastField.setBounds(20, 240, 200, 20);
        genresField.setBounds(20, 280, 200, 20);
        descriptionArea.setBounds(20, 320, 200, 60);
    }

    private void addTextFields() {
        add(nameTextField);
        add(statusField);
        add(seasonsField);
        add(chapsField);
        add(broadcastField);
        add(genresField);
        add(descriptionArea);
    }

    private void textFields() {
        initFields();
        locateFields();
        addTextFields();
    }

    private void button() {
        aceptButton = new JButton("Aceptar");
        aceptButton.setBounds(110, 420, 80, 20);
        add(aceptButton);
    }

    public JButton getAceptButton() {
        return aceptButton;
    }
    private void setEvents(){
        aceptButton.addActionListener(actionListener);
        aceptButton.setActionCommand("EDIT_SERIE");
    }
}
