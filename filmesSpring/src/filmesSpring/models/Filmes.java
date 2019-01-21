package filmesSpring.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Filmes {

	private Long id;
	private String titulo;
	private String genero;
	private String diretor;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataLancamento;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public Calendar getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	@Override
	public String toString() {
		return "Filmes [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", diretor=" + diretor
				+ ", dataLancamento=" + dataLancamento + "]";
	}
	
	
	
}