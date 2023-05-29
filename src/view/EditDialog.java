package view;

import javax.swing.*;

public class EditDialog extends JDialog{
    private JLabel editText;
    private JLabel nameLabel;
    private JTextField namTextField;
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
    private JTextArea descrptioArea;
    private JButton aceptButton;

    public EditDialog(){
        setSize(300, 500);
        setLayout(null);
        initLabels();
        locateLabels();
        addLabels();	    
        button();    
    }

    private void initLabels(){
        editText = new JLabel("Editar serie");
        nameLabel = new JLabel("Nombre:");
        statusLabel = new JLabel("Estado:");
        seasonsLabel = new JLabel("Temporadas:");
        chapsLabel = new JLabel("Cápitulos:");
        broadcastLabel = new JLabel("Emisión:");
        genresLabel = new JLabel("Géneros");
        descrption = new JLabel("Descrpción:");
    }
    private void locateLabels(){
        editText.setBounds(100, 20, 100, 20);
        nameLabel.setBounds(20, 60, 50, 20);
        statusLabel.setBounds(20, 100, 50, 20);
        seasonsLabel.setBounds(20, 140, 80, 20);
        chapsLabel.setBounds(20, 180, 80, 20);
        broadcastLabel.setBounds(20, 220, 80, 20);
        genresLabel.setBounds(20, 260, 80, 20);
        descrption.setBounds(20, 300, 80, 20);
    }
    private void addLabels(){
        add(editText);
        add(nameLabel);
        add(statusLabel);
        add(seasonsLabel);
        add(chapsLabel);
        add(broadcastLabel);
        add(genresLabel);
        add(descrption);
    }
    
    private void button(){
        aceptButton = new JButton("Aceptar");
        aceptButton.setBounds(125, 360, 50, 20);
        add(aceptButton);
    }
}
