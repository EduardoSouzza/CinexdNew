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
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "crFilmes")
@ViewScoped
public class CrudFilmes implements Serializable{
    
    Filmes fm = new Filmes();

     @PostConstruct
    public void init() {
        
     
    }

    public Filmes getFm() {
        return fm;
    }

    public void setFm(Filmes fm) {
        this.fm = fm;
    }
    
    public String inserir(ActionEvent e) throws ClassNotFoundException, SQLException{
        ConectaBanco.createFilmes(fm);
        return "index";
    }

}
