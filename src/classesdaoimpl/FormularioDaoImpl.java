/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdaoimpl;

import classesdao.FormularioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemavotação.Aluno;
import uteis.ConnectionDataBase;

/**
 *
 * @author esdraschaves
 */
public class FormularioDaoImpl implements FormularioDao{
    private Connection conexao;
    PreparedStatement st1;
    
    
    public void fechaStatement() {
        try {
            st1.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormularioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ResultSet getFormularioNumQuestao(){
        ResultSet a;
        
        String query = "SELECT f.id, f.nome, f.data_inicial, f.data_final, f.criador_cpf, COUNT(f.id) FROM questoes q INNER JOIN " +
"				(formulario f INNER JOIN restricao r ON aluno = TRUE AND r.formulario_id = f.id) ON f.id = q.formulario_id GROUP BY f.id;";
        try{
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query);
            
            a = st1.executeQuery();
            
            return a;
        }
        catch(SQLException se){
            Logger.getLogger(FormularioDaoImpl.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
        finally{
            try{
                //st1.close();
                conexao.close();
            }
            catch(SQLException se){
                Logger.getLogger(FormularioDaoImpl.class.getName()).log(Level.SEVERE, null, se);
                System.exit(1);
            }
        }
        
    }
    
    public ResultSet getQuestoesFormulario(String id) {
        String query,query1;
        Aluno temp;
        ResultSet resposta;
        query1 = "select aluno from restricao where formulario_id = ?;";
         try {
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query1);    
            st1.setString(1, id);  
            resposta = st1.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            try {
                st1.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        try {
            if(!resposta.getBoolean("aluno")){
                System.out.println("Sem premissao para acessar este formulario.");
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormularioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        query = "select * from Questoes q left iner join possiveisRespostas r on q.id = r.id where q.formulario_id = ?;";
       
        try {
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query);    
            st1.setString(1, id);  
            resposta = st1.executeQuery();
            return resposta;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            try {
                st1.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
       
    }
}
