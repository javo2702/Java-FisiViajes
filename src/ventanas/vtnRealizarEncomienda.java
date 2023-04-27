/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Agencia;
import clases.Cliente;
import clases.Empresa;
import clases.Encomienda;
import clases.VentaEncomienda;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jvall
 */
public class vtnRealizarEncomienda extends javax.swing.JFrame {

    private Empresa emp;
    private Cliente cli;
    private String recep;
    private ArrayList<Encomienda> arrayEnco;
    private DefaultTableModel modelEnco;
    private String hora;
    private String fecha;
    private Agencia a;
    private VentaEncomienda vEnco;
    private int cantidadEnco;
    private double pesoTotal;
    private boolean flag;
    /**
     * Creates new form vtnRealizarEncomienda
     */
    public vtnRealizarEncomienda(Empresa emp2, Agencia a2,String recepcionista) {
        emp =  emp2;
        a = a2;
        recep = recepcionista;
        vEnco = new VentaEncomienda();
        arrayEnco = new ArrayList<>();
        hora = "";
        fecha = "";
        cantidadEnco = 0;
        pesoTotal = 0;
        flag = false;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage()); 
        llenarRutas();
        llenarTitulosTabla();
    }

    //Nuevo 
     public void validarDatosNumericos(java.awt.event.KeyEvent evento2){
        if((evento2.getKeyChar() >= 48 && evento2.getKeyChar() <= 57)){
            if(dest.getText().length()>8){
                JOptionPane.showMessageDialog(this, "Solo se admiten 9 digitos","Informacion", JOptionPane.INFORMATION_MESSAGE);
                dest.setText(dest.getText().substring(0, 9));
            }
        }
        else if(!(evento2.getKeyCode()==KeyEvent.VK_BACK_SPACE||evento2.getKeyCode()==KeyEvent.VK_LEFT||evento2.getKeyCode()==KeyEvent.VK_RIGHT
                ||evento2.getKeyCode()==KeyEvent.VK_ENTER)){
            dest.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Solo se admiten caracteres numericos","Error", JOptionPane.ERROR_MESSAGE);
            int ind = dest.getText().length()-1;
            if(!(dest.getText().charAt(ind)>='0'&& dest.getText().charAt(ind) <= '9')){
                dest.setText(dest.getText().substring(0, ind));
                dest.setBackground(Color.white);
            }
               
        }
    }
    public void validarDNIaBuscar(java.awt.event.KeyEvent evento2){
        if((evento2.getKeyChar() >= 48 && evento2.getKeyChar() <= 57)){
            if(txtDniCliente.getText().length()>8){
                JOptionPane.showMessageDialog(this, "Solo se admiten 9 digitos","Informacion", JOptionPane.INFORMATION_MESSAGE);
                txtDniCliente.setText(txtDniCliente.getText().substring(0, 9));
            }
        }
        else if(!(evento2.getKeyCode()==KeyEvent.VK_BACK_SPACE||evento2.getKeyCode()==KeyEvent.VK_LEFT||evento2.getKeyCode()==KeyEvent.VK_RIGHT
                ||evento2.getKeyCode()==KeyEvent.VK_ENTER)){
            txtDniCliente.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Solo se admiten caracteres numericos","Error", JOptionPane.ERROR_MESSAGE);
            int ind = txtDniCliente.getText().length()-1;
            if(!(txtDniCliente.getText().charAt(ind)>='0'&& txtDniCliente.getText().charAt(ind) <= '9')){
                txtDniCliente.setText(txtDniCliente.getText().substring(0, ind));
                txtDniCliente.setBackground(Color.white);
            }
               
        }
    }
    public void restringuirTextos(java.awt.event.KeyEvent evt){
        if(!((evt.getKeyChar()>=65 && evt.getKeyChar() <= 90)||(evt.getKeyChar()>=97 && evt.getKeyChar()<= 122)
                ||evt.getKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getKeyCode()==KeyEvent.VK_LEFT||evt.getKeyCode()==KeyEvent.VK_RIGHT
                ||evt.getKeyCode()==KeyEvent.VK_ENTER||evt.getKeyCode()==KeyEvent.VK_SHIFT||evt.getKeyCode()==KeyEvent.VK_SPACE)){
            JOptionPane.showMessageDialog(this, "No se admiten caracteres especiales","Error", JOptionPane.ERROR_MESSAGE);
            if(nomDest.getText().length()!=0){
               nomDest.setText(nomDest.getText().substring(0, nomDest.getText().length()-1)); 
            }
        }
    }
    
    public double excepcionPeso(){
        boolean bandera;
        double peso=0;
        String cadena = PesoEnco.getText();
        do{
            try{
                peso = Double.parseDouble(cadena);
                bandera = false;
                PesoEnco.setBackground(Color.white);
            } catch(NumberFormatException e){
                PesoEnco.setBackground(Color.red);
                cadena = JOptionPane.showInputDialog("Ingrese un monto numerico");
                PesoEnco.setText(cadena);
                bandera = true;
            }
        } while(bandera);
        return peso;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoEnco = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dest = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nomDest = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        costoTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtDniCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtplaca = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cDest = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableEnco = new javax.swing.JTable();
        insertar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        DescEnco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        rbSiEnco = new javax.swing.JRadioButton();
        rbNoEnco = new javax.swing.JRadioButton();
        txtnombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comrutas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        PesoEnco = new javax.swing.JTextField();
        confirmar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("DNI");

        jLabel2.setText("Emisor");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre");

        jLabel6.setText("Receptor");

        jLabel7.setText("DNI");

        dest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                destKeyPressed(evt);
            }
        });

        jLabel8.setText("Nombres");

        nomDest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomDestKeyPressed(evt);
            }
        });

        jLabel10.setText("Costo total");

        costoTotal.setEditable(false);

        jLabel11.setText("Codigo");

        txtDniCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniClienteKeyPressed(evt);
            }
        });

        jLabel12.setText("Furgon");

        txtplaca.setEditable(false);

        jLabel16.setText("Codigo");

        cDest.setEnabled(false);

        registrar.setText("Registrar encomienda");
        registrar.setEnabled(false);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel15.setText("Encomiendas");

        jButton3.setText("Volver");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        TableEnco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Descripcion/Nombre", "Fragil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableEnco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableEncoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableEnco);
        if (TableEnco.getColumnModel().getColumnCount() > 0) {
            TableEnco.getColumnModel().getColumn(0).setResizable(false);
            TableEnco.getColumnModel().getColumn(1).setResizable(false);
            TableEnco.getColumnModel().getColumn(2).setResizable(false);
        }

        insertar.setText("Insertar");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jLabel5.setText("Descripcion/Nombre");

        jLabel17.setText("¿Frágil?");

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        rbSiEnco.setText("Si");
        rbSiEnco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbSiEncoMouseClicked(evt);
            }
        });

        rbNoEnco.setText("No");

        txtnombre.setEditable(false);

        jLabel9.setText("Rutas");

        comrutas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        comrutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comrutasActionPerformed(evt);
            }
        });

        jLabel3.setText("Peso");

        confirmar.setText("Confirmar Datos");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logotipo2.0peque.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel5)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel17)
                        .addGap(115, 115, 115)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(DescEnco, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(rbSiEnco))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addComponent(PesoEnco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(rbNoEnco)
                        .addGap(63, 63, 63)
                        .addComponent(insertar)
                        .addGap(5, 5, 5)
                        .addComponent(modificar)
                        .addGap(7, 7, 7)
                        .addComponent(eliminar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(registrar)
                        .addGap(14, 14, 14)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(jLabel4)
                                .addGap(24, 24, 24)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)
                                .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(buscar)))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(37, 37, 37)
                                .addComponent(comrutas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel7)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(cDest, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(costoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dest, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel8)
                                .addGap(42, 42, 42)
                                .addComponent(nomDest, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(confirmar)
                .addGap(282, 282, 282))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DescEnco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(rbSiEnco)))
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buscar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comrutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4))
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12))
                            .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(PesoEnco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(rbNoEnco)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(nomDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(costoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        grupoEnco.add(rbSiEnco);
        grupoEnco.add(rbNoEnco);
    }//GEN-LAST:event_formWindowActivated

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        buscarCliente();
    }//GEN-LAST:event_buscarActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        // TODO add your handling code here:
        registrarEncomienda();
    }//GEN-LAST:event_registrarActionPerformed

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        // TODO add your handling code here:
        agregarItem();
    }//GEN-LAST:event_insertarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        modificarItem();
    }//GEN-LAST:event_modificarActionPerformed

    private void TableEncoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableEncoMouseClicked
        // TODO add your handling code here:
        int enco = TableEnco.rowAtPoint(evt.getPoint());
        mostrarTabla(enco);
    }//GEN-LAST:event_TableEncoMouseClicked

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        eliminarItem();
    }//GEN-LAST:event_eliminarActionPerformed

    private void rbSiEncoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbSiEncoMouseClicked
        // TODO add your handling code here:
        if(rbSiEnco.isSelected()){
            JOptionPane.showMessageDialog(null, "Existe un recargo del 5% del costo de su paquete");
        }
    }//GEN-LAST:event_rbSiEncoMouseClicked

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        // TODO add your handling code here:
        confirmarDatos();
    }//GEN-LAST:event_confirmarActionPerformed

    private void comrutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comrutasActionPerformed
        // TODO add your handling code here:
        llenarPlacaFurgon();
    }//GEN-LAST:event_comrutasActionPerformed

    private void destKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_destKeyPressed
        // TODO add your handling code here:
        validarDatosNumericos(evt);
    }//GEN-LAST:event_destKeyPressed

    private void nomDestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomDestKeyPressed
        // TODO add your handling code here:
        restringuirTextos(evt);
    }//GEN-LAST:event_nomDestKeyPressed

    private void txtDniClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClienteKeyPressed
        // TODO add your handling code here:
        validarDNIaBuscar(evt);
    }//GEN-LAST:event_txtDniClienteKeyPressed

    public void llenarRutas(){
        ArrayList<String> rutas = emp.rutas('f');
        for(int i=0;i<rutas.size();i++){
            comrutas.addItem(rutas.get(i));
        }
        comrutas.setSelectedItem(null);    
    }
    
    public void llenarTitulosTabla(){
        String[] titulos ={"Descripcion","Peso","Fragilidad"};
        modelEnco = new DefaultTableModel(null,titulos);
    }
    
    public void registrarEncomienda(){
        vEnco.setDestinatarioDNI(dest.getText());
        a.llenarEncomienda(vEnco,txtplaca.getText());
        DefaultTableModel modelo = a.mostrarDetalles(txtcodigo.getText());
        vtnBoletaEncomienda vBe = new vtnBoletaEncomienda(emp.getRuc(),recep,fecha,hora,txtDniCliente.getText(),txtnombre.getText(),dest.getText(),
                                                            nomDest.getText(),vEnco.getRuta(),String.valueOf(pesoTotal),
                                                            String.valueOf(vEnco.getCostoTotal()),modelo);
        vBe.setVisible(true);
        cantidadEnco = 0;
        pesoTotal = 0;
        limpiarComponentes();
    }
    
    public void agregarItem(){
        pesoTotal += excepcionPeso();
        if(a.obtenerCapacidadFurgon(txtplaca.getText())-pesoTotal>0){
            Encomienda enc = new Encomienda();
            enc.setNombreObjeto(DescEnco.getText());
            enc.setPeso(Double.parseDouble(PesoEnco.getText()));
            if(rbSiEnco.isSelected())
                enc.setFragilidad(true);
            else
                enc.setFragilidad(false);   
            arrayEnco.add(enc);
            llenarTable(enc);
            cantidadEnco += 1;
            limpiarCasillasItems();
        }
        else{
            JOptionPane.showMessageDialog(null, "El furgon esta en su máxima capacidad\nNo se pueden agregar mas Items");
            pesoTotal -= excepcionPeso();
            limpiarCasillasItems();
        }
    }
    
    public void limpiarCasillasItems(){
        PesoEnco.setText("");
        DescEnco.setText("");
        grupoEnco.clearSelection();
    }
    
    public void modificarItem(){
        int ind = TableEnco.getSelectedRow();
        Encomienda enc = new Encomienda();
        enc.setNombreObjeto(DescEnco.getText());
        enc.setPeso(Double.parseDouble(PesoEnco.getText()));
        if(rbSiEnco.isSelected())
            enc.setFragilidad(true);
        else
            enc.setFragilidad(false);   
        arrayEnco.add(ind, enc);
        modelEnco = (DefaultTableModel)TableEnco.getModel();
        modelEnco.removeRow(ind);
        llenarTable(enc);
    }
    
    public void mostrarTabla(int enco){
        DescEnco.setText(TableEnco.getValueAt(enco, 0).toString());
        PesoEnco.setText(TableEnco.getValueAt(enco, 1).toString());
        if(TableEnco.getValueAt(enco, 0).toString().equals("Si"))
            rbSiEnco.setSelected(true);
        else
            rbNoEnco.setSelected(true);
    }
    
    public void eliminarItem(){
        int in = TableEnco.getSelectedRow();
        modelEnco = (DefaultTableModel)TableEnco.getModel();
        modelEnco.removeRow(in);
        TableEnco.setModel(modelEnco);
    }
    
    public void confirmarDatos(){
        llenarDatosEnco();
        cDest.setText(txtcodigo.getText());
        costoTotal.setText(String.valueOf(vEnco.getCostoTotal()));
        insertar.setEnabled(false);
        modificar.setEnabled(false);
        eliminar.setEnabled(false);
        registrar.setEnabled(true);
    }
    
    public void llenarPlacaFurgon(){
        if(flag){
            int indice;
            String placaf;
            indice = comrutas.getSelectedIndex(); 
            placaf = emp.placaFurgon(comrutas.getItemAt(indice));
            if(a.obtenerCapacidadFurgon(placaf)!=0)
                txtplaca.setText(placaf);
            else
                JOptionPane.showMessageDialog(null, "Advertencia: Furgon sin capacidad\nSeleccione otra ruta"); /// Esto
        }
        else{
            txtplaca.setText("");
            flag = true; 
        }
        
    }
    
    public void llenarDatosEnco(){
        Date fechad = new Date();
        int indice;
        Double costo;
        vEnco.setClienteDNI(txtDniCliente.getText());
        vEnco.setListaEncomienda(arrayEnco);
        fecha = new SimpleDateFormat("dd-MM-yyyy").format(fechad);
        vEnco.setFechaPago(fecha);
        hora = getHora();
        vEnco.setHoraPago(hora);
        indice = comrutas.getSelectedIndex();
        vEnco.setRuta(comrutas.getItemAt(indice));
        costo = emp.obtenerCostoEncomienda(comrutas.getItemAt(indice),txtplaca.getText());
        vEnco.calcularCostoTotal(costo);
        vEnco.setCodigoPaquete(txtcodigo.getText());
        vEnco.setCantidad(cantidadEnco);
        vEnco.setPesoTotal(pesoTotal);
    }
    public String getHora(){
        Calendar date = Calendar.getInstance();
        int ho,min,seg;
        ho = date.get(Calendar.HOUR_OF_DAY);
        min = date.get(Calendar.MINUTE);
        seg = date.get(Calendar.SECOND);
        return ho+":"+min+":"+seg;
    }
            
    public void buscarCliente(){
       if(emp.buscarClienteDni(txtDniCliente.getText())){
          Cliente client = emp.getCliente();
            txtnombre.setText(client.getNombres());
     
          buscar.setEnabled(false);
        }
        else{        
      vtnRegistroCliente vR = new vtnRegistroCliente(txtDniCliente.getText(),emp);
       vR.setVisible(true);
       }
    }
    public void llenarTable(Encomienda enco){
       
        String[] campos = new String[3];
        campos[0] = enco.getNombreObjeto();
        campos[1] = String.valueOf(enco.getPeso());
        if(enco.isFragilidad())
            campos[2] = "Si";
        else 
            campos[2] = "No";
        modelEnco.addRow(campos);
        TableEnco.setModel(modelEnco);
    }
    
    public void limpiarComponentes(){
        txtDniCliente.setText("");
        txtplaca.setText("");
        txtcodigo.setText("");
        comrutas.setSelectedItem(null);
        txtnombre.setText("");
        TableEnco.setModel(null);
        DescEnco.setText("");
        PesoEnco.setText("");
        grupoEnco.clearSelection();
        dest.setText("");
        nomDest.setText("");
        cDest.setText("");
        costoTotal.setText("");
        registrar.setEnabled(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vtnRealizarEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vtnRealizarEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vtnRealizarEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vtnRealizarEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new vtnRealizarEncomienda(null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DescEnco;
    private javax.swing.JTextField PesoEnco;
    private javax.swing.JTable TableEnco;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField cDest;
    private javax.swing.JComboBox<String> comrutas;
    private javax.swing.JButton confirmar;
    private javax.swing.JTextField costoTotal;
    private javax.swing.JTextField dest;
    private javax.swing.JButton eliminar;
    private javax.swing.ButtonGroup grupoEnco;
    private javax.swing.JButton insertar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nomDest;
    private javax.swing.JRadioButton rbNoEnco;
    private javax.swing.JRadioButton rbSiEnco;
    private javax.swing.JButton registrar;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtplaca;
    // End of variables declaration//GEN-END:variables
}
