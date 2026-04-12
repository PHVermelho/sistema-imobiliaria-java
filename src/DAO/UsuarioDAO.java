/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Login;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.Conexao.ConnectionFactory.ConnectionFactory;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Pedro Henrique
 */
public class UsuarioDAO {
    
    private Connection connection;
    
    public UsuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarUsuario(Usuario usuario){
        String sql = "insert into Usuario(nome, email, telefone, senha, tipo, data_admissao) values (?,?,?,?,?,?);";
    
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getTelefone());
            ps.setString(4, usuario.getSenha());
            ps.setString(5, usuario.getTipo());
            ps.setDate(6, java.sql.Date.valueOf(usuario.getDataAdmissao()));
            
            ps.executeUpdate();
     
        }catch(SQLException e){
            throw new RuntimeException("Erro ao Cadastrar usuário", e);
        }
    }
    
    public Usuario login(String email, String senha){
        String sql = "select * from Usuario where email = ? and senha = ?;";
        
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Usuario usuario = new Usuario();
                
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setDataAdmissao(rs.getDate("data_admissao").toLocalDate());
                return usuario;
            }
            return null;
        }catch(SQLException e){
            throw new RuntimeException("Erro ao fazer login", e);
        }
    }
}
