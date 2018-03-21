package com.moj.anagrammer.services;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moj.anagrammer.dao.WordListDao;

@Service
public class AnagramsService {
	
	@Autowired
	private WordListDao wordListDao;
	
	Logger log = LoggerFactory.getLogger(AnagramsService.class);
	
	
	public Set<String> find(String wordToFind) {
		
		long startTime = System.currentTimeMillis();
		
		 int worldToFindLen = wordToFind.length();
		
		char[] sortedWordToFind = wordToFind.replaceAll("[\\s]", "").toCharArray();
		Arrays.sort(sortedWordToFind);
		
		Set<String> anagramsList = wordListDao.getWordList().stream()
				.filter(w -> { 
					return checkAnagram(w, sortedWordToFind, worldToFindLen);					
				}).collect(Collectors.toSet());	
		
	    log.info("time for word " + wordToFind + " : " + (System.currentTimeMillis() - startTime));
	    
	    return anagramsList;
	}
	
	
	private boolean checkAnagram(String wordToCheck, char[] sortedWordToFind, int wordToFindLength) {
		
		if(wordToCheck.length() != wordToFindLength) { return false; };
		
		char[] sortedWordToCheck = wordToCheck.replaceAll("[\\s]", "").toCharArray();
	    
	    Arrays.sort(sortedWordToCheck);
	    
		return Arrays.equals(sortedWordToCheck, sortedWordToFind);
				
	}
	
}
