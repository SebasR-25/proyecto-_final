package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import resources.GlobalFont;

public class PanelInicial extends JPanel {
    private final ActionListener actionListener;
    private Image image;
    private JLabel bienvenido;
    private JLabel fanime;
    private JLabel frase;
    private JPanel logIn;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userText;
    private JTextField passwordText;
    private JButton logInButton;
    private JButton signInButton;
    
    public PanelInicial(ActionListener actionListener){
        this.actionListener = actionListener;
        ImageIcon icon = new ImageIcon("src/resources/media/Fondo.jpg");
        Image originalImage = icon.getImage();
        Image scaledImage = originalImage.getScaledInstance(1366, 768, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImage).getImage();
        setLayout(null);
        initLabels();
        addLabels();
        initPanel();
        addPanel();
        setEvents();
        setVisible(true);
    }

    private void setEvents() {
        logInButton.addActionListener(actionListener);
        logInButton.setActionCommand("LOGIN_USER");
        passwordText.addActionListener(actionListener);
        passwordText.setActionCommand("LOGIN_USER");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 1366, 768, this);
    }
    
    private void initLabels(){
        bienvenido = new JLabel("Bienvenido a");
        bienvenido.setBounds(641, 150, 100, 20);
        fanime = new JLabel("FANIME");
        fanime.setBounds(491, 190, 400, 40);
        frase = new JLabel("Maneja tus series favoritas");
        frase.setBounds(591, 250, 200, 20);
        setFonts();
    }
    private void setFonts(){
        Font font1 = new Font("SansSerif", Font.PLAIN, 14);
        bienvenido.setForeground(Color.white);
        fanime.setForeground(Color.white);
        frase.setForeground(Color.white);
        bienvenido.setFont(font1);
        frase.setFont(font1);
        fanime.setFont(GlobalFont.customFont);
        bienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        fanime.setHorizontalAlignment(SwingConstants.CENTER);
        frase.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private void addLabels(){
        add(bienvenido);
        add(fanime);
        add(frase);
    }
    
    private void initPanel(){
        logIn = new JPanel();
        logIn.setBounds(566, 350, 250, 250);
        logIn.setVisible(true);
        logIn.setOpaque(true);
        logIn.setBackground(Color.white);
        logIn.setLayout(null);
        initPanelElements();
        addPanelElements();    
    }
    private void addPanel(){
        add(logIn);
    }
    private void initPanelElements(){
        userLabel = new JLabel("Usuario");
        userLabel.setBounds(30, 30, 60, 20);
        passwordLabel = new JLabel("Contraseña");
        passwordLabel.setBounds(30, 80, 90, 20);
        userText = new JTextField(20);
        userText.setBounds(20, 50, 210, 20);
        passwordText = new JTextField(20);
        passwordText.setBounds(20, 100, 210, 20);
        logInButton = new JButton("Log in");
        logInButton.setBounds(70, 140, 90, 30);
        signInButton = new JButton("Sign in");
        signInButton.setBounds(70, 180, 90, 30);
    }
    private void addPanelElements(){
        logIn.add(userLabel);
        logIn.add(userText);
        logIn.add(passwordLabel);
        logIn.add(passwordText);
        logIn.add(logInButton);
        logIn.add(signInButton);
    }

    public JPanel getLogIn() {
        return logIn;
    }

    public void setLogIn(JPanel logIn) {
        this.logIn = logIn;
    }

    public JTextField getUserText() {
        return userText;
    }

    public void setUserText(JTextField userText) {
        this.userText = userText;
    }

    public JTextField getPasswordText() {
        return passwordText;
    }

    public void setPasswordText(JTextField passwordText) {
        this.passwordText = passwordText;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public void setLogInButton(JButton logInButton) {
        this.logInButton = logInButton;
    }

    public JButton getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(JButton signInButton) {
        this.signInButton = signInButton;
    }
}
