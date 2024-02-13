/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import DTOS.CuentaDTO;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import persistencia.IConexionBD;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class JFrameHistorial extends javax.swing.JFrame {

    
    private IConexionBD conexionBD;
    private CuentaDTO cuentaDTO;
    private int pagina;
    private int elementos;
    private boolean paginacion;
    private String tipo;
    
    /**
     * Creates new form JFrameHistorial
     */
    public JFrameHistorial(Frame frame, IConexionBD conexionBD, CuentaDTO cuentaDTO) {
        initComponents();
        this.conexionBD = conexionBD;
        this.cuentaDTO = cuentaDTO;
        tipo = "Transferencia";
        imprimirTbla(cuentaDTO.getNumeroCuenta(), pagina, tipo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorialOperaciones = new javax.swing.JTable();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnTransferencia = new javax.swing.JButton();
        btnRetiro = new javax.swing.JButton();
        btnRetiroSinCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Historial de operaciones");

        tblHistorialOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHistorialOperaciones);

        btnSiguiente.setText("Siguiente ->");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAnterior.setText("<- Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnCancelar.setText("X");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnTransferencia.setText("Transferencia");
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });

        btnRetiro.setText("Retiro");
        btnRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroActionPerformed(evt);
            }
        });

        btnRetiroSinCuenta.setText("Retiro sin cuenta");
        btnRetiroSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAnterior)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(202, 202, 202)
                        .addComponent(btnCancelar)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSiguiente)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTransferencia, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRetiro, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRetiroSinCuenta, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnTransferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRetiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRetiroSinCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAnterior)
                            .addComponent(btnSiguiente))
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param idCuenta
     * @param offset
     * @param tipo
     */
    public void imprimirTbla(int idCuenta, int offset, String tipo){
        
        Logger logger = Logger.getLogger(JFrameSeleccionCuenta.class.getName());
        String sql = """
        CALL tablaOperacionTipo(?, ?, 5, ?);
        """;
        
        
        try (Connection connection = conexionBD.crearConexion();
             PreparedStatement comand = connection.prepareStatement(sql)) {

            comand.setInt(2, idCuenta);
            comand.setString(1, tipo);
            comand.setInt(3, offset);
            
            // Ejecutar la consulta y obtener resultados
            try (ResultSet resultSet = comand.executeQuery()) {
                // Crear un modelo de tabla
                DefaultTableModel model = new DefaultTableModel();

                // Obtener metadatos (nombres de columnas)
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(resultSet.getMetaData().getColumnName(i));
                }
                int contador = 0;
                // Agregar filas al modelo
                while (resultSet.next()) {
                    
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                            
//                        row[i - 1] = resultSet.getObject(i);
                        contador ++;
                        
//                        if(i == 1 && resultSet.getObject(i) == null){
//                            
//                            paginacion = false;
//                            
//                            
//                        }else if (i == 2 && resultSet.getObject(i) == null){
//                            
//                            paginacion = false;
//                            
//                        }else if (i == 3 && resultSet.getObject(i) == null){
//                            
//                            paginacion = false;
//                            
//                        }else if (i == 4 && resultSet.getObject(i) == null){
//                            
//                            paginacion = false;
//                            
//                        }else if (i == 5 && resultSet.getObject(i) == null){
//                            
//                            paginacion = false;
//                            
//                        }

                        if(i == 4){
                            
                            // Supongamos que estás obteniendo el valor datetime de tu ResultSet
                            // rs es tu ResultSet y 1 es el índice de la columna que contiene la fecha
                            java.sql.Timestamp timestamp = resultSet.getTimestamp(i);

                            // Convierte el timestamp a una cadena formateada usando SimpleDateFormat
                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm");
                            String fechaFormateada = sdf.format(timestamp);

                            // Ahora puedes usar fechaFormateada en tu tabla
                            row[i -1] = fechaFormateada;

                            
                        }else{
                            
                            row[i - 1] = resultSet.getObject(i);
                            
                        }
                    }
                    model.addRow(row);
                }
                elementos = contador;
                if(elementos == 25){
                    
                    paginacion = true;
                    btnSiguiente.setEnabled(true);
                    
                }else {
                    
                    paginacion = false;
                    btnSiguiente.setEnabled(false);
                    
                }
                // Establecer el modelo en el JTable
                tblHistorialOperaciones.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    
    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        if(pagina == 0){
            
            btnAnterior.setEnabled(false);
            
        }else{
            pagina = pagina - 5;
            imprimirTbla(cuentaDTO.getNumeroCuenta(), pagina, tipo);
            
            System.out.println(pagina);
            System.out.println(elementos);
            
        }
        
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        
        JFrameCliente cliente = new JFrameCliente(cuentaDTO);
        cliente.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        
        if(!paginacion){
            
            btnSiguiente.setEnabled(false);
            
        }else{
            pagina = pagina + 5;
            imprimirTbla(cuentaDTO.getNumeroCuenta(), pagina, tipo);
            btnAnterior.setEnabled(true);
            System.out.println(pagina);
            System.out.println(elementos);
            
        }
        
        
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        // TODO add your handling code here:
        tipo = "Transferencia";
        btnTransferencia.setEnabled(false);
        btnRetiro.setEnabled(true);
        btnRetiroSinCuenta.setEnabled(true);
        imprimirTbla(cuentaDTO.getNumeroCuenta(), pagina, tipo);
        
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void btnRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroActionPerformed
        // TODO add your handling code here:
        
        tipo = "Retiro";
        btnTransferencia.setEnabled(true);
        btnRetiro.setEnabled(false);
        btnRetiroSinCuenta.setEnabled(true);
        imprimirTbla(cuentaDTO.getNumeroCuenta(), pagina, tipo);
        
    }//GEN-LAST:event_btnRetiroActionPerformed

    private void btnRetiroSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuentaActionPerformed
        // TODO add your handling code here:
        
        tipo = "Retiro sin cuenta";
        btnTransferencia.setEnabled(true);
        btnRetiro.setEnabled(true);
        btnRetiroSinCuenta.setEnabled(false);
        imprimirTbla(cuentaDTO.getNumeroCuenta(), pagina, tipo);
        
    }//GEN-LAST:event_btnRetiroSinCuentaActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JFrameHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrameHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrameHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrameHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFrameHistorial().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRetiro;
    private javax.swing.JButton btnRetiroSinCuenta;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistorialOperaciones;
    // End of variables declaration//GEN-END:variables
}
