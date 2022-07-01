/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trabajo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author HP
 */
public class Ventana extends JFrame implements ActionListener{
    
    private JPanel jPanel1;
    private JPanel panelDim;
    private JPanel panelBot;
    private JPanel colorPanel;
    private PanelPrincipal jPanel2;
    private ArrayList<JLabel> labelList;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JButton jButton1;
    private JButton jButton2;
    

    public Ventana(String title) {
        super(title);
        this.setSize(560, 500);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        jButton1.addActionListener(this);  
        jButton2.addActionListener(this);  
    }
    
    private void initComponents(){
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        jPanel1 = new JPanel();
        jPanel1.setBorder(new TitledBorder("DIBUJAR FIGURA"));
        colorPanel = new JPanel();
        panelDim = new JPanel();
        panelBot = new JPanel();
        jPanel2 = new PanelPrincipal(new Figura(0, Color.YELLOW, 0, 0));
        jPanel2.setPreferredSize(new Dimension(100, 200));
        
        getContentPane().add(jPanel1);
        jPanel1.add(colorPanel);
        jPanel1.add(panelDim);
        jPanel1.add(panelBot);
        getContentPane().add(jPanel2);
        iniciarLabels();
        iniciarTextFields();
        iniciarComboBox();
        iniciarBotones();
        setPanels();
        
    }
    
    private void setPanels(){
       colorPanel.add(labelList.get(0));
       colorPanel.add(jComboBox1);
       colorPanel.add(labelList.get(1));
       colorPanel.add(jComboBox2);
       panelDim.add(labelList.get(2));
       panelDim.add(labelList.get(3));
       panelDim.add(jTextField1);
       panelDim.add(labelList.get(4));
       panelDim.add(jTextField2);
       panelBot.add(jButton1);
       panelBot.add(jButton2);
        
    }
    
    private void iniciarLabels(){
        labelList = new ArrayList<>();
        labelList.add(new JLabel("Seleccionar Figura que deseea"));
        labelList.add(new JLabel("Seleccionar el Color que deseea"));
        labelList.add(new JLabel("Dimensiones Figura:"));
        labelList.add(new JLabel("Alto"));
        labelList.add(new JLabel("Largo"));
 
    }
    
    private void iniciarTextFields(){
        jTextField1 = new JTextField(3);
        jTextField2 = new JTextField(3);
    }
    
    private void iniciarComboBox(){
        jComboBox2 = new JComboBox();
        jComboBox1 = new JComboBox();
        jComboBox1.addItem("Circulo");
        jComboBox1.addItem("Estrella");
        jComboBox1.addItem("Cuadrado");
        jComboBox1.addItem("Rectangulo");
        jComboBox1.addItem("Triangulo");
        jComboBox2.addItem("Amarillo");
        jComboBox2.addItem("Azul");
        jComboBox2.addItem("Rojo");
        jComboBox2.addItem("Verde");   
        
    }
    private void iniciarBotones(){
        jButton2 = new JButton("Nuevo");
        jButton1 = new JButton("Dibujar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jButton1 == e.getSource()) {
            getData();
            getColors();
            JOptionPane.showMessageDialog(this, "Por favor dar click en la "
                    + "pantalla de abajo para graficar");
        }
        else{
            jPanel2.getFigura().setHeight(0);
            jPanel2.getFigura().setWidth(0);
            jPanel2.repaint();
        }
      }
    private void getData(){ 
        jPanel2.getFigura().setFigura(jComboBox1.getSelectedIndex());
        jPanel2.getFigura().setHeight(Integer.parseInt(jTextField1.getText()));
        jPanel2.getFigura().setWidth(Integer.parseInt(jTextField2.getText()));       
    }
    private void getColors(){
        if (jComboBox2.getSelectedItem().equals("Amarillo")) {
            jPanel2.getFigura().setColor(Color.YELLOW);
        }
        if (jComboBox2.getSelectedItem().equals("Azul")) {
            jPanel2.getFigura().setColor(Color.BLUE);
        }
        if (jComboBox2.getSelectedItem().equals("Rojo")) {
            jPanel2.getFigura().setColor(Color.RED);
        }
        if (jComboBox2.getSelectedItem().equals("Verde")) {
            jPanel2.getFigura().setColor(Color.GREEN);
        }
    } 
}
    
    
    

