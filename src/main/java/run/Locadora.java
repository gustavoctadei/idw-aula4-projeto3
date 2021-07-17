/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import dao.CategoriaDao;
import dao.ClienteDao;
import dao.EnderecoDao;
import dao.FilmeDao;
import dao.LocacaoDao;
import dao.MidiaDao;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Categoria;
import model.Cliente;
import model.Endereco;
import model.Filme;
import model.Locacao;
import model.Midia;

/**
 *
 * @author gustavo
 */
public class Locadora {
    
    public static void main(String[] args) {
        Locadora locadora = new Locadora();
        locadora.cadastraCategorias();
        locadora.cadastraFilmes();
        locadora.cadastraMidias();
        
        locadora.cadastraEndereco();
        locadora.cadastraCliente();
        locadora.cadastraLocacao();
    }
    
    private void cadastraCategorias() {
        String[] categorias = {"Aventura", "Ação", "Comédia"};
        
        Categoria categoria = null;
        CategoriaDao categoriaDao = new CategoriaDao();
        
        for (int i = 0; i < categorias.length; i++) {
            categoria = new Categoria();
            categoria.setDescricao(categorias[i]);
            categoriaDao.salvar(categoria);
        }
    }
    
    private void cadastraFilmes() {
        String[] filmesDescricao = {"Senhor dos Anéis", "Transformers", "Ghostbusters"};
        Date[] filmesAnoProducao = {new Date(2001-1900, 11, 19), new Date(2007-1900, 6, 20), new Date(1985-1900, 1, 1)};
        
        Filme filme = null;
        FilmeDao filmeDao = new FilmeDao();
        
        for (int i = 0; i < filmesDescricao.length; i++) {
            filme = new Filme();
            filme.setDescricao(filmesDescricao[i]);
            filme.setAno(filmesAnoProducao[i]);
            filme.setIdCategoria( new Categoria(i + 1) );
            
            filmeDao.salvar(filme);
        }
    }
    
    private void cadastraMidias() {
        Midia midia = null;
        
        MidiaDao midiaDao = new MidiaDao();
        FilmeDao filmeDao = new FilmeDao();
        
        List<Filme> listaFilme = filmeDao.listar();
        
        for (Filme f : listaFilme) {
            midia = new Midia();
            midia.setIdFilme(f);
            midia.setInutilizada(false);
            
            midiaDao.salvar(midia);
        }
    }
    
    private void cadastraEndereco() {
        Endereco endereco = new Endereco();
        EnderecoDao enderecoDao = new EnderecoDao();
        
        endereco.setBairro("Centro");
        endereco.setCep("78.900-000");
        endereco.setCidade("Porto Velho");
        endereco.setComplemento("Casa");
        endereco.setNumero("11111");
        endereco.setRua("Av. Carlos Gomes");
        endereco.setEstado("RO");
        
        enderecoDao.salvar(endereco);
    }
    
    private void cadastraCliente() {
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        
        cliente.setCelular("(69) 9 9999-9999");
        cliente.setEmail("gustavo@email.com");
        cliente.setNome("Gustavo Tadei");
        cliente.setTelefone("(69) 3333-3333");
        cliente.setIdEndereco(new Endereco(1));
        
        clienteDao.salvar(cliente);
    }
    
    private void cadastraLocacao() {
        Locacao locacao = new Locacao();
        LocacaoDao locacaoDao = new LocacaoDao();
        
        locacao.setIdCliente(new Cliente(1));
        locacao.setIdMidia(new Midia(1));
        locacao.setDataEmprestimo(new Date());
        locacao.setDataDevolucao( calculaDataDevolucao(locacao.getDataEmprestimo()) );
        locacao.setObservacao("Devolução após dois dias");
        
        locacaoDao.salvar(locacao);
    }
    
    private Date calculaDataDevolucao(Date dataEmprestimo) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataEmprestimo);
        
        calendar.add(Calendar.DATE, 2);
        
        Date dataDevolucao = calendar.getTime();
        
        return dataDevolucao;
    }
    
}
