package igti.desafio.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemOrder {

	public ItemOrder() {
	}

	public ItemOrder(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;

	@Column(name = "quantity")
	private Integer quantity;

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
