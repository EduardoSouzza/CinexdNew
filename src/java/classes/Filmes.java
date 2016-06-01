package classes;

import java.util.Calendar;

public class Filmes {
    public String id;
        public String nome;
        public String elenco;
        public String diretor;
        public String classificacao;
        public String sinopse;
        public String duracao;
        public Calendar dataLancamento;
        public String generos;

    public Filmes(String id, String nome, String elenco, String diretor, String classificacao, String sinopse, String duracao, Calendar dataLancamento, String generos) {
        this.id = id;
        this.nome = nome;
        this.elenco = elenco;
        this.diretor = diretor;
        this.classificacao = classificacao;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.dataLancamento = dataLancamento;
        this.generos = generos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }


    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }
    
}
