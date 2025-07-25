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
        btnCrear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Usuarios");
        setPreferredSize(new java.awt.Dimension(560, 385));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Apellido");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtApellido.setPreferredSize(new java.awt.Dimension(64, 25));
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 140, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        txtNombre.setPreferredSize(new java.awt.Dimension(64, 25));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 140, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Celular");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 21));

        txtCelular.setPreferredSize(new java.awt.Dimension(64, 25));
        jPanel2.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 140, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("DNI");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        txtUsuario.setPreferredSize(new java.awt.Dimension(64, 25));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 140, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Clave");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        txtClave.setPreferredSize(new java.awt.Dimension(140, 25));
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel2.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        cboxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Vendedor", "Administrador" }));
        cboxCategoria.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel2.add(cboxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Direccion");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jtbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbUsuario);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 530, 210));

        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 100, -1));

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
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 100, -1));

        btnLimpiar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 100, -1));

        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 100, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("ADMINISTRAR USUARIOS");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        btnCrear.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setPreferredSize(new java.awt.Dimension(90, 25));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 100, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Categoría");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        txtDireccion.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Usuario");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        txtDni.setPreferredSize(new java.awt.Dimension(140, 25));
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbUsuarioMouseClicked
        int fila = jtbUsuario.getSelectedRow();
    if (fila != -1) {
        idUsuario = Integer.parseInt(jtbUsuario.getValueAt(fila, 0).toString());
        txtNombre.setText(jtbUsuario.getValueAt(fila, 1).toString());
        txtApellido.setText(jtbUsuario.getValueAt(fila, 2).toString());
        txtDni.setText(jtbUsuario.getValueAt(fila, 3).toString());
        txtUsuario.setText(jtbUsuario.getValueAt(fila, 4).toString());
        txtClave.setText(jtbUsuario.getValueAt(fila, 5).toString());
        cboxCategoria.setSelectedItem(jtbUsuario.getValueAt(fila, 6).toString());
        txtCelular.setText(jtbUsuario.getValueAt(fila, 7).toString());
        txtDireccion.setText(jtbUsuario.getValueAt(fila, 8).toString());
    }
    }//GEN-LAST:event_jtbUsuarioMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtApellido.setText("");
        txtNombre.setText("");
        txtCelular.setText("");
        txtUsuario.setText("");
        txtClave.setText("");
        txtDni.setText("");
        txtDireccion.setText("");
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
                usu.setDireccion(txtDireccion.getText().trim());

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

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed
    private boolean validarCampos() {
    if (txtNombre.getText().trim().isEmpty()
        || txtApellido.getText().trim().isEmpty()
        || txtCelular.getText().trim().isEmpty()
        || txtUsuario.getText().trim().isEmpty()
        || txtClave.getText().trim().isEmpty()
        || cboxCategoria.getSelectedIndex() == 0
        || txtDni.getText().trim().isEmpty()
        || txtDireccion.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(null, "Complete todos los campos correctamente");
        return false;
    }

    return true;
}

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if (validarCampos()) {
        Usuario nuevo = new Usuario();
        nuevo.setNombre(txtNombre.getText());
        nuevo.setApellido(txtApellido.getText());
        nuevo.setDni(txtDni.getText());
        nuevo.setUsuario(txtUsuario.getText());
        nuevo.setClave(txtClave.getText());
        nuevo.setCategoria(cboxCategoria.getSelectedItem().toString());
        nuevo.setCelular(txtCelular.getText());
        nuevo.setDireccion(txtDireccion.getText());
        

        if (ct.crear(nuevo)) {
            JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
            this.Limpiar();
            this.CargarTUsuarios();
        } else {
            JOptionPane.showMessageDialog(null, "Error al crear usuario");
        }
    }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

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
    private javax.swing.JButton btnCrear;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jtbUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void CargarTUsuarios() {
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Evita que las celdas se editen
        }
    };

    model.addColumn("ID");
    model.addColumn("Nombre");
    model.addColumn("Apellido");
    model.addColumn("Dni");
    model.addColumn("Usuario");
    model.addColumn("Clave");
    model.addColumn("Categoría");
    model.addColumn("Celular");
    model.addColumn("Dirección");

    Connection cn = Conexion.conectar();
    String sql = "SELECT idUsuario, nombres, apellidos, dni, usuario, clave, categoria, celular, direccion FROM usuario";

    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Object[] fila = new Object[9];
            for (int i = 0; i < 9; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            model.addRow(fila);
        }

        jtbUsuario.setModel(model);

        // 👇 Esto bloquea la edición y selecciona solo filas
        jtbUsuario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbUsuario.setRowSelectionAllowed(true);
        jtbUsuario.setColumnSelectionAllowed(false);

        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al llenar la tabla usuario: " + e);
    }
}

    
   private void buscarYMostrarUsuarios() {
    Usuario filtro = new Usuario();
    filtro.setNombre(txtNombre.getText().trim());
    filtro.setApellido(txtApellido.getText().trim());
    filtro.setDni(txtDni.getText().trim());
    filtro.setUsuario(txtUsuario.getText().trim());
    filtro.setClave(txtClave.getText().trim());
    filtro.setCategoria(cboxCategoria.getSelectedItem().toString());
    filtro.setCelular(txtCelular.getText().trim());
          
    filtro.setDireccion(txtDireccion.getText().trim());

    List<Usuario> lista = ct.buscarFiltrado(filtro);

    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // evita que se puedan editar las celdas
        }
    };

    model.addColumn("ID");
    model.addColumn("Nombre");
    model.addColumn("Apellido");
    model.addColumn("Dni");
    model.addColumn("Usuario");
    model.addColumn("Clave");
    model.addColumn("Categoría");
    model.addColumn("Celular");
    model.addColumn("Dirección");

    for (Usuario u : lista) {
        Object[] fila = new Object[] {
            u.getIdUsuario(),
            u.getNombre(),
            u.getApellido(),
            u.getDni(),
            u.getUsuario(),
            u.getClave(),
            u.getCategoria(),
            u.getCelular(),
            u.getDireccion()
        };
        model.addRow(fila);
    }

    jtbUsuario.setModel(model);

    // 👇 Esto asegura que solo se pueda seleccionar una fila y no columnas
    jtbUsuario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jtbUsuario.setRowSelectionAllowed(true);
    jtbUsuario.setColumnSelectionAllowed(false);
}

    
    private void Limpiar() {
        txtApellido.setText("");
        txtNombre.setText("");
        txtCelular.setText("");
        txtUsuario.setText("");
        txtClave.setText("");
        txtDireccion.setText("");
        txtDni.setText("");
        cboxCategoria.setSelectedIndex(0);
    }
}
