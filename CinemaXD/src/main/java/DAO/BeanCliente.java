/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import RecomendacaoFilmes.ConectaBanco;
import classes.Cliente;
import classes.Filmes;
import classes.PerfilCliente;
import classes.PerfilFilme;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "crCliente")
@RequestScoped
public class BeanCliente implements Serializable {

    Cliente cli = new Cliente();
    PerfilCliente pf = new PerfilCliente();
    
     double acao;
    double terror;
    double comedia;
    double romance;
    double documentario;
    double drama;
    double animacao;
    double suspense;

    
    
    @PostConstruct
    public void init() {

    }
    
    
    public String inserCliente(ActionEvent e){
        
        try {
            pf.setAcao(acao);
            
            System.out.println(acao + "ssssssssssssssssssssssssssssssss");
            pf.setAnimação(animacao);
            pf.setComedia(comedia);
            pf.setDocumentario(documentario);
            pf.setDrama(drama);
            pf.setRomance(romance);
            pf.setSuspense(suspense);
            pf.setTerror(terror);
            cli.setPerfil(pf);
            ConectaBanco.createUsuario(cli);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "index";
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    
    
    public double getAcao() {
        return acao;
    }

    public void setAcao(double acao) {
        this.acao = acao;
    }

    public double getTerror() {
        return terror;
    }

    public void setTerror(double terror) {
        this.terror = terror;
    }

    public double getComedia() {
        return comedia;
    }

    public void setComedia(double comedia) {
        this.comedia = comedia;
    }

    public double getRomance() {
        return romance;
    }

    public void setRomance(double romance) {
        this.romance = romance;
    }

    public double getDocumentario() {
        return documentario;
    }

    public void setDocumentario(double documentario) {
        this.documentario = documentario;
    }

    public double getDrama() {
        return drama;
    }

    public void setDrama(double drama) {
        this.drama = drama;
    }

    public double getAnimacao() {
        return animacao;
    }

    public void setAnimacao(double animacao) {
        this.animacao = animacao;
    }

    public double getSuspense() {
        return suspense;
    }

    public void setSuspense(double suspense) {
        this.suspense = suspense;
    }
   
}
