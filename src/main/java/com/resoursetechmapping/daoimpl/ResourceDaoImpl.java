package com.resoursetechmapping.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.resoursetechmapping.bean.Resource;
import com.resoursetechmapping.dao.ResourceDao;

class ResourceMapper implements RowMapper<Resource> {
	public Resource mapRow(ResultSet rs, int arg1) throws SQLException {
		Resource resource = new Resource();
		resource.setId(rs.getInt("id"));
		resource.setFirstName(rs.getString("firstname"));
		resource.setMiddleName(rs.getString("middlename"));
		resource.setLastName(rs.getString("lastname"));
		resource.setListOfTechWorkedOn(rs.getString("technologies"));
		resource.setCertification(rs.getString("certifications"));
		resource.setProjects(rs.getString("projects"));
		resource.setApplicationWorkLoadType(rs.getString("applicationtype"));
		return resource;
	}
}

@Repository
public class ResourceDaoImpl implements ResourceDao {

	private JdbcTemplate jdbcTemplate;

	public ResourceDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addResourece(Resource resource) {
		String addResourece = "insert into resourcemapping values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(addResourece,
				new Object[] { resource.getId(), resource.getFirstName(), resource.getMiddleName(),
						resource.getLastName(), resource.getListOfTechWorkedOn(), resource.getCertification(),
						resource.getProjects(), resource.getApplicationWorkLoadType() });
	}

	public Resource getResource(String idOrName) {
		String sql = "SELECT * FROM resourcemapping WHERE id= ?";
		return jdbcTemplate.queryForObject(sql, new ResourceMapper(), idOrName);
	}
}
