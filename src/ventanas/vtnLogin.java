/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Empresa;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jvall
 */
public class vtnLogin extends javax.swing.JFrame {
    private Empresa emp;
    /**
     * Creates new form vtnLogin
     */
    public vtnLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        emp = new Empresa();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
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
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        imagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2754581-128.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 130, 150));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 123, -1));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 123, 20));

        jLabel2.setText("Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 170, -1, -1));

        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        btnIngresar.setText("Ingresar");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 80, 40));

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 70, 40));

        imagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gaaaa.jpg"))); // NOI18N
        imagenFondo.setText("jLabel5");
        jPanel1.add(imagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        validarLogin();
    }//GEN-LAST:event_btnIngresarMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void validarLogin(){
        char[] password = txtPass.getPassword();
        String pValida="";
        for(int i=0;i<password.length;i++){
            pValida = pValida + Character.toString(password[i]);
        }
        
        String user = txtUsuario.getText();
        String psw = pValida;
        
        Boolean valid = emp.validarUsuario(user, psw);
        if(valid) {
           String category = emp.getCategoryOfUser(user);
           if(category.equals("Admin")) {
                vtnAdministrador vSu = new vtnAdministrador(emp,user);
                vSu.setVisible(true);
                this.dispose();
           }
           if(category.equals("Recepcionista")) {
                vtnRecepcionista vRecep = new vtnRecepcionista(emp,emp.getNombreRecepcionista(user));
                vRecep.setVisible(true);
                this.dispose();
           }
        }
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
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(vtnLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //Logger.getLogger(vtnLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //Logger.getLogger(vtnLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            //Logger.getLogger(vtnLogin.class.getName()).log(Level.SEVERE, null, ex);
        }   

//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//            
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(vtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(vtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(vtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(vtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vtnLogin().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel imagenFondo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
