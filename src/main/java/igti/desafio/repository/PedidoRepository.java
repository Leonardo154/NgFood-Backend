package igti.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import igti.desafio.modelo.Order;

public interface PedidoRepository extends JpaRepository<Order, Integer> {

}
