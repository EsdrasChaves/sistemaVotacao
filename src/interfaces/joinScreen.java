/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classesdaoimpl.PessoaDaoImpl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import sistemavotação.Aluno;
import sistemavotação.Pessoa;
import uteis.Formatacao;

/**
 *
 * @author esdraschaves
 */
public class joinScreen extends javax.swing.JFrame {

    /**
     * Creates new form joinScreen
     */
    public joinScreen() {
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

        text_cadastro = new javax.swing.JLabel();
        text_cpf = new javax.swing.JLabel();
        text_nome = new javax.swing.JLabel();
        text_emailInst = new javax.swing.JLabel();
        text_emailSec = new javax.swing.JLabel();
        text_dataNasc = new javax.swing.JLabel();
        text_senha = new javax.swing.JLabel();
        text_tipo = new javax.swing.JLabel();
        input_cpf = new javax.swing.JTextField();
        input_nome = new javax.swing.JTextField();
        input_emailInst = new javax.swing.JTextField();
        input_emailSec = new javax.swing.JTextField();
        input_dataNasc = new datechooser.beans.DateChooserCombo();
        input_passWord = new javax.swing.JPasswordField();
        input_tipo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(750, 500));
        setMinimumSize(new java.awt.Dimension(750, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        text_cadastro.setFont(new java.awt.Font("Waree", 0, 18)); // NOI18N
        text_cadastro.setForeground(new java.awt.Color(254, 254, 254));
        text_cadastro.setText("Cadastro");
        getContentPane().add(text_cadastro);
        text_cadastro.setBounds(29, 24, 80, 31);

        text_cpf.setFont(new java.awt.Font("Waree", 0, 18)); // NOI18N
        text_cpf.setForeground(new java.awt.Color(254, 254, 254));
        text_cpf.setText("CPF:");
        getContentPane().add(text_cpf);
        text_cpf.setBounds(29, 84, 40, 31);

        text_nome.setFont(new java.awt.Font("Waree", 0, 18)); // NOI18N
        text_nome.setForeground(new java.awt.Color(254, 254, 254));
        text_nome.setText("Nome:");
        getContentPane().add(text_nome);
        text_nome.setBounds(29, 128, 59, 31);

        text_emailInst.setFont(new java.awt.Font("Waree", 0, 18)); // NOI18N
        text_emailInst.setForeground(new java.awt.Color(254, 254, 254));
        text_emailInst.setText("E-mail Institucional:");
        getContentPane().add(text_emailInst);
        text_emailInst.setBounds(29, 178, 176, 31);

        text_emailSec.setFont(new java.awt.Font("Waree", 0, 18)); // NOI18N
        text_emailSec.setForeground(new java.awt.Color(254, 254, 254));
        text_emailSec.setText("E-mail Secundário:");
        getContentPane().add(text_emailSec);
        text_emailSec.setBounds(29, 227, 167, 31);

        text_dataNasc.setFont(new java.awt.Font("Waree", 0, 18)); // NOI18N
        text_dataNasc.setForeground(new java.awt.Color(254, 254, 254));
        text_dataNasc.setText("Data de nascimento:");
        getContentPane().add(text_dataNasc);
        text_dataNasc.setBounds(29, 276, 187, 31);

        text_senha.setFont(new java.awt.Font("Waree", 0, 18)); // NOI18N
        text_senha.setForeground(new java.awt.Color(254, 254, 254));
        text_senha.setText("Senha:");
        getContentPane().add(text_senha);
        text_senha.setBounds(29, 325, 61, 31);

        text_tipo.setFont(new java.awt.Font("Waree", 0, 18)); // NOI18N
        text_tipo.setForeground(new java.awt.Color(254, 254, 254));
        text_tipo.setText("Tipo:");
        getContentPane().add(text_tipo);
        text_tipo.setBounds(29, 375, 44, 31);

        input_cpf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        input_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_cpfActionPerformed(evt);
            }
        });
        getContentPane().add(input_cpf);
        input_cpf.setBounds(257, 88, 278, 20);

        input_nome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(input_nome);
        input_nome.setBounds(257, 132, 278, 20);

        input_emailInst.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        input_emailInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_emailInstActionPerformed(evt);
            }
        });
        getContentPane().add(input_emailInst);
        input_emailInst.setBounds(257, 182, 278, 20);

        input_emailSec.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(input_emailSec);
        input_emailSec.setBounds(257, 233, 278, 20);

        try {
            input_dataNasc.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(1997, 6, 3),
                new java.util.GregorianCalendar(1997, 6, 3))));
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }
    getContentPane().add(input_dataNasc);
    input_dataNasc.setBounds(257, 279, 155, 28);

    input_passWord.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    input_passWord.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            input_passWordActionPerformed(evt);
        }
    });
    getContentPane().add(input_passWord);
    input_passWord.setBounds(257, 329, 278, 20);

    input_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Professor", "Aluno", "Técnico Adm", "Técnico Acad", "Terceirizado" }));
    input_tipo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    input_tipo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            input_tipoActionPerformed(evt);
        }
    });
    getContentPane().add(input_tipo);
    input_tipo.setBounds(257, 375, 132, 30);

    jButton1.setText("Próximo");
    jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton1);
    jButton1.setBounds(432, 430, 270, 40);

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/12107952-1.jpg"))); // NOI18N
    getContentPane().add(jLabel1);
    jLabel1.setBounds(0, 0, 760, 530);

    setSize(new java.awt.Dimension(760, 530));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void input_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_cpfActionPerformed

    private void input_emailInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_emailInstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_emailInstActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int tipo = input_tipo.getSelectedIndex();
        Aluno pessoa;
        
        System.out.println(tipo);
        
        switch (tipo){
            case 1:
                pessoa = new Aluno();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo não suportado");
                pessoa = null;
                break;
        }
        // No momento só será implementado o cadastro do aluno
       
        
        if(pessoa != null) {
            if (!(input_cpf.getText().length() > 0 &&
                    input_nome.getText().length() > 0 &&
                    input_emailInst.getText().length() > 0 &&
                    input_passWord.getText().length() > 0)) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            }else {
                
                new joinScreenAluno(input_cpf.getText(), input_nome.getText(), 
                        input_emailInst.getText(), input_emailSec.getText(), 
                        input_dataNasc.getSelectedDate(), input_passWord.getText()).setVisible(true);
                this.dispose();
                            
            }
        
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void input_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_tipoActionPerformed

    private void input_passWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_passWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_passWordActionPerformed

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
            java.util.logging.Logger.getLogger(joinScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(joinScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(joinScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(joinScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new joinScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField input_cpf;
    private datechooser.beans.DateChooserCombo input_dataNasc;
    private javax.swing.JTextField input_emailInst;
    private javax.swing.JTextField input_emailSec;
    private javax.swing.JTextField input_nome;
    private javax.swing.JPasswordField input_passWord;
    private javax.swing.JComboBox<String> input_tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel text_cadastro;
    private javax.swing.JLabel text_cpf;
    private javax.swing.JLabel text_dataNasc;
    private javax.swing.JLabel text_emailInst;
    private javax.swing.JLabel text_emailSec;
    private javax.swing.JLabel text_nome;
    private javax.swing.JLabel text_senha;
    private javax.swing.JLabel text_tipo;
    // End of variables declaration//GEN-END:variables
}
