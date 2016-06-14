/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Produto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo Kuya
 */
public class CrudProduto implements Crud {

    @Override
    public void inserir(Object p) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = ss.beginTransaction();
        try {
            ss.save((Produto) p);
            ts.commit();
        } catch (Exception ex) {
            ts.rollback();
            throw ex;
        } finally {
            HibernateUtil.close(ss);
        }
    }

    @Override
    public void alterar(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Object p) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = ss.beginTransaction();
        try {
            ss.delete((Produto) p);
            ts.commit();
        } catch (Exception ex) {
            ts.rollback();
            throw ex;
        } finally {
            HibernateUtil.close(ss);
        }
    }

    @Override
    public List list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
