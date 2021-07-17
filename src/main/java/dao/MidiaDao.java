/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Midia;

/**
 *
 * @author gustavo
 */
public class MidiaDao extends GenericDao {
    
    public void salvar(Midia midia) {
        savePojo(midia);
    }
    
    public void atualizar(Midia midia) {
        savePojo(midia);
    }
    
    public void excluir(Midia midia) {
        removePojo(midia);
    }
    
    public Midia buscarMidia(Integer idMidia) {
        String sql = "select m from Midia m where m.idMidia = ?1";
        
        return (Midia) getPojo(sql, idMidia);
    }
    
    public List<Midia> listar() {
        String sql = "select m from Midia m";
        
        return getPureList(Midia.class, sql);
    }
    
}
