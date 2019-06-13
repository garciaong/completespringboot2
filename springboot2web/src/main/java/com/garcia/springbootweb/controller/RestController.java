package com.garcia.springbootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garcia.springbootweb.rest.model.PlayerResp;
import com.garcia.springbootweb.service.PlayerService;

import lombok.extern.log4j.Log4j2;

@org.springframework.web.bind.annotation.RestController
@Log4j2
public class RestController {

	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello "+name;
    }
	
	@GetMapping(value="/players", produces = "application/json")
	public ResponseEntity<PlayerResp> listPlayers() {
		try {
			log.info("Invoking '/players' endpoint");
			PlayerResp response = new PlayerResp("List of English Premier League's Players");
			response.setPlayer(playerService.getPlayers());
			
			return new ResponseEntity<PlayerResp>(response, HttpStatus.OK);
		} catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<PlayerResp>(new PlayerResp("Endpoint invocation failed! Error : ["+e+"]"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
    }
}
