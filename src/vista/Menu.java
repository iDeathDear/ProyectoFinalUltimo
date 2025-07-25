package vista;
public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Inicio de Sesión - NOVOX");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnUsuario = new javax.swing.JMenu();
        btnAdministrar = new javax.swing.JMenuItem();
        btnProducto = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        btnCliente = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        btnVenta = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        btnStock = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        btnConfiguracion = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        btnCerrar = new javax.swing.JMenu();
        jMCerrar = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem4.setText("jMenuItem4");

        jMenuItem7.setText("jMenuItem7");

        jMenuItem8.setText("jMenuItem8");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de venta de case");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/novox.PNG"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 250, 160));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cel.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 330, 140));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 490));

        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usumenu.png"))); // NOI18N
        btnUsuario.setText("Usuario");

        btnAdministrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevousu.png"))); // NOI18N
        btnAdministrar.setText("Administrar usuario");
        btnAdministrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarActionPerformed(evt);
            }
        });
        btnUsuario.add(btnAdministrar);

        jMenuBar1.add(btnUsuario);

        btnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iphone.png"))); // NOI18N
        btnProducto.setText("Producto");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevocase.png"))); // NOI18N
        jMenuItem5.setText("Registrar producto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        btnProducto.add(jMenuItem5);

        jMenuBar1.add(btnProducto);

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clientemenu.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.setMaximumSize(new java.awt.Dimension(84, 100));

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarcliente.png"))); // NOI18N
        jMenuItem1.setText("Registrar cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        btnCliente.add(jMenuItem1);

        jMenuBar1.add(btnCliente);

        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/venta.png"))); // NOI18N
        btnVenta.setText("Venta");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/generarventa.png"))); // NOI18N
        jMenuItem3.setText("Generar venta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        btnVenta.add(jMenuItem3);

        jMenuBar1.add(btnVenta);

        btnStock.setText("Stock");

        jMenuItem2.setText("Agregar stock");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        btnStock.add(jMenuItem2);

        jMenuBar1.add(btnStock);

        btnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configurar.png"))); // NOI18N
        btnConfiguracion.setText("Configuración");

        jMenuItem9.setText("Mantenimiento");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        btnConfiguracion.add(jMenuItem9);

        jMenuBar1.add(btnConfiguracion);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrarsesion.png"))); // NOI18N
        btnCerrar.setText("Cerrar Sesión");

        jMCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        jMCerrar.setText("Cerrar");
        jMCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCerrarActionPerformed(evt);
            }
        });
        btnCerrar.add(jMCerrar);

        jMenuBar1.add(btnCerrar);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JDCliente cl = new JDCliente(this, true);
        cl.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JDProducto vt = new JDProducto(this, true);
        vt.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Stock pr = new Stock(this, true);
        pr.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnAdministrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarActionPerformed
        GestionarUsuario usu = new GestionarUsuario(this, true);
        usu.setVisible(true);
    }//GEN-LAST:event_btnAdministrarActionPerformed

    private void jMCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMCerrarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JDVenta vt = new JDVenta(this, true);
        vt.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
       
        LoginProgramador ventana1 = new LoginProgramador(); //instanciamos la ventana a donde queremos entrar
        ventana1.setVisible(true);//nos apertura a la ventana que desemos entrar (True)ABRIR

        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAdministrar;
    private javax.swing.JMenu btnCerrar;
    private javax.swing.JMenu btnCliente;
    private javax.swing.JMenu btnConfiguracion;
    private javax.swing.JMenu btnProducto;
    private javax.swing.JMenu btnStock;
    private javax.swing.JMenu btnUsuario;
    private javax.swing.JMenu btnVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMCerrar;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void Privilegios(String categoria) {
    
        if ("Administrador".equals(categoria)) {
            btnUsuario.setEnabled(true);
            btnProducto.setEnabled(true);
            btnCliente.setEnabled(true);
            btnStock.setEnabled(true);
            btnVenta.setEnabled(true);
            btnCerrar.setEnabled(true);
        } else if ("Vendedor".equals(categoria)) {
            btnUsuario.setVisible(false);
            btnProducto.setVisible(false);
            btnStock.setVisible(false);
       }
    }
}


