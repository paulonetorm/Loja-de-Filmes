package filmesSpring.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Vendas {
	private Long id;
	private Clientes cliente;
	private Filmes filme;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	Calendar dataVenda;
	private String Status;
	
	public Vendas() {
		this.Status = "processando";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Filmes getFilme() {
		return filme;
	}

	public void setFilme(Filmes filme) {
		this.filme = filme;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Vendas [id=" + id + ", cliente=" + cliente + ", filme=" + filme + ", dataVenda=" + dataVenda
				+ ", Status=" + Status + "]";
	}

}
