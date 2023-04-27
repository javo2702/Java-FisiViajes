/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Empresa;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jvall
 */
public class vtnAsientosBus extends javax.swing.JFrame {
    private Empresa emp;
    private String placaBus;
    private ArrayList<Integer> asientos;
    private boolean permitirSeleccion[];
    /**
     * Creates new form vtnAsientosBus
     */
    public vtnAsientosBus(Empresa emp1, String p,ArrayList<Integer> a) {
        initComponents();
        this.emp = emp1;
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        placaBus = p;
        asientos = a;
        permitirSeleccion = new boolean[75];
        for(int i=0;i<75;i++){
            permitirSeleccion[i] = true;
        }
        llenarEstadoAsientos();
        primer1.setVisible(false);
        primer2.setVisible(false);
    }

    public void llenarEstadoAsientos(){
        if(asientos.get(0)==1){
            btn1.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado1.png")));
            permitirSeleccion[0] = false;
        }
        if(asientos.get(1)==1){
            btn2.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado2.png")));
            permitirSeleccion[1] = false;
        }
        if(asientos.get(2)==1){
            btn3.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado3.png")));
            permitirSeleccion[2] = false;
        }
        if(asientos.get(3)==1){
            btn4.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado4.png")));
            permitirSeleccion[3] = false;
        }
        if(asientos.get(4)==1){
            btn5.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado5.png")));
            permitirSeleccion[4] = false;
        }
        if(asientos.get(5)==1){
            btn6.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientocoupado6.png")));
            permitirSeleccion[5] = false;
        }
        if(asientos.get(6)==1){
            btn7.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado7.png")));
            permitirSeleccion[6] = false;
        }
        if(asientos.get(7)==1){
            btn8.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado8.png")));
            permitirSeleccion[7] = false;
        }
        if(asientos.get(8)==1){
            btn9.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado9.png")));
            permitirSeleccion[8] = false;
        }
        if(asientos.get(9)==1){
            btn10.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado10.png")));
            permitirSeleccion[9] = false;
        }
        if(asientos.get(10)==1){
            btn11.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado11.png")));
            permitirSeleccion[10] = false;
        }
        if(asientos.get(11)==1){
            btn12.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado12.png")));
            permitirSeleccion[11] = false;
        }
        if(asientos.get(12)==1){
            btn13.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado13.png")));
            permitirSeleccion[12] = false;
        }
        if(asientos.get(13)==1){
            btn14.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado14.png")));
            permitirSeleccion[13] = false;
        }
        if(asientos.get(14)==1){
            btn15.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado15.png")));
            permitirSeleccion[14] = false;
        }
        if(asientos.get(16)==1){
            btn17.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado17.png")));
            permitirSeleccion[16] = false;
        }
        if(asientos.get(17)==1){
            btn18.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado18.png")));
            permitirSeleccion[17] = false;
        }
        if(asientos.get(18)==1){
            btn19.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado19.png")));
            permitirSeleccion[18] = false;
        }
        if(asientos.get(19)==1){
            btn20.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado20.png")));
            permitirSeleccion[19] = false;
        }
        if(asientos.get(20)==1){
            btn21.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado21.png")));
            permitirSeleccion[20] = false;
        }
        if(asientos.get(21)==1){
            btn22.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado22.png")));
            permitirSeleccion[21] = false;
        }
        if(asientos.get(22)==1){
            btn23.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado23.png")));
            permitirSeleccion[22] = false;
        }
        if(asientos.get(23)==1){
            btn24.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado24.png")));
            permitirSeleccion[23] = false;
        }
        if(asientos.get(24)==1){
            btn25.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado25.png")));
            permitirSeleccion[24] = false;
        }
        if(asientos.get(25)==1){
            btn26.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado26.png")));
            permitirSeleccion[25] = false;
        }
        if(asientos.get(26)==1){
            btn27.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado27.png")));
            permitirSeleccion[26] = false;
        }
        if(asientos.get(27)==1){
            btn28.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado28.png")));
            permitirSeleccion[27] = false;
        }
        if(asientos.get(28)==1){
            btn29.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado29.png")));
            permitirSeleccion[28] = false;
        }
        if(asientos.get(29)==1){
            btn30.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado30.png")));
            permitirSeleccion[29] = false;
        }
        if(asientos.get(30)==1){
            btn31.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado31.png")));
            permitirSeleccion[30] = false;
        }
        if(asientos.get(31)==1){
            btn32.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado32.png")));
            permitirSeleccion[31] = false;
        }
        if(asientos.get(32)==1){
            btn33.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado33.png")));
            permitirSeleccion[32] = false;
        }
        if(asientos.get(33)==1){
            btn34.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado34.png")));
            permitirSeleccion[33] = false;
        }
        if(asientos.get(34)==1){
            btn35.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado35.png")));
            permitirSeleccion[34] = false;
        }
        if(asientos.get(35)==1){
            btn36.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado36.png")));
            permitirSeleccion[35] = false;
        }
        if(asientos.get(36)==1){
            btn37.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado37.png")));
            permitirSeleccion[36] = false;
        }
        if(asientos.get(37)==1){
            btn38.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado38.png")));
            permitirSeleccion[37] = false;
        }
        if(asientos.get(38)==1){
            btn39.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado39.png")));
            permitirSeleccion[38] = false;
        }
        if(asientos.get(39)==1){
            btn40.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado40.png")));
            permitirSeleccion[39] = false;
        }
        if(asientos.get(40)==1){
            btn41.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado41.png")));
            permitirSeleccion[40] = false;
        }
        if(asientos.get(41)==1){
            btn42.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado42.png")));
            permitirSeleccion[41] = false;
        }
        if(asientos.get(42)==1){
            btn43.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado43.png")));
            permitirSeleccion[42] = false;
        }
        if(asientos.get(43)==1){
            btn44.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado44.png")));
            permitirSeleccion[43] = false;
        }
        if(asientos.get(44)==1){
            btn45.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado45.png")));
            permitirSeleccion[44] = false;
        }
        if(asientos.get(45)==1){
            btn46.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado46.png")));
            permitirSeleccion[45] = false;
        }
        if(asientos.get(46)==1){
            btn47.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado47.png")));
            permitirSeleccion[46] = false;
        }
        if(asientos.get(47)==1){
            btn48.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado48.png")));
            permitirSeleccion[47] = false;
        }
        if(asientos.get(48)==1){
            btn49.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado49.png")));
            permitirSeleccion[48] = false;
        }
        if(asientos.get(49)==1){
            btn50.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado50.png")));
            permitirSeleccion[49] = false;
        }
        if(asientos.get(50)==1){
            btn51.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado51.png")));
            permitirSeleccion[50] = false;
        }
        if(asientos.get(51)==1){
            btn52.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado52.png")));
            permitirSeleccion[51] = false;
        }
        if(asientos.get(52)==1){
            btn53.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado53.png")));
            permitirSeleccion[52] = false;
        }
        if(asientos.get(53)==1){
            btn54.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado54.png")));
            permitirSeleccion[53] = false;
        }if(asientos.get(54)==1){
            btn55.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado55.png")));
            permitirSeleccion[54] = false;
        }if(asientos.get(55)==1){
            btn56.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado56.png")));
            permitirSeleccion[55] = false;
        }
        if(asientos.get(56)==1){
            btn57.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado57.png")));
            permitirSeleccion[56] = false;
        }
        if(asientos.get(57)==1){
            btn58.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado58.png")));
            permitirSeleccion[57] = false;
        }if(asientos.get(58)==1){
            btn59.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado59.png")));
            permitirSeleccion[58] = false;
        }
        if(asientos.get(59)==1){
            btn60.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado60.png")));
            permitirSeleccion[59] = false;
        }
        if(asientos.get(60)==1){
            btn61.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado61.png")));
            permitirSeleccion[60] = false;
        }
        if(asientos.get(61)==1){
            btn62.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado62.png")));
            permitirSeleccion[61] = false;
        }
        if(asientos.get(62)==1){
            btn63.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado63.png")));
            permitirSeleccion[62] = false;
        }
        if(asientos.get(63)==1){
            btn64.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado64.png")));
            permitirSeleccion[63] = false;
        }
        if(asientos.get(64)==1){
            btn65.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado65.png")));
            permitirSeleccion[64] = false;
        }
        if(asientos.get(65)==1){
            btn66.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado66.png")));
            permitirSeleccion[65] = false;
        }
        if(asientos.get(66)==1){
            btn67.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado67.png")));
            permitirSeleccion[66] = false;
        }
        if(asientos.get(67)==1){
            btn68.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado68.png")));
            permitirSeleccion[67] = false;
        }
        if(asientos.get(68)==1){
            btn69.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado69.png")));
            permitirSeleccion[68] = false;
        }
        if(asientos.get(69)==1){
            btn70.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado70.png")));
            permitirSeleccion[69] = false;
        }
        if(asientos.get(70)==1){
            btn71.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado71.png")));
            permitirSeleccion[70] = false;
        }
        if(asientos.get(72)==1){
            btn73.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado73.png")));
            permitirSeleccion[72] = false;
        }
        if(asientos.get(73)==1){
            btn74.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado74.png")));
            permitirSeleccion[73] = false;
        }if(asientos.get(74)==1){
            btn75.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado75.png")));
            permitirSeleccion[74] = false;
        }
        // lo que les gusta: copy and paste
           
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        primer1 = new javax.swing.JPanel();
        btn3 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        primer2 = new javax.swing.JPanel();
        btn2 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        segundo1 = new javax.swing.JPanel();
        btn19 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn27 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btn35 = new javax.swing.JButton();
        btn39 = new javax.swing.JButton();
        btn43 = new javax.swing.JButton();
        btn47 = new javax.swing.JButton();
        btn51 = new javax.swing.JButton();
        btn55 = new javax.swing.JButton();
        btn59 = new javax.swing.JButton();
        btn63 = new javax.swing.JButton();
        btn67 = new javax.swing.JButton();
        btn71 = new javax.swing.JButton();
        btn75 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn26 = new javax.swing.JButton();
        btn30 = new javax.swing.JButton();
        btn34 = new javax.swing.JButton();
        btn38 = new javax.swing.JButton();
        btn42 = new javax.swing.JButton();
        btn46 = new javax.swing.JButton();
        btn50 = new javax.swing.JButton();
        btn54 = new javax.swing.JButton();
        btn58 = new javax.swing.JButton();
        btn62 = new javax.swing.JButton();
        btn66 = new javax.swing.JButton();
        btn70 = new javax.swing.JButton();
        btn74 = new javax.swing.JButton();
        segundo2 = new javax.swing.JPanel();
        btn17 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn25 = new javax.swing.JButton();
        btn29 = new javax.swing.JButton();
        btn33 = new javax.swing.JButton();
        btn37 = new javax.swing.JButton();
        btn41 = new javax.swing.JButton();
        btn45 = new javax.swing.JButton();
        btn49 = new javax.swing.JButton();
        btn53 = new javax.swing.JButton();
        btn57 = new javax.swing.JButton();
        btn61 = new javax.swing.JButton();
        btn65 = new javax.swing.JButton();
        btn69 = new javax.swing.JButton();
        btn73 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn24 = new javax.swing.JButton();
        btn28 = new javax.swing.JButton();
        btn32 = new javax.swing.JButton();
        btn36 = new javax.swing.JButton();
        btn40 = new javax.swing.JButton();
        btn44 = new javax.swing.JButton();
        btn48 = new javax.swing.JButton();
        btn52 = new javax.swing.JButton();
        btn56 = new javax.swing.JButton();
        btn60 = new javax.swing.JButton();
        btn64 = new javax.swing.JButton();
        btn68 = new javax.swing.JButton();
        btn72 = new javax.swing.JButton();
        segundo3 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        primerPiso = new javax.swing.JMenu();
        segundoPiso = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        primer1.setBackground(new java.awt.Color(204, 204, 204));
        primer1.setLayout(new java.awt.GridLayout(1, 5, 10, 0));

        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento3.png"))); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        primer1.add(btn3);

        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento6.png"))); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        primer1.add(btn6);

        btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento9.png"))); // NOI18N
        btn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn9MouseClicked(evt);
            }
        });
        primer1.add(btn9);

        btn12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento12.png"))); // NOI18N
        btn12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn12MouseClicked(evt);
            }
        });
        primer1.add(btn12);

        btn15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento15.png"))); // NOI18N
        btn15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn15MouseClicked(evt);
            }
        });
        primer1.add(btn15);

        getContentPane().add(primer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 400, 60));

        primer2.setBackground(new java.awt.Color(204, 204, 204));
        primer2.setLayout(new java.awt.GridLayout(2, 5, 10, 0));

        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento2.png"))); // NOI18N
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
        });
        primer2.add(btn2);

        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento5.png"))); // NOI18N
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5MouseClicked(evt);
            }
        });
        primer2.add(btn5);

        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento8.png"))); // NOI18N
        btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn8MouseClicked(evt);
            }
        });
        primer2.add(btn8);

        btn11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento11.png"))); // NOI18N
        btn11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn11MouseClicked(evt);
            }
        });
        primer2.add(btn11);

        btn14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento14.png"))); // NOI18N
        btn14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn14MouseClicked(evt);
            }
        });
        primer2.add(btn14);

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento1.png"))); // NOI18N
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        primer2.add(btn1);

        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento4.png"))); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        primer2.add(btn4);

        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento7.png"))); // NOI18N
        btn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn7MouseClicked(evt);
            }
        });
        primer2.add(btn7);

        btn10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento10.png"))); // NOI18N
        btn10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn10MouseClicked(evt);
            }
        });
        primer2.add(btn10);

        btn13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento13.png"))); // NOI18N
        btn13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn13MouseClicked(evt);
            }
        });
        primer2.add(btn13);

        getContentPane().add(primer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 400, 100));

        segundo1.setBackground(new java.awt.Color(204, 204, 204));
        segundo1.setLayout(new java.awt.GridLayout(2, 15, 10, 0));

        btn19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a19.png"))); // NOI18N
        btn19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn19MouseClicked(evt);
            }
        });
        segundo1.add(btn19);

        btn23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a23.png"))); // NOI18N
        btn23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn23MouseClicked(evt);
            }
        });
        segundo1.add(btn23);

        btn27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a27.png"))); // NOI18N
        btn27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn27MouseClicked(evt);
            }
        });
        segundo1.add(btn27);

        btn31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a31.png"))); // NOI18N
        btn31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn31MouseClicked(evt);
            }
        });
        segundo1.add(btn31);

        btn35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a35.png"))); // NOI18N
        btn35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn35MouseClicked(evt);
            }
        });
        segundo1.add(btn35);

        btn39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento39.png"))); // NOI18N
        btn39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn39MouseClicked(evt);
            }
        });
        segundo1.add(btn39);

        btn43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento43.png"))); // NOI18N
        btn43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn43MouseClicked(evt);
            }
        });
        segundo1.add(btn43);

        btn47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento47.png"))); // NOI18N
        btn47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn47MouseClicked(evt);
            }
        });
        segundo1.add(btn47);

        btn51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento51.png"))); // NOI18N
        btn51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn51MouseClicked(evt);
            }
        });
        segundo1.add(btn51);

        btn55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento55.png"))); // NOI18N
        btn55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn55MouseClicked(evt);
            }
        });
        segundo1.add(btn55);

        btn59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento59.png"))); // NOI18N
        btn59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn59MouseClicked(evt);
            }
        });
        segundo1.add(btn59);

        btn63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento63.png"))); // NOI18N
        btn63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn63MouseClicked(evt);
            }
        });
        segundo1.add(btn63);

        btn67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento67.png"))); // NOI18N
        btn67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn67MouseClicked(evt);
            }
        });
        segundo1.add(btn67);

        btn71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento71.png"))); // NOI18N
        btn71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn71MouseClicked(evt);
            }
        });
        segundo1.add(btn71);

        btn75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento75.png"))); // NOI18N
        btn75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn75MouseClicked(evt);
            }
        });
        segundo1.add(btn75);

        btn18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a18.png"))); // NOI18N
        btn18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn18MouseClicked(evt);
            }
        });
        segundo1.add(btn18);

        btn22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a22.png"))); // NOI18N
        btn22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn22MouseClicked(evt);
            }
        });
        segundo1.add(btn22);

        btn26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a26.png"))); // NOI18N
        btn26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn26MouseClicked(evt);
            }
        });
        segundo1.add(btn26);

        btn30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a30.png"))); // NOI18N
        btn30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn30MouseClicked(evt);
            }
        });
        segundo1.add(btn30);

        btn34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a34.png"))); // NOI18N
        btn34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn34MouseClicked(evt);
            }
        });
        segundo1.add(btn34);

        btn38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento38.png"))); // NOI18N
        btn38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn38MouseClicked(evt);
            }
        });
        segundo1.add(btn38);

        btn42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento42.png"))); // NOI18N
        btn42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn42MouseClicked(evt);
            }
        });
        segundo1.add(btn42);

        btn46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento46.png"))); // NOI18N
        btn46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn46MouseClicked(evt);
            }
        });
        segundo1.add(btn46);

        btn50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento50.png"))); // NOI18N
        btn50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn50MouseClicked(evt);
            }
        });
        segundo1.add(btn50);

        btn54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento54.png"))); // NOI18N
        btn54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn54MouseClicked(evt);
            }
        });
        segundo1.add(btn54);

        btn58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento58.png"))); // NOI18N
        btn58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn58MouseClicked(evt);
            }
        });
        segundo1.add(btn58);

        btn62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento62.png"))); // NOI18N
        btn62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn62MouseClicked(evt);
            }
        });
        segundo1.add(btn62);

        btn66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento66.png"))); // NOI18N
        btn66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn66MouseClicked(evt);
            }
        });
        segundo1.add(btn66);

        btn70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento70.png"))); // NOI18N
        btn70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn70MouseClicked(evt);
            }
        });
        segundo1.add(btn70);

        btn74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento74.png"))); // NOI18N
        btn74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn74MouseClicked(evt);
            }
        });
        segundo1.add(btn74);

        getContentPane().add(segundo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 980, 110));

        segundo2.setBackground(new java.awt.Color(204, 204, 204));
        segundo2.setLayout(new java.awt.GridLayout(2, 15, 10, 0));

        btn17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a17.png"))); // NOI18N
        btn17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn17MouseClicked(evt);
            }
        });
        segundo2.add(btn17);

        btn21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a21.png"))); // NOI18N
        btn21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn21MouseClicked(evt);
            }
        });
        segundo2.add(btn21);

        btn25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a25.png"))); // NOI18N
        btn25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn25MouseClicked(evt);
            }
        });
        segundo2.add(btn25);

        btn29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a29.png"))); // NOI18N
        btn29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn29MouseClicked(evt);
            }
        });
        segundo2.add(btn29);

        btn33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a33.png"))); // NOI18N
        btn33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn33MouseClicked(evt);
            }
        });
        segundo2.add(btn33);

        btn37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento37.png"))); // NOI18N
        btn37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn37MouseClicked(evt);
            }
        });
        segundo2.add(btn37);

        btn41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento41.png"))); // NOI18N
        btn41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn41MouseClicked(evt);
            }
        });
        segundo2.add(btn41);

        btn45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento45.png"))); // NOI18N
        btn45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn45MouseClicked(evt);
            }
        });
        segundo2.add(btn45);

        btn49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento49.png"))); // NOI18N
        btn49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn49MouseClicked(evt);
            }
        });
        segundo2.add(btn49);

        btn53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento53.png"))); // NOI18N
        btn53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn53MouseClicked(evt);
            }
        });
        segundo2.add(btn53);

        btn57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento57.png"))); // NOI18N
        btn57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn57MouseClicked(evt);
            }
        });
        segundo2.add(btn57);

        btn61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento61.png"))); // NOI18N
        btn61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn61MouseClicked(evt);
            }
        });
        segundo2.add(btn61);

        btn65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento65.png"))); // NOI18N
        btn65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn65MouseClicked(evt);
            }
        });
        segundo2.add(btn65);

        btn69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento69.png"))); // NOI18N
        btn69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn69MouseClicked(evt);
            }
        });
        segundo2.add(btn69);

        btn73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento73.png"))); // NOI18N
        btn73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn73MouseClicked(evt);
            }
        });
        segundo2.add(btn73);

        btn16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento16.png"))); // NOI18N
        btn16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn16MouseClicked(evt);
            }
        });
        segundo2.add(btn16);

        btn20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a20.png"))); // NOI18N
        btn20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn20MouseClicked(evt);
            }
        });
        segundo2.add(btn20);

        btn24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a24.png"))); // NOI18N
        btn24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn24MouseClicked(evt);
            }
        });
        segundo2.add(btn24);

        btn28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a28.png"))); // NOI18N
        btn28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn28MouseClicked(evt);
            }
        });
        segundo2.add(btn28);

        btn32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a32.png"))); // NOI18N
        btn32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn32MouseClicked(evt);
            }
        });
        segundo2.add(btn32);

        btn36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/a36.png"))); // NOI18N
        btn36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn36MouseClicked(evt);
            }
        });
        segundo2.add(btn36);

        btn40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento40.png"))); // NOI18N
        btn40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn40MouseClicked(evt);
            }
        });
        segundo2.add(btn40);

        btn44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento44.png"))); // NOI18N
        btn44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn44MouseClicked(evt);
            }
        });
        segundo2.add(btn44);

        btn48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento48.png"))); // NOI18N
        btn48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn48MouseClicked(evt);
            }
        });
        segundo2.add(btn48);

        btn52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento52.png"))); // NOI18N
        btn52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn52MouseClicked(evt);
            }
        });
        segundo2.add(btn52);

        btn56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento56.png"))); // NOI18N
        btn56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn56MouseClicked(evt);
            }
        });
        segundo2.add(btn56);

        btn60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento60.png"))); // NOI18N
        btn60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn60MouseClicked(evt);
            }
        });
        segundo2.add(btn60);

        btn64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento64.png"))); // NOI18N
        btn64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn64MouseClicked(evt);
            }
        });
        segundo2.add(btn64);

        btn68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento68.png"))); // NOI18N
        btn68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn68MouseClicked(evt);
            }
        });
        segundo2.add(btn68);

        btn72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientosSinMARCAR/asiento72.png"))); // NOI18N
        btn72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn72MouseClicked(evt);
            }
        });
        segundo2.add(btn72);

        getContentPane().add(segundo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 980, 100));

        segundo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen fondo.png"))); // NOI18N
        segundo3.setText("jLabel1");
        getContentPane().add(segundo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1256, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 80, 50));

        primerPiso.setText("Primer Piso");
        primerPiso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                primerPisoMouseClicked(evt);
            }
        });
        jMenuBar1.add(primerPiso);

        segundoPiso.setText("Segundo Piso");
        segundoPiso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                segundoPisoMouseClicked(evt);
            }
        });
        jMenuBar1.add(segundoPiso);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        if(permitirSeleccion[0]){
            emp.modificarEstadoAsiento(placaBus, 1);
            btn1.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado1.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        if(permitirSeleccion[5]){
            emp.modificarEstadoAsiento(placaBus, 6);
            btn6.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado6.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        if(permitirSeleccion[2]){
            emp.modificarEstadoAsiento(placaBus, 3);
            btn3.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado3.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        if(permitirSeleccion[3]){
            emp.modificarEstadoAsiento(placaBus, 4);
            btn4.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado4.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked
        if(permitirSeleccion[1]){
            emp.modificarEstadoAsiento(placaBus, 2);
            btn2.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado2.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn2MouseClicked

    private void btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseClicked
        if(permitirSeleccion[4]){
            emp.modificarEstadoAsiento(placaBus, 5);
            btn5.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado5.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
        
    }//GEN-LAST:event_btn5MouseClicked

    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked
        if(permitirSeleccion[0]){
            emp.modificarEstadoAsiento(placaBus, 1);
            btn1.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado1.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
        
    }//GEN-LAST:event_btn1MouseClicked

    private void btn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn7MouseClicked
        if(permitirSeleccion[6]){
            emp.modificarEstadoAsiento(placaBus, 7);
            btn7.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado7.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn7MouseClicked

    private void btn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseClicked
        if(permitirSeleccion[7]){
            emp.modificarEstadoAsiento(placaBus, 8);
            btn8.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado8.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn8MouseClicked

    private void btn9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn9MouseClicked
        if(permitirSeleccion[8]){
            emp.modificarEstadoAsiento(placaBus, 9);
            btn9.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado9.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn9MouseClicked

    private void btn10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MouseClicked
        if(permitirSeleccion[9]){
            emp.modificarEstadoAsiento(placaBus, 10);
            btn10.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado10.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn10MouseClicked

    private void btn11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn11MouseClicked
        if(permitirSeleccion[10]){
            emp.modificarEstadoAsiento(placaBus, 11);
            btn11.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado11.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn11MouseClicked

    private void btn12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn12MouseClicked
        if(permitirSeleccion[11]){
            emp.modificarEstadoAsiento(placaBus, 12);
            btn12.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado12.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn12MouseClicked

    private void btn13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn13MouseClicked
        if(permitirSeleccion[12]){
            emp.modificarEstadoAsiento(placaBus, 13);
            btn13.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado13.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn13MouseClicked

    private void btn14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn14MouseClicked
        if(permitirSeleccion[13]){
            emp.modificarEstadoAsiento(placaBus, 14);
            btn14.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado14.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn14MouseClicked

    private void btn15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn15MouseClicked
        if(permitirSeleccion[14]){
            emp.modificarEstadoAsiento(placaBus, 15);
            btn15.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado15.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn15MouseClicked

    private void btn16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn16MouseClicked
        if(permitirSeleccion[15]){
            emp.modificarEstadoAsiento(placaBus, 16);
            btn16.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado16.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn16MouseClicked

    private void btn17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn17MouseClicked
        if(permitirSeleccion[16]){
            emp.modificarEstadoAsiento(placaBus, 17);
            btn17.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado17.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn17MouseClicked

    private void btn18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn18MouseClicked
        if(permitirSeleccion[17]){
            emp.modificarEstadoAsiento(placaBus, 18);
            btn18.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado18.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn18MouseClicked

    private void btn19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn19MouseClicked
        if(permitirSeleccion[18]){
            emp.modificarEstadoAsiento(placaBus, 19);
            btn19.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado19.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn19MouseClicked

    private void btn20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn20MouseClicked
        if(permitirSeleccion[19]){
            emp.modificarEstadoAsiento(placaBus, 20);
            btn20.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado20.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn20MouseClicked

    private void btn21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn21MouseClicked
        if(permitirSeleccion[20]){
            emp.modificarEstadoAsiento(placaBus, 21);
            btn21.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado21.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn21MouseClicked

    private void btn22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn22MouseClicked
        if(permitirSeleccion[21]){
            emp.modificarEstadoAsiento(placaBus, 22);
            btn22.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado22.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn22MouseClicked

    private void btn23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn23MouseClicked
        if(permitirSeleccion[22]){
            emp.modificarEstadoAsiento(placaBus, 23);
            btn23.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado23.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn23MouseClicked

    private void btn24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn24MouseClicked
        if(permitirSeleccion[23]){
            emp.modificarEstadoAsiento(placaBus, 24);
            btn24.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado24.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn24MouseClicked

    private void btn25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn25MouseClicked
        if(permitirSeleccion[24]){
            emp.modificarEstadoAsiento(placaBus, 25);
            btn25.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado25.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn25MouseClicked

    private void btn26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn26MouseClicked
        if(permitirSeleccion[25]){
            emp.modificarEstadoAsiento(placaBus, 26);
            btn26.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado26.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn26MouseClicked

    private void btn27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn27MouseClicked
        if(permitirSeleccion[26]){
            emp.modificarEstadoAsiento(placaBus, 27);
            btn27.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado27.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn27MouseClicked

    private void btn28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn28MouseClicked
        if(permitirSeleccion[27]){
            emp.modificarEstadoAsiento(placaBus, 28);
            btn28.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado28.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn28MouseClicked

    private void btn29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn29MouseClicked
        if(permitirSeleccion[28]){
            emp.modificarEstadoAsiento(placaBus, 29);
            btn29.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado29.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn29MouseClicked

    private void btn30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn30MouseClicked
        if(permitirSeleccion[29]){
            emp.modificarEstadoAsiento(placaBus, 30);
            btn30.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado30.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn30MouseClicked

    private void btn31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn31MouseClicked
        if(permitirSeleccion[30]){
            emp.modificarEstadoAsiento(placaBus, 31);
            btn31.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado31.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn31MouseClicked

    private void btn32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn32MouseClicked
        if(permitirSeleccion[31]){
            emp.modificarEstadoAsiento(placaBus, 32);
            btn32.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado32.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn32MouseClicked

    private void btn33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn33MouseClicked
        if(permitirSeleccion[32]){
            emp.modificarEstadoAsiento(placaBus, 33);
            btn33.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado33.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn33MouseClicked

    private void btn34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn34MouseClicked
        if(permitirSeleccion[33]){
            emp.modificarEstadoAsiento(placaBus, 34);
            btn34.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado34.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn34MouseClicked

    private void btn35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn35MouseClicked
        if(permitirSeleccion[34]){
            emp.modificarEstadoAsiento(placaBus, 35);
            btn35.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado35.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn35MouseClicked

    private void btn36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn36MouseClicked
        if(permitirSeleccion[35]){
            emp.modificarEstadoAsiento(placaBus, 36);
            btn36.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado36.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn36MouseClicked

    private void btn37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn37MouseClicked
        if(permitirSeleccion[36]){
            emp.modificarEstadoAsiento(placaBus, 37);
            btn37.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado37.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn37MouseClicked

    private void btn38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn38MouseClicked
        if(permitirSeleccion[37]){
            emp.modificarEstadoAsiento(placaBus, 38);
            btn38.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado38.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn38MouseClicked

    private void btn39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn39MouseClicked
        if(permitirSeleccion[38]){
            emp.modificarEstadoAsiento(placaBus, 39);
            btn39.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado39.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn39MouseClicked

    private void btn40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn40MouseClicked
        if(permitirSeleccion[39]){
            emp.modificarEstadoAsiento(placaBus, 40);
            btn40.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado40.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn40MouseClicked

    private void btn41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn41MouseClicked
        if(permitirSeleccion[40]){
            emp.modificarEstadoAsiento(placaBus, 41);
            btn41.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado41.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn41MouseClicked

    private void btn42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn42MouseClicked
        if(permitirSeleccion[41]){
            emp.modificarEstadoAsiento(placaBus, 42);
            btn42.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado42.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn42MouseClicked

    private void btn43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn43MouseClicked
        if(permitirSeleccion[42]){
            emp.modificarEstadoAsiento(placaBus, 43);
            btn43.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado43.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn43MouseClicked

    private void btn44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn44MouseClicked
        if(permitirSeleccion[43]){
            emp.modificarEstadoAsiento(placaBus, 44);
            btn44.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado44.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn44MouseClicked

    private void btn45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn45MouseClicked
        if(permitirSeleccion[44]){
            emp.modificarEstadoAsiento(placaBus, 45);
            btn45.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado45.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn45MouseClicked

    private void btn46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn46MouseClicked
        if(permitirSeleccion[45]){
            emp.modificarEstadoAsiento(placaBus, 46);
            btn46.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado46.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn46MouseClicked

    private void btn47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn47MouseClicked
        if(permitirSeleccion[46]){
            emp.modificarEstadoAsiento(placaBus, 47);
            btn47.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado47.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn47MouseClicked

    private void btn48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn48MouseClicked
        if(permitirSeleccion[47]){
            emp.modificarEstadoAsiento(placaBus, 47);
            btn47.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado47.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn48MouseClicked

    private void btn49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn49MouseClicked
        if(permitirSeleccion[48]){
            emp.modificarEstadoAsiento(placaBus, 49);
            btn49.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado49.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn49MouseClicked

    private void btn50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn50MouseClicked
        if(permitirSeleccion[49]){
            emp.modificarEstadoAsiento(placaBus, 50);
            btn50.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado50.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn50MouseClicked

    private void btn51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn51MouseClicked
        if(permitirSeleccion[50]){
            emp.modificarEstadoAsiento(placaBus, 51);
            btn51.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado51.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn51MouseClicked

    private void btn52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn52MouseClicked
        if(permitirSeleccion[51]){
            emp.modificarEstadoAsiento(placaBus, 52);
            btn52.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado52.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn52MouseClicked

    private void btn53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn53MouseClicked
        if(permitirSeleccion[52]){
            emp.modificarEstadoAsiento(placaBus, 53);
            btn53.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado53.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn53MouseClicked

    private void btn54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn54MouseClicked
        if(permitirSeleccion[53]){
            emp.modificarEstadoAsiento(placaBus, 54);
            btn54.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado54.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn54MouseClicked

    private void btn55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn55MouseClicked
        if(permitirSeleccion[54]){
            emp.modificarEstadoAsiento(placaBus, 55);
            btn55.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado55.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn55MouseClicked

    private void btn56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn56MouseClicked
        if(permitirSeleccion[55]){
            emp.modificarEstadoAsiento(placaBus, 56);
            btn56.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado56.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn56MouseClicked

    private void btn57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn57MouseClicked
        if(permitirSeleccion[56]){
            emp.modificarEstadoAsiento(placaBus, 57);
            btn57.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado57.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn57MouseClicked

    private void btn58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn58MouseClicked
        if(permitirSeleccion[57]){
            emp.modificarEstadoAsiento(placaBus, 58);
            btn58.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado58.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn58MouseClicked

    private void btn59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn59MouseClicked
        if(permitirSeleccion[58]){
            emp.modificarEstadoAsiento(placaBus, 59);
            btn59.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado59.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn59MouseClicked

    private void btn60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn60MouseClicked
        if(permitirSeleccion[59]){
            emp.modificarEstadoAsiento(placaBus, 60);
            btn60.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado60.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn60MouseClicked

    private void btn61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn61MouseClicked
        if(permitirSeleccion[60]){
            emp.modificarEstadoAsiento(placaBus, 61);
            btn61.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado61.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn61MouseClicked

    private void btn62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn62MouseClicked
        if(permitirSeleccion[61]){
            emp.modificarEstadoAsiento(placaBus, 62);
            btn62.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado62.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn62MouseClicked

    private void btn63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn63MouseClicked
        if(permitirSeleccion[62]){
            emp.modificarEstadoAsiento(placaBus, 63);
            btn63.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado63.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn63MouseClicked

    private void btn64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn64MouseClicked
        if(permitirSeleccion[63]){
            emp.modificarEstadoAsiento(placaBus, 64);
            btn64.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado64.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn64MouseClicked

    private void btn65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn65MouseClicked
        if(permitirSeleccion[64]){
            emp.modificarEstadoAsiento(placaBus, 65);
            btn65.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado65.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn65MouseClicked

    private void btn66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn66MouseClicked
        if(permitirSeleccion[65]){
            emp.modificarEstadoAsiento(placaBus, 66);
            btn66.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado66.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn66MouseClicked

    private void btn67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn67MouseClicked
        if(permitirSeleccion[66]){
            emp.modificarEstadoAsiento(placaBus, 67);
            btn67.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado67.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn67MouseClicked

    private void btn68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn68MouseClicked
        if(permitirSeleccion[67]){
            emp.modificarEstadoAsiento(placaBus, 68);
            btn68.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado68.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn68MouseClicked

    private void btn69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn69MouseClicked
        if(permitirSeleccion[68]){
            emp.modificarEstadoAsiento(placaBus, 69);
            btn69.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado69.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn69MouseClicked

    private void btn70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn70MouseClicked
        if(permitirSeleccion[69]){
            emp.modificarEstadoAsiento(placaBus, 70);
            btn70.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado70.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn70MouseClicked

    private void btn71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn71MouseClicked
        if(permitirSeleccion[70]){
            emp.modificarEstadoAsiento(placaBus, 71);
            btn71.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado71.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn71MouseClicked

    private void btn72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn72MouseClicked
        if(permitirSeleccion[71]){
            emp.modificarEstadoAsiento(placaBus, 72);
            btn72.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado72.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn72MouseClicked

    private void btn73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn73MouseClicked
        if(permitirSeleccion[72]){
            emp.modificarEstadoAsiento(placaBus, 73);
            btn73.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado73.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn73MouseClicked

    private void btn74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn74MouseClicked
        if(permitirSeleccion[73]){
            emp.modificarEstadoAsiento(placaBus, 74);
            btn74.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado74.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn74MouseClicked

    private void btn75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn75MouseClicked
        if(permitirSeleccion[74]){
            emp.modificarEstadoAsiento(placaBus, 75);
            btn75.setIcon(new ImageIcon(getClass().getResource("/imagenes/asientoocupado75.png")));
        }
        else
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
    }//GEN-LAST:event_btn75MouseClicked

    private void segundoPisoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_segundoPisoMouseClicked
        // TODO add your handling code here:
        primer1.setVisible(false);
        primer2.setVisible(false);
        segundo1.setVisible(true);
        segundo2.setVisible(true);
    }//GEN-LAST:event_segundoPisoMouseClicked

    private void primerPisoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_primerPisoMouseClicked
        // TODO add your handling code here:
        segundo1.setVisible(false);
        segundo2.setVisible(false);
        primer1.setVisible(true);
        primer2.setVisible(true);
    }//GEN-LAST:event_primerPisoMouseClicked

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
            java.util.logging.Logger.getLogger(vtnAsientosBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vtnAsientosBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vtnAsientosBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vtnAsientosBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vtnAsientosBus(null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn24;
    private javax.swing.JButton btn25;
    private javax.swing.JButton btn26;
    private javax.swing.JButton btn27;
    private javax.swing.JButton btn28;
    private javax.swing.JButton btn29;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn30;
    private javax.swing.JButton btn31;
    private javax.swing.JButton btn32;
    private javax.swing.JButton btn33;
    private javax.swing.JButton btn34;
    private javax.swing.JButton btn35;
    private javax.swing.JButton btn36;
    private javax.swing.JButton btn37;
    private javax.swing.JButton btn38;
    private javax.swing.JButton btn39;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn40;
    private javax.swing.JButton btn41;
    private javax.swing.JButton btn42;
    private javax.swing.JButton btn43;
    private javax.swing.JButton btn44;
    private javax.swing.JButton btn45;
    private javax.swing.JButton btn46;
    private javax.swing.JButton btn47;
    private javax.swing.JButton btn48;
    private javax.swing.JButton btn49;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn50;
    private javax.swing.JButton btn51;
    private javax.swing.JButton btn52;
    private javax.swing.JButton btn53;
    private javax.swing.JButton btn54;
    private javax.swing.JButton btn55;
    private javax.swing.JButton btn56;
    private javax.swing.JButton btn57;
    private javax.swing.JButton btn58;
    private javax.swing.JButton btn59;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn60;
    private javax.swing.JButton btn61;
    private javax.swing.JButton btn62;
    private javax.swing.JButton btn63;
    private javax.swing.JButton btn64;
    private javax.swing.JButton btn65;
    private javax.swing.JButton btn66;
    private javax.swing.JButton btn67;
    private javax.swing.JButton btn68;
    private javax.swing.JButton btn69;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn70;
    private javax.swing.JButton btn71;
    private javax.swing.JButton btn72;
    private javax.swing.JButton btn73;
    private javax.swing.JButton btn74;
    private javax.swing.JButton btn75;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnVolver;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel primer1;
    private javax.swing.JPanel primer2;
    private javax.swing.JMenu primerPiso;
    private javax.swing.JPanel segundo1;
    private javax.swing.JPanel segundo2;
    private javax.swing.JLabel segundo3;
    private javax.swing.JMenu segundoPiso;
    // End of variables declaration//GEN-END:variables
}
