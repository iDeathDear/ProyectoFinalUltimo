package vista;

import conexion.Conexion;
import java.sql.*;
import controlador.Ctrl_Producto;
import datos.Producto;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.ProductoDAO;
import dao.impl.ProductoDAOImpl;

public class JDProducto extends javax.swing.JDialog {
    private int idProducto;
    Producto pro = new Producto();
    Ctrl_Producto ct = new Ctrl_Producto();
    DefaultTableModel model = new DefaultTableModel();

    public JDProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        model.setColumnIdentifiers(new String[]{"ID", "Modelo", "Marca", "Almacenamiento", "Color", "Precio"});
        jtbProducto.setModel(model);
        jtbProducto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbProducto.setRowSelectionAllowed(true);
        jtbProducto.setColumnSelectionAllowed(false); // <- bloquea selección de columnas

        
        this.CargarTProducto();
        this.FijarColumna();
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtIdproducto = new javax.swing.JTextField();
        txtMarca = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cboxColor = new javax.swing.JComboBox<>();
        cboxMarca = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbProducto = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cboxAlmacenamiento = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar producto");
        setPreferredSize(new java.awt.Dimension(640, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setText("ID del Producto");

        txtIdproducto.setEnabled(false);
        txtIdproducto.setPreferredSize(new java.awt.Dimension(140, 25));
        txtIdproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdproductoActionPerformed(evt);
            }
        });

        txtMarca.setBackground(new java.awt.Color(255, 255, 255));
        txtMarca.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txtMarca.setText("Marca");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Color");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setText("Precio");

        txtPrecio.setPreferredSize(new java.awt.Dimension(140, 25));
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        btnCrear.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setPreferredSize(new java.awt.Dimension(90, 25));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("REGISTRAR PRODUCTO");

        cboxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el color", "negro", "amarillo", "blanco", "esmeralda", "azul" }));
        cboxColor.setPreferredSize(new java.awt.Dimension(140, 25));
        cboxColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxColorActionPerformed(evt);
            }
        });

        cboxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la marca", "Samsung", "Apple", "Xiaomi", "Motorola", "Huawei", "Oppo", "Honor", "Realme", " ", " " }));
        cboxMarca.setPreferredSize(new java.awt.Dimension(140, 25));
        cboxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMarcaActionPerformed(evt);
            }
        });

        jtbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Marca", "Almacenamiento", "Color", "Precio", "Stock", "Descripción"
            }
        ));
        jtbProducto.setToolTipText("");
        jScrollPane3.setViewportView(jtbProducto);
        if (jtbProducto.getColumnModel().getColumnCount() > 0) {
            jtbProducto.getColumnModel().getColumn(0).setResizable(false);
            jtbProducto.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbProducto.getColumnModel().getColumn(1).setResizable(false);
            jtbProducto.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel7.setText("Almacenamiento");

        cboxAlmacenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la cantidad de memoria", "64 gb", "128 gb", " " }));
        cboxAlmacenamiento.setPreferredSize(new java.awt.Dimension(140, 25));
        cboxAlmacenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAlmacenamientoActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setText("Modelo");

        txtModelo.setPreferredSize(new java.awt.Dimension(140, 25));
        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(16, 16, 16)
                                        .addComponent(txtIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(67, 67, 67)
                                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtMarca)
                                        .addGap(75, 75, 75)
                                        .addComponent(cboxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboxAlmacenamiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(80, 80, 80)
                                        .addComponent(cboxColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(73, 73, 73)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(txtIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtMarca))
                            .addComponent(cboxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7))
                            .addComponent(cboxAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboxColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtIdproducto.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Selecciona un producto para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar este producto?", "Confirmar", JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        int id = Integer.parseInt(txtIdproducto.getText());
        if (ctrl.eliminar(id)) {
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente");
            Limpiar();
            buscarYMostrarProductos();
            txtModelo.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar producto");
        }
    }
    }//GEN-LAST:event_btnEliminarActionPerformed
       
    private final Ctrl_Producto ctrl = new Ctrl_Producto();
  
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
         if (txtIdproducto.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Selecciona un producto para actualizar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (txtModelo.getText().isEmpty() ||
        cboxMarca.getSelectedIndex() == 0 ||
        cboxAlmacenamiento.getSelectedIndex() == 0 ||
        cboxColor.getSelectedIndex() == 0 ||
        txtPrecio.getText().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Completa todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Producto producto = new Producto();
    producto.setModelo(txtModelo.getText().trim());
    producto.setMarca(cboxMarca.getSelectedItem().toString());
    producto.setAlmacenamiento(cboxAlmacenamiento.getSelectedItem().toString());
    producto.setColor(cboxColor.getSelectedItem().toString());
    producto.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));

    int id = Integer.parseInt(txtIdproducto.getText());

    if (ctrl.actualizar(producto, id)) {
        JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
        Limpiar();
        buscarYMostrarProductos();
        txtModelo.requestFocus();
    } else {
        JOptionPane.showMessageDialog(this, "Error al actualizar producto");
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if (txtModelo.getText().isEmpty() ||
        cboxMarca.getSelectedIndex() == 0 ||
        cboxAlmacenamiento.getSelectedIndex() == 0 ||
        cboxColor.getSelectedIndex() == 0 ||
        txtPrecio.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "Complete todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Producto producto = new Producto();
    producto.setModelo(txtModelo.getText().trim());
    producto.setMarca(cboxMarca.getSelectedItem().toString());
    producto.setAlmacenamiento(cboxAlmacenamiento.getSelectedItem().toString());
    producto.setColor(cboxColor.getSelectedItem().toString());
    producto.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));

    ProductoDAO dao = new ProductoDAOImpl();
    if (dao.crear(producto)) {
        JOptionPane.showMessageDialog(this, "Producto creado exitosamente");
        Limpiar();
        CargarTProducto();
        FijarColumna();
        txtModelo.requestFocus();
    } else {
        JOptionPane.showMessageDialog(this, "Error al crear producto");
    }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void cboxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMarcaActionPerformed
        cboxMarca.transferFocus();
    }//GEN-LAST:event_cboxMarcaActionPerformed

    private void cboxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxColorActionPerformed
        cboxColor.transferFocus();
    }//GEN-LAST:event_cboxColorActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        txtPrecio.transferFocus();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    buscarYMostrarProductos();
    txtModelo.requestFocus();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cboxAlmacenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAlmacenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxAlmacenamientoActionPerformed

    private void txtIdproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdproductoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
        txtModelo.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            JDProducto dialog = new JDProducto(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboxAlmacenamiento;
    private javax.swing.JComboBox<String> cboxColor;
    private javax.swing.JComboBox<String> cboxMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jtbProducto;
    private javax.swing.JTextField txtIdproducto;
    private javax.swing.JLabel txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
     
    txtIdproducto.setText("");
    txtModelo.setText("");
    cboxMarca.setSelectedIndex(0);
    cboxAlmacenamiento.setSelectedIndex(0);
    cboxColor.setSelectedIndex(0);
    txtPrecio.setText("");
    }

    private void Buscar(String buscar) {
        try {
            DefaultTableModel marca;
            marca = ct.buscar(buscar);
            jtbProducto.setModel(marca);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    private void CargarTProducto() {
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // desactiva las celdas
        }
    };

    model.setColumnIdentifiers(new String[]{"ID", "Modelo", "Marca", "Almacenamiento", "Color", "Precio"});

    Ctrl_Producto controlador = new Ctrl_Producto();
    model = controlador.obtenerTodos();

    jtbProducto.setModel(model);

    // Configurar selección de solo filas
    jtbProducto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jtbProducto.setRowSelectionAllowed(true);
    jtbProducto.setColumnSelectionAllowed(false);
    FijarColumna(); 
}



    private void EnviarDatosProductoSelec(int idProducto) {
        try {
            Connection cn = Conexion.conectar();
            String sql = "SELECT * FROM producto WHERE idProducto = '" + idProducto + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                txtIdproducto.setText(rs.getString("idProducto"));
                txtModelo.setText(rs.getString("modelo"));
                cboxMarca.setSelectedItem(rs.getString("marca"));
                cboxAlmacenamiento.setSelectedItem(rs.getString("almacenamiento"));
                cboxColor.setSelectedItem(rs.getString("color"));
                txtPrecio.setText(rs.getString("precio"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al selecionar producto " + e);
        }
    }
    
    //Tamaño del ancho de las columnas y filarlos
    private void FijarColumna() {
    jtbProducto.getColumnModel().getColumn(0).setPreferredWidth(20);  // ID
    jtbProducto.getColumnModel().getColumn(0).setResizable(false);

    jtbProducto.getColumnModel().getColumn(1).setPreferredWidth(60);  // Modelo
    jtbProducto.getColumnModel().getColumn(1).setResizable(false);

    jtbProducto.getColumnModel().getColumn(2).setPreferredWidth(80);  // Marca
    jtbProducto.getColumnModel().getColumn(2).setResizable(false);

    jtbProducto.getColumnModel().getColumn(3).setPreferredWidth(80);  // Almacenamiento
    jtbProducto.getColumnModel().getColumn(3).setResizable(false);

    jtbProducto.getColumnModel().getColumn(4).setPreferredWidth(60);  // Color
    jtbProducto.getColumnModel().getColumn(4).setResizable(false);

    jtbProducto.getColumnModel().getColumn(5).setPreferredWidth(60);  // Precio
    jtbProducto.getColumnModel().getColumn(5).setResizable(false);

    jtbProducto.setRowHeight(20);
}
private void buscarYMostrarProductos() {
    
    DefaultTableModel model = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // <- Esto impide edición directa
      }
    };
    String filtro = txtModelo.getText().trim(); // o puedes usar un combo más adelante
        
    DefaultTableModel modelo = ctrl.buscar(filtro); // usa buscar(filtro) si estás aplicando filtro activo
    jtbProducto.setModel(modelo);
    FijarColumna();
    
    // Detectar clic en la tabla
    jtbProducto.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = jtbProducto.rowAtPoint(e.getPoint());

            if (fila >= 0) {
                txtIdproducto.setText(jtbProducto.getValueAt(fila, 0).toString());
                txtModelo.setText(jtbProducto.getValueAt(fila, 1).toString());
                cboxMarca.setSelectedItem(jtbProducto.getValueAt(fila, 2).toString());
                cboxAlmacenamiento.setSelectedItem(jtbProducto.getValueAt(fila, 3).toString());
                cboxColor.setSelectedItem(jtbProducto.getValueAt(fila, 4).toString());
                txtPrecio.setText(jtbProducto.getValueAt(fila, 5).toString());
            }
        }
    });
}

}
