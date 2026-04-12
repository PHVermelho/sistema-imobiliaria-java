/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author Pedro Henrique
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String tipo;
    private LocalDate dataAdmissao;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nome, String email, String telefone, String senha, String tipo, LocalDate dataAdmissao) {
        this.idUsuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.tipo = tipo;
        this.dataAdmissao = dataAdmissao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }   
}
