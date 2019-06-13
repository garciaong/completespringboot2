package com.garcia.springbootweb.rest.model;

import java.util.List;

import com.garcia.springbootweb.entity.Player;

import lombok.Data;

@Data
public class PlayerResp {

	private String info;
	private List<Player> player;
	
	public PlayerResp(String info) {
		this.info = info;
	}
	
}
