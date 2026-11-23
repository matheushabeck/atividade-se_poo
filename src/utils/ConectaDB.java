/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDB {
    public static Connection getConexao() throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/db_agenda";
        String user = "postgres";
        String password = "postgres";
        return DriverManager.getConnection(url, user, password);
    }
}
