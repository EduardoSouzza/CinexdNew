package classes;

import java.util.ArrayList;

class Estado {

    public int id;
    public String nome;
    public ArrayList<Cidade> cidade;

    public Estado(int id, String nome, ArrayList<Cidade> cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cidade> getCidade() {
        return cidade;
    }

    public void setCidade(ArrayList<Cidade> cidade) {
        this.cidade = cidade;
    }
    
    

}
