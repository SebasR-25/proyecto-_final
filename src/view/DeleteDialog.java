package view;

import java.awt.event.ActionListener;

import javax.swing.*;

public class DeleteDialog extends JDialog {
    private ActionListener actionListener;
    private JLabel serieLabel;
    private JTextField serieNameText;
    private JButton continueButton;
    
    public DeleteDialog(ActionListener actionListener){
        this.actionListener = actionListener;
        setSize(300, 230);
        setLayout(null);
        setLocationRelativeTo(null);
        initComp();
        locateComp();
        setEvents();
        addComp();
    }


    private void initComp(){
        serieLabel = new JLabel("<html>Ingrese el nombre de la serie que desea borrar</html>");
        serieNameText = new JTextField();
        continueButton = new JButton( "Aceptar");
    }
    private void locateComp(){
        serieLabel.setBounds(75, 50, 150, 40);
        serieNameText.setBounds(75, 90, 150, 20);
        continueButton.setBounds(110, 130, 80, 20);    
    }
    private void addComp(){
        add(serieLabel);
        add(serieNameText);
        add(continueButton);
    }
    public JButton getContinueButton(){
        return continueButton;
    }
    private void setEvents(){
        continueButton.addActionListener(actionListener);
        continueButton.setActionCommand("DELETE_SERIE");
    }

    public JTextField getSerieNameText() {
        return serieNameText;
    }

    public void setSerieNameText(JTextField serieNameText) {
        this.serieNameText = serieNameText;
    }

    public void setContinueButton(JButton continueButton) {
        this.continueButton = continueButton;
    }
}