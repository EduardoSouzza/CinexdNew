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
public class Teste {

    private int id;
    private int Maximo;
    private int Total;

    public Teste() {
    }

    public Teste(int id, int Maximo, int Total) {
        this.id = id;
        this.Maximo = Maximo;
        this.Total = Total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaximo() {
        return Maximo;
    }

    public void setMaximo(int Maximo) {
        this.Maximo = Maximo;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
    
}
