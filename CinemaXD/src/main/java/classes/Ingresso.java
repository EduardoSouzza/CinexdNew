/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Marcelo
 */
public class Ingresso {
    private Filmes idFilme;
    private String dataFilme;
    private int valor;
    private int sala;
    private String poltrona;
    private String horario;
    
    public Ingresso(){
        
    }

    public Ingresso(Filmes idFilme, String dataFilme, int valor, int sala, String poltrona, String horario) {
        this.idFilme = idFilme;
        this.dataFilme = dataFilme;
        this.valor = valor;
        this.sala = sala;
        this.poltrona = poltrona;
        this.horario = horario;
    }

    public Filmes getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Filmes idFilme) {
        this.idFilme = idFilme;
    }

    public String getDataFilme() {
        return dataFilme;
    }

    public void setDataFilme(String dataFilme) {
        this.dataFilme = dataFilme;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(String poltrona) {
        this.poltrona = poltrona;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
     
}

