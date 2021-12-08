package igti.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import igti.desafio.modelo.Product;

public interface ProdutoRepository extends JpaRepository<Product, Integer> {

}
