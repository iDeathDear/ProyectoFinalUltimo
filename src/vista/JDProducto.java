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

public class JDProducto extends javax.swing.JDialog {
    private int idProducto;
    Producto pro = new Producto();
    Ctrl_Producto ct = new Ctrl_Producto();
    DefaultTableModel model = new DefaultTableModel();

    public JDProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        // Configurar modelo de tabla sin columna 'modelo'
        model.setColumnIdentifiers(new String[]{"ID", "Marca", "Almacenamiento", "Color", "Precio", "Stock", "Descripción"});
        jtbProducto.setModel(model);
        
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtStock = new javax.swing.JTextField();
        cboxColor = new javax.swing.JComboBox<>();
        cboxMarca = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbProducto = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cboxAlmacenamiento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar producto");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setText("ID del Producto");

        txtIdproducto.setBackground(new java.awt.Color(204, 204, 255));
        txtIdproducto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtIdproducto.setEnabled(false);
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

        txtPrecio.setBackground(new java.awt.Color(204, 204, 255));
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setText("Stock");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setText("Descripción");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        btnGuardar.setBackground(new java.awt.Color(0, 102, 255));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GuardarTodo.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(0, 102, 255));
        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel8.setText("REGISTRAR PRODUCTO");

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel19.setText("Buscar");

        txtBuscar.setBackground(new java.awt.Color(204, 204, 255));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        txtStock.setBackground(new java.awt.Color(204, 204, 255));
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        cboxColor.setBackground(new java.awt.Color(204, 204, 255));
        cboxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el color", "negro", "amarillo", "blanco", "esmeralda", "azul" }));
        cboxColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxColorActionPerformed(evt);
            }
        });

        cboxMarca.setBackground(new java.awt.Color(204, 204, 255));
        cboxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la marca", "Samsung", "Apple", "Xiaomi", "Motorola", "Huawei", "Oppo", "Honor", "Realme", " ", " " }));
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

        cboxAlmacenamiento.setBackground(new java.awt.Color(204, 204, 255));
        cboxAlmacenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la cantidad de memoria", "64 gb", "128 gb", " " }));
        cboxAlmacenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAlmacenamientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMarca)
                                .addGap(75, 75, 75)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(24, 24, 24)
                                    .addComponent(txtIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxColor, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarca)
                            .addComponent(cboxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboxAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

       if (cboxMarca.getSelectedItem().toString().equals("Seleccione marca") ||
            cboxAlmacenamiento.getSelectedItem().toString().equals("Seleccione almacenamiento") ||
            cboxColor.getSelectedItem().toString().equals("Seleccione el color") || txtStock.getText().equals("") || txtPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            cboxMarca.setBackground(Color.red);
            cboxAlmacenamiento.setBackground(Color.red);
            cboxColor.setBackground(Color.red);
            txtStock.setBackground(Color.red);
            txtPrecio.setBackground(Color.red);
        } else {
            try {
                pro.setMarca(cboxMarca.getSelectedItem().toString().trim());
                pro.setAlmacenamiento(cboxAlmacenamiento.getSelectedItem().toString().trim());
                pro.setColor(cboxColor.getSelectedItem().toString().trim());
                pro.setStock(Integer.parseInt(txtStock.getText().trim()));
                pro.setDescripcion(txtDescripcion.getText().trim());
                if (ct.guardar(pro)) {
                    JOptionPane.showMessageDialog(null, "Celular registrado");
                    this.CargarTProducto();
                    this.FijarColumna();
                    this.Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }
            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error en: " + e);
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (idProducto == 0) {  // Verificar si hay un ID seleccionado
    JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
} else {
    int confirmacion = JOptionPane.showConfirmDialog(
        this, 
        "¿Está seguro de eliminar este producto?", 
        "Confirmar eliminación", 
        JOptionPane.YES_NO_OPTION
    );
    
    if (confirmacion == JOptionPane.YES_OPTION) {
        if (ct.eliminar(idProducto)) {  // Si eliminar() devuelve true al tener éxito
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.Limpiar();
            this.CargarTProducto();
            this.FijarColumna();
            idProducto = 0;  // Resetear el ID
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (cboxMarca.getSelectedItem().toString().isEmpty() ||
            cboxAlmacenamiento.getSelectedItem().toString().isEmpty() ||
            txtPrecio.getText().isEmpty() || txtStock.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            pro.setMarca(cboxMarca.getSelectedItem().toString().trim());
            pro.setAlmacenamiento(cboxAlmacenamiento.getSelectedItem().toString().trim());
            pro.setColor(cboxColor.getSelectedItem().toString().trim());
            pro.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
            pro.setStock(Integer.parseInt(txtStock.getText().trim()));
            pro.setDescripcion(txtDescripcion.getText().trim());

            if (ct.actualizar(pro, idProducto)) {
                JOptionPane.showMessageDialog(null, "Datos del celular actualizados");
                this.Limpiar();
                this.CargarTProducto();
                this.FijarColumna();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtIdproducto.setText("");
        this.cboxMarca.setSelectedItem("Seleccione la marca");
        this.cboxAlmacenamiento.setSelectedItem("Seleccione la cantidad de memoria");
        this.cboxColor.setSelectedItem("Seleccione el color");
        txtPrecio.setText("");
        txtStock.setText("");
        txtDescripcion.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cboxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMarcaActionPerformed
        cboxMarca.transferFocus();
    }//GEN-LAST:event_cboxMarcaActionPerformed

    private void cboxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxColorActionPerformed
        cboxColor.transferFocus();
    }//GEN-LAST:event_cboxColorActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        txtPrecio.transferFocus();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        txtStock.transferFocus();
    }//GEN-LAST:event_txtStockActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.Buscar(txtBuscar.getText());
        this.FijarColumna();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void cboxAlmacenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAlmacenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxAlmacenamientoActionPerformed

    private void txtIdproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdproductoActionPerformed

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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboxAlmacenamiento;
    private javax.swing.JComboBox<String> cboxColor;
    private javax.swing.JComboBox<String> cboxMarca;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jtbProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdproducto;
    private javax.swing.JLabel txtMarca;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        txtIdproducto.setText("");
        this.cboxMarca.setSelectedItem("Seleccione la marca");
        this.cboxAlmacenamiento.setSelectedItem("Seleccione la cantidad de memoria");
        this.cboxColor.setSelectedItem("Seleccione el color");
        txtPrecio.setText("");
        txtStock.setText("");
        txtDescripcion.setText("");
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
        model.setRowCount(0);
        model.setColumnCount(0);
        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM producto";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            JDProducto.jtbProducto = new JTable(model);
            JDProducto.jScrollPane3.setViewportView(JDProducto.jtbProducto);

            model.addColumn("ID");
            model.addColumn("Marca");
            model.addColumn("Almacenamiento");
            model.addColumn("Color");
            model.addColumn("Precio");
            model.addColumn("Stock");
            model.addColumn("Descripción");

            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla producto" + e);
        }

        jtbProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jtbProducto.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idProducto = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProductoSelec(idProducto);
                }
            }
        });
    }

    private void EnviarDatosProductoSelec(int idProducto) {
        try {
            Connection cn = Conexion.conectar();
            String sql = "SELECT * FROM producto WHERE idProducto = '" + idProducto + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                txtIdproducto.setText(rs.getString("idProducto"));
                cboxMarca.setSelectedItem(rs.getString("marca"));
                cboxAlmacenamiento.setSelectedItem(rs.getString("almacenamiento"));
                cboxColor.setSelectedItem(rs.getString("color"));
                txtPrecio.setText(rs.getString("precio"));
                txtStock.setText(rs.getString("stock"));
                txtDescripcion.setText(rs.getString("descripcion"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al selecionar producto " + e);
        }
    }
    
    //Tamaño del ancho de las columnas y filarlos
    private void FijarColumna() {
        jtbProducto.getColumnModel().getColumn(0).setPreferredWidth(20);
        jtbProducto.getColumnModel().getColumn(0).setResizable(false);
        jtbProducto.getColumnModel().getColumn(1).setPreferredWidth(30);
        jtbProducto.getColumnModel().getColumn(1).setResizable(false);
        jtbProducto.getColumnModel().getColumn(2).setPreferredWidth(80);
        jtbProducto.getColumnModel().getColumn(2).setResizable(false);
        jtbProducto.getColumnModel().getColumn(3).setPreferredWidth(80);
        jtbProducto.getColumnModel().getColumn(3).setResizable(false);
        jtbProducto.getColumnModel().getColumn(4).setPreferredWidth(20);
        jtbProducto.getColumnModel().getColumn(4).setResizable(false);
        jtbProducto.getColumnModel().getColumn(5).setPreferredWidth(20);
        jtbProducto.getColumnModel().getColumn(5).setResizable(false);
        jtbProducto.getColumnModel().getColumn(6).setPreferredWidth(50);
        jtbProducto.getColumnModel().getColumn(6).setResizable(false);
        
        jtbProducto.setRowHeight(20);
    }
}
