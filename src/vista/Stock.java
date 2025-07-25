package vista;

import controlador.Ctrl_Producto;
import controlador.Ctrl_Stock;
import datos.ProductoConStock;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class Stock extends javax.swing.JDialog {

    Ctrl_Stock ctrlStock = new Ctrl_Stock();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    int idProductoSeleccionado = -1;

    public Stock(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

        cargarTablaProductos();

        jtbStock.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = jtbStock.rowAtPoint(evt.getPoint());
                if (fila > -1) {
                    idProductoSeleccionado = Integer.parseInt(jtbStock.getValueAt(fila, 0).toString());

                    txtIdProducto.setText(jtbStock.getValueAt(fila, 0).toString());
                    txtModelo.setText(jtbStock.getValueAt(fila, 1).toString());
                    txtMarca.setText(jtbStock.getValueAt(fila, 2).toString());
                    txtAlmacenamiento.setText(jtbStock.getValueAt(fila, 3).toString());
                    txtColor.setText(jtbStock.getValueAt(fila, 4).toString());
                    txtPrecio.setText(jtbStock.getValueAt(fila, 5).toString());
                    txtStockActual.setText(jtbStock.getValueAt(fila, 6).toString());
                }
            }
        });
    }
      
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbStock = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        txtAlmacenamiento = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtIdProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtStockActual = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAgregarStock = new javax.swing.JTextField();
        btnActualizarStock = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar stock");
        setPreferredSize(new java.awt.Dimension(560, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Marca", "Almacenamiento", "Color", "Precio", "Stock"
            }
        ));
        jScrollPane2.setViewportView(jtbStock);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 520, 162));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setText("ID Producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Marca");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel9.setText("Almacenamiento");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setText("Color");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, 21));

        txtColor.setEditable(false);
        txtColor.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel1.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        txtAlmacenamiento.setEditable(false);
        txtAlmacenamiento.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel1.add(txtAlmacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        txtMarca.setEditable(false);
        txtMarca.setPreferredSize(new java.awt.Dimension(140, 25));
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        txtIdProducto.setEditable(false);
        txtIdProducto.setPreferredSize(new java.awt.Dimension(140, 25));
        txtIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProductoActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setText("Precio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        txtPrecio.setEditable(false);
        txtPrecio.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        txtStockActual.setEditable(false);
        txtStockActual.setPreferredSize(new java.awt.Dimension(140, 25));
        txtStockActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActualActionPerformed(evt);
            }
        });
        jPanel1.add(txtStockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 60, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setText("Stock Actual");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setText("Modelo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtModelo.setEditable(false);
        txtModelo.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel7.setText("Agregar Stock");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        txtAgregarStock.setPreferredSize(new java.awt.Dimension(140, 25));
        txtAgregarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarStockActionPerformed(evt);
            }
        });
        jPanel1.add(txtAgregarStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 60, -1));

        btnActualizarStock.setText("Actualizar Stock");
        btnActualizarStock.setPreferredSize(new java.awt.Dimension(90, 25));
        btnActualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarStockActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 120, 30));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 120, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("STOCK");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void cargarTablaProductos() {
    modeloTabla = new DefaultTableModel();
    jtbStock.setModel(modeloTabla);

    modeloTabla.addColumn("ID");
    modeloTabla.addColumn("Modelo");
    modeloTabla.addColumn("Marca");
    modeloTabla.addColumn("Almacenamiento");
    modeloTabla.addColumn("Color");
    modeloTabla.addColumn("Precio");
    modeloTabla.addColumn("Stock");

    Ctrl_Producto ctrlProducto = new Ctrl_Producto();
    List<ProductoConStock> lista = ctrlProducto.obtenerVistaStock(); // usa el DTO

    for (ProductoConStock p : lista) {
        modeloTabla.addRow(new Object[]{
            p.getIdProducto(),
            p.getModelo(),
            p.getMarca(),
            p.getAlmacenamiento(),
            p.getColor(),
            p.getPrecio(),
            p.getStock()
        });
    }
}

        
    
    private void txtIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProductoActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtStockActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActualActionPerformed

    private void txtAgregarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarStockActionPerformed
        if (txtAgregarStock.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "El campo 'Agregar Stock' no puede estar vacío.");
    return;
    }

    }//GEN-LAST:event_txtAgregarStockActionPerformed

    private void btnActualizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarStockActionPerformed
        if (idProductoSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un producto de la tabla.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(txtAgregarStock.getText());
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "Ingresa una cantidad válida.");
                return;
            }

            // Confirmar antes de ejecutar
            int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Deseas agregar " + cantidad + " unidades al stock?",
                "Confirmar actualización",
                JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                boolean actualizado = ctrlStock.agregarStock(idProductoSeleccionado, cantidad);
                if (actualizado) {
                    JOptionPane.showMessageDialog(this, "Stock actualizado correctamente.");
                    cargarTablaProductos();
                    limpiarCampos();
                } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el stock.");
            }
        }
                else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el stock.");
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "¿Deseas agregar " + cantidad + " unidades al stock?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) return;

            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad no válida.");
        }
    }//GEN-LAST:event_btnActualizarStockActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed
      
    private void limpiarCampos() {
        txtIdProducto.setText("");
        txtModelo.setText("");
        txtMarca.setText("");
        txtAlmacenamiento.setText("");
        txtColor.setText("");
        txtPrecio.setText("");
        txtStockActual.setText("");
        txtAgregarStock.setText("");
        idProductoSeleccionado = -1;
    }
    
    public static void main(String args[]) {
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarStock;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbStock;
    private javax.swing.JTextField txtAgregarStock;
    private javax.swing.JTextField txtAlmacenamiento;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStockActual;
    // End of variables declaration//GEN-END:variables
}
