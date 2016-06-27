/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import classes.Cliente;
import classes.Filmes;
import classes.PerfilCliente;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class BeanRecomendacao {

    /**
     * Creates a new instance of jSFFilmes
     */
    public BeanRecomendacao() {
    }
    
    public List<Filmes> getALL() throws ClassNotFoundException, SQLException{
        Cliente use = new Cliente();
        use.setId_cliente(1);
        use.setNome("Karina");
        PerfilCliente p = new PerfilCliente();
        p.setAcao(4);
        p.setAnimação(2);
        p.setComedia(3);
        p.setDocumentario(4);
        p.setDrama(3);
        p.setRomance(1);
        p.setTerror(0);
        use.setPerfil(p);
        
        return RecomendacaoFilmes.RecomendaFilmes.recomenda(use);
        
    }
    
}
