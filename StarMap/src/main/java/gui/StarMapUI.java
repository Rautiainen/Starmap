/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.joml.vector.Vector3f;
import starmap.Star;
import starmap.StarCube;
import starmap.StarFrame;
import starmap.Starset;

/**
 *
 * @author air
 */
public class StarMapUI extends javax.swing.JFrame {
    
    private static Starset starSelection;
    //StarFrame starFrame;
    /**
     * Creates new form StarMapUI
     */
    public StarMapUI() {
        initComponents();
        updateTextFields();
    }
    
    private void updateTextFields() {
        jTextFieldCenterX.setText(String.format("%.3f",starSelection.getStarcube().getCenter().x));
        jTextFieldCenterY.setText(String.format("%.3f",starSelection.getStarcube().getCenter().y));
        jTextFieldCenterZ.setText(String.format("%.3f",starSelection.getStarcube().getCenter().z));
        Vector3f rthetaphi = new Vector3f();
        rthetaphi = starSelection.getStarcube().getCenterSpherical();
        rthetaphi.SIUnitstoAstronomical();
        jTextFieldCenterDistance.setText(String.format("%.3f", rthetaphi.x));
        jTextFieldCenterDec.setText(String.format("%.3f", rthetaphi.y));
        jTextFieldCenterRAsc.setText(String.format("%.3f", rthetaphi.z));
        jTextFieldObservationSpotX.setText(String.format("%.3f",starSelection.getStarcube().getObservationSpot().x));
        jTextFieldObservationSpotY.setText(String.format("%.3f",starSelection.getStarcube().getObservationSpot().y));
        jTextFieldObservationSpotZ.setText(String.format("%.3f",starSelection.getStarcube().getObservationSpot().z));
        rthetaphi = starSelection.getStarcube().getObservationSpotSpherical();
        rthetaphi.SIUnitstoAstronomical();
        jTextFieldObservationSpotDistance.setText(String.format("%.3f", rthetaphi.x));
        jTextFieldObservationSpotDec.setText(String.format("%.3f", rthetaphi.y));
        jTextFieldObservationSpotRAsc.setText(String.format("%.3f", rthetaphi.z));
        jTextFieldEdgeLength.setText(String.format("%.3f", starSelection.getStarcube().getEdgeLength()));
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
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCenterX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCenterY = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCenterZ = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCenterDistance = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCenterRAsc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCenterDec = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldObservationSpotX = new javax.swing.JTextField();
        jTextFieldObservationSpotY = new javax.swing.JTextField();
        jTextFieldObservationSpotZ = new javax.swing.JTextField();
        jTextFieldObservationSpotDistance = new javax.swing.JTextField();
        jTextFieldObservationSpotRAsc = new javax.swing.JTextField();
        jTextFieldObservationSpotDec = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldEdgeLength = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonShow = new javax.swing.JButton();
        jCheckBoxRotate = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Center of the cube");

        jLabel2.setText("x:");

        jTextFieldCenterX.setText("jTextField1");
        jTextFieldCenterX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCenterXActionPerformed(evt);
            }
        });

        jLabel3.setText("y;");

        jTextFieldCenterY.setText("jTextField2");
        jTextFieldCenterY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCenterYActionPerformed(evt);
            }
        });

        jLabel4.setText("z:");

        jTextFieldCenterZ.setText("jTextField3");
        jTextFieldCenterZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCenterZActionPerformed(evt);
            }
        });

        jLabel5.setText("distance:");

        jTextFieldCenterDistance.setText("jTextField4");
        jTextFieldCenterDistance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCenterDistanceActionPerformed(evt);
            }
        });

        jLabel6.setText("right ascension:");

        jTextFieldCenterRAsc.setText("jTextField5");
        jTextFieldCenterRAsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCenterRAscActionPerformed(evt);
            }
        });

        jLabel7.setText("declination:");

        jTextFieldCenterDec.setText("jTextField6");
        jTextFieldCenterDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCenterDecActionPerformed(evt);
            }
        });

        jLabel8.setText("x:");

        jLabel9.setText("y;");

        jLabel10.setText("z:");

        jLabel11.setText("distance:");

        jLabel12.setText("right ascension:");

        jLabel13.setText("declination:");

        jTextFieldObservationSpotX.setText("jTextField7");

        jTextFieldObservationSpotY.setText("jTextField8");

        jTextFieldObservationSpotZ.setText("jTextField9");

        jTextFieldObservationSpotDistance.setText("jTextField10");

        jTextFieldObservationSpotRAsc.setText("jTextField11");

        jTextFieldObservationSpotDec.setText("jTextField12");

        jLabel14.setText("Observation spot");

        jLabel15.setText("Edge length");

        jTextFieldEdgeLength.setText("jTextField13");

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("-");

        jButtonShow.setText("Show");
        jButtonShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowActionPerformed(evt);
            }
        });

        jCheckBoxRotate.setText("Rotate");
        jCheckBoxRotate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxRotateStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(6, 6, 6)
                                .addComponent(jTextFieldEdgeLength, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldCenterZ, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldObservationSpotZ, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabel5))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldObservationSpotX, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldCenterX, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jTextFieldObservationSpotY, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCenterY, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldObservationSpotDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jTextFieldCenterDistance, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldObservationSpotDec, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCenterDec, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldObservationSpotRAsc, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCenterRAsc, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBoxRotate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(jButtonShow, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCenterX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCenterY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCenterZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCenterDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldCenterDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCenterRAsc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldObservationSpotX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldObservationSpotZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldObservationSpotDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldObservationSpotDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldObservationSpotRAsc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldObservationSpotY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButtonShow)
                    .addComponent(jTextFieldEdgeLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxRotate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCenterXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCenterXActionPerformed
        Vector3f center = new Vector3f();
        center = starSelection.getStarcube().getCenter();
        center = new Vector3f(Float.parseFloat(jTextFieldCenterX.getText()),center.y, center.z);
        starSelection.getStarcube().setCenter(center);
        updateTextFields();
    }//GEN-LAST:event_jTextFieldCenterXActionPerformed

    private void jTextFieldCenterRAscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCenterRAscActionPerformed
        Vector3f centerSpherical = new Vector3f();
        centerSpherical = starSelection.getStarcube().getCenterSpherical();
        centerSpherical.SIUnitstoAstronomical();
        centerSpherical.z = Float.parseFloat(jTextFieldCenterRAsc.getText());
        centerSpherical.astronomicalUnitstoSI();
        starSelection.getStarcube().setCenterSpherical(centerSpherical.x,centerSpherical.y,centerSpherical.z);
        updateTextFields();
    }//GEN-LAST:event_jTextFieldCenterRAscActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowActionPerformed
        //comment for debugging
        starSelection.load(starSelection.getStarcube());
        new StarFrame().execute(starSelection.getgLoopObject());
        System.out.println("Proper names:");
        starSelection.printProperNames(); //for debugging
        // starSelection.print(); //for debugging
    }//GEN-LAST:event_jButtonShowActionPerformed

    private void jTextFieldCenterYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCenterYActionPerformed
        Vector3f center = new Vector3f();
        center = starSelection.getStarcube().getCenter();
        center = new Vector3f(center.x, Float.parseFloat(jTextFieldCenterY.getText()), center.z);
        starSelection.getStarcube().setCenter(center);
        updateTextFields();
    }//GEN-LAST:event_jTextFieldCenterYActionPerformed

    private void jTextFieldCenterZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCenterZActionPerformed
        Vector3f center = new Vector3f();
        center = starSelection.getStarcube().getCenter();
        center = new Vector3f(center.x, center.y, Float.parseFloat(jTextFieldCenterZ.getText()));
        starSelection.getStarcube().setCenter(center);
        updateTextFields();
    }//GEN-LAST:event_jTextFieldCenterZActionPerformed

    private void jTextFieldCenterDistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCenterDistanceActionPerformed
        Vector3f centerSpherical = new Vector3f();
        centerSpherical = starSelection.getStarcube().getCenterSpherical();
        //Distance unit is parsec, astronomical unit. 
        starSelection.getStarcube().setCenterSpherical(Float.parseFloat(jTextFieldCenterDistance.getText()),centerSpherical.y, centerSpherical.z);
        updateTextFields();
    }//GEN-LAST:event_jTextFieldCenterDistanceActionPerformed

    private void jTextFieldCenterDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCenterDecActionPerformed
        Vector3f centerSpherical = new Vector3f();
        centerSpherical = starSelection.getStarcube().getCenterSpherical();
        centerSpherical.SIUnitstoAstronomical();
        centerSpherical.y = Float.parseFloat(jTextFieldCenterDec.getText());
        centerSpherical.astronomicalUnitstoSI();
        starSelection.getStarcube().setCenterSpherical(centerSpherical.x,centerSpherical.y,centerSpherical.z);
        updateTextFields();
    }//GEN-LAST:event_jTextFieldCenterDecActionPerformed

    private void jCheckBoxRotateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxRotateStateChanged
        starSelection.setbRotate(jCheckBoxRotate.isSelected());
    }//GEN-LAST:event_jCheckBoxRotateStateChanged
    
          
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StarMapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StarMapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StarMapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StarMapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        //normal launch
        starSelection = new Starset(); 
        //Starset bigDipper = new Starset();
        //StarCube starcube = new StarCube(bigDipper.center(),(float) (66 * (Math.PI/180)));
        //starSelection = new Starset(starcube);
        
        /* Create and display the form */
                        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StarMapUI().setVisible(true);
          
            }
        });
        
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StarMapUI().setVisible(true);
            }
        });
        */
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonShow;
    private javax.swing.JCheckBox jCheckBoxRotate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldCenterDec;
    private javax.swing.JTextField jTextFieldCenterDistance;
    private javax.swing.JTextField jTextFieldCenterRAsc;
    private javax.swing.JTextField jTextFieldCenterX;
    private javax.swing.JTextField jTextFieldCenterY;
    private javax.swing.JTextField jTextFieldCenterZ;
    private javax.swing.JTextField jTextFieldEdgeLength;
    private javax.swing.JTextField jTextFieldObservationSpotDec;
    private javax.swing.JTextField jTextFieldObservationSpotDistance;
    private javax.swing.JTextField jTextFieldObservationSpotRAsc;
    private javax.swing.JTextField jTextFieldObservationSpotX;
    private javax.swing.JTextField jTextFieldObservationSpotY;
    private javax.swing.JTextField jTextFieldObservationSpotZ;
    // End of variables declaration//GEN-END:variables
}
