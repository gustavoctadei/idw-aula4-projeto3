/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author gustavo
 */
public class ClienteDao extends GenericDao {
    
    public void salvar(Cliente cliente) {
        savePojo(cliente);
    }
    
    public void atualizar(Cliente cliente) {
        savePojo(cliente);
    }
    
    public void excluir(Cliente cliente) {
        removePojo(cliente);
    }
    
    public Cliente buscarCliente(Integer idCliente) {
        String sql = "select c from Cliente c where c.idCliente = ?1";
        
        return (Cliente) getPojo(sql, idCliente);
    }
    
    public List<Cliente> listar() {
        String sql = "select c from Categoria c";
        
        return getPureList(Cliente.class, sql);
    }
    
}
