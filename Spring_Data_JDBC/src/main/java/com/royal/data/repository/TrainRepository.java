package com.royal.data.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.royal.data.entity.Train;

@Repository
public class TrainRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	public TrainRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private final RowMapper<Train> rowMapper = (rs, rowNum) -> {
		Train train = new Train();
		train.setId(rs.getInt("id"));
		train.setName(rs.getString("name"));
		train.setOrigin(rs.getString("origin"));
		train.setDestination(rs.getString("destination"));
		return train;
	};
	
	public List<Train> findAll() {
		return jdbcTemplate.query("SELECT * FROM trains", rowMapper);
	}
	
	public Train findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM trains WHERE id = ?", rowMapper, id);
	}
	
	public void save(Train train) {
		jdbcTemplate.update("INSERT INTO trains (name, origin, destination) VALUES (?, ?, ?)", train.getName(), train.getOrigin(), train.getDestination());
	}
	
	public void update(Train train) {
		jdbcTemplate.update("UPDATE trains SET name=?, origin=?, destination=? WHERE id=?", train.getName(), train.getOrigin(), train.getDestination(), train.getId());
	}
	
	public void deleteById(int id) {
		jdbcTemplate.update("DELETE FROM trains WHERE id=?", id);
	}
}
