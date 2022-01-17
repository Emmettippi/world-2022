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
		NationDto dto = null;

		try {
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM nation WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			// "1" is the index 1-based
			// setLong method lets me set the x param as given long
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();

			// while (rs.next()) {
			rs.next();
			Nation nation = new Nation();
			nation.setId(rs.getLong("id"));
			nation.setCodice(rs.getString("codice"));
			nation.setNome(rs.getString("nome"));
			dto = nationMapper.toDto(nation);
			// }

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
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
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nations;
	}
}
