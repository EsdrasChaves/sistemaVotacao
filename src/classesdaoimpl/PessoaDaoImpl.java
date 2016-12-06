/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdaoimpl;

import classesdao.PessoaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uteis.ConnectionDataBase;

/**
 *
 * @author esdraschaves
 */
public class PessoaDaoImpl implements PessoaDao{
    
    private Connection conexao;
    private PreparedStatement st1;
    private ResultSet resultado;
    
    
    @Override
    public boolean validaPessoa(String cpf, String password) {
        try {
            String query;
            String senha;
            
            query = "select senha from pessoa where cpf = ?;";
            
            
            conexao = ConnectionDataBase.getConnection();
            
            st1 = conexao.prepareStatement(query);
            
            st1.setString(1, cpf);
            resultado = st1.executeQuery();
            
            
            if(resultado.next() == false)
                return false;
            
            
            return resultado.getString("senha").equals(password);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                st1.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        
        return true;
    }
    
}
