package com.thoughtworksoftwares.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.thoughtworksoftwares.dao.IGenericDomainDao;

@Repository
public class GenericDomainDaoImpl implements IGenericDomainDao{

	private static final Logger LOG = LoggerFactory.getLogger(GenericDomainDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Map<String, Object>> getList() {
		String query = "SELECT ID, FIRST_NAME, LAST_NAME, DOB, GENDER, DOJ FROM EMPLOYEES LIMIT 0, 50";
		LOG.info("Fetching Data...");
		return jdbcTemplate.query(query, new RowMapper<Map<String, Object>>() {
			@Override
			public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
				ResultSetMetaData metaData = rs.getMetaData();
				Map<String, Object> dataMap = Collections.synchronizedMap(new LinkedHashMap<String, Object>());
				for(int i=1; i<=metaData.getColumnCount(); i++) {
					dataMap.put(metaData.getColumnName(i), rs.getObject(metaData.getColumnName(i)));
				}
				return dataMap;
			}
		});
	}
}
