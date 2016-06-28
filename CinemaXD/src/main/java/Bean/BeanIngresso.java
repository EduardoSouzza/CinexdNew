/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import RecomendacaoFilmes.ConectaBanco;
import classes.Ingresso;
import java.sql.SQLException;
import javax.faces.event.ActionEvent;
import classes.Filmes;
import classes.Teste;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.validation.ValidationException;

/**
 *
 * @author Marcelo
 */
@ManagedBean(name = "crudIngresso")
@SessionScoped
public class BeanIngresso {

    private int total = 0;
    private int identificador;
    boolean ocupado = false;
    Ingresso ingresso = new Ingresso();
    Filmes filme = new Filmes();
    Teste testeRelatorio = new Teste();
    ArrayList<Ingresso> listaIngresso = new ArrayList<Ingresso>();
    ArrayList<Teste> listaRelatorio = new ArrayList<Teste>();

    public BeanIngresso() {
        ingresso.setValor(20.5);
        ingresso.setPoltrona("H5");
    }

    public String comprarIngresso(ActionEvent ae, String nomeFilme) throws ClassNotFoundException, SQLException {
        listaIngresso = ConectaBanco.selectAllIngresso();
        ocupado = true;
        for (int i = 0; i < listaIngresso.size(); i++) {             
            if((listaIngresso.get(i).getPoltrona()) == (ingresso.getPoltrona())
                    && (listaIngresso.get(i).getDataFilme() == ingresso.getDataFilme())
                    && (listaIngresso.get(i).getSala() == ingresso.getSala())
                    && (listaIngresso.get(i).getHorario()== ingresso.getHorario())){                    
                    ocupado = true;
            }
        }
        filme = ConectaBanco.selectFilme(nomeFilme);
        ingresso.setIdFilme(filme.getId());
        ConectaBanco.createIngresso(ingresso);
        ConectaBanco.ingressoComprado(filme.getId(), ingresso.getDataFilme());
        return "index";
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public String carregarFilme(ActionEvent ae, String nome) throws ClassNotFoundException, SQLException {
        try {
            filme = ConectaBanco.selectFilme(nome);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return "CadIngressos";
    }

    public Filmes getFilme() {
        return filme;
    }

    public void setFilme(Filmes filme) {
        this.filme = filme;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Teste getTesteRelatorio() {
        return testeRelatorio;
    }

    public void setTesteRelatorio(Teste testeRelatorio) {
        this.testeRelatorio = testeRelatorio;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    

    public String relatorioIngresso(ActionEvent ae) throws ClassNotFoundException, SQLException {
        try {
            //Retornou todos ingressos comprados
            listaIngresso = ConectaBanco.selectAllIngresso();
            identificador = listaIngresso.get(0).getIdFilme();
            for (int i = 0; i < listaIngresso.size(); i++) {
                testeRelatorio.setId(listaIngresso.get(i).getIdFilme());
            }
            testeRelatorio.setTotal(listaIngresso.size());
            listaRelatorio.add(testeRelatorio);
            return "Relatorios";
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO: " + ex);
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
        }
        return "Relatorios";
    }

    public void checkedSelectOneRadioValue(FacesContext context, UIComponent component, Object value) throws ValidationException {

    }

}
