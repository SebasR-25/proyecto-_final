package view;

import model.BroadcastDay;
import model.Serie;
import model.Status;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class EditDialog extends JDialog {
    private ActionListener actionListener;
    private JLabel editText;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel statusLabel;
    private JComboBox<String> statusField;
    private JLabel seasonsLabel;
    private JTextField seasonsField;
    private JLabel chapsLabel;
    private JTextField chapsField;
    private JLabel broadcastLabel;
    private JComboBox<String> broadcastField;
    private JLabel genresLabel;
    private JTextField genresField;
    private JLabel description;
    private JTextArea descriptionArea;
    private JButton acceptButton;

    public EditDialog(ActionListener actionListener) {
        this.actionListener = actionListener;
        setSize(300, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        labels();
        textFields();
        button();
        setEvents();
    }

    private void initLabels() {
        editText = new JLabel("Editar serie");
        nameLabel = new JLabel("Nombre:");
        statusLabel = new JLabel("Estado:");
        seasonsLabel = new JLabel("Temporadas:");
        chapsLabel = new JLabel("Capítulos:");
        broadcastLabel = new JLabel("Emisión:");
        genresLabel = new JLabel("Géneros (Ej: Aventura, Action, Fantasia):");
        description = new JLabel("Description:");
    }

    private void locateLabels() {
        editText.setBounds(100, 20, 100, 20);
        nameLabel.setBounds(20, 60, 50, 20);
        statusLabel.setBounds(20, 100, 50, 20);
        seasonsLabel.setBounds(20, 140, 80, 20);
        chapsLabel.setBounds(20, 180, 80, 20);
        broadcastLabel.setBounds(20, 220, 80, 20);
        genresLabel.setBounds(20, 260, 300, 20);
        description.setBounds(20, 300, 80, 20);
    }

    private void addLabels() {
        add(editText);
        add(nameLabel);
        add(statusLabel);
        add(seasonsLabel);
        add(chapsLabel);
        add(broadcastLabel);
        add(genresLabel);
        add(description);
    }

    private void labels() {
        initLabels();
        locateLabels();
        addLabels();
    }

    private void initFields() {
        nameTextField = new JTextField();
        statusField = new JComboBox<>();
        seasonsField = new JTextField();
        chapsField = new JTextField();
        broadcastField = new JComboBox<>();
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
        acceptButton = new JButton("Aceptar");
        acceptButton.setBounds(110, 420, 80, 20);
        add(acceptButton);
    }

    private void setEvents() {
        acceptButton.addActionListener(actionListener);
        acceptButton.setActionCommand("EDIT_ACCEPT");
    }

    public void clearFields() {
        nameTextField.setText("");
        seasonsField.setText("");
        chapsField.setText("");
        if (statusField.getItemCount() > 0 && broadcastField.getItemCount() > 0){
            statusField.setSelectedIndex(0);
            broadcastField.setSelectedIndex(0);
        }
        genresField.setText("");
        descriptionArea.setText("");
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JComboBox<String> getStatusField() {
        return statusField;
    }

    public JTextField getSeasonsField() {
        return seasonsField;
    }

    public JTextField getChapsField() {
        return chapsField;
    }

    public JComboBox<String> getBroadcastField() {
        return broadcastField;
    }

    public JTextField getGenresField() {
        return genresField;
    }

    public JTextArea getDescriptionArea() {
        return descriptionArea;
    }


    public void fillInfo(Serie serie) {
        nameTextField.setText(serie.getName());
        statusField.setSelectedItem(serie.getStatus().toString());
        seasonsField.setText(String.valueOf(serie.getSeasons()));
        chapsField.setText(String.valueOf(serie.getChapters()));
        broadcastField.setSelectedItem(serie.getBroadcastDay().toString());
        genresField.setText(adaptGenres(serie.getGenres()));
        descriptionArea.setText(serie.getDescription());
    }

    private String adaptGenres(List<String> genres) {
        StringBuilder genresString = new StringBuilder();
        for (String genre : genres) {
            genresString.append(genre).append(", ");
        }
        return genresString.substring(0, genresString.length() - 2);
    }
    public void fillComboBoxes(List<Status> statusList, List<BroadcastDay> broadcastDays) {
        for (Status status : statusList) {
            statusField.addItem(String.valueOf(status));
        }
        for (BroadcastDay broadcastDay : broadcastDays) {
            broadcastField.addItem(String.valueOf(broadcastDay));
        }

    }
}
