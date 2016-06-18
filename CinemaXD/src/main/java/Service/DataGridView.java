package Service;

import RecomendacaoFilmes.ConectaBanco;
import classes.Filmes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DataGridView implements Serializable {

    private List<Filmes> filmes;

    private Filmes selectedFilmes;

    @ManagedProperty("#{filmesService}")
    private FilmeService service;

    @PostConstruct
    public void init() {
        filmes = service.createFilmes(48);

        try {
            ConectaBanco.createFilmes(filmes.get(0));
        } catch (Exception e) {
        }

    }

    public List<Filmes> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filmes> filmes) {
        this.filmes = filmes;
    }

    public Filmes getSelectedFilmes() {
        return selectedFilmes;
    }

    public void setSelectedFilmes(Filmes selectedFilmes) {
        this.selectedFilmes = selectedFilmes;
    }

    public FilmeService getService() {
        return service;
    }

    public void setService(FilmeService service) {
        this.service = service;
    }

}
