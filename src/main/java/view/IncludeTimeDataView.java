/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import model.WeatherData;
import model.impli.WeatherDataCollection;
import util.DateFormat;

/**
 *
 * @author W-E-R
 */
public class IncludeTimeDataView extends javax.swing.JInternalFrame {

    /**
     * Creates new form TimeDataView
     */
    public IncludeTimeDataView() {
        initComponents();
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
        tfTemperature = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfHumidity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPressure = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btInclude = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        tfDate = new javax.swing.JFormattedTextField();

        setTitle("Dados de tempo");

        jLabel1.setText("Temperatura");

        tfTemperature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTemperatureActionPerformed(evt);
            }
        });

        jLabel2.setText("Humidade");

        tfHumidity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHumidityActionPerformed(evt);
            }
        });

        jLabel3.setText("Press??o");

        jLabel4.setText("Data");

        btInclude.setText("Incluir");
        btInclude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncludeActionPerformed(evt);
            }
        });

        btCancel.setText("Cancelar");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        try {
            tfDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfHumidity, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(tfPressure)
                            .addComponent(tfTemperature)
                            .addComponent(tfDate))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 83, Short.MAX_VALUE)
                        .addComponent(btInclude, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfHumidity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tfPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInclude)
                    .addComponent(btCancel))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("ifTimeData");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfTemperatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTemperatureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTemperatureActionPerformed

    private void tfHumidityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHumidityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHumidityActionPerformed

    private void btIncludeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncludeActionPerformed
      
    }//GEN-LAST:event_btIncludeActionPerformed

    private void tfDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDateActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btInclude;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFormattedTextField tfDate;
    private javax.swing.JTextField tfHumidity;
    private javax.swing.JTextField tfPressure;
    private javax.swing.JTextField tfTemperature;
    // End of variables declaration//GEN-END:variables

    public String getTfDate() {
        return tfDate.getText();
    }
    
    public String getTfHumidity() {
        return tfHumidity.getText();
    }
    
    public String getTfPressure() {
        return tfPressure.getText();
    }
    
    public String getTfTemperature() {
        return tfTemperature.getText();
    }
    
    public void setTxDate(String txDate) {
        this.tfDate.setText(txDate);
    }    
    
    public void setTxHumidity(String txHumidity) {
        this.tfHumidity.setText(txHumidity);
    }
    
    public void setTxPressure(String txPressure) {
        this.tfPressure.setText(txPressure);
    }
    
    public void setTxTemperature(String txTemperature) {
        this.tfTemperature.setText(txTemperature);
    }


    public JButton getBtInclude() {
        return btInclude;
    }

    public JButton getBtCancel() {
        return btCancel;
    }
    
    
    
    
    
}
