/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recomendação_de_Filmes;

import classes.Cliente;
import classes.Filmes;
import classes.Perfil_Filme;
import classes.Perfil_cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ConectaBancoProvisório {

    protected static Connection conectaBanco() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection Conec;
        Conec = DriverManager.getConnection("jdbc:"
                + "postgresql://localhost/SistemaDeCredito",
                "postgres", "123");
        return Conec;
    }

    public List<Filmes> listAll() throws ClassNotFoundException, SQLException {
        Connection c = ConectaBancoProvisório.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Filme");
        ResultSet r = p.executeQuery();
        List<Filmes> lista_de_filmes = new ArrayList<>();
        while (r.next()) {
            Filmes fm = new Filmes();
            fm.setId(r.getInt("id_Filme"));
            fm.setNome(r.getString("Nome"));
            fm.setElenco(r.getString("Elenco"));
            fm.setClassificacao("Classificacao");
            fm.setDiretor(r.getString("Diretor"));
            fm.setDataLancamento(r.getString("DataLancamento"));
            fm.setGeneros(r.getString("Genero"));
            fm.setSinopse(r.getString("Sinopse"));
            fm.setDuracao(String.valueOf(r.getString("Duracao")));
            fm.setPerfil(ConectaBancoProvisório.getPerfil(fm.getId()));
            lista_de_filmes.add(fm);
        }
        return lista_de_filmes;
    }

    public static Perfil_Filme getPerfil(int id_filmes) throws SQLException, ClassNotFoundException {
        Connection c = ConectaBancoProvisório.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Perfil where id_filme = ?;");
        p.setInt(1, id_filmes);
        ResultSet r = p.executeQuery();
        Perfil_Filme perfil = new Perfil_Filme();
        while (r.next()) {
            perfil.setAcao(r.getInt("Acao"));
            perfil.setAnimação(r.getInt("Animacao"));
            perfil.setComedia(r.getInt("Comedia"));
            perfil.setDocumentario(r.getInt("Documentario"));
            perfil.setDrama(r.getInt("Drama"));
            perfil.setRomance(r.getInt("Romance"));
            perfil.setTerror(r.getInt("Terror"));
        }
        return perfil;
    }

    public static Cliente getUser(String nome) throws SQLException, ClassNotFoundException {
        Connection c = ConectaBancoProvisório.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Cliente where NOme like ? ;");
        p.setString(1, nome);
        ResultSet r = p.executeQuery();
        Cliente cli = new Cliente();
        while(r.next()){
            cli.setId_cliente(r.getInt("id_cliente"));
            cli.setNome(r.getString("Nome"));
            cli.setSenha(r.getString("Senha"));
            cli.setEmail(r.getString("Email"));
            cli.setPerfil(ConectaBancoProvisório.getPerfilCli(cli.getId_cliente()));
        }
        return cli;
    }
    
     public static Perfil_cliente getPerfilCli(int id_Cliente) throws SQLException, ClassNotFoundException {
        Connection c = ConectaBancoProvisório.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Perfil_cliente where id_cliente = ?;");
        p.setInt(1, id_Cliente);
        ResultSet r = p.executeQuery();
        Perfil_cliente perfil = new Perfil_cliente();
        while (r.next()) {
            perfil.setAcao(r.getInt("Acao"));
            perfil.setAnimação(r.getInt("Animacao"));
            perfil.setComedia(r.getInt("Comedia"));
            perfil.setDocumentario(r.getInt("Documentario"));
            perfil.setDrama(r.getInt("Drama"));
            perfil.setRomance(r.getInt("Romance"));
            perfil.setTerror(r.getInt("Terror"));
        }
        return perfil;
    }
}
