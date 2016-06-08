/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recomendação_de_Filmes;

import classes.Filmes;
import classes.Perfil_Filme;
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

            lista_de_filmes.add(fm);
        }
        return lista_de_filmes;
    }
    
    public Perfil_Filme getPerfil(int id_filmes) throws SQLException, ClassNotFoundException{
        Connection c = ConectaBancoProvisório.conectaBanco();
        PreparedStatement p = c.prepareStatement("select * from Perfil where id_filme = ?;");
        p.setInt(1, id_filmes);
        ResultSet r = p.executeQuery();
        Perfil_Filme perfil = new Perfil_Filme();
        while(r.next()){
            
        }
        return perfil;
        
    }

}
