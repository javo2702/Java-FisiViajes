/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Empresa;
import clases.Terramoza;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jvall
 */
public class vtnRegistroTerramoza extends javax.swing.JFrame {

    Empresa empresa;
    /**
     * Creates new form vtnRegistroTerramoza
     */
    public vtnRegistroTerramoza(Empresa emp) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        empresa = emp;
        tablaTerramoza.setModel(empresa.mostrarDatosTerramoza());
    }

    public void validarDatosNumericos(java.awt.event.KeyEvent evento2){
        if((evento2.getKeyChar() >= 48 && evento2.getKeyChar() <= 57)){
            if(dni.getText().length()>8){
                JOptionPane.showMessageDialog(this, "Solo se admiten 9 digitos","Informacion", JOptionPane.INFORMATION_MESSAGE);
                dni.setText(dni.getText().substring(0, 9));
            }
        }
        else if(!(evento2.getKeyCode()==KeyEvent.VK_BACK_SPACE||evento2.getKeyCode()==KeyEvent.VK_LEFT||evento2.getKeyCode()==KeyEvent.VK_RIGHT
                ||evento2.getKeyCode()==KeyEvent.VK_ENTER)){
            JOptionPane.showMessageDialog(this, "Solo se admiten caracteres numericos","Error", JOptionPane.ERROR_MESSAGE);
            int ind = dni.getText().length()-1;
            if(!(dni.getText().charAt(ind)>='0'&& dni.getText().charAt(ind) <= '9'))
               dni.setText(dni.getText().substring(0, ind));
        }
    }
    public void validarCelular(java.awt.event.KeyEvent evento2){
        if((evento2.getKeyChar() >= 48 && evento2.getKeyChar()<= 57)){
            if(celular.getText().length()>8){
                JOptionPane.showMessageDialog(this, "Solo se admiten 9 digitos","Informacion", JOptionPane.INFORMATION_MESSAGE);
                celular.setText(celular.getText().substring(0, 9));
            }
        }
        else if(!(evento2.getKeyCode()==KeyEvent.VK_BACK_SPACE||evento2.getKeyCode()==KeyEvent.VK_LEFT||evento2.getKeyCode()==KeyEvent.VK_RIGHT
                ||evento2.getKeyCode()==KeyEvent.VK_ENTER)){
            celular.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Solo se admiten caracteres numericos","Error", JOptionPane.ERROR_MESSAGE);
            int ind = celular.getText().length()-1;
            if(!(celular.getText().charAt(ind)>='0'&& celular.getText().charAt(ind) <= '9')){
               celular.setText(celular.getText().substring(0, ind));
               celular.setBackground(Color.white);
            }       
        }
    }
    
    public void restringuirTextos(java.awt.event.KeyEvent evt, char opc){
        if(!((evt.getKeyChar()>=65 && evt.getKeyChar() <= 90)||(evt.getKeyChar()>=97 && evt.getKeyChar()<= 122)
                ||evt.getKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getKeyCode()==KeyEvent.VK_LEFT||evt.getKeyCode()==KeyEvent.VK_RIGHT
                ||evt.getKeyCode()==KeyEvent.VK_ENTER||evt.getKeyCode()==KeyEvent.VK_SHIFT||evt.getKeyCode()==KeyEvent.VK_SPACE)){
            JOptionPane.showMessageDialog(this, "No se admiten caracteres especiales","Error", JOptionPane.ERROR_MESSAGE);
            if(nombres.getText().length()!=0 && opc == 'n'){
               nombres.setText(nombres.getText().substring(0, nombres.getText().length()-1)); 
            }
            if(apellidos.getText().length()!=0 && opc == 'a'){
                apellidos.setText(apellidos.getText().substring(0, apellidos.getText().length()-1));
            }
        }
    }
    
    public String restringuirIdCorporativo(){
        String cod = idCorpo.getText();
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
        String cadena = txtEdad.getText();
        do{
            try{
                edad = Integer.parseInt(cadena);
                flag = false;
                txtEdad.setBackground(Color.white);
            } catch(NumberFormatException e){
                txtEdad.setBackground(Color.red);
                cadena = JOptionPane.showInputDialog("Ingrese una edad numerica");
                txtEdad.setText(cadena);
                flag = true;
            }
        } while(flag);
        return edad;
    }
    public double excepcionSueldo(){
        boolean flag;
        double sueldo=0;
        String cadena = txtSueldo.getText();
        do{
            try{
                sueldo = Double.parseDouble(cadena);
                flag = false;
                txtSueldo.setBackground(Color.white);
            } catch(NumberFormatException e){
                txtSueldo.setBackground(Color.red);
                cadena = JOptionPane.showInputDialog("Ingrese un monto numerico");
                txtSueldo.setText(cadena);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTerramoza = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboSex = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        celular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        idCorpo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        institucion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        comboIdioma = new javax.swing.JComboBox<>();
        btnAgregarTerramoza = new javax.swing.JButton();
        btnModificarTerramoza = new javax.swing.JButton();
        btnEliminarTerramoza = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaTerramoza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Corporativo", "Nombres", "DNI", "Edad"
            }
        ));
        tablaTerramoza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTerramozaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTerramoza);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 680, 230));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Registro de Terramoza");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, 20));

        jLabel2.setText("Nombres:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombresKeyPressed(evt);
            }
        });
        jPanel1.add(nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 160, -1));

        jLabel3.setText("Apellidos:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apellidosKeyPressed(evt);
            }
        });
        jPanel1.add(apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 150, -1));

        jLabel4.setText("DNI:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dniKeyPressed(evt);
            }
        });
        jPanel1.add(dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 80, -1));

        jLabel5.setText("Edad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 80, -1));

        jLabel6.setText("Sexo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, 20));

        comboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino","Femenino" }));
        jPanel1.add(comboSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 140, -1));
        comboSex.setSelectedItem(null);

        jLabel7.setText("Celular:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                celularKeyPressed(evt);
            }
        });
        jPanel1.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 80, -1));

        jLabel8.setText("Sueldo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        jPanel1.add(txtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 80, -1));

        jLabel9.setText("Id Corporativo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));
        jPanel1.add(idCorpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 130, -1));

        jLabel10.setText("Nombre de Institucion:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));
        jPanel1.add(institucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 170, -1));

        jLabel11.setText("Idioma:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        comboIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Ingles", "Frances", "Portugues" }));
        jPanel1.add(comboIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 120, -1));
        comboIdioma.setSelectedItem(null);

        btnAgregarTerramoza.setText("Agregar");
        btnAgregarTerramoza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTerramozaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarTerramoza, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 272, -1, 40));

        btnModificarTerramoza.setText("Modificar");
        btnModificarTerramoza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTerramozaActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarTerramoza, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 272, -1, 40));

        btnEliminarTerramoza.setText("Eliminar");
        btnEliminarTerramoza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTerramozaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarTerramoza, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 272, -1, 40));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 80, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logotipo2.0peque.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 160, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarTerramozaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTerramozaActionPerformed
        // TODO add your handling code here:
        eliminarTerramoza();
    }//GEN-LAST:event_btnEliminarTerramozaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarTerramozaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTerramozaActionPerformed
        // TODO add your handling code here:
        agregarTerramoza();
    }//GEN-LAST:event_btnAgregarTerramozaActionPerformed

    private void btnModificarTerramozaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTerramozaActionPerformed
        // TODO add your handling code here:
        modificarTerramoza();
    }//GEN-LAST:event_btnModificarTerramozaActionPerformed

    private void tablaTerramozaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTerramozaMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = tablaTerramoza.rowAtPoint(evt.getPoint());
        mostrarTabla(filaSeleccionada);
    }//GEN-LAST:event_tablaTerramozaMouseClicked

    private void nombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombresKeyPressed
        // TODO add your handling code here:
        restringuirTextos(evt,'n');
    }//GEN-LAST:event_nombresKeyPressed

    private void apellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidosKeyPressed
        // TODO add your handling code here:
        restringuirTextos(evt,'a');
    }//GEN-LAST:event_apellidosKeyPressed

    private void dniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniKeyPressed
        // TODO add your handling code here:
        validarDatosNumericos(evt);
    }//GEN-LAST:event_dniKeyPressed

    private void celularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_celularKeyPressed
        // TODO add your handling code here:
        validarCelular(evt);
    }//GEN-LAST:event_celularKeyPressed

    public void agregarTerramoza(){
        Terramoza terra = new Terramoza();
        terra.setNombres(nombres.getText());
        terra.setApellidos(apellidos.getText());
        terra.setDni(dni.getText());
        terra.setCelular(celular.getText());
        terra.setEdad(excepcionEdad());
        terra.setIdCorporativo(idCorpo.getText());
        int indiceIdioma = comboIdioma.getSelectedIndex();
        terra.setIdiomas(comboIdioma.getItemAt(indiceIdioma));
        terra.setSueldo(excepcionSueldo());
        int indiceSex = comboSex.getSelectedIndex();
        terra.setSexo(comboSex.getItemAt(indiceSex));
        terra.setNombreInstitucion(institucion.getText());
        empresa.agregarTrabajador(terra);
        limpiarCampos();
        tablaTerramoza.setModel(empresa.mostrarDatosTerramoza());
    }
    
    public void eliminarTerramoza(){
        empresa.eliminarDatosTerramoza(tablaTerramoza);
        limpiarCampos();
        tablaTerramoza.setModel(empresa.mostrarDatosTerramoza());
    }
    
    public void modificarTerramoza(){
        Terramoza terra = new Terramoza();
        terra.setNombres(nombres.getText());
        terra.setApellidos(apellidos.getText());
        terra.setDni(dni.getText());
        terra.setCelular(celular.getText());
        terra.setEdad(excepcionEdad());
        terra.setIdCorporativo(idCorpo.getText());
        int indiceIdioma = comboIdioma.getSelectedIndex();
        terra.setIdiomas(comboIdioma.getItemAt(indiceIdioma));
        terra.setSueldo(excepcionSueldo());
        int indiceSex = comboSex.getSelectedIndex();
        terra.setSexo(comboSex.getItemAt(indiceSex));
        terra.setNombreInstitucion(institucion.getText());
        empresa.actualizarTerramoza(terra, tablaTerramoza);
        limpiarCampos();
        tablaTerramoza.setModel(empresa.mostrarDatosTerramoza());
    }
    
    public void mostrarTabla(int filaSeleccionada){
        nombres.setText(tablaTerramoza.getValueAt(filaSeleccionada, 1).toString());
        apellidos.setText(tablaTerramoza.getValueAt(filaSeleccionada, 2).toString());
        dni.setText(tablaTerramoza.getValueAt(filaSeleccionada, 3).toString());
        txtEdad.setText(tablaTerramoza.getValueAt(filaSeleccionada, 4).toString());
        comboSex.setSelectedItem(tablaTerramoza.getValueAt(filaSeleccionada, 5).toString());
        celular.setText(tablaTerramoza.getValueAt(filaSeleccionada, 6).toString());
        txtSueldo.setText(tablaTerramoza.getValueAt(filaSeleccionada, 7).toString());
        idCorpo.setText(tablaTerramoza.getValueAt(filaSeleccionada, 8).toString());
        comboIdioma.setSelectedItem(tablaTerramoza.getValueAt(filaSeleccionada, 9).toString());
        institucion.setText(tablaTerramoza.getValueAt(filaSeleccionada, 10).toString());
    }
    
    public void limpiarCampos(){
        nombres.setText("");
        apellidos.setText("");
        dni.setText("");
        txtEdad.setText("");
        comboSex.setSelectedItem(null);
        celular.setText("");
        txtSueldo.setText("");
        idCorpo.setText("");
        comboIdioma.setSelectedItem(null);
        institucion.setText("");
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
            java.util.logging.Logger.getLogger(vtnRegistroTerramoza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroTerramoza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroTerramoza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroTerramoza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vtnRegistroTerramoza(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidos;
    private javax.swing.JButton btnAgregarTerramoza;
    private javax.swing.JButton btnEliminarTerramoza;
    private javax.swing.JButton btnModificarTerramoza;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField celular;
    private javax.swing.JComboBox<String> comboIdioma;
    private javax.swing.JComboBox<String> comboSex;
    private javax.swing.JTextField dni;
    private javax.swing.JTextField idCorpo;
    private javax.swing.JTextField institucion;
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
    private javax.swing.JTextField nombres;
    private javax.swing.JTable tablaTerramoza;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
