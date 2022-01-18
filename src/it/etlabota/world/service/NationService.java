package it.etlabota.world.service;

import java.util.List;

import it.etlabota.world.dto.NationDto;

public interface NationService {

	/**
	 * dto.id has to be null (it'll be ignored)
	 */
	public NationDto create(NationDto dto);

	/**
	 * Id must not be null
	 */
	public NationDto update(NationDto dto);

	/**
	 * Id must not be null
	 */
	public NationDto getOne(Long id);

	/**
	 * Id must not be null
	 */
	public void delete(Long id);

	public List<NationDto> getAll();
}
