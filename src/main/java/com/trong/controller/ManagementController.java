package com.trong.controller;

import com.trong.PlayerManager;
import com.trong.dto.PlayerInformation;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log
public class ManagementController {

	@PostMapping("/create-player")
	public String createPlayer(@ModelAttribute("playerInformation") PlayerInformation playerInformation, Model model) {
		PlayerManager.getInstance().createPlayer(playerInformation);
		model.addAttribute("playerName", playerInformation.getName());
		return "player";
	}
}
