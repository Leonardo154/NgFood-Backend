package igti.desafio.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;

@Entity(name = "t_order")
public class Order {

	public static String SITUACAO_AGUARDANDO = "Aguardando";
	public static String SITUACAO_EM_PREPARACAO = "Em preparação";
	public static String SITUACAO_SAIU_PARA_ENTREGA = "Saiu para entrega";
	public static String SITUACAO_ENTREGUE = "Entregue";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
	@Column(name = "id_order")
	private Integer id;

	@Column(name = "data_hour")
	private LocalDateTime dataHour;

	@Column(name = "situation")
	private String situation;

	@ElementCollection
	@CollectionTable(name = "item_order", joinColumns = { @JoinColumn(name = "id_order") })
	@OrderBy("product")
	private List<ItemOrder> itens = new ArrayList<>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataHour() {
		return this.dataHour;
	}

	public void setDataHour(LocalDateTime dataHour) {
		this.dataHour = dataHour;
	}

	public String getSituation() {
		return this.situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public List<ItemOrder> getItens() {
		return this.itens;
	}

	public void setItens(List<ItemOrder> itens) {
		this.itens = itens;
	}

}
