/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdaoimpl;

import classesdao.AlunoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemavotação.Aluno;
import uteis.ConnectionDataBase;

/**
 *
 * @author esdraschaves
 */
public class AlunoDaoImpl implements AlunoDao{
    private Connection conexao;
    private Statement sentenca;
    PreparedStatement st;
     
    
    @Override
    public ArrayList<Aluno> getAllAlunos() {
        
        ArrayList<Aluno> resultados = new ArrayList<>();
        ResultSet resposta;     
        String query;
        
        query = "select * from pessoa p inner join aluno a on p.cpf = a.cpf;";
            
            
        try {
            conexao = ConnectionDataBase.getConnection();
            sentenca = conexao.createStatement();
            resposta = sentenca.executeQuery(query);
            
            while (resposta.next()) {
                Aluno temp = new Aluno();
                
                temp.setCPF(resposta.getString("cpf"));
                temp.setNome(resposta.getString("nome"));
                temp.setEmail_inst(resposta.getString("email_institucional"));
                temp.setEmail_sec(resposta.getString("email_secundario"));
                temp.setData_nasc(resposta.getString("data_nasc"));
                temp.setSenha(resposta.getString("senha"));
                temp.setTipo(resposta.getString("tipo"));
                
                
                temp.setNro_matricula(resposta.getString("numero_matricula"));
                temp.setCurso(resposta.getString("curso_sigla"));
                
                resultados.add(temp);
            }
            
            return resultados;
            
        } catch (SQLException ex) {
            System.out.println("Errou!");
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                sentenca.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        
    }
    
    
    @Override
    public int insertAluno (Aluno aluno) {
        int executeUpdate;
        
        String query = "insert into aluno (cpf, numero_matricula, curso_sigla) "
                + " values (?, ?, ?);";
        try{
            conexao = ConnectionDataBase.getConnection();
            st = conexao.prepareStatement(query);
            
            st.setString(1, aluno.getCPF());
            st.setString(2, aluno.getNro_matricula());
            st.setString(3, aluno.getCurso());
            
            executeUpdate = st.executeUpdate();
            
            return executeUpdate;
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
             try {
                st.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        
    }
    
    @Override
    public Aluno getAluno (Aluno aluno) {
        ResultSet resposta;
        String query;
        String cpf = aluno.getCPF();
                
        query = "select * from pessoa p inner join aluno a on p.cpf = a.cpf where a.cpf ='" + cpf + "';";
        
        try {
            conexao = ConnectionDataBase.getConnection();
            sentenca = conexao.createStatement();
            resposta = sentenca.executeQuery(query);
            
            Aluno temp = new Aluno();
            
            temp.setCPF(resposta.getString("cpf"));
            temp.setNome(resposta.getString("nome"));
            temp.setEmail_inst(resposta.getString("email_institucional"));
            temp.setEmail_sec(resposta.getString("email_secundario"));
            temp.setData_nasc(resposta.getString("data_nasc"));
            temp.setSenha(resposta.getString("senha"));
            temp.setTipo(resposta.getString("tipo"));
                
                
            temp.setNro_matricula(resposta.getString("numero_matricula"));
            temp.setCurso(resposta.getString("curso_sigla"));
            
            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            try {
                sentenca.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        
    }
    
    @Override
    public void deleteAluno (String cpf) {
        String query;
        ResultSet resposta;
              
        query = "delete from aluno where cpf = '" + cpf + "';";
        
        try {
            conexao = ConnectionDataBase.getConnection();
            sentenca = conexao.createStatement();
            
            resposta = sentenca.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentenca.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
    }
}
