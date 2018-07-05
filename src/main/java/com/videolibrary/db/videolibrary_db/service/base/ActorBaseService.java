package com.videolibrary.db.videolibrary_db.service.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.videolibrary.db.videolibrary_db.entity.Actor;
import com.videolibrary.db.videolibrary_db.service.ActorService;

//IMPORT RELATIONS
import com.videolibrary.db.videolibrary_db.entity.Film;

@Service
public class ActorBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
    //CRUD - CREATE
    	
	public Actor insert(Actor obj) {
		Long id = jdbcTemplate.queryForObject("select max(_id) from `actor`", new MapSqlParameterSource(), Long.class);
		obj.set_id(id == null ? 1 : id + 1);
		String sql = "INSERT INTO `actor` (`_id`, ,`FilmObj`) VALUES (:id,, :FilmObj )";
			SqlParameterSource parameters = new MapSqlParameterSource()
		    .addValue("id", obj.get_id())
			.addValue("FilmObj", obj.getFilmObj());
		
		jdbcTemplate.update(sql, parameters);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM `Actor` WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
    //CRUD - GET ONE
    	
	public Actor get(Long id) {
	    
		String sql = "select * from `Actor` where `_id` = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return (Actor) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper(Actor.class));
	}


    	
        	
    //CRUD - GET LIST
    	
	public List<Actor> getList() {
	    
		String sql = "select * from `Actor`";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Actor.class));
	    
	    
	}

    	
    //CRUD - EDIT
    	
	public Actor update(Actor obj, Long id) {

		String sql = "UPDATE `Actor` SET  , `FilmObj` = :FilmObj  WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("FilmObj", obj.getFilmObj());
		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in ActorService.java
     */
    

}
