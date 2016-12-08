/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavotação;

import interfaces.loginScreen;
import uteis.ConnectionDataBase;

/**
 *
 * @author esdraschaves
 */
public class SistemaVotação {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ConnectionDataBase.loadDrive();
        ConnectionDataBase.getConnection();
        
        new loginScreen().setVisible(true);
    }
    
}
