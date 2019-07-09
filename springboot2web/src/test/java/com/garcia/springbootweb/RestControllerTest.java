package com.garcia.springbootweb;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.garcia.springbootweb.entity.Player;
import com.garcia.springbootweb.service.PlayerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerTest {

	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private PlayerService playerService;
    
    @WithMockUser("USER")
    @Test
    public void testPlayerEndpoint() throws Exception {
    	Player leno = new Player();
    	leno.setId(1);
    	leno.setName("Leno");
    	leno.setPosition("Goalkeeper");
    	leno.setClub("Arsenal FC");
    	 
        List<Player> playerList = Arrays.asList(leno);
     
        when(playerService.getPlayers()).thenReturn(playerList);
     
        mvc.perform(get("/players")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().contentType(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$.player[0].name").value("Leno"));
    }
	
}
