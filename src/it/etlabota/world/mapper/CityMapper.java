package it.etlabota.world.mapper;

import java.util.ArrayList;
import java.util.List;

import it.etlabota.world.dto.CityDto;
import it.etlabota.world.model.City;
import it.etlabota.world.model.Nation;

public class CityMapper {

	private static NationMapper nationMapper = new NationMapper();

	public CityDto toDto(City city) {
		return toDto(city, null);
	}

	public CityDto toDto(City city, Nation nation) {
		if (city == null) {
			return null;
		}
		CityDto dto = new CityDto();
		dto.setId(city.getId());
		dto.setArea(city.getArea());
		dto.setNome(city.getNome());
		dto.setPopulation(city.getPopulation());
		dto.setNation(nationMapper.toDto(nation));
		return dto;
	}

	public City toModel(CityDto dto) {
		if (dto == null) {
			return null;
		}
		City city = new City();
		city.setId(dto.getId());
		city.setNome(dto.getNome());
		city.setArea(dto.getArea());
		city.setPopulation(dto.getPopulation());
		if (dto.getNation() != null) {
			city.setIdNation(dto.getNation().getId());
		}
		return city;
	}

	public List<CityDto> toDto(List<City> cities) {
		if (cities == null) {
			return null;
		}
		List<CityDto> dtos = new ArrayList<>();
		for (City city : cities) {
			dtos.add(toDto(city));
		}
		return dtos;
	}

	public List<City> toModel(List<CityDto> dtos) {
		if (dtos == null) {
			return null;
		}
		List<City> cities = new ArrayList<>();
		for (CityDto dto : dtos) {
			cities.add(toModel(dto));
		}
		return cities;
	}
}
