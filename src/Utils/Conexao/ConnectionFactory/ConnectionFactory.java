/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils.Conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pedro Henrique
 */
public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/DBImobiliariaMorarBem";
    private static final String USER = "root";
    private static final String PASS = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do MySQL não encontrado.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados.", e);
        }
    }
}
