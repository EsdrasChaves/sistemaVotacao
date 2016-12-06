/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classesdao.AlunoDao;
import classesdao.PessoaDao;
import classesdaoimpl.AlunoDaoImpl;
import classesdaoimpl.PessoaDaoImpl;

/**
 *
 * @author esdraschaves
 */
public class loginScreen extends javax.swing.JFrame {
    
    AlunoDao aux = new AlunoDaoImpl();
    
    /**
     * Creates new form loginScreen
     */
    public loginScreen() {
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

        text_login = new javax.swing.JLabel();
        text_CPF1 = new javax.swing.JLabel();
        text_PassWord = new javax.swing.JLabel();
        text_error = new javax.swing.JLabel();
        input_CPF = new javax.swing.JTextField();
        input_PassWord = new javax.swing.JPasswordField();
        button_logIn = new javax.swing.JButton();
        button_join = new javax.swing.JLabel();
        image_loginBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(650, 700));
        setPreferredSize(new java.awt.Dimension(550, 800));
        setResizable(false);
        getContentPane().setLayout(null);

        text_login.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        text_login.setForeground(new java.awt.Color(254, 254, 254));
        text_login.setText("LOGIN");
        getContentPane().add(text_login);
        text_login.setBounds(220, 130, 90, 40);

        text_CPF1.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        text_CPF1.setForeground(new java.awt.Color(254, 254, 254));
        text_CPF1.setText("CPF");
        getContentPane().add(text_CPF1);
        text_CPF1.setBounds(30, 270, 40, 30);

        text_PassWord.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        text_PassWord.setForeground(new java.awt.Color(254, 254, 254));
        text_PassWord.setText("Senha");
        getContentPane().add(text_PassWord);
        text_PassWord.setBounds(30, 340, 70, 30);

        text_error.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(text_error);
        text_error.setBounds(289, 380, 160, 30);

        input_CPF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        input_CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_CPFActionPerformed(evt);
            }
        });
        getContentPane().add(input_CPF);
        input_CPF.setBounds(110, 270, 340, 30);

        input_PassWord.setToolTipText("");
        input_PassWord.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        input_PassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_PassWordActionPerformed(evt);
            }
        });
        getContentPane().add(input_PassWord);
        input_PassWord.setBounds(110, 340, 340, 30);

        button_logIn.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        button_logIn.setForeground(new java.awt.Color(1, 1, 1));
        button_logIn.setText("Entrar");
        button_logIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logInActionPerformed(evt);
            }
        });
        getContentPane().add(button_logIn);
        button_logIn.setBounds(110, 450, 340, 45);

        button_join.setFont(new java.awt.Font("Waree", 0, 18)); // NOI18N
        button_join.setText("Cadastre-se");
        button_join.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cad_handles(evt);
            }
        });
        getContentPane().add(button_join);
        button_join.setBounds(340, 520, 110, 20);

        image_loginBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/12107952-1.jpg"))); // NOI18N
        getContentPane().add(image_loginBack);
        image_loginBack.setBounds(0, 0, 580, 959);

        setSize(new java.awt.Dimension(560, 830));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void input_CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_CPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_CPFActionPerformed

    private void input_PassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_PassWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_PassWordActionPerformed

    private void button_logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_logInActionPerformed
        // TODO add your handling code here:
        String cpf;
        PessoaDao valid = new PessoaDaoImpl();
        
        cpf = input_CPF.getText();
        text_error.setText("");
        
        if(valid.validaPessoa(cpf, input_PassWord.getText())) {
            this.dispose();
            new areaAluno(aux.getAluno(cpf)).setVisible(true);
        }else {
            text_error.setText("CPF ou senha inválido!");
        }
    }//GEN-LAST:event_button_logInActionPerformed

    private void cad_handles(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cad_handles
        // TODO add your handling code here:
        new joinScreen().setVisible(true);
    }//GEN-LAST:event_cad_handles

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
            java.util.logging.Logger.getLogger(loginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_join;
    private javax.swing.JButton button_logIn;
    private javax.swing.JLabel image_loginBack;
    private javax.swing.JTextField input_CPF;
    private javax.swing.JPasswordField input_PassWord;
    private javax.swing.JLabel text_CPF1;
    private javax.swing.JLabel text_PassWord;
    private javax.swing.JLabel text_error;
    private javax.swing.JLabel text_login;
    // End of variables declaration//GEN-END:variables
}
