/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import Controlador.DAOUsuarioIMP;
import Vistas.Principal;
import javax.swing.JOptionPane;

/**
 *
 * @author Tats5
 */
public class Login extends javax.swing.JFrame {
DAOUsuarioIMP user= new DAOUsuarioIMP();
 DBHelper db = new DBHelper();
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblimagen = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        usernametxt = new javax.swing.JTextField();
        passwordtxt = new javax.swing.JPasswordField();
        BtnEntrar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login.jpg"))); // NOI18N
        jPanel1.add(lblimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 230));

        lblUser.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblUser.setForeground(new java.awt.Color(0, 0, 0));
        lblUser.setText("Correo");
        jPanel1.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 30));

        lblPass.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblPass.setForeground(new java.awt.Color(0, 0, 0));
        lblPass.setText("Password");
        jPanel1.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 110, 30));

        usernametxt.setBackground(new java.awt.Color(255, 255, 255));
        usernametxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        usernametxt.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(usernametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 280, 40));

        passwordtxt.setBackground(new java.awt.Color(255, 255, 255));
        passwordtxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        passwordtxt.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(passwordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 280, 40));

        BtnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        BtnEntrar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        BtnEntrar.setForeground(new java.awt.Color(0, 0, 0));
        BtnEntrar.setText("Enter");
        BtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 100, 30));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEntrarActionPerformed
      
        var Correo = usernametxt.getText();
        var Pass = passwordtxt.getText();
        user.login(Correo, Pass);
        try {
            
           if(!Correo.isEmpty() || !Pass.equals("")){
                   
          Principal abrir = new Principal();
          abrir.setVisible(true);
          this.dispose();
                
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }
      
        

    }//GEN-LAST:event_BtnEntrarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
          Registrar abrir = new Registrar();
          abrir.setVisible(true);
          this.dispose();


        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEntrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JPasswordField passwordtxt;
    private javax.swing.JTextField usernametxt;
    // End of variables declaration//GEN-END:variables
}
