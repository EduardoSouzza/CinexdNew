/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecomendacaoFilmes;

import classes.Cliente;
import classes.Filmes;
import classes.PerfilFilme;
import classes.PerfilCliente;
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
public class ConectaBanco {

    protected static Connection conectaBanco() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinexd", "postgres", "utfpr");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public static List<Filmes> listAll() throws ClassNotFoundException, SQLException {
        Connection c = ConectaBanco.conectaBanco();
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
            fm.setPerfil(ConectaBanco.getPerfil(fm.getId()));
            lista_de_filmes.add(fm);
        }
        return lista_de_filmes;
    }

    public static PerfilFilme getPerfil(int id_filmes) throws SQLException, ClassNotFoundException {
        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Perfil where id_filme = ?;");
        p.setInt(1, id_filmes);
        ResultSet r = p.executeQuery();
        PerfilFilme perfil = new PerfilFilme();
        while (r.next()) {
            perfil.setAcao(r.getInt("Acao"));
            perfil.setAnimacao(r.getInt("Animacao"));
            perfil.setComedia(r.getInt("Comedia"));
            perfil.setDocumentario(r.getInt("Documentario"));
            perfil.setDrama(r.getInt("Drama"));
            perfil.setRomance(r.getInt("Romance"));
            perfil.setTerror(r.getInt("Terror"));
        }
        return perfil;
    }
    

    public static Cliente getUser(String nome) throws SQLException, ClassNotFoundException {
        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Cliente where NOme like ? ;");
        p.setString(1, nome);
        ResultSet r = p.executeQuery();
        Cliente cli = new Cliente();
        while (r.next()) {
            cli.setId_cliente(r.getInt("id_cliente"));
            cli.setNome(r.getString("Nome"));
            cli.setSenha(r.getString("Senha"));
            cli.setEmail(r.getString("Email"));
            cli.setPerfil(ConectaBanco.getPerfilCli(cli.getId_cliente()));
        }
        return cli;
    }

    public static PerfilCliente getPerfilCli(int id_Cliente) throws SQLException, ClassNotFoundException {
        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Perfil_cliente where id_cliente = ?;");
        p.setInt(1, id_Cliente);
        ResultSet r = p.executeQuery();
        PerfilCliente perfil = new PerfilCliente();
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

    public static void createFilmes(Filmes fm) throws ClassNotFoundException, SQLException {
        try {

            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("insert into filme (nome, diretor, elenco, classificacao, sinopse, duracao, datalancamento, genero) values (?,?,?,?,?,?,?,?)");
            p.setString(1, fm.getNome());
            p.setString(2, fm.getDiretor());
            p.setString(3, fm.getElenco());
            p.setInt(4, 0);
            p.setString(5, fm.getSinopse());
            p.setInt(6, 0);
            p.setString(7, fm.getDataLancamento());
            p.setString(8, fm.getGeneros());
            p.execute();
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static void deleteFilme(int idFilme) {

        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("delete from filme where id_filme = ?");
            p.setInt(1, idFilme);
            p.execute();
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static void updateFilme(Filmes fm) throws ClassNotFoundException, SQLException {
       
        try {
            Connection c = ConectaBanco.conectaBanco();
            PreparedStatement p = c.prepareStatement("update filme set diretor = ?,"
                    + "                              elenco = ?, classificacao = ?, sinopse = ?, duracao = ?,"
                    + "                              datalancamento = ?, genero = ? where id_filme = ?");

            p.setString(1, fm.getDiretor());
            p.setString(2, fm.getElenco());
            p.setInt(3, Integer.parseInt(fm.getClassificacao()));
            p.setString(4, fm.getSinopse());
            p.setInt(5, Integer.parseInt(fm.getDuracao()));
            p.setString(6, fm.getDataLancamento());
            p.setString(7, fm.getGeneros());
            p.setInt(8, fm.getId());
            p.executeUpdate();
            System.out.println("passou");
        } catch (Exception e) {
            System.out.println("erroR: " + e);
        }
    }

    public static Filmes selectFilme(String nomeFilme) throws ClassNotFoundException, SQLException {

        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("SELECT * FROM filme where nome like ?");
        p.setString(1, nomeFilme);
        ResultSet rs = p.executeQuery();
        Filmes fm = new Filmes();

        while (rs.next()) {
            fm.setId(Integer.parseInt(rs.getString("id_filme")));
            fm.setNome(rs.getString("nome"));
            fm.setDiretor(rs.getString("diretor"));
            fm.setElenco(rs.getString("elenco"));
            fm.setClassificacao(rs.getString("classificacao"));
            fm.setSinopse(rs.getString("sinopse"));
            fm.setDuracao(rs.getString("duracao"));
            fm.setDataLancamento(rs.getString("datalancamento"));
            fm.setGeneros(rs.getString("genero"));
        }

        return fm;
    }

    public static ArrayList<Filmes> selectAllFilmes() throws ClassNotFoundException, SQLException {

        Connection c = ConectaBanco.conectaBanco();
        PreparedStatement p = c.prepareStatement("SELECT * FROM filme");
        ResultSet rs = p.executeQuery();
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        while (rs.next()) {
            Filmes fm = new Filmes();
            fm.setId(Integer.parseInt(rs.getString("id_filme")));
            fm.setNome(rs.getString("nome"));
            fm.setDiretor(rs.getString("diretor"));
            fm.setElenco(rs.getString("elenco"));
            fm.setClassificacao(rs.getString("classificacao"));
            fm.setSinopse(rs.getString("sinopse"));
            fm.setDuracao(rs.getString("duracao"));
            fm.setDataLancamento(rs.getString("datalancamento"));
            fm.setGeneros(rs.getString("genero"));
            filmes.add(fm);
        }

        return filmes;
    }
}
