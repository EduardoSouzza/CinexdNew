/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import RecomendacaoFilmes.ConectaBanco;
import classes.Filmes;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "crFilmes")
@RequestScoped
public class CrudFilmes implements Serializable {

    Filmes fm = new Filmes();
    String nomeFilme;
    String msgDeletado;
    int idFilme;

    @PostConstruct
    public void init() {

    }

    public String selectFilme(ActionEvent e, String nf) throws InterruptedException {
        try {
            System.out.println("nome do filme index " + nf);
            fm = ConectaBanco.selectFilme(nf);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return "CadFilmes";
    }

    public String inserir(ActionEvent e) {
        try {
            System.out.println("filmesss" + fm.getNome());
            ConectaBanco.createFilmes(fm);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrudFilmes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrudFilmes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "index";
    }

    public String updateFilme(ActionEvent e) throws ClassNotFoundException, SQLException {
        ConectaBanco.updateFilme(fm);
        return "index";
    }

    public String deleteFilme(ActionEvent e, int id) throws ClassNotFoundException, SQLException {
        System.out.println("id index" + id);
        ConectaBanco.deleteFilme(id);
        return "index";
    }

    public Filmes getFm() {
        return fm;
    }

    public void setFm(Filmes fm) {
        this.fm = fm;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

}
