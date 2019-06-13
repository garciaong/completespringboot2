package com.garcia.springbootweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garcia.springbootweb.entity.Player;
import com.garcia.springbootweb.repository.PlayerRepository;

@Service("playerService")
public class PlayerService {

	@Autowired
	private PlayerRepository repo;
	
	public List<Player> getPlayers(){
		return repo.findAll();
	}
	
	public Player getPlayerById(Integer id) {
		return repo.findById(id).get();
	}
	
}
