package it.etlabota.world.service.impl;

import java.util.List;

import it.etlabota.world.dto.NationDto;
import it.etlabota.world.mapper.NationMapper;
import it.etlabota.world.service.NationService;

public class NationServiceImpl implements NationService {

	private NationMapper nationMapper = new NationMapper();

	@Override
	public NationDto create(NationDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NationDto update(NationDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NationDto getOne(Long id) {
		// TODO Auto-generated method stub
		// resultSet = select * from nation where id = ?
		// nation = resultSet
		// list<city> = select * from city where id_nation = nation.id
		// dto = mapper(nation, list<city>)
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<NationDto> getAll() {
		// TODO Auto-generated method stub
		// resultSet = select * from nation
		// list model nation = resultSet
		// list dto nation = mapper(list model nation)
		return null;
	}
}
