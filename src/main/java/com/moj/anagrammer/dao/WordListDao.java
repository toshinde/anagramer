package com.moj.anagrammer.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WordListDao {
	
	Logger log = LoggerFactory.getLogger(WordListDao.class);
	
	private List<String> wordList;
	
	@Value("${wordlist.location}")
	private String wordListLocation;

	@PostConstruct
	public void loadWordList() {
	
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource(wordListLocation).toURI());		
			wordList = Files.lines(path).collect(Collectors.toList());

		} catch (URISyntaxException | IOException e) {
			log.error("Unable to load words list.");
		
		}
	}


	public List<String> getWordList() {
		return wordList;
	}

}
