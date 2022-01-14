package it.etlabota.world.model;

public class City {
	private Long id;
	private String nome;
	private Long population;
	private Double area;
	private Long idNation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Long getIdNation() {
		return idNation;
	}

	public void setIdNation(Long idNation) {
		this.idNation = idNation;
	}
}
