/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecomendacaoFilmes;

import classes.Filmes;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class TEste {
    
     public static void main(String[] args) throws ClassNotFoundException, SQLException {

        List<Filmes> fmRcomendado;
       
            fmRcomendado = ConectaBanco.listAll();
            for (int i = 0; i < fmRcomendado.size(); i++) {
                System.out.println(fmRcomendado.get(i).getNome());
            }
        

    }
    
}
