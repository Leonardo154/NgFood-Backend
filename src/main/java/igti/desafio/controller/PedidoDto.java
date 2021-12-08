package igti.desafio.controller;

import java.util.List;

import igti.desafio.modelo.Product;

public class PedidoDto {
	private List<ItemPedidoDto> itens;

	public List<ItemPedidoDto> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoDto> itens) {
		this.itens = itens;
	}

	public static class ItemPedidoDto {
		private Product product;
		private Integer quantity;

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
	}
}