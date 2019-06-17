package com.garcia.springbootweb;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.garcia.springbootweb.entity.Player;
import com.garcia.springbootweb.repository.PlayerRepository;
import com.garcia.springbootweb.service.PlayerService;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerServiceTest {

	@Autowired
	private PlayerService service;
	
	@MockBean
    private PlayerRepository repo;
	
	@Test
	public void testGetPlayerById() {
		Player leno = new Player();
    	leno.setId(3);
    	leno.setName("Leno");
    	leno.setPosition("Goalkeeper");
    	leno.setClub("Arsenal FC");
	 
    	when(repo.findById(leno.getId())).thenReturn(Optional.of(leno));
		
	    Player player = service.getPlayerById(3);
	  
	     assertEquals("Leno", player.getName());
	 }
	
}
