package com.trong;

import com.trong.dto.PlayerInformation;
import com.trong.model.Player;
import lombok.extern.java.Log;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Log
public class PlayerManager {
	private static PlayerManager instance;
	private HashSet<Player> listPlayer = new HashSet<>();

	private PlayerManager() {
	}

	public static PlayerManager getInstance() {
		if (instance == null) {
			instance = new PlayerManager();
		}
		return instance;
	}

	public void createPlayer(PlayerInformation playerInformation) {
		Player player = new Player();
		player.setName(playerInformation.getName());
		listPlayer.add(player);
	}
}
