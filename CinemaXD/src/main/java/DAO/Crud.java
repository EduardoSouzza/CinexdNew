/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Rodrigo Kuya
 */
public interface Crud<T> {
    public void inserir(T entity);
    
    public void alterar(T entity);
    
    public void remover(T entity);
    
    public List<T> list();
    
    public T findById(int id);
}
