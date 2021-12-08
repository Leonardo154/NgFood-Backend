package igti.desafio.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import igti.desafio.modelo.ItemOrder;
import igti.desafio.modelo.Order;
import igti.desafio.repository.PedidoRepository;

@RestController
@Transactional
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/pedidos")
	public List<Order> listaPedidos() {
		return pedidoRepository.findAll(Sort.by("dataHour").descending());
	}

	@PostMapping("/pedidos")
	public Order realizaPedido(@RequestBody PedidoDto pedido) {
		var entidadePedido = new Order();
		entidadePedido.setDataHour(LocalDateTime.now());
		entidadePedido.setSituation(Order.SITUACAO_AGUARDANDO);
		entidadePedido.setItens(pedido.getItens().stream()
				.map(item -> new ItemOrder(item.getProduct(), item.getQuantity())).collect(Collectors.toList()));

		return pedidoRepository.save(entidadePedido);
	}

	@GetMapping("/pedidos/{idPedido}")
	public Order obtemPedido(@PathVariable Integer idPedido) {
		return pedidoRepository.findById(idPedido).get();
	}

	@PutMapping("/pedidos/{idPedido}/situacao")
	public Order atualizaSituacaoPedido(@PathVariable Integer idPedido,
			@RequestParam(required = true) String novaSituacao) {
		Order pedido = pedidoRepository.findById(idPedido).get();
		pedido.setSituation(novaSituacao);
		pedidoRepository.save(pedido);
		return pedido;
	}
}
