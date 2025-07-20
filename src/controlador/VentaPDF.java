package controlador;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.JDVenta;

public class VentaPDF {

    private String nombreCliente;
    private String dniCliente;
    private String celularCliente;
    private String direccionCliente;

    private String fechaActual = "";
    private String nombreArchivoPDF = "";

    public void DatosCliente(int idCliente) {
        try (Connection cn = Conexion.conectar();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM cliente WHERE idCliente = '" + idCliente + "'")) {

            if (rs.next()) {
                nombreCliente = rs.getString("apellido") + " " + rs.getString("nombre");
                dniCliente = rs.getString("dni");
                celularCliente = rs.getString("celular");
                direccionCliente = rs.getString("direccion");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e.getMessage());
        }
    }

    public void generarBoletaPDF() {
        try {
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            String nuevafecha = fechaActual.replace("/", "_");
            nombreArchivoPDF = "Venta_Celulares_" + nombreCliente + "_" + nuevafecha + ".pdf";

            File file = new File("src/pdf/" + nombreArchivoPDF);
            FileOutputStream archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/imagenes/celulares_logo.jpg");

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            fecha.add("Boleta: 001" + "\nFecha: " + fechaActual + "\n\n");

            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);
            encabezado.setWidths(new float[]{20f, 30f, 70f, 40f});
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            encabezado.addCell(img);

            String ruc = "20612529109";
            String nombre = "Novox S.A.C";
            String celular = "987654321";
            String direccion = "Av Arequipa 2064 Of 2B Lince - Lima";
            String razon = "Novox S.A.C";
            String detalle = "¡Tu smartphone ideal te espera con el mejor servicio del Perú!";

            encabezado.addCell("");
            encabezado.addCell("RUC: " + ruc + "\nEmpresa: " + nombre + "\nCelular: " + celular + "\nDirección: " + direccion + "\nRazón Social: " + razon + "\n" + detalle);
            encabezado.addCell(fecha);
            doc.add(encabezado);

            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del cliente:\n\n");
            doc.add(cliente);

            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);
            tablaCliente.setWidths(new float[]{25f, 45f, 30f, 40f});
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);

            PdfPCell[] celdasCliente = {
                new PdfPCell(new Phrase("DNI: ", negrita)),
                new PdfPCell(new Phrase("Nombre: ", negrita)),
                new PdfPCell(new Phrase("Celular: ", negrita)),
                new PdfPCell(new Phrase("Dirección: ", negrita))
            };

            for (PdfPCell celda : celdasCliente) {
                celda.setBorder(0);
                tablaCliente.addCell(celda);
            }

            tablaCliente.addCell(dniCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(celularCliente);
            tablaCliente.addCell(direccionCliente);
            doc.add(tablaCliente);

            doc.add(new Paragraph("\nDatos del pedido:\n\n"));

            PdfPTable tablaProducto = new PdfPTable(7);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            tablaProducto.setWidths(new float[]{15f, 15f, 15f, 15f, 15f, 15f, 20f});
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);

            String[] encabezados = {"Marca", "Modelo", "Almacenamiento", "Color", "Cantidad", "P.Unitario", "Total"};
            for (String encabezadoTexto : encabezados) {
                PdfPCell celda = new PdfPCell(new Phrase(encabezadoTexto, negrita));
                celda.setBorder(0);
                celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tablaProducto.addCell(celda);
            }

            for (int i = 0; i < JDVenta.jtbVenta.getRowCount(); i++) {
                tablaProducto.addCell(JDVenta.jtbVenta.getValueAt(i, 1).toString()); // Marca
                tablaProducto.addCell(JDVenta.jtbVenta.getValueAt(i, 2).toString()); // Modelo
                tablaProducto.addCell(JDVenta.jtbVenta.getValueAt(i, 3).toString()); // Almacenamiento
                tablaProducto.addCell(JDVenta.jtbVenta.getValueAt(i, 4).toString()); // Color
                tablaProducto.addCell(JDVenta.jtbVenta.getValueAt(i, 5).toString()); // Cantidad
                tablaProducto.addCell(JDVenta.jtbVenta.getValueAt(i, 6).toString()); // Precio
                tablaProducto.addCell(JDVenta.jtbVenta.getValueAt(i, 9).toString()); // Total
            }

            doc.add(tablaProducto);

            Paragraph total = new Paragraph();
            total.add(Chunk.NEWLINE);
            total.add("Total a pagar: S/ " + JDVenta.txtTotal.getText());
            total.setAlignment(Element.ALIGN_RIGHT);
            doc.add(total);

            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por tu compra!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error al generar PDF: " + e.getMessage());
        }
    }
}
