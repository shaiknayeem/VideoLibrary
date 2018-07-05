package com.videolibrary.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.videolibrary.db.videolibrary_db.service.FilmService;
import com.videolibrary.db.videolibrary_db.entity.Film;

//IMPORT RELATIONS
import com.videolibrary.db.videolibrary_db.entity.Film;

public class FilmBaseController {
    
    @Autowired
	FilmService filmService;



//CRUD METHODS



/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
