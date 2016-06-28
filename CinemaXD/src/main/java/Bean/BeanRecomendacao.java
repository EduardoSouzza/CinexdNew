/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import RecomendacaoFilmes.ConectaBanco;
import classes.Cliente;
import classes.Filmes;
import classes.PerfilCliente;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class BeanRecomendacao {
    
    Cliente cli = new Cliente();
    /**
     * Creates a new instance of jSFFilmes
     */
    public BeanRecomendacao() {
    }
    
    public List<Filmes> getALL() throws ClassNotFoundException, SQLException{
       
        return RecomendacaoFilmes.RecomendaFilmes.recomenda(cli);
        
    }
    
    public String direct(ActionEvent e ,String nome) throws SQLException, ClassNotFoundException{
        cli = ConectaBanco.getUser(nome);
        return "TeladeRecomendacao";
    }
    
}
