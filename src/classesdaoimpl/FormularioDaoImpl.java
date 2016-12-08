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
    
    
    @Override
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
                conexao.close();
            }
            catch(SQLException se){
                Logger.getLogger(FormularioDaoImpl.class.getName()).log(Level.SEVERE, null, se);
                System.exit(1);
            }
        }
        
    }
    
    @Override
    public ResultSet getQuestoesFormulario(int id) {
        String query,query1;
        Aluno temp;
        ResultSet resposta;
        
            query1 = "select aluno from restricao where formulario_id = ?;";
         try {
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query1);    
            st1.setInt(1, id);  
            resposta = st1.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        try {
            if(resposta.next()){
                if(!resposta.getBoolean("aluno")){
                    System.out.println("Sem premissao para acessar este formulario.");
                    return null;
                }
            }else
                return null;
                
        } catch (SQLException ex) {
            Logger.getLogger(FormularioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                st1.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FormularioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        query = "SELECT q.id, q.descricao, q.formulario_id, p.id AS pRes_id, p.opcao, p.questao_id FROM questoes q LEFT JOIN possiveisrespostas p ON q.id = p.questao_id WHERE q.formulario_id = ? order by q.id, pres_id;";
       
        try {
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query);    
            st1.setInt(1, id);  
            resposta = st1.executeQuery();
            return resposta;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
       
    }

    @Override
    public ResultSet getResultadosQuestao(int id) {
         try {
             String query,query1;
             Aluno temp;
             int quantidade;
             ResultSet resposta;
             
             query1 = "SELECT count(DISTINCT pessoa_cpf) AS quantidade FROM respondeme WHERE questao_id = ?;";
             
             conexao = ConnectionDataBase.getConnection();
             st1 = conexao.prepareStatement(query1);
             st1.setInt(1, id);
             resposta = st1.executeQuery();
             
             resposta.next();
             quantidade = resposta.getInt("quantidade");
             query = "SELECT possivelres_id,count(*)/? AS porcentagem FROM respondeme GROUP BY possivelres_id,questao_id HAVING questao_id = ?;";
             
             
             conexao = ConnectionDataBase.getConnection();
             st1 = conexao.prepareStatement(query);
             st1.setInt(1, quantidade);
             st1.setInt(2,id);
             resposta = st1.executeQuery();
             return resposta;
             
             
         } catch (SQLException ex) {
            Logger.getLogger(FormularioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public ResultSet getQtaQuestoes(String cpf) {
        ResultSet resposta;
        String query;
        try {
            
            query = "SELECT COUNT(*) FROM respostas GROUP BY pessoa_cpf HAVING pessoa_cpf = ? ;";
            
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query);
            
            st1.setString(1, cpf);
            resposta = st1.executeQuery();
            
            return resposta;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @Override
    public boolean deleteResposta(int questao_id) {
        String query0,query1,query2,query3;
        Aluno temp;
	int quantidade;
        ResultSet resposta;
	
	query0 = "DELETE FROM respondesna WHERE questao_id = ?;";
	query1 = "DELETE FROM respondevf WHERE questao_id = ?;";
	query2 = "DELETE FROM respondetxt WHERE questao_id = ?;";
	query3 = "DELETE FROM respondeme WHERE questao_id = ?;";
	
         try {
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query0);    
            st1.setInt(1, questao_id);   
            st1.executeUpdate();

	    st1 = conexao.prepareStatement(query1);    
            st1.setInt(1, questao_id);   
            st1.executeUpdate();

	    st1 = conexao.prepareStatement(query2);    
            st1.setInt(1, questao_id);   
            st1.executeUpdate();

	    st1 = conexao.prepareStatement(query3);    
            st1.setInt(1, questao_id);   
            st1.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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

    @Override
    public void UpdateRestricao(int id,boolean pro,boolean alu,boolean tec,boolean ter){
	String query;
        Aluno temp;
	int quantidade;
        ResultSet resposta;
	
	query = "UPDATE restricao SET  professor = ?, aluno = ?, tecnico = ?, terceirizado = ? WHERE formulario_id = ? ;";
	
         try {
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query);     
            st1.setBoolean(1, pro);
            st1.setBoolean(2, alu);
            st1.setBoolean(3, tec);
            st1.setBoolean(4, ter);
            st1.setInt(5, id);
            st1.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
