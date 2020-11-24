package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felip
 */
public class Conexao {
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        Connection cone = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aulaPedro", "postgres", "102310");
        return cone;
    }
}
        
    
    

