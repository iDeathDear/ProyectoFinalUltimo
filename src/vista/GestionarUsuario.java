package vista;

import conexion.Conexion;
import controlador.Ctrl_Usuario;
import datos.Usuario;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.event.MouseListener;


public class GestionarUsuario extends javax.swing.JDialog {

    private int idUsuario = 0;
    Usuario usu = new Usuario();
    Ctrl_Usuario ct = new Ctrl_Usuario();

    public GestionarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        for (MouseListener ml : jtbUsuario.getMouseListeners()) {
    if (ml.getClass().getName().contains("FormListener")) {
        jtbUsuario.removeMouseListener(ml);
    }
}
        jPanel2.setBackground(null);
        txtNombre.setBackground(null);
        txtApellido.setBackground(null);
        txtCelular.setBackground(null);
        txtUsuario.setBackground(null);
        txtClave.setBackground(null);
        cboxCategoria.setBackground(null);
        btnBuscar.setBackground(null);
        btnActualizar.setBackground(null);
        btnEliminar.setBackground(null);
        btnLimpiar.setBackground(null);
    
        this.CargarTUsuarios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        cboxCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbUsuario = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Usuarios");
        setPreferredSize(new java.awt.Dimension(630, 440));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setText("Apellido");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 81, -1, -1));
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 81, 136, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 136, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setText("Celular");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 127, -1, 21));
        jPanel2.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 127, 136, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setText("Usuario");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 81, -1, -1));
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 81, 128, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel7.setText("Clave");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 127, -1, -1));

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel2.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 127, 128, -1));

        cboxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Vendedor", "Administrador" }));
        jPanel2.add(cboxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 128, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Categoría");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jtbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Apellido", "Nombre", "Celular", "Categoría", "Usuario", "Clave"
            }
        ));
        jtbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbUsuario);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 590, 230));

        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 100, -1));

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setMaximumSize(new java.awt.Dimension(91, 23));
        btnEliminar.setMinimumSize(new java.awt.Dimension(91, 23));
        btnEliminar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 121, 100, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 67, 100, -1));

        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 94, 100, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("ADMINISTRAR USUARIOS");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbUsuarioMouseClicked
        int fila = jtbUsuario.getSelectedRow();
    if (fila != -1) {
        idUsuario = Integer.parseInt(jtbUsuario.getValueAt(fila, 0).toString());
        txtApellido.setText(jtbUsuario.getValueAt(fila, 1).toString());
        txtNombre.setText(jtbUsuario.getValueAt(fila, 2).toString());
        txtCelular.setText(jtbUsuario.getValueAt(fila, 3).toString());
        cboxCategoria.setSelectedItem(jtbUsuario.getValueAt(fila, 4).toString());
        txtUsuario.setText(jtbUsuario.getValueAt(fila, 5).toString());
        txtClave.setText(jtbUsuario.getValueAt(fila, 6).toString());
    }
    }//GEN-LAST:event_jtbUsuarioMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtApellido.setText("");
        txtNombre.setText("");
        txtCelular.setText("");
        txtUsuario.setText("");
        txtClave.setText("");
        cboxCategoria.setSelectedIndex(0); // Asegúrate de que el primer ítem sea "Seleccione"
        txtNombre.requestFocus(); // Para que el cursor vuelva a empezar allí
        CargarTUsuarios();    
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario");
        } else {
            if (txtApellido.getText().isEmpty() || txtNombre.getText().isEmpty() || txtCelular.getText().isEmpty()
                || cboxCategoria.getSelectedItem().toString().isEmpty() || txtUsuario.getText().isEmpty() || txtClave.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            } else {
                usu.setApellido(txtApellido.getText().trim());
                usu.setNombre(txtNombre.getText().trim());
                usu.setCelular(txtCelular.getText().trim());
                usu.setCategoria(cboxCategoria.getSelectedItem().toString().trim());
                usu.setUsuario(txtUsuario.getText().trim());
                usu.setClave(txtClave.getText().trim());
                if (ct.actualizar(usu, idUsuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario actualizado");
                    this.Limpiar();
                    this.CargarTUsuarios();
                    idUsuario = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar usuario");
                }
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un Usuario");
        } else {
            if (ct.eliminar(idUsuario)) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado");
                this.Limpiar();
                this.CargarTUsuarios();
                txtNombre.requestFocus();
                idUsuario = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar usuario");
                this.Limpiar();
                this.CargarTUsuarios();
                txtNombre.requestFocus();
                
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarYMostrarUsuarios();        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionarUsuario dialog = new GestionarUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jtbUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void CargarTUsuarios() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Apellido");
    model.addColumn("Nombre");
    model.addColumn("Celular");
    model.addColumn("Categoría");
    model.addColumn("Usuario");
    model.addColumn("Clave");

    Connection cn = Conexion.conectar();
    String sql = "SELECT idUsuario, apellidos, nombres, celular, categoria, usuario, clave FROM usuario";

    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Object[] fila = new Object[7];
            for (int i = 0; i < 7; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            model.addRow(fila);
        }

        jtbUsuario.setModel(model); // importante: no se reemplaza la tabla
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al llenar la tabla usuario: " + e);
    }
}


    private void EnviarDatosUsuarioSelec(int idUsuario) {
        try {
            Connection cn = Conexion.conectar();
            String sql = "SELECT idUsuario,apellidos,nombres,celular,categoria,usuario, clave FROM usuario WHERE idUsuario = '" + idUsuario + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                txtApellido.setText(rs.getString("apellidos"));
                txtNombre.setText(rs.getString("nombres"));
                txtCelular.setText(rs.getString("celular"));
                cboxCategoria.setSelectedItem(rs.getString("categoria"));
                txtUsuario.setText(rs.getString("usuario"));
                txtClave.setText(rs.getString("clave"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al selecionar usuario " + e);
        }
    }
    
    private void buscarYMostrarUsuarios() {
    Usuario filtro = new Usuario();
    filtro.setApellido(txtApellido.getText().trim());
    filtro.setNombre(txtNombre.getText().trim());
    filtro.setCelular(txtCelular.getText().trim());
    filtro.setCategoria(cboxCategoria.getSelectedItem().toString());
    filtro.setUsuario(txtUsuario.getText().trim());

    List<Usuario> lista = ct.buscarFiltrado(filtro);

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Apellido");
    model.addColumn("Nombre");
    model.addColumn("Celular");
    model.addColumn("Categoría");
    model.addColumn("Usuario");
    model.addColumn("Clave");

    for (Usuario u : lista) {
        Object[] fila = new Object[]{
            u.getIdUsuario(),
            u.getApellido(),
            u.getNombre(),
            u.getCelular(),
            u.getCategoria(),
            u.getUsuario(),
            u.getClave()
        };
        model.addRow(fila);
    }

    jtbUsuario.setModel(model); // usamos la tabla existente    // reaplicamos el listener
}
    
    private void Limpiar() {
        txtApellido.setText("");
        txtNombre.setText("");
        txtCelular.setText("");
        cboxCategoria.setSelectedItem("Seleccione");
        txtUsuario.setText("");
        txtClave.setText("");
    }
}
