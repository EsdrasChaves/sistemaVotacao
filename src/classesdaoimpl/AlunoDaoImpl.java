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
    PreparedStatement st1;
    PreparedStatement st2;

    public AlunoDaoImpl() {}     
    
    @Override
    public ArrayList<Aluno> getAllAlunos() {
        
        ArrayList<Aluno> resultados = new ArrayList<>();
        ResultSet resposta;     
        String query;
        
        query = "select * from pessoa p inner join aluno a on p.cpf = a.cpf;";
            
            
        try {
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query);
            
            
            
            resposta = st1.executeQuery();
            
            while (resposta.next()) {
                Aluno temp = new Aluno();
                
                temp.setCPF(resposta.getString("cpf"));
                temp.setNome(resposta.getString("nome"));
                temp.setEmail_inst(resposta.getString("email_institucional"));
                temp.setEmail_sec(resposta.getString("email_secundario"));
                temp.setData_nasc(resposta.getDate("data_nasc"));
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
                st1.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        
    }
    
    
    @Override
    public int insertAluno (Aluno aluno) {
        int executeUpdate1;
        int executeUpdate2;
        
        
        String query_Pessoa = "insert into pessoa (cpf, nome, email_institucional, email_secundario, data_nasc, senha, tipo)"
                + " values (?, ?, ?, ?, ?, ?, ?);";
        
        String query_Aluno = "insert into aluno (cpf, numero_matricula, curso_sigla) "
                + " values (?, ?, ?);";
        
        try{
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query_Aluno);
            st2 = conexao.prepareStatement(query_Pessoa);
            
            st2.setString(1, aluno.getCPF());
            st2.setString(2, aluno.getNome());
            st2.setString(3, aluno.getEmail_inst());
            st2.setString(4, aluno.getEmail_sec());
            st2.setDate(5, aluno.getData_nasc());
            st2.setString(6, aluno.getSenha());
            st2.setString(7, aluno.getTipo());
            
            
            st1.setString(1, aluno.getCPF());
            st1.setString(2, aluno.getNro_matricula());
            st1.setString(3, aluno.getCurso());
            
            
            executeUpdate2 = st2.executeUpdate();
            executeUpdate1 = st1.executeUpdate();
            
                    
            if(executeUpdate1 == 1 && executeUpdate2 == 1) 
                return 1;
            else
                return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
             try {
                st1.close();
                st2.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        
    }
    
    @Override
    public Aluno getAluno (String cpf) {
        String query;
        Aluno temp;
        ResultSet resposta;
        
        query = "select * from pessoa p inner join aluno a on p.cpf = a.cpf where a.cpf = ?;";
        
        try {
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query);
            
            st1.setString(1, cpf);
            
            resposta = st1.executeQuery();
            
            temp = new Aluno();
            
            resposta.next();
            temp.setCPF(resposta.getString("cpf"));
            temp.setNome(resposta.getString("nome"));
            temp.setEmail_inst(resposta.getString("email_institucional"));
            temp.setEmail_sec(resposta.getString("email_secundario"));
            temp.setData_nasc(resposta.getDate("data_nasc"));
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
                st1.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        
    }
    
    @Override
    public void deleteAluno (String cpf) {
        String query1;
        String query2;
        
        query1 = "delete from pessoa where cpf = ? ;";
        query2 = "delete from aluno where cpf = ? ;";
        
        try {
            conexao = ConnectionDataBase.getConnection();
            
            st1 = conexao.prepareStatement(query2);
            st1.setString(1, cpf);
            st1.executeUpdate();
            
            st2 = conexao.prepareStatement(query1);
            st2.setString(1, cpf);
            st2.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st1.close();
                st2.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
    }
    
}
