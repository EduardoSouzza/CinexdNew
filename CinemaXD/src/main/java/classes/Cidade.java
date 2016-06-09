package classes;

class Cidade {
    
    public int id;
    public String nome;
    public int idEstado;

    public Cidade(int id, String nome, int idEstado) {
        this.id = id;
        this.nome = nome;
        this.idEstado = idEstado;
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

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
    
}
