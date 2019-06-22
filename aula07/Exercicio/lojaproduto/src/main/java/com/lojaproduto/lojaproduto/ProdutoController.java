package com.lojaproduto.lojaproduto;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestController
public class ProdutoController {
    HashMap<Integer, Produto> hash;

    public ProdutoController(){
        hash = new HashMap<>();
        Produto p = new Produto();
        p.setId(1);
        p.setNome("Cerveja skol");
        p.setValor(10.0);
        hash.put(p.getId(), p);
    }

    @RequestMapping(value = "/produtosGET", method = RequestMethod.GET)
    public ArrayList<Produto> RequisicaoGet() {
        Produto p = new Produto();
        p.setId(1);
        p.setNome("Cerveja skol");
        p.setValor(10D);
        hash.put(p.getId(),p);
        return (ArrayList<Produto> )hash.values().stream().collect(Collectors.toList());
    }

    @RequestMapping(value = "/produtosPOST", method = RequestMethod.POST)
    public ArrayList<Produto> RequisicaoPOST(@RequestBody Produto produto) {
        hash.put(produto.getId(),produto);
        return (ArrayList<Produto> )hash.values().stream().collect(Collectors.toList());
    }

    @RequestMapping(value = "/produtosPUT/{id}", method = RequestMethod.PUT)
    public Produto RequisicaoPut(@PathVariable Integer id, @RequestBody Produto produto) {
        Produto oldProduto = hash.get(id);
        oldProduto.setValor(produto.getValor());
        oldProduto.setNome(produto.getNome());
        hash.replace(id,oldProduto);
        return oldProduto;
    }

    @RequestMapping(value = "/produtosDelete/{id}", method = RequestMethod.DELETE)
    public ArrayList<Produto> RequisicaoDelete(@PathVariable Integer id) {
        hash.remove(id);
        return (ArrayList<Produto>)hash.values().stream().collect(Collectors.toList());
    }

}
