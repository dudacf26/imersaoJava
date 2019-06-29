package com.lojaproduto.lojaproduto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository <Produto,Integer> {
        List<Produto> findByNome(String nome);
        List<Produto> findByNomeContaining(String nome);

        @Query(value = "select * from produto p " +
                "where p.valor >= :valorA and p.valor <= :valorB", nativeQuery = true)
        List<Produto> findByValores(@Param("valorA")Double valorA, @Param("valorB")Double valorB);



}
