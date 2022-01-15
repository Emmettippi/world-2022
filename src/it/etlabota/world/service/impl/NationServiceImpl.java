package it.etlabota.world.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.etlabota.world.dto.NationDto;
import it.etlabota.world.mapper.NationMapper;
import it.etlabota.world.model.Nation;
import it.etlabota.world.service.NationService;
import it.etlabota.world.util.DbConnection;

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
		List<NationDto> nations = new ArrayList<>();

		try {
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM nation";

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			Nation nation;
			while (rs.next()) {
				nation = new Nation();
				nation.setId(rs.getLong("id"));
				nation.setNome(rs.getString("nome"));
				nation.setCodice(rs.getString("codice"));
				nations.add(nationMapper.toDto(nation));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nations;
	}
}
