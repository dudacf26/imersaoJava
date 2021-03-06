package com.lojaproduto.lojaproduto;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;
    HashMap<Integer, Produto> hash;

    public ProdutoController() {
      hash = new HashMap<>();
        Produto p = new Produto();
        Produto p1 = new Produto();
        Produto p2 = new Produto();

        p.setId(1);
        p1.setId(2);
        p2.setId(3);

        p.setNome("Cerveja skol");
        p1.setNome("Cerveja skin");
        p2.setNome("Cerveja heineken");

        p.setValor(10.0);
        p1.setValor(20.0);
        p2.setValor(30.0);

        hash.put(p.getId(), p);
        hash.put(p1.getId(), p1);
        hash.put(p2.getId(), p2);

        }

        */


    @GetMapping("/produtosGET/")
    public ArrayList<Produto> RequisicaoGet() {
        Produto p = new Produto();
        p.setId(1);
        p.setNome("Cerveja skol");
        p.setValor(10D);
        hash.put(p.getId(), p);
        return (ArrayList<Produto>) hash.values().stream().collect(Collectors.toList());
    }

    @GetMapping("/produtosGET/{id}")
    public Produto RequisicaoGetPorId(@PathVariable Integer id) {
        Produto oldProduto = hash.get(id);
        return oldProduto;
    }

   // public ArrayList<Produto> RequisicaoPOST(@RequestBody Produto produto) {
    @PostMapping("/produtosPOST")
    public void addProduto (@RequestBody Produto produto) {
            //   hash.put(produto.getId(), produto);
       // return (ArrayList<Produto>) hash.values().stream().collect(Collectors.toList());
        produtoRepository.save(produto);
    }

    @GetMapping("/produtosGET")
    public List<Produto> getAllProdutos(){
        return (List<Produto>) produtoRepository.findAll();
    }

/*
    @PutMapping("/produtosPUT/{id}")
    public Produto getAllProdutos(@PathVariable Integer id, @RequestBody Produto produto){
        Produto oldProduto = produtoRepository.findById(id).get();
        oldProduto.setValor(produto.getValor());
        oldProduto.setNome(produto.getNome());
        produtoRepository.save(oldProduto);
        return oldProduto;
    }
*/

    @DeleteMapping("/produtosDELETE/{id}")
    public void getAllProdutos(@PathVariable Integer id){
        Produto oldProduto = produtoRepository.findById(id).get();
        produtoRepository.delete(oldProduto);
    }

    @PostMapping("/produto/getByNome")
    public List<Produto> getByNome (@RequestBody String nome){
        return produtoRepository.findByNomeContaining(nome);
    }

    @GetMapping("/produto/getEntreValores")
    public List<Produto> getEntreValores (@RequestParam Double valorA, @RequestParam Double valorB){
        return produtoRepository.findByValores(valorA,valorB);
    }
  /*  @GetMapping("/produtosPUT/{id}")
    public Produto RequisicaoPut(@PathVariable Integer id, @RequestBody Produto produto) {
        Produto oldProduto = hash.get(id);
        oldProduto.setValor(produto.getValor());
        oldProduto.setNome(produto.getNome());
        hash.replace(id, oldProduto);
        return oldProduto;
    }

    @GetMapping("/produtosDelete/{id}")
    public ArrayList<Produto> RequisicaoDelete(@PathVariable Integer id) {
        hash.remove(id);
        return (ArrayList<Produto>) hash.values().stream().collect(Collectors.toList());
    }
*/
}
