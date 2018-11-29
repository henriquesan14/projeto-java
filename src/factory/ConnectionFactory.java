/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author computador
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/dbclinicajava";
		try {
			conn = DriverManager.getConnection(url, "root", "");
			//JOptionPane.showMessageDialog(null, "Conectado com Sucesso!");
		}catch(SQLException e) {
			System.out.println("Error na conexão com o banco! ");
			e.printStackTrace();
		}
		
		return conn;
	}
    
    
   
    
}
