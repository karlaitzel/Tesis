/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karla.msicu.emociones.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Developer
 */
public class NuevoTema extends javax.swing.JFrame {
    Tema parentView = null;
    /**
     * Creates new form NuevoCurso
     */
    public NuevoTema(Tema parentView) {
        initComponents();
        this.parentView = parentView;
                fillCombos();
    }
    
    private void saveCurso() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emociones?serverTimezone=UTC", "emociones", "emociones");
        String nombre = CampoNombre.getText();
        String curso_idcurso = CampoCurso.getValue();
        if(!nombre.equals("")){
            String query = "insert into tema (nombre,curso_idcurso) values (?,?)";
            PreparedStatement preparedStatemet = connection.prepareStatement(query);
            preparedStatemet.setString (1, nombre);
            preparedStatemet.setString (2, curso_idcurso);            
            preparedStatemet.execute();
            parentView.fillTable();
            connection.close();
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GuardarNombre = new javax.swing.JButton();
        EtiquetaNombre = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        EtiquetaCurso = new javax.swing.JLabel();
        CampoCurso = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Tema");

        GuardarNombre.setText("Guardar");
        GuardarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarNombreActionPerformed(evt);
            }
        });

        EtiquetaNombre.setText("Nombre del tema");

        CampoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNombreActionPerformed(evt);
            }
        });

        EtiquetaCurso.setText("Curso al que pertenece");

        CampoCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Curso 1", "Item 3", "Item 4" }));
        CampoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoNombre)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EtiquetaNombre)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(GuardarNombre))
                            .addComponent(EtiquetaCurso))
                        .addGap(0, 156, Short.MAX_VALUE))
                    .addComponent(CampoCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EtiquetaNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(EtiquetaCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CampoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(GuardarNombre)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarNombreActionPerformed
        try {
            saveCurso();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NuevoTema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GuardarNombreActionPerformed

    private void CampoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNombreActionPerformed

    private void CampoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCursoActionPerformed
        CampoCurso JComboBox<String> JcomboBox = new JComboBox<>(new String[] {"One", "Two", "Three", "Four"});
        JcomboBox.setEditable(true);
        getContentPane().add(JcomboBox);// TODO add your handling code here:
    }//GEN-LAST:event_CampoCursoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CampoCurso;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JLabel EtiquetaCurso;
    private javax.swing.JLabel EtiquetaNombre;
    private javax.swing.JButton GuardarNombre;
    // End of variables declaration//GEN-END:variables
}
