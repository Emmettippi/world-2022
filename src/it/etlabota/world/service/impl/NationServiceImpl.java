package it.etlabota.world.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.MysqlType;

import it.etlabota.world.dto.NationDto;
import it.etlabota.world.mapper.NationMapper;
import it.etlabota.world.model.Nation;
import it.etlabota.world.service.NationService;
import it.etlabota.world.util.DbConnection;

public class NationServiceImpl implements NationService {

	private NationMapper nationMapper = new NationMapper();

	@Override
	public NationDto create(NationDto dto) {
		if (dto == null) {
			return null;
		}
		if (dto.getId() != null) {
			return this.update(dto);
		}
		NationDto savedDto = null;
		try {
			Connection conn = DbConnection.getConnection();
			Nation entity = nationMapper.toModel(dto);
			String sql = "INSERT INTO nation \n" +
				"(codice, nome, population, id_capitale, superficie, government_type, middle_age, path_flag) \n" +
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?) \n";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, entity.getCodice());
			statement.setString(2, entity.getNome());
			statement.setLong(3, entity.getPopulation()); // DOES NOT ACCEPTS NULL
			statement.setObject(4, entity.getIdCapital(), MysqlType.BIGINT); // DOES ACCEPTS NULL
			statement.setObject(5, entity.getArea(), MysqlType.DOUBLE);
			statement.setObject(6, entity.getGovernmentType(), MysqlType.VARCHAR);
			statement.setObject(7, entity.getMiddleAge(), MysqlType.FIELD_TYPE_SHORT);
			statement.setObject(8, entity.getPathFlag(), MysqlType.VARCHAR);
			//			statement.setObject(4, entity.getIdCapital(), MysqlType.BIGINT);
			//			statement.setObject(5, entity.getArea(), MysqlType.DOUBLE);
			//			statement.setObject(6, entity.getGovernmentType(), MysqlType.VARCHAR);
			//			statement.setObject(7, entity.getMiddleAge(), MysqlType.FIELD_TYPE_SHORT);
			//			statement.setObject(8, entity.getPathFlag(), MysqlType.VARCHAR);

			statement.executeUpdate();

			String sql2 = "SELECT MAX(id) FROM nation";
			PreparedStatement statement2 = conn.prepareStatement(sql2);
			ResultSet rs = statement2.executeQuery();
			rs.next();
			Long id = rs.getLong(1);
			conn.close();

			savedDto = this.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return savedDto;
	}

	@Override
	public NationDto update(NationDto dto) {
		if (dto == null) {
			return null;
		}
		if (dto.getId() == null) {
			return this.create(dto);
		}
		NationDto savedDto = null;
		try {
			Connection conn = DbConnection.getConnection();
			Nation entity = nationMapper.toModel(dto);
			String sql = "UPDATE nation \n"
				+ "SET codice=?, nome=?, population=?, id_capitale=?, superficie=?, government_type=?"
				+ ", middle_age=?, path_flag=? \n"
				+ "WHERE id=? \n";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, entity.getCodice());
			statement.setString(2, entity.getNome());
			statement.setLong(3, entity.getPopulation()); // DOES NOT ACCEPTS NULL
			statement.setObject(4, entity.getIdCapital(), MysqlType.BIGINT); // DOES ACCEPTS NULL
			statement.setObject(5, entity.getArea(), MysqlType.DOUBLE);
			statement.setObject(6, entity.getGovernmentType(), MysqlType.VARCHAR);
			statement.setObject(7, entity.getMiddleAge(), MysqlType.FIELD_TYPE_SHORT);
			statement.setObject(8, entity.getPathFlag(), MysqlType.VARCHAR);
			statement.setLong(9, entity.getId());
			//			statement.setLong(4, entity.getIdCapital());
			//			statement.setDouble(5, entity.getArea());
			//			statement.setString(6, entity.getGovernmentType());
			//			statement.setShort(7, entity.getMiddleAge());
			//			statement.setString(8, entity.getPathFlag());
			//			statement.setLong(9, entity.getId());

			int updated = statement.executeUpdate();
			if (updated != 1) {
				throw new Exception("Entity has been deleted");
			}

			conn.close();

			savedDto = this.getOne(entity.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return savedDto;
	}

	@Override
	public NationDto getOne(Long id) {
		if (id == null) {
			return null;
		}
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
			nation.setPopulation(rs.getLong("population"));
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
