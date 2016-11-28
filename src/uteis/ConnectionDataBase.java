/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author esdraschaves
 */
public class ConnectionDataBase {
    public static void loadDrive () {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException cnfe) {
            System.out.println("Não foi possível achar o Driver!");
            cnfe.printStackTrace();
            System.exit(1);
        }
        System.out.println("Driver carregado com sucesso");
    }
    
    public static Connection getConnection () {
        Connection conexao = null;
        try {
            System.out.println("Conectando com o servidor!");
            String url = "jdbc:postgresql://localhost/postgres?user=postgres&password=dbestudo";
            conexao = DriverManager.getConnection(url);
            System.out.println("Conectado!");
        }catch (SQLException se) {
            System.out.println("Não foi possível conectar ao banco de dados.");
            se.printStackTrace();
        }
        
        return conexao;
    }
}