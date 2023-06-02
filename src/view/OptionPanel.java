package view;

import javax.swing.*;

import resources.GlobalFont;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class OptionPanel extends JPanel{
    private final ActionListener actionListener;
    private Image image;
    private JButton goToInfo;
    private JButton goToAdd;
    private JButton goToEdit;
    private JButton goToDelete;
    private JButton goToBack;
    private EditDialog editDialog;
    private AddDialog addDialog;
    private DeleteDialog deleteDialog;
    
    public OptionPanel(ActionListener actionListener){
        this.actionListener = actionListener;
        ImageIcon icon = new ImageIcon("src/resources/media/Fondo.jpg");
        Image originalImage = icon.getImage();
        Image scaledImage = originalImage.getScaledInstance(1366, 768, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImage).getImage();
        setLayout(null);
        initButtons();
        addFont();
        locateButtons();
        addButtons();
        addListeners();
        initDialogs(actionListener);
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 1366, 768, this);
    }

    private void initDialogs(ActionListener actionListener){
        addDialog = new AddDialog(actionListener);
        editDialog = new EditDialog(actionListener);
        deleteDialog = new DeleteDialog(actionListener);
        goToInfo.addActionListener(actionListener);
        goToInfo.setActionCommand("GO_TO_INFO");
    }
    private void initButtons(){
        goToInfo = new JButton("VER SERIES");
        goToAdd = new JButton("AÑADIR");
        goToEdit = new JButton("EDITAR");
        goToDelete = new JButton("BORRAR");
        goToBack = new JButton("REGRESAR");
    }
    private void addFont(){
        goToInfo.setFont(GlobalFont.infoFont);
        goToAdd.setFont(GlobalFont.infoFont);
        goToEdit.setFont(GlobalFont.infoFont);
        goToDelete.setFont(GlobalFont.infoFont);
        goToBack.setFont(GlobalFont.infoFont);
    }
    private void locateButtons(){
        goToInfo.setBounds(591, 61, 200, 80);
        goToAdd.setBounds(591, 202, 200, 80);
        goToEdit.setBounds(591, 343, 200, 80);
        goToDelete.setBounds(591, 484, 200, 80);
        goToBack.setBounds(591, 625, 200, 80);
    }
    private void addButtons(){
        add(goToInfo);
        add(goToAdd);
        add(goToEdit);
        add(goToDelete);
        add(goToBack);
    }
    private void addListeners(){
        goToEdit.addActionListener(actionListener);
        goToEdit.setActionCommand("SHOW_EDIT_DIALOG");
        goToDelete.addActionListener(e->{
            deleteDialog.getSerieNameText().setText("");
            deleteDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            deleteDialog.setVisible(true);
        });
        goToAdd.addActionListener(actionListener);
        goToAdd.setActionCommand("SHOW_ADD_DIALOG");
        addKeyStroke();
    }
    private void addKeyStroke(){
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.ALT_DOWN_MASK);
        InputMap inputMap = goToAdd.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, "myAction");
        ActionMap actionMap = goToAdd.getActionMap();
        actionMap.put("myAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("src/resources/media/Fondo_Easter_Egg.jpg");
                Image scaledImage = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/3, Image.SCALE_SMOOTH);
                image = new ImageIcon(scaledImage).getImage();
                repaint();
            }
        });
    }

    public JButton getGoToInfo() {
        return goToInfo;
    }

    public void setGoToInfo(JButton goToInfo) {
        this.goToInfo = goToInfo;
    }

    public JButton getGoToAdd() {
        return goToAdd;
    }

    public void setGoToAdd(JButton goToAdd) {
        this.goToAdd = goToAdd;
    }

    public JButton getGoToEdit() {
        return goToEdit;
    }

    public void setGoToEdit(JButton goToEdit) {
        this.goToEdit = goToEdit;
    }

    public JButton getGoToDelete() {
        return goToDelete;
    }

    public void setGoToDelete(JButton goToDelete) {
        this.goToDelete = goToDelete;
    }

    public JButton getGoToBack() {
        return goToBack;
    }

    public void setGoToBack(JButton goToBack) {
        this.goToBack = goToBack;
    }

    public EditDialog getEditDialog() {
        return editDialog;
    }

    public void setEditDialog(EditDialog editDialog) {
        this.editDialog = editDialog;
    }

    public AddDialog getAddDialog() {
        return addDialog;
    }

    public void setAddDialog(AddDialog addDialog) {
        this.addDialog = addDialog;
    }

    public DeleteDialog getDeleteDialog() {
        return deleteDialog;
    }

    public void setDeleteDialog(DeleteDialog deleteDialog) {
        this.deleteDialog = deleteDialog;
    }
}
