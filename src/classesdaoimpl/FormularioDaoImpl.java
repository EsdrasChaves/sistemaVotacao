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
import uteis.ConnectionDataBase;

/**
 *
 * @author esdraschaves
 */
public class FormularioDaoImpl implements FormularioDao{
    private Connection conexao;
    PreparedStatement st1;
    
    
    @Override
    public ResultSet getFormularioNumQuestao(){
        
        String query = "SELECT formulario_id, COUNT(id) FROM questoes GROUP BY formulario_id";
        try{
            conexao = ConnectionDataBase.getConnection();
            st1 = conexao.prepareStatement(query);
            return st1.executeQuery();
        }
        catch(SQLException se){
            Logger.getLogger(FormularioDaoImpl.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
        finally{
            try{
                st1.close();
                conexao.close();
            }
            catch(SQLException se){
                Logger.getLogger(FormularioDaoImpl.class.getName()).log(Level.SEVERE, null, se);
                System.exit(1);
            }
        }
        
    }
}
