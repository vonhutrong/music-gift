package com.trong.controller;

import com.trong.model.Command;
import com.trong.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private PlayerService playerService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("listUrl", playerService.getListUrl());
		return "home";
	}

	@MessageMapping("/add-url")
	@SendTo("/topic/public")
	public Command addUrl(@Payload Command command) {
		playerService.addUrl(command.getArgument());
		return command;
	}
}
