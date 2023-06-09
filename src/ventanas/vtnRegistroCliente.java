/*
 * To change this license header, Clienteose License Headers in Project Properties.
 * To change this template file, Clienteose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Cliente;
import clases.Empresa;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jvall
 */
public class vtnRegistroCliente extends javax.swing.JFrame {

    private Empresa emp;
    /**
     * Creates new form vtnRegistro
     * @param dniEnviado
     */
    public vtnRegistroCliente(String dniEnviado, Empresa emp) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        txtClienteDni.setText(dniEnviado);
        this.emp = emp;
    }

    public void validarCelular(java.awt.event.KeyEvent evento2){
        if((evento2.getKeyChar() >= 48 && evento2.getKeyChar()<= 57)){
            if(txtClienteCel.getText().length()>8){
                JOptionPane.showMessageDialog(this, "Solo se admiten 9 digitos","Informacion", JOptionPane.INFORMATION_MESSAGE);
                txtClienteCel.setText(txtClienteCel.getText().substring(0, 9));
            }
        }
        else if(!(evento2.getKeyCode()==KeyEvent.VK_BACK_SPACE||evento2.getKeyCode()==KeyEvent.VK_LEFT||evento2.getKeyCode()==KeyEvent.VK_RIGHT
                ||evento2.getKeyCode()==KeyEvent.VK_ENTER)){
            txtClienteCel.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Solo se admiten caracteres numericos","Error", JOptionPane.ERROR_MESSAGE);
            int ind = txtClienteCel.getText().length()-1;
            if(!(txtClienteCel.getText().charAt(ind)>='0'&& txtClienteCel.getText().charAt(ind) <= '9')){
               txtClienteCel.setText(txtClienteCel.getText().substring(0, ind));
               txtClienteCel.setBackground(Color.white);
            }       
        }
    }
    
    public void restringuirTextos(java.awt.event.KeyEvent evt, char opc){
        if(!((evt.getKeyChar()>=65 && evt.getKeyChar() <= 90)||(evt.getKeyChar()>=97 && evt.getKeyChar()<= 122)
                ||evt.getKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getKeyCode()==KeyEvent.VK_LEFT||evt.getKeyCode()==KeyEvent.VK_RIGHT
                ||evt.getKeyCode()==KeyEvent.VK_ENTER||evt.getKeyCode()==KeyEvent.VK_SHIFT||evt.getKeyCode()==KeyEvent.VK_SPACE)){
            JOptionPane.showMessageDialog(this, "No se admiten caracteres especiales","Error", JOptionPane.ERROR_MESSAGE);
            if(txtClienteName.getText().length()!=0 && opc == 'n'){
               txtClienteName.setText(txtClienteName.getText().substring(0, txtClienteName.getText().length()-1)); 
            }
            if(txtClienteApe.getText().length()!=0 && opc == 'a'){
                txtClienteApe.setText(txtClienteApe.getText().substring(0, txtClienteApe.getText().length()-1));
            }
        }
    }
    
    public int excepcionEdad(){
        boolean flag;
        int edad=0;
        String cadena = txtClienteEdad.getText();
        do{
            try{
                edad = Integer.parseInt(cadena);
                flag = false;
                txtClienteEdad.setBackground(Color.white);
            } catch(NumberFormatException e){
                txtClienteEdad.setBackground(Color.red);
                cadena = JOptionPane.showInputDialog("Ingrese una edad numerica");
                txtClienteEdad.setText(cadena);
                flag = true;
            }
        } while(flag);
        return edad;
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
        txtClienteName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtClienteApe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtClienteDni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtClienteCel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtClienteEdad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnRegistrarCliente = new javax.swing.JButton();
        btnVolverR = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        comboSex = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Registro del cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel2.setText("Nombres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        txtClienteName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteNameKeyPressed(evt);
            }
        });
        jPanel1.add(txtClienteName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 179, -1));

        jLabel3.setText("Apellidos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        txtClienteApe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteApeKeyPressed(evt);
            }
        });
        jPanel1.add(txtClienteApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 179, -1));

        jLabel4.setText("DNI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        txtClienteDni.setEditable(false);
        jPanel1.add(txtClienteDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 108, -1));

        jLabel5.setText("Celular");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        txtClienteCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteCelKeyPressed(evt);
            }
        });
        jPanel1.add(txtClienteCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 132, -1));

        jLabel6.setText("Edad");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));
        jPanel1.add(txtClienteEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 71, -1));

        jLabel7.setText("Sexo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        btnRegistrarCliente.setText("Registrar");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, 40));

        btnVolverR.setText("Volver");
        btnVolverR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverRActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logotipo2.0peque.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 60));

        comboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Masculino","Femenino"}));
        jPanel1.add(comboSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 310, 130, -1));
        comboSex.setSelectedItem(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        // TODO add your handling code here:
        registrarCliente();
        this.dispose();
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnVolverRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverRActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVolverRActionPerformed

    private void txtClienteNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteNameKeyPressed
        // TODO add your handling code here:
        restringuirTextos(evt,'n');
    }//GEN-LAST:event_txtClienteNameKeyPressed

    private void txtClienteApeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteApeKeyPressed
        // TODO add your handling code here:
        restringuirTextos(evt,'a');
    }//GEN-LAST:event_txtClienteApeKeyPressed

    private void txtClienteCelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteCelKeyPressed
        // TODO add your handling code here:
        validarCelular(evt);
    }//GEN-LAST:event_txtClienteCelKeyPressed

    public void registrarCliente(){
        Cliente cliente = new Cliente();
        cliente.setDni(txtClienteDni.getText());
        cliente.setNombres(txtClienteName.getText());
        cliente.setApellidos(txtClienteApe.getText());
        cliente.setCelular(txtClienteCel.getText());
        cliente.setEdad(excepcionEdad());
        int indice = comboSex.getSelectedIndex();
        cliente.setSexo(comboSex.getItemAt(indice));
        emp.agregarCliente(cliente);
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
            java.util.logging.Logger.getLogger(vtnRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vtnRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new vtnRegistroCliente(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnVolverR;
    private javax.swing.JComboBox<String> comboSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtClienteApe;
    private javax.swing.JTextField txtClienteCel;
    private javax.swing.JTextField txtClienteDni;
    private javax.swing.JTextField txtClienteEdad;
    private javax.swing.JTextField txtClienteName;
    // End of variables declaration//GEN-END:variables
}
