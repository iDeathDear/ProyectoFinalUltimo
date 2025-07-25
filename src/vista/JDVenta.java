package vista;

import java.sql.*;
import java.util.Date;
import conexion.Conexion;
import controlador.Ctrl_RegistrarVenta;
import controlador.Ctrl_Producto;
import datos.Producto;

import datos.DetalleVenta;
import datos.Venta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dao.VentaDAO;    

public class JDVenta extends javax.swing.JDialog {

    private DefaultTableModel model;
    //Lista para el detalle de venta de los productos
    ArrayList<DetalleVenta> listaProducto = new ArrayList<>();
    private DetalleVenta producto;

    private DefaultTableModel modeloTablaVenta;

    private int idProducto = 0;
    private String nombre = "";
    private String variante = "";
    private String iphone = "";
    private int cantidadBBDD = 0;
    private double preUnitario = 0.0;
    private int contador = 1;

    private int cantidad = 0; //Cantidad de productos a comprar
    private double subtotal = 0.0; //Cantidad por precio
    private double descuento = 0.0;
    private double igv = 0.0;
    private double totalPagar = 0.0;

    //Variables para calculos generales
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double igvGeneral = 0.0;
    private double totalPagarGeneral = 0.0;

    //ID de Detalle venta
    private int auxIdDetalle = 1;

    

    private void TablaProducto() {
    model = new DefaultTableModel();
    // Añadir columnas adaptadas a celulares
    model.addColumn("N");
    model.addColumn("Marca");
    model.addColumn("Almacenamiento");
    model.addColumn("Color");
    model.addColumn("Cantidad");
    model.addColumn("Precio");
    model.addColumn("SubT");
    model.addColumn("Desc");
    model.addColumn("IGV");
    model.addColumn("Total");
    
    // Establecer el modelo en la tabla
    tblCarritoVenta.setModel(model);

}
public JDVenta(java.awt.Frame parent, boolean modal) {
    super(parent, modal); // Llama al constructor de JDialog
    initComponents(); 
    modeloTablaVenta = (DefaultTableModel) tblCarritoVenta.getModel();

// Inicializa los componentes
    // Evento que se activa cuando se cambia el modelo seleccionado
cboxModelo.addItemListener(new java.awt.event.ItemListener() {
    public void itemStateChanged(java.awt.event.ItemEvent e) {
        if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String modeloSeleccionado = cboxModelo.getSelectedItem().toString();
            cargarDatosProductoPorModelo(modeloSeleccionado);
        }
    }
});

    setLocationRelativeTo(parent); // Centra el diálogo respecto a la ventana padre
    TablaProducto();
    cargarModelos();
    CargarComboProductos();// Llena cboxModelo con los productos de la base
    
    cboxModelo.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        String modeloSeleccionado = cboxModelo.getSelectedItem().toString();

        if (!modeloSeleccionado.equals("Seleccione modelo:")) {
            try {
                Connection cn = Conexion.conectar();
                String sql = "SELECT * FROM producto WHERE modelo = ?";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, modeloSeleccionado);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    cboxMarca.setSelectedItem(rs.getString("marca"));
                    cboxAlmacenamiento.setSelectedItem(rs.getString("almacenamiento"));
                    cboxColor.setSelectedItem(rs.getString("color"));
                    txtPrecio.setText(String.valueOf(rs.getDouble("precio")));
                }

                cn.close();
            } catch (Exception e) {
                System.out.println("Error al cargar datos del modelo: " + e);
            }
        }
    }
}
    
    
    );

    
}
    private void cargarDatosProductoPorModelo(String modelo) {
    try {
        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM producto WHERE modelo = ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, modelo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            idProducto = rs.getInt("idProducto"); // asegúrate que esta variable esté declarada en tu clase
            cboxMarca.setSelectedItem(rs.getString("marca"));
            cboxAlmacenamiento.setSelectedItem(rs.getString("almacenamiento"));
            cboxColor.setSelectedItem(rs.getString("color"));
            txtPrecio.setText(String.valueOf(rs.getDouble("precio")));

            cantidadBBDD = rs.getInt("stock"); // para validar stock
            preUnitario = rs.getDouble("precio"); // para calcular total
        }

        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al cargar datos del producto: " + e);
    }
}

    private void cargarModelos() {
    try {
        Connection cn = Conexion.conectar();
        String sql = "SELECT DISTINCT modelo FROM producto";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        cboxModelo.removeAllItems();

        while (rs.next()) {
            cboxModelo.addItem(rs.getString("modelo"));
        }
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al cargar modelos: " + e);
    }
}


    //Metodo para presentar la info de la tabla detalle venta
    private void listaTablaProducto() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Modelo");
    model.addColumn("Marca");
    model.addColumn("Almacenamiento");
    model.addColumn("Color");
    model.addColumn("Cantidad");
    model.addColumn("Precio");
    model.addColumn("Subtotal");
    model.addColumn("IGV");
    model.addColumn("Total");

    for (DetalleVenta d : listaProducto) {
        try (Connection cn = Conexion.conectar()) {
            String sql = "SELECT modelo, marca, almacenamiento, color FROM producto WHERE idProducto = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, d.getIdProducto());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                String almacenamiento = rs.getString("almacenamiento");
                String color = rs.getString("color");

                model.addRow(new Object[]{
                    d.getIdProducto(),
                    modelo,
                    marca,
                    almacenamiento,
                    color,
                    d.getCantidad(),
                    d.getPreUnitario(),
                    d.getSubTotal(),
                    d.getIgv(),
                    d.getTotalpagar()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar tabla carrito: " + e.getMessage());
        }
    }

    tblCarritoVenta.setModel(model); // ✅ correcto

}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnBoleta = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboxMarca = new javax.swing.JComboBox<>();
        cboxAlmacenamiento = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboxColor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnAñadirProducto = new javax.swing.JButton();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarritoVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cboxModelo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar venta");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("VENTAS");

        btnBoleta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBoleta.setText("Procesar");
        btnBoleta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBoleta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoletaActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Datos del producto");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Marca:");

        cboxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la marca:", "Samsung", "Apple", "Xiaomi", "Motorola", "Huawei", "Oppo", "Honor", "Realme" }));
        cboxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMarcaActionPerformed(evt);
            }
        });

        cboxAlmacenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione variante:", "64gb", "128gb" }));
        cboxAlmacenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAlmacenamientoActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("Almacenamiento:");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Color:");

        cboxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el color:", "negro", "amarillo", "blanco", "esmeralda", "azul" }));
        cboxColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxColorActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Precio:");

        btnAñadirProducto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnAñadirProducto.setText("Añadir");
        btnAñadirProducto.setPreferredSize(new java.awt.Dimension(72, 23));
        btnAñadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirProductoActionPerformed(evt);
            }
        });

        txtTotalPagar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTotalPagar.setEnabled(false);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Total a pagar:");

        tblCarritoVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCarritoVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarritoVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCarritoVenta);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Modelo");

        cboxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxModeloActionPerformed(evt);
            }
        });

        jLabel3.setText("Cantidad");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 270, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCantidad)
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
                                .addGap(8, 8, 8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBoleta)
                                .addGap(11, 11, 11)
                                .addComponent(btnAñadirProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))))
                    .addComponent(cboxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxColor, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(cboxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(2, 2, 2)
                        .addComponent(cboxColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAñadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBoleta)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, 660, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnAñadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirProductoActionPerformed
       DatosProducto(); // Ya consulta idProducto, stock (cantidadBBDD), precioUnitario

    int cantidad = 0;

    if (idProducto == 0) {
        JOptionPane.showMessageDialog(null, "Primero seleccione un producto válido.");
        return;
    }

    if (txtCantidad.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese la cantidad.");
        return;
    }

    try {
        cantidad = Integer.parseInt(txtCantidad.getText().trim());
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero.");
            return;
        }

        if (cantidad > cantidadBBDD) {
            JOptionPane.showMessageDialog(null, "Cantidad supera el stock disponible.");
            return;
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Cantidad inválida.");
        return;
    }

    double total = preUnitario * cantidad;

// Agregar a la tabla carrito
modeloTablaVenta.addRow(new Object[]{
    contador++,
    cboxMarca.getSelectedItem().toString(),
    cboxModelo.getSelectedItem().toString(),
    cboxAlmacenamiento.getSelectedItem().toString(),
    cboxColor.getSelectedItem().toString(),
    cantidad,
    preUnitario,
    total
});


    // Actualizar total general
    totalPagarGeneral += total;
    txtTotalPagar.setText(String.format("%.2f", totalPagarGeneral));

    // Agregar a lista para insertar en BD
    DetalleVenta detalle = new DetalleVenta();
    detalle.setIdProducto(idProducto);
    detalle.setCantidad(cantidad);
    detalle.setPrecioUnitario(preUnitario);
    detalle.setTotalPagar(total);

    listaProducto.add(detalle);

    limpiarCampos();
    }//GEN-LAST:event_btnAñadirProductoActionPerformed

    private void cboxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxColorActionPerformed

    private void cboxAlmacenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAlmacenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxAlmacenamientoActionPerformed

    private void cboxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxMarcaActionPerformed

    private void btnBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoletaActionPerformed
        if (listaProducto.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Agregue al menos un producto antes de procesar la venta.");
        return;
    }

    // Crear venta
    Venta venta = new Venta();
    Ctrl_RegistrarVenta ctrl = new Ctrl_RegistrarVenta();

    String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    venta.setFechaVenta(fechaActual);
    venta.setValorPagar(totalPagarGeneral);

    int idVentaGenerada = ctrl.guardarYObtenerId(venta); // <-- Método que debes tener en Ctrl_RegistrarVenta

    if (idVentaGenerada == 0) {
        JOptionPane.showMessageDialog(null, "No se pudo registrar la venta.");
        return;
    }

    boolean detallesOK = true;

    for (DetalleVenta item : listaProducto) {
        item.setIdVenta(idVentaGenerada);

        if (!ctrl.guardarDetalle(item)) {
            detallesOK = false;
            break;
        }

        RestarStockProductos(item.getIdProducto(), item.getCantidad());
    }

    if (detallesOK) {
        JOptionPane.showMessageDialog(null, "Venta registrada correctamente.");
        listaProducto.clear();
        listaTablaProducto();
        limpiarCampos();
        txtTotalPagar.setText("0.0");
        totalPagarGeneral = 0.0;
    } else {
        JOptionPane.showMessageDialog(null, "Error al registrar los detalles de la venta.");
    }
    }//GEN-LAST:event_btnBoletaActionPerformed

    

    
    private void tblCarritoVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarritoVentaMouseClicked
        int fila = tblCarritoVenta.rowAtPoint(evt.getPoint());
        int columna = 0;

        if (fila > -1) {
            idArrayList = (int) model.getValueAt(fila, columna);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el producto?");
        //Opciones: si = 0 y no = 1; cancelar=2; close = -1
        switch (opcion) {
            case 0:
            listaProducto.remove(idArrayList - 1);
            this.CalcularTotalPagar();
            this.listaTablaProducto();
            break;
            case 1: //No desea eliminar
            break;
            default: //Si preciona cancel (2) o close (-1)
            break;
        }
    }//GEN-LAST:event_tblCarritoVentaMouseClicked

    private void cboxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxModeloActionPerformed

    int idArrayList = 0;
    public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(JDVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(() -> {
        JDVenta ventana = new JDVenta(new javax.swing.JFrame(), true); // constructor correcto
        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0); // Cierra la aplicación completa al cerrar la ventana
            }
        });
        ventana.setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirProducto;
    private javax.swing.JButton btnBoleta;
    private javax.swing.JComboBox<String> cboxAlmacenamiento;
    private javax.swing.JComboBox<String> cboxColor;
    private javax.swing.JComboBox<String> cboxMarca;
    private javax.swing.JComboBox<String> cboxModelo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCarritoVenta;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables

    

    //Metodo para cargar los productos en jComboBox
    private void CargarComboProductos() {
    Connection cn = Conexion.conectar();
    String sql = "SELECT modelo FROM producto";
    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        cboxModelo.removeAllItems();
        cboxModelo.addItem("Seleccione modelo:");

        while (rs.next()) {
            cboxModelo.addItem(rs.getString("modelo"));
        }

        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al cargar modelos: " + e.getMessage());
    }
}


    //Metodo para validar que no se ingresen caracteres no numericos
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Metodo para mostrar los datos del producto
    private void DatosProducto() {
    String modelo = cboxModelo.getSelectedItem().toString();
    String marca = cboxMarca.getSelectedItem().toString();
    String almacenamiento = cboxAlmacenamiento.getSelectedItem().toString();
    String color = cboxColor.getSelectedItem().toString();

    Ctrl_Producto ctrlProducto = new Ctrl_Producto();
    Producto producto = ctrlProducto.obtenerProductoPorDetalle(modelo, marca, almacenamiento, color);

    if (producto != null) {
        idProducto = producto.getIdProducto();
        cantidadBBDD = ctrlProducto.obtenerStockActual(idProducto); // desde tabla stock
        preUnitario = producto.getPrecio();
        this.CalcularIgv(preUnitario);
    } else {
        cantidadBBDD = 0;
        JOptionPane.showMessageDialog(null, "Producto no encontrado con esa combinación.");
    }
}




    private double CalcularIgv(double precio) {
        igv = (precio * cantidad) * 0.18;
        return igv;
    }
    
        private void limpiarCampos() {
        txtCantidad.setText("");
        txtPrecio.setText("");
        cboxModelo.setSelectedIndex(0);
        cboxMarca.setSelectedIndex(0);
        cboxAlmacenamiento.setSelectedIndex(0);
        cboxColor.setSelectedIndex(0);
    }

    
    //Metodo para calcular el Total a pagar de todos los productos agregados a la Tabla
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        igvGeneral = 0;
        totalPagarGeneral = 0;

        for (DetalleVenta elemento : listaProducto) {
            subtotalGeneral += elemento.getSubTotal();
            descuentoGeneral += elemento.getDescuento();
            igvGeneral += elemento.getIgv();
            totalPagarGeneral += elemento.getTotalpagar();
        }
        //Redondear decimales
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        igvGeneral = (double) Math.round(igvGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

       }

   

    

    //Tamaño del ancho de las columnas y filarlos
    private void FijarColumna() {

        tblCarritoVenta.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblCarritoVenta.getColumnModel().getColumn(0).setResizable(false);
        tblCarritoVenta.getColumnModel().getColumn(1).setPreferredWidth(25);
        tblCarritoVenta.getColumnModel().getColumn(1).setResizable(false);
        tblCarritoVenta.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblCarritoVenta.getColumnModel().getColumn(2).setResizable(false);
        tblCarritoVenta.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblCarritoVenta.getColumnModel().getColumn(3).setResizable(false);
        tblCarritoVenta.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblCarritoVenta.getColumnModel().getColumn(4).setResizable(false);
        tblCarritoVenta.getColumnModel().getColumn(5).setPreferredWidth(20);
        tblCarritoVenta.getColumnModel().getColumn(5).setResizable(false);
        tblCarritoVenta.getColumnModel().getColumn(6).setPreferredWidth(10);
        tblCarritoVenta.getColumnModel().getColumn(6).setResizable(false);
        tblCarritoVenta.getColumnModel().getColumn(7).setPreferredWidth(10);
        tblCarritoVenta.getColumnModel().getColumn(7).setResizable(false);
        tblCarritoVenta.getColumnModel().getColumn(8).setPreferredWidth(10);
        tblCarritoVenta.getColumnModel().getColumn(8).setResizable(false);
        tblCarritoVenta.getColumnModel().getColumn(9).setPreferredWidth(20);
        tblCarritoVenta.getColumnModel().getColumn(9).setResizable(false);

        tblCarritoVenta.setRowHeight(20);
    }
    
    //Metodo para restar la cantidad o stock de los productos
    private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductoBD = 0;
        try {
            Connection cn = Conexion.conectar();
            String sql = "SELECT idProducto, stock FROM producto WHERE idProducto = '" + idProducto + "' ";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                cantidadProductoBD = rs.getInt("stock");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar stock 1" + e);
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("UPDATE producto SET stock=? WHERE idProducto = '" + idProducto + "' ");
            int nuevoStock = cantidadProductoBD - cantidad;
            ps.setInt(1, nuevoStock);
            if (ps.executeUpdate() > 0) {
                System.out.println("Actualizado");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar stock 2" + e);
        }
    }
    
}
