/*
 * To change this license header, Recepose License Headers in Project Properties.
 * To change this template file, Recepose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Empresa;
import clases.Recepcionista;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jvall
 */
public class vtnRegistroRecepcionista extends javax.swing.JFrame {
    Empresa emp;
    /**
     * Creates new form vtnRegistroRecepcionista
     */
    public vtnRegistroRecepcionista(Empresa emp1) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        emp = emp1;
        tablaRecepcionista.setModel(emp.mostrarDatosRecepcionista());
    }

    public void validarDatosNumericos(java.awt.event.KeyEvent evento2){
        if((evento2.getKeyChar() >= 48 && evento2.getKeyChar() <= 57)){
            if(txtRecepDni.getText().length()>8){
                JOptionPane.showMessageDialog(this, "Solo se admiten 9 digitos","Informacion", JOptionPane.INFORMATION_MESSAGE);
                txtRecepDni.setText(txtRecepDni.getText().substring(0, 9));
            }
        }
        else if(!(evento2.getKeyCode()==KeyEvent.VK_BACK_SPACE||evento2.getKeyCode()==KeyEvent.VK_LEFT||evento2.getKeyCode()==KeyEvent.VK_RIGHT
                ||evento2.getKeyCode()==KeyEvent.VK_ENTER)){
            JOptionPane.showMessageDialog(this, "Solo se admiten caracteres numericos","Error", JOptionPane.ERROR_MESSAGE);
            int ind = txtRecepDni.getText().length()-1;
            if(!(txtRecepDni.getText().charAt(ind)>='0'&& txtRecepDni.getText().charAt(ind) <= '9'))
               txtRecepDni.setText(txtRecepDni.getText().substring(0, ind));
        }
    }
    public void validarCelular(java.awt.event.KeyEvent evento2){
        if((evento2.getKeyChar() >= 48 && evento2.getKeyChar()<= 57)){
            if(txtRecepCel.getText().length()>8){
                JOptionPane.showMessageDialog(this, "Solo se admiten 9 digitos","Informacion", JOptionPane.INFORMATION_MESSAGE);
                txtRecepCel.setText(txtRecepCel.getText().substring(0, 9));
            }
        }
        else if(!(evento2.getKeyCode()==KeyEvent.VK_BACK_SPACE||evento2.getKeyCode()==KeyEvent.VK_LEFT||evento2.getKeyCode()==KeyEvent.VK_RIGHT
                ||evento2.getKeyCode()==KeyEvent.VK_ENTER)){
            txtRecepCel.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Solo se admiten caracteres numericos","Error", JOptionPane.ERROR_MESSAGE);
            int ind = txtRecepCel.getText().length()-1;
            if(!(txtRecepCel.getText().charAt(ind)>='0'&& txtRecepCel.getText().charAt(ind) <= '9')){
               txtRecepCel.setText(txtRecepCel.getText().substring(0, ind));
               txtRecepCel.setBackground(Color.white);
            }       
        }
    }
    
    public void restringuirTextos(java.awt.event.KeyEvent evt, char opc){
        if(!((evt.getKeyChar()>=65 && evt.getKeyChar() <= 90)||(evt.getKeyChar()>=97 && evt.getKeyChar()<= 122)
                ||evt.getKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getKeyCode()==KeyEvent.VK_LEFT||evt.getKeyCode()==KeyEvent.VK_RIGHT
                ||evt.getKeyCode()==KeyEvent.VK_ENTER||evt.getKeyCode()==KeyEvent.VK_SHIFT||evt.getKeyCode()==KeyEvent.VK_SPACE)){
            JOptionPane.showMessageDialog(this, "No se admiten caracteres especiales","Error", JOptionPane.ERROR_MESSAGE);
            if(txtRecepName.getText().length()!=0 && opc == 'n'){
               txtRecepName.setText(txtRecepName.getText().substring(0, txtRecepName.getText().length()-1)); 
            }
            if(txtRecepApe.getText().length()!=0 && opc == 'a'){
                txtRecepApe.setText(txtRecepApe.getText().substring(0, txtRecepApe.getText().length()-1));
            }
        }
    }
    
    public String restringuirIdCorporativo(){
        String cod = txtRecepId.getText();
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
        String cadena = txtRecepEdad.getText();
        do{
            try{
                edad = Integer.parseInt(cadena);
                flag = false;
                txtRecepEdad.setBackground(Color.white);
            } catch(NumberFormatException e){
                txtRecepEdad.setBackground(Color.red);
                cadena = JOptionPane.showInputDialog("Ingrese una edad numerica");
                txtRecepEdad.setText(cadena);
                flag = true;
            }
        } while(flag);
        return edad;
    }
    public double excepcionSueldo(){
        boolean flag;
        double sueldo=0;
        String cadena = txtRecepSueldo.getText();
        do{
            try{
                sueldo = Double.parseDouble(cadena);
                flag = false;
                txtRecepSueldo.setBackground(Color.white);
            } catch(NumberFormatException e){
                txtRecepSueldo.setBackground(Color.red);
                cadena = JOptionPane.showInputDialog("Ingrese un monto numerico");
                txtRecepSueldo.setText(cadena);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRecepName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRecepApe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRecepDni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRecepEdad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtRecepCel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRecepSueldo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRecepId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboNivelT = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        comboIdioma = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRecepcionista = new javax.swing.JTable();
        btnAgregarRecepcionista = new javax.swing.JButton();
        btnModificarRecepcionista = new javax.swing.JButton();
        btnEliminarRecepcionista = new javax.swing.JButton();
        btnVolverR = new javax.swing.JButton();
        comboSex = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Registro de Recepcionista");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel2.setText("Nombres:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 81, -1, -1));

        txtRecepName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecepNameKeyPressed(evt);
            }
        });
        jPanel1.add(txtRecepName, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 77, 165, -1));

        jLabel3.setText("Apellidos:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        txtRecepApe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecepApeKeyPressed(evt);
            }
        });
        jPanel1.add(txtRecepApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 77, 179, -1));

        jLabel4.setText("DNI:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        txtRecepDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecepDniKeyPressed(evt);
            }
        });
        jPanel1.add(txtRecepDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 77, 72, -1));

        jLabel5.setText("Edad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));
        jPanel1.add(txtRecepEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 64, -1));

        jLabel6.setText("Sexo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jLabel7.setText("Celular:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        txtRecepCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecepCelKeyPressed(evt);
            }
        });
        jPanel1.add(txtRecepCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 72, -1));

        jLabel8.setText("Sueldo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));
        jPanel1.add(txtRecepSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 64, -1));

        jLabel9.setText("Id Corporativo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));
        jPanel1.add(txtRecepId, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 110, -1));

        jLabel10.setText("Nivel Tecnologico:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));

        comboNivelT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jPanel1.add(comboNivelT, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 168, 120, -1));
        comboNivelT.addItem("Avanzado");
        comboNivelT.addItem("Intermedio");
        comboNivelT.addItem("Basico");

        jLabel11.setText("Idioma:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 217, -1, -1));

        comboIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        jPanel1.add(comboIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 120, -1));
        comboIdioma.addItem("Español");
        comboIdioma.addItem("Ingles");
        comboIdioma.addItem("Frances");

        tablaRecepcionista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Corporativo", "Nombres", "DNI", "Edad"
            }
        ));
        tablaRecepcionista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRecepcionistaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRecepcionista);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 640, 253));

        btnAgregarRecepcionista.setText("Agregar");
        btnAgregarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRecepcionistaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, 40));

        btnModificarRecepcionista.setText("Modificar");
        btnModificarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRecepcionistaActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, 40));

        btnEliminarRecepcionista.setText("Eliminar");
        btnEliminarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRecepcionistaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, 40));

        btnVolverR.setText("Volver");
        btnVolverR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverRActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverR, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 80, 50));

        comboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jPanel1.add(comboSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 110, -1));
        comboSex.addItem("Masculino");
        comboSex.addItem("Femenino");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logotipo2.0peque.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 160, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRecepcionistaActionPerformed
        // TODO add your handling code here:
        modificarRecepcionista();
    }//GEN-LAST:event_btnModificarRecepcionistaActionPerformed

    private void btnVolverRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverRActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVolverRActionPerformed

    private void btnAgregarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRecepcionistaActionPerformed
        // TODO add your handling code here:
        agregarRecepcionista();
    }//GEN-LAST:event_btnAgregarRecepcionistaActionPerformed
    
    private void btnEliminarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRecepcionistaActionPerformed
        // TODO add your handling code here:
        eliminarRecepcionista();
    }//GEN-LAST:event_btnEliminarRecepcionistaActionPerformed

    private void tablaRecepcionistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRecepcionistaMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = tablaRecepcionista.rowAtPoint(evt.getPoint());
        mostrarTabla(filaSeleccionada);
    }//GEN-LAST:event_tablaRecepcionistaMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowActivated

    private void txtRecepNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecepNameKeyPressed
        // TODO add your handling code here:
        restringuirTextos(evt,'n');
    }//GEN-LAST:event_txtRecepNameKeyPressed

    private void txtRecepApeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecepApeKeyPressed
        // TODO add your handling code here:
        restringuirTextos(evt,'a');
    }//GEN-LAST:event_txtRecepApeKeyPressed

    private void txtRecepDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecepDniKeyPressed
        // TODO add your handling code here:
        validarDatosNumericos(evt);
    }//GEN-LAST:event_txtRecepDniKeyPressed

    private void txtRecepCelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecepCelKeyPressed
        // TODO add your handling code here:
        validarCelular(evt);
    }//GEN-LAST:event_txtRecepCelKeyPressed

    public void mostrarTabla(int filaSeleccionada){
        txtRecepName.setText(tablaRecepcionista.getValueAt(filaSeleccionada, 1).toString());
        txtRecepApe.setText(tablaRecepcionista.getValueAt(filaSeleccionada, 2).toString());
        txtRecepDni.setText(tablaRecepcionista.getValueAt(filaSeleccionada, 3).toString());
        txtRecepCel.setText(tablaRecepcionista.getValueAt(filaSeleccionada, 6).toString());
        txtRecepEdad.setText(tablaRecepcionista.getValueAt(filaSeleccionada, 4).toString());
        txtRecepId.setText(tablaRecepcionista.getValueAt(filaSeleccionada, 8).toString());
        txtRecepSueldo.setText(tablaRecepcionista.getValueAt(filaSeleccionada, 7).toString());
        comboIdioma.setSelectedItem(tablaRecepcionista.getValueAt(filaSeleccionada, 10).toString());
        comboNivelT.setSelectedItem(tablaRecepcionista.getValueAt(filaSeleccionada, 9).toString());
        comboSex.setSelectedItem(tablaRecepcionista.getValueAt(filaSeleccionada, 5).toString());
    }
    
    public void eliminarRecepcionista(){
        emp.eliminarDatosRecepcionista(tablaRecepcionista);
        limpiarCampos();
        tablaRecepcionista.setModel(emp.mostrarDatosRecepcionista());
    }
    
    public void agregarRecepcionista(){
        Recepcionista recep = new Recepcionista();
        recep.setNombres(txtRecepName.getText());
        recep.setApellidos(txtRecepApe.getText());
        recep.setDni(txtRecepDni.getText());
        recep.setCelular(txtRecepCel.getText());
        recep.setEdad(excepcionEdad());
        recep.setIdCorporativo(txtRecepId.getText());
        int idiomaSelec = comboIdioma.getSelectedIndex();
        recep.setIdiomas(comboIdioma.getItemAt(idiomaSelec));
        int nivelSelec = comboNivelT.getSelectedIndex();
        recep.setNivelTecnologico(comboNivelT.getItemAt(nivelSelec));
        int sexoSelec = comboSex.getSelectedIndex();
        recep.setSexo(comboSex.getItemAt(sexoSelec));
        recep.setSueldo(excepcionSueldo());
        emp.agregarTrabajador(recep);
        limpiarCampos();
        tablaRecepcionista.setModel(emp.mostrarDatosRecepcionista());
    }
    
    public void modificarRecepcionista(){
        Recepcionista recep = new Recepcionista();
        recep.setNombres(txtRecepName.getText());
        recep.setApellidos(txtRecepApe.getText());
        recep.setDni(txtRecepDni.getText());
        recep.setCelular(txtRecepCel.getText());
        recep.setEdad(excepcionEdad());
        recep.setIdCorporativo(txtRecepId.getText());
        int idiomaSelec = comboIdioma.getSelectedIndex();
        recep.setIdiomas(comboIdioma.getItemAt(idiomaSelec));
        int nivelSelec = comboNivelT.getSelectedIndex();
        recep.setNivelTecnologico(comboNivelT.getItemAt(nivelSelec));
        int sexoSelec = comboSex.getSelectedIndex();
        recep.setSexo(comboSex.getItemAt(sexoSelec));
        recep.setSueldo(excepcionSueldo());
        emp.actualizarRecepcionista(recep, tablaRecepcionista);
        limpiarCampos();
        tablaRecepcionista.setModel(emp.mostrarDatosRecepcionista());
    }
    
    public void limpiarCampos(){
        txtRecepName.setText("");
        txtRecepApe.setText("");
        txtRecepDni.setText("");
        txtRecepCel.setText("");
        txtRecepEdad.setText("");
        txtRecepId.setText("");
        txtRecepSueldo.setText("");
        comboIdioma.setSelectedItem(null);
        comboNivelT.setSelectedItem(null);
        comboSex.setSelectedItem(null);
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
            java.util.logging.Logger.getLogger(vtnRegistroRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new vtnRegistroRecepcionista(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarRecepcionista;
    private javax.swing.JButton btnEliminarRecepcionista;
    private javax.swing.JButton btnModificarRecepcionista;
    private javax.swing.JButton btnVolverR;
    private javax.swing.JComboBox<String> comboIdioma;
    private javax.swing.JComboBox<String> comboNivelT;
    private javax.swing.JComboBox<String> comboSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable tablaRecepcionista;
    private javax.swing.JTextField txtRecepApe;
    private javax.swing.JTextField txtRecepCel;
    private javax.swing.JTextField txtRecepDni;
    private javax.swing.JTextField txtRecepEdad;
    private javax.swing.JTextField txtRecepId;
    private javax.swing.JTextField txtRecepName;
    private javax.swing.JTextField txtRecepSueldo;
    // End of variables declaration//GEN-END:variables
}
