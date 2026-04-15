/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Login;
import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.Conexao.ConnectionFactory.ConnectionFactory;
import View.Administrador.Administrador;
import View.Login.LoginFuncionario;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Henrique
 */
public class FuncionarioDAO {

    private Connection connection;

    public FuncionarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {

        int idAdmin = Sessao.idAdministrador;

        System.out.println("ID ADMIN: " + Sessao.idAdministrador);
        String sql = "insert into funcionario(nome, email, telefone, senha, cargo, id_administrador) values (?,?,?,?,?,?);";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getEmail());
            ps.setString(3, funcionario.getTelefone());
            ps.setString(4, funcionario.getSenha());
            ps.setString(5, funcionario.getCargo());
            if (funcionario.getCargo().equals("ADMINISTRADOR")) {
                ps.setNull(6, java.sql.Types.INTEGER);
            } else {
                ps.setInt(6, Sessao.idAdministrador);
            }
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao Cadastrar Funcionário", e);
        }
    }

    public Funcionario login(String email, String senha) {
        String sql = "select * from funcionario where email = ? and senha = ?;";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCargo(rs.getString("cargo"));            

                if (email.equals(rs.getString("email"))) {
                    if (senha.equals(rs.getString("senha"))) {
                        JOptionPane.showMessageDialog(null, "Login Efetuado com sucesso");
                        if (funcionario.getCargo().equals("ADMINISTRADOR")) {
                            Sessao.idAdministrador = funcionario.getIdFuncionario();
                            Administrador adm = new Administrador();
                            adm.setVisible(true);
                        }else{
                            Sessao.idAdministrador = rs.getInt("id_administrador");
                        }
                    }
                }

                return funcionario;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fazer login", e);
        }
    }

    public class Sessao {

        public static int idAdministrador;
    }
}
