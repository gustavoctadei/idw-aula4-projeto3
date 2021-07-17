/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Endereco;

/**
 *
 * @author gustavo
 */
public class EnderecoDao extends GenericDao {
    
    public void salvar(Endereco endereco) {
        savePojo(endereco);
    }
    
    public void atualizar(Endereco endereco) {
        savePojo(endereco);
    }
    
    public void excluir(Endereco endereco) {
        removePojo(endereco);
    }
    
    public Endereco buscarEndereco(Integer idEndereco) {
        String sql = "select e from Endereco e where e.idEndereco = ?1";
        
        return (Endereco) getPojo(sql, idEndereco);
    }
    
    public List<Endereco> listar() {
        String sql = "select e from Endereco e";
        
        return getPureList(Endereco.class, sql);
    }
    
}
