/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor_pokemon;

import es.discoduroderoer.ficheros.Texto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class AnidirFormaAprendizaje extends javax.swing.JDialog {

    private String datos[];

    public AnidirFormaAprendizaje(JDialog parent, boolean modal, String[] datos) {
        super(parent, modal);
        initComponents();
        this.datos = datos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtValor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtValor)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String errores = "";

        if (this.txtValor.getText().isEmpty()) {
            errores += " - Insertar un valor";
        }

        if (errores.equals("")) {

            try {
                String valor = this.txtValor.getText();

                int proximoID = VariablesGlobales.conexion.proximoIDDisponible("id_forma_aprendizaje", "forma_aprendizaje");

                
                String sql = "insert into forma_aprendizaje values(" + proximoID + "," + datos[2] + ")";
                System.out.println(sql);
                Texto.escribirFicheroCaracteresBuf("forma_aprendizaje.txt", sql + "\r\n", true);
                VariablesGlobales.conexion.ejecutarInstruccion(sql);
                
                sql = "insert into " + datos[0] + "(id_forma_aprendizaje, " + datos[1] + ") values(" + proximoID + "," + valor + ")";
                System.out.println(sql);
                Texto.escribirFicheroCaracteresBuf("tipo_aprendizaje.txt", sql + "\r\n", true);
                VariablesGlobales.conexion.ejecutarInstruccion(sql);

                

                this.dispose();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, errores, "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
