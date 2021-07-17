/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Categoria;

/**
 *
 * @author gustavo
 */
public class CategoriaDao extends GenericDao {
    
    public void salvar(Categoria categoria) {
        savePojo(categoria);
    }
    
    public void atualizar(Categoria categoria) {
        savePojo(categoria);
    }
    
    public void excluir(Categoria categoria) {
        removePojo(categoria);
    }
    
    public Categoria buscarCategoria(Integer idCategoria) {
        String sql = "select c from Categoria c where c.idCategoria = ?1";
        
        return (Categoria) getPojo(sql, idCategoria);
    }
    
    public List<Categoria> listar() {
        String sql = "select c from Categoria c";
        
        return getPureList(Categoria.class, sql);
    }
    
}
