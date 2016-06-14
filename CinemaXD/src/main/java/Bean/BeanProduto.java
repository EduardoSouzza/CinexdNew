/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.Crud;
import DAO.CrudProduto;
import classes.Produto;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rodrigo Kuya
 */
@ManagedBean
@SessionScoped
public class BeanProduto implements Serializable{
    
    Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
   
    public String inserir(ActionEvent actionEvent){
        Crud dao = new CrudProduto();
        dao.inserir(produto);
        return "index";
    }
    
    public String remover(ActionEvent actionEvent){
        Crud dao = new CrudProduto();
        dao.remover(produto);
        return "index";
    }
    
    public void prepararProduto(ActionEvent actionEvent){
        produto = new Produto();
    }

}
