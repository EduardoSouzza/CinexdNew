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
public class jSFFilmes {

    /**
     * Creates a new instance of jSFFilmes
     */
    public jSFFilmes() {
    }
    
    public List<Filmes> getALL() throws ClassNotFoundException, SQLException{
        Cliente use = new Cliente();
        use.setId_cliente(1);
        use.setNome("Karina");
        PerfilCliente p = new PerfilCliente();
        p.setAcao(5);
        p.setAnimação(0);
        p.setComedia(5);
        p.setDocumentario(0);
        p.setDrama(2);
        p.setRomance(3);
        p.setTerror(0);
        use.setPerfil(p);
        
        return RecomendacaoFilmes.RecomendaFilmes.recomenda(use);
        
    }
    
}
