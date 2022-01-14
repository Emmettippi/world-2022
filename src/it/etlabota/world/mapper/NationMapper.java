package it.etlabota.world.mapper;

import java.util.ArrayList;
import java.util.List;

import it.etlabota.world.dto.NationDto;
import it.etlabota.world.model.City;
import it.etlabota.world.model.Nation;

public class NationMapper {

	private CityMapper cityMapper = new CityMapper();

	public NationDto toDto(Nation nation) {
		return toDto(nation, null);
	}

	public NationDto toDto(Nation nation, List<City> cities) {
		if (nation == null) {
			return null;
		}
		NationDto dto = new NationDto();
		dto.setId(nation.getId());
		dto.setArea(nation.getArea());
		dto.setCodice(nation.getCodice());
		dto.setGovernmentType(nation.getGovernmentType());
		dto.setIdCapital(nation.getIdCapital());
		dto.setMiddleAge(nation.getMiddleAge());
		dto.setNome(nation.getNome());
		dto.setPathFlag(nation.getPathFlag());
		dto.setPopulation(nation.getPopulation());
		dto.setCities(cityMapper.toDto(cities));
		return dto;
	}

	public Nation toModel(NationDto dto) {
		if (dto == null) {
			return null;
		}
		Nation nation = new Nation();
		nation.setId(dto.getId());
		nation.setArea(dto.getArea());
		nation.setCodice(dto.getCodice());
		nation.setGovernmentType(dto.getGovernmentType());
		nation.setIdCapital(dto.getIdCapital());
		nation.setMiddleAge(dto.getMiddleAge());
		nation.setNome(dto.getNome());
		nation.setPathFlag(dto.getPathFlag());
		nation.setPopulation(dto.getPopulation());
		return nation;
	}

	public List<NationDto> toDto(List<Nation> nations) {
		if (nations == null) {
			return null;
		}
		List<NationDto> dtos = new ArrayList<>();
		for (Nation nation : nations) {
			dtos.add(toDto(nation));
		}
		return dtos;
	}

	public List<Nation> toModel(List<NationDto> dtos) {
		if (dtos == null) {
			return null;
		}
		List<Nation> nations = new ArrayList<>();
		for (NationDto dto : dtos) {
			nations.add(toModel(dto));
		}
		return nations;
	}
}
