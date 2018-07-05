package com.videolibrary.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.PropertySource;

import com.videolibrary.controller.base.ActorBaseController;

@RestController
@PropertySource("classpath:${configfile.path}/VideoLibrary.properties")
@RequestMapping(value="${endpoint.api}", headers = "Accept=application/json")
public class ActorController extends ActorBaseController {

	//OVERRIDE HERE YOUR CUSTOM CONTROLLER

}
