/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdaoimpl;

import classesdao.UnidadeAcadDao;
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
public class UnidadeAcadDaoImpl implements UnidadeAcadDao{
    private Connection conexao;
    PreparedStatement st1, st2, st3, st4;
    String query;
    ResultSet resultado1;

    
    @Override
    public boolean removeUnidAcad(String sigla){
  
        try {
            conexao = ConnectionDataBase.getConnection();
            
            query = "SELECT count(*) FROM unidadeacad;";
            st1 = conexao.prepareStatement(query);
            resultado1 = st1.executeQuery();
            resultado1.next();
            if(resultado1.getInt("count")<=1){
                return false;
            }
            else{
                query = "select * from unidadeacad where sigla != ?";
                st2 = conexao.prepareStatement(query);
                st2.setString(1, sigla);
                resultado1 = st2.executeQuery();
                resultado1.next();
                

                query = "update professor set uacad_sigla = ? where uacad_sigla = ?;";
                st3 = conexao.prepareStatement(query);
                st3.setString(1, resultado1.getString("sigla"));
                st3.setString(2,sigla);
                st3.executeUpdate();
                
                query = "update curso set uacad_sigla = ? where uacad_sigla = ?;";
                st3 = conexao.prepareStatement(query);
                st3.setString(1, resultado1.getString("sigla"));
                st3.setString(2,sigla);
                st3.executeUpdate();
                
                
                query = "update tecnicoacad set uacad_sigla = ? where uacad_sigla = ?;";
                st3 = conexao.prepareStatement(query);
                st3.setString(1, resultado1.getString("sigla"));
                st3.setString(2,sigla);
                st3.executeUpdate();
                
                query = "delete from unidadeacad where sigla = ? ;";
                st4 = conexao.prepareStatement(query);
                st4.setString(1, sigla);
                st4.executeUpdate();
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnidadeAcadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                st1.close();
                st2.close();
                st3.close();
                st4.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(UnidadeAcadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
}
