/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Filme;

/**
 *
 * @author gustavo
 */
public class FilmeDao extends GenericDao {
    
    public void salvar(Filme filme) {
        savePojo(filme);
    }
    
    public void atualizar(Filme filme) {
        savePojo(filme);
    }
    
    public void excluir(Filme filme) {
        removePojo(filme);
    }
    
    public Filme buscarFilme(Integer idFilme) {
        String sql = "select f from Filme f where f.idFilme = ?1";
        
        return (Filme) getPojo(sql, idFilme);
    }
    
    public List<Filme> listar() {
        String sql = "select f from Filme f";
        
        return getPureList(Filme.class, sql);
    }
    
}
