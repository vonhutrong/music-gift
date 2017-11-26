package com.trong.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
	private List<String> listUrl = new ArrayList<>();

	public List<String> getListUrl() {
		return listUrl;
	}

	public void addUrl(String url) {
		listUrl.add(url);
	}
}
