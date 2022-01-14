package it.etlabota.world.dto;

import java.util.List;

public class NationDto {
	private Long id;
	private String codice;
	private String nome;
	private Long population;
	private Long idCapital;
	private Double area;
	private String governmentType;
	private Short middleAge;
	private String pathFlag;
	private List<CityDto> cities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
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

	public Long getIdCapital() {
		return idCapital;
	}

	public void setIdCapital(Long idCapital) {
		this.idCapital = idCapital;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getGovernmentType() {
		return governmentType;
	}

	public void setGovernmentType(String governmentType) {
		this.governmentType = governmentType;
	}

	public Short getMiddleAge() {
		return middleAge;
	}

	public void setMiddleAge(Short middleAge) {
		this.middleAge = middleAge;
	}

	public String getPathFlag() {
		return pathFlag;
	}

	public void setPathFlag(String pathFlag) {
		this.pathFlag = pathFlag;
	}

	public List<CityDto> getCities() {
		return cities;
	}

	public void setCities(List<CityDto> cities) {
		this.cities = cities;
	}
}
