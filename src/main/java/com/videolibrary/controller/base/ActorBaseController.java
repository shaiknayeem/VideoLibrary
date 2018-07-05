package com.videolibrary.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.videolibrary.db.videolibrary_db.service.ActorService;
import com.videolibrary.db.videolibrary_db.entity.Actor;

//IMPORT RELATIONS
import com.videolibrary.db.videolibrary_db.entity.Film;

public class ActorBaseController {
    
    @Autowired
	ActorService actorService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "/actors", method = RequestMethod.POST, headers = "Accept=application/json")
	public Actor insert(@RequestBody Actor obj) {
		Actor result = actorService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/actors/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		actorService.delete(id);
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/actors/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Actor get(@PathVariable Long id) {
		Actor obj = actorService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/actors", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Actor> getList() {
		return actorService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/actors/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Actor update(@RequestBody Actor obj, @PathVariable("id") Long id) {
		Actor result = actorService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
