package com.garcia.springbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garcia.springbootweb.entity.Player;

@Repository("playerRepository")
public interface PlayerRepository extends JpaRepository<Player,Integer>{

}
