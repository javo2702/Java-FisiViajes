/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conductor;
import clases.Empresa;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jvall
 */
public class vtnRegistroConductor extends javax.swing.JFrame {

    Empresa emp;

    
    /**
     * Creates new form vtnRegistroChofer
     */
    public vtnRegistroConductor(Empresa emp1) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        emp = emp1;
        tablaChoferes.setModel(emp.mostrarDatosConductor());
    }
    //Nuevo similar en los demas registros
    
    public void validarDatosNumericos(java.awt.event.KeyEvent evento2){
        if((evento2.getKeyChar() >= 48 && evento2.getKeyChar() <= 57)){
            if(txtChoD.getText().length()>8){
                JOptionPane.showMessageDialog(this, "Solo se admiten 9 digitos","Informacion", JOptionPane.INFORMATION_MESSAGE);
                txtChoD.setText(txtChoD.getText().substring(0, 9));
            }
        }
        else if(!(evento2.getKeyCode()==KeyEvent.VK_BACK_SPACE||evento2.getKeyCode()==KeyEvent.VK_LEFT||evento2.getKeyCode()==KeyEvent.VK_RIGHT
                ||evento2.getKeyCode()==KeyEvent.VK_ENTER)){
            JOptionPane.showMessageDialog(this, "Solo se admiten caracteres numericos","Error", JOptionPane.ERROR_MESSAGE);
            int ind = txtChoD.getText().length()-1;
            if(!(txtChoD.getText().charAt(ind)>='0'&& txtChoD.getText().charAt(ind) <= '9'))
               txtChoD.setText(txtChoD.getText().substring(0, ind));
        }
    }
    public void validarCelular(java.awt.event.KeyEvent evento2){
        if((evento2.getKeyChar() >= 48 && evento2.getKeyChar()<= 57)){
            if(txtChoCel.getText().length()>8){
                JOptionPane.showMessageDialog(this, "Solo se admiten 9 digitos","Informacion", JOptionPane.INFORMATION_MESSAGE);
                txtChoCel.setText(txtChoCel.getText().substring(0, 9));
            }
        }
        else if(!(evento2.getKeyCode()==KeyEvent.VK_BACK_SPACE||evento2.getKeyCode()==KeyEvent.VK_LEFT||evento2.getKeyCode()==KeyEvent.VK_RIGHT
                ||evento2.getKeyCode()==KeyEvent.VK_ENTER)){
            txtChoCel.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Solo se admiten caracteres numericos","Error", JOptionPane.ERROR_MESSAGE);
            int ind = txtChoCel.getText().length()-1;
            if(!(txtChoCel.getText().charAt(ind)>='0'&& txtChoCel.getText().charAt(ind) <= '9')){
               txtChoCel.setText(txtChoCel.getText().substring(0, ind));
               txtChoCel.setBackground(Color.white);
            }       
        }
    }
    
    public void restringuirTextos(java.awt.event.KeyEvent evt, char opc){
        if(!((evt.getKeyChar()>=65 && evt.getKeyChar() <= 90)||(evt.getKeyChar()>=97 && evt.getKeyChar()<= 122)
                ||evt.getKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getKeyCode()==KeyEvent.VK_LEFT||evt.getKeyCode()==KeyEvent.VK_RIGHT
                ||evt.getKeyCode()==KeyEvent.VK_ENTER||evt.getKeyCode()==KeyEvent.VK_SHIFT||evt.getKeyCode()==KeyEvent.VK_SPACE)){
            JOptionPane.showMessageDialog(this, "No se admiten caracteres especiales","Error", JOptionPane.ERROR_MESSAGE);
            if(txtChoName.getText().length()!=0 && opc == 'n'){
               txtChoName.setText(txtChoName.getText().substring(0, txtChoName.getText().length()-1)); 
            }
            if(txtChoApe.getText().length()!=0 && opc == 'a'){
                txtChoApe.setText(txtChoApe.getText().substring(0, txtChoApe.getText().length()-1));
            }
        }
    }
    
    public String restringuirIdCorporativo(){
        String cod = txtChoID.getText();
        boolean flag=false;
        do{
            if(cod.length()<=10)
                flag = true;
            else
                cod = JOptionPane.showInputDialog("Ingrese un Id Corporativo\ncon 10 caracteres como máximo");
        } while(!flag);
        return cod;
    }
    
    public int excepcionEdad(){
        boolean flag;
        int edad=0;
        String cadena = txtChoEdad.getText();
        do{
            try{
                edad = Integer.parseInt(cadena);
                flag = false;
                txtChoEdad.setBackground(Color.white);
            } catch(NumberFormatException e){
                txtChoEdad.setBackground(Color.red);
                cadena = JOptionPane.showInputDialog("Ingrese una edad numerica");
                txtChoEdad.setText(cadena);
                flag = true;
            }
        } while(flag);
        return edad;
    }
    public double excepcionSueldo(){
        boolean flag;
        double sueldo=0;
        String cadena = txtChoSueldo.getText();
        do{
            try{
                sueldo = Double.parseDouble(cadena);
                flag = false;
                txtChoSueldo.setBackground(Color.white);
            } catch(NumberFormatException e){
                txtChoSueldo.setBackground(Color.red);
                cadena = JOptionPane.showInputDialog("Ingrese un monto numerico");
                txtChoSueldo.setText(cadena);
                flag = true;
            }
        } while(flag);
        return sueldo;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoCho = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaChoferes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rbSiCho = new javax.swing.JRadioButton();
        rbNoCho = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtChoName = new javax.swing.JTextField();
        txtChoApe = new javax.swing.JTextField();
        txtChoD = new javax.swing.JTextField();
        txtChoEdad = new javax.swing.JTextField();
        txtChoCel = new javax.swing.JTextField();
        txtChoSueldo = new javax.swing.JTextField();
        txtChoID = new javax.swing.JTextField();
        txtChoExp = new javax.swing.JTextField();
        btnChoSalir = new javax.swing.JButton();
        btnChoAgregar = new javax.swing.JButton();
        btnChoModi = new javax.swing.JButton();
        btnChoEliminar = new javax.swing.JButton();
        comboSex = new javax.swing.JComboBox<>();
        comboCat = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaChoferes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "DNI", "Edad", "Categoria"
            }
        ));
        tablaChoferes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaChoferesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaChoferes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 630, 160));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Registro del Conductor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel2.setText("Nombres:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 84, -1, -1));

        jLabel3.setText("Apellidos:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jLabel4.setText("DNI:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 86, -1, 20));

        jLabel5.setText("Edad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 135, -1, -1));

        jLabel6.setText("Sexo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jLabel7.setText("Celular:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));

        jLabel8.setText("Sueldo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 186, -1, -1));

        jLabel9.setText("Id Corporativo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        jLabel10.setText("Licencia:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        rbSiCho.setText("Sí");
        jPanel1.add(rbSiCho, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, -1, -1));

        rbNoCho.setText("No");
        jPanel1.add(rbNoCho, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        jLabel11.setText("Categoria:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel12.setText("¿Cuenta con experiencia?:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        txtChoName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChoNameKeyPressed(evt);
            }
        });
        jPanel1.add(txtChoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 80, 137, -1));

        txtChoApe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChoApeKeyPressed(evt);
            }
        });
        jPanel1.add(txtChoApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 148, -1));

        txtChoD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChoDKeyPressed(evt);
            }
        });
        jPanel1.add(txtChoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 84, -1));
        jPanel1.add(txtChoEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 71, -1));

        txtChoCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChoCelKeyPressed(evt);
            }
        });
        jPanel1.add(txtChoCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 83, -1));
        jPanel1.add(txtChoSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 70, -1));
        jPanel1.add(txtChoID, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 100, -1));
        jPanel1.add(txtChoExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 130, -1));

        btnChoSalir.setText("Salir");
        btnChoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnChoSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 70, 40));

        btnChoAgregar.setText("Agregar");
        btnChoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnChoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 40));

        btnChoModi.setText("Modificar");
        btnChoModi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoModiActionPerformed(evt);
            }
        });
        jPanel1.add(btnChoModi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 322, -1, 40));

        btnChoEliminar.setText("Eliminar");
        btnChoEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnChoEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 322, -1, 40));

        comboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino"}));
        jPanel1.add(comboSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 90, -1));

        comboCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A-IIIa", "A-IIIb", "A-I", "A-IIb" }));
        jPanel1.add(comboCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 70, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logotipo2.0peque.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 160, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        grupoCho.add(rbSiCho);
        grupoCho.add(rbNoCho);
    }//GEN-LAST:event_formWindowActivated

    private void btnChoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnChoSalirActionPerformed

    private void btnChoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoAgregarActionPerformed
        // TODO add your handling code here:
        agregarConductor();
    }//GEN-LAST:event_btnChoAgregarActionPerformed

    private void btnChoModiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoModiActionPerformed
        // TODO add your handling code here:
        modificarConductor();
    }//GEN-LAST:event_btnChoModiActionPerformed

    private void tablaChoferesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaChoferesMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = tablaChoferes.rowAtPoint(evt.getPoint());
        mostrarTabla(filaSeleccionada);
    }//GEN-LAST:event_tablaChoferesMouseClicked

    private void btnChoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoEliminarActionPerformed
        // TODO add your handling code here:
        eliminarConductor();
    }//GEN-LAST:event_btnChoEliminarActionPerformed

    private void txtChoDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChoDKeyPressed
        // TODO add your handling code here:
        validarDatosNumericos(evt);
    }//GEN-LAST:event_txtChoDKeyPressed

    private void txtChoCelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChoCelKeyPressed
        // TODO add your handling code here:
        validarCelular(evt);
    }//GEN-LAST:event_txtChoCelKeyPressed

    private void txtChoNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChoNameKeyPressed
        // TODO add your handling code here:
        restringuirTextos(evt,'n');
    }//GEN-LAST:event_txtChoNameKeyPressed

    private void txtChoApeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChoApeKeyPressed
        // TODO add your handling code here:
        restringuirTextos(evt,'a');
    }//GEN-LAST:event_txtChoApeKeyPressed

    public void agregarConductor(){
        Conductor cond = new Conductor();
        cond.setNombres(txtChoName.getText());
        cond.setDni(txtChoD.getText());
        cond.setApellidos(txtChoApe.getText());
        int indiceCategoria = comboCat.getSelectedIndex();
        cond.setCategoria(comboCat.getItemAt(indiceCategoria));
        int indiceSexo = comboSex.getSelectedIndex();
        cond.setSexo(comboSex.getItemAt(indiceSexo));
        cond.setCelular(txtChoCel.getText());
        cond.setEdad(excepcionEdad());
        cond.setExperiencia(txtChoExp.getText());
        cond.setIdCorporativo(restringuirIdCorporativo());
        if(rbSiCho.isSelected()==true)
            cond.setLicencia(true);
        else
            cond.setLicencia(false);
        cond.setSueldo(excepcionSueldo());
        emp.agregarTrabajador(cond);
        limpiarTextos();
        tablaChoferes.setModel(emp.mostrarDatosConductor());
    }
    
    public void modificarConductor(){
        Conductor cond = new Conductor ();
        cond.setNombres(txtChoName.getText());
        cond.setDni(txtChoD.getText());
        cond.setApellidos(txtChoApe.getText());
        int indiceCategoria = comboCat.getSelectedIndex();
        cond.setCategoria(comboCat.getItemAt(indiceCategoria));
        int indiceSexo = comboSex.getSelectedIndex();
        cond.setSexo(comboSex.getItemAt(indiceSexo));
        cond.setCelular(txtChoCel.getText());
        cond.setEdad(excepcionEdad());
        cond.setExperiencia(txtChoExp.getText());
        cond.setIdCorporativo(txtChoID.getText());
        cond.setSueldo(excepcionSueldo());
        if(rbSiCho.isSelected()==true)
            cond.setLicencia(true);
        else
            cond.setLicencia(false);
        emp.actualizarConductor(cond, tablaChoferes);
        limpiarTextos();
        tablaChoferes.setModel(emp.mostrarDatosConductor());
    }
    
    public void mostrarTabla(int filaSeleccionada){
        txtChoName.setText(tablaChoferes.getValueAt(filaSeleccionada, 1).toString());
        txtChoD.setText(tablaChoferes.getValueAt(filaSeleccionada, 3).toString());
        txtChoApe.setText(tablaChoferes.getValueAt(filaSeleccionada, 2).toString());
        txtChoEdad.setText(tablaChoferes.getValueAt(filaSeleccionada, 4).toString());
        comboSex.setSelectedItem(tablaChoferes.getValueAt(filaSeleccionada, 5).toString());
        txtChoCel.setText(tablaChoferes.getValueAt(filaSeleccionada, 6).toString());
        txtChoSueldo.setText(tablaChoferes.getValueAt(filaSeleccionada, 7).toString());
        txtChoID.setText(tablaChoferes.getValueAt(filaSeleccionada, 8).toString());
        if(tablaChoferes.getValueAt(filaSeleccionada, 9).toString().equals("Si"))
            rbSiCho.setSelected(true);
        else
            rbNoCho.setSelected(true);
        comboCat.setSelectedItem(tablaChoferes.getValueAt(filaSeleccionada, 10).toString());
        txtChoExp.setText(tablaChoferes.getValueAt(filaSeleccionada, 11).toString());
    }
    
    public void eliminarConductor(){
        emp.eliminarDatosConductor(tablaChoferes);
        limpiarTextos();
        tablaChoferes.setModel(emp.mostrarDatosConductor());
    }
    public void limpiarTextos(){
        txtChoName.setText("");
        txtChoD.setText("");
        txtChoApe.setText("");
        comboSex.setSelectedItem(null);
        txtChoExp.setText("");
         comboCat.setSelectedItem(null);
        txtChoEdad.setText("");
        txtChoSueldo.setText("");
        txtChoCel.setText("");
        txtChoID.setText("");
        grupoCho.clearSelection();
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
            java.util.logging.Logger.getLogger(vtnRegistroConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new vtnRegistroConductor(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoAgregar;
    private javax.swing.JButton btnChoEliminar;
    private javax.swing.JButton btnChoModi;
    private javax.swing.JButton btnChoSalir;
    private javax.swing.JComboBox<String> comboCat;
    private javax.swing.JComboBox<String> comboSex;
    private javax.swing.ButtonGroup grupoCho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbNoCho;
    private javax.swing.JRadioButton rbSiCho;
    private javax.swing.JTable tablaChoferes;
    private javax.swing.JTextField txtChoApe;
    private javax.swing.JTextField txtChoCel;
    private javax.swing.JTextField txtChoD;
    private javax.swing.JTextField txtChoEdad;
    private javax.swing.JTextField txtChoExp;
    private javax.swing.JTextField txtChoID;
    private javax.swing.JTextField txtChoName;
    private javax.swing.JTextField txtChoSueldo;
    // End of variables declaration//GEN-END:variables
}
