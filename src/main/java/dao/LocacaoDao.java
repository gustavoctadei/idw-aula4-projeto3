/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Locacao;

/**
 *
 * @author gustavo
 */
public class LocacaoDao extends GenericDao {
    
    public void salvar(Locacao locacao) {
        savePojo(locacao);
    }
    
    public void atualizar(Locacao locacao) {
        savePojo(locacao);
    }
    
    public void excluir(Locacao locacao) {
        removePojo(locacao);
    }
    
    public Locacao buscarLocacao(Integer idLocacao) {
        String sql = "select l from Locacao l where l.idLocacao = ?1";
        
        return (Locacao) getPojo(sql, idLocacao);
    }
    
    public List<Locacao> listar() {
        String sql = "select l from Locacao l";
        
        return getPureList(Locacao.class, sql);
    }
    
}
