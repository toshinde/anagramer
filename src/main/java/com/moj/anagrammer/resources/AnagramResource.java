package com.moj.anagrammer.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moj.anagrammer.services.AnagramsService;

@RequestMapping("/anagrams")
@RestController
public class AnagramResource {

	Logger log = LoggerFactory.getLogger(AnagramResource.class);
	
	@Autowired
	private AnagramsService wordListService;
	
	@GetMapping("/{anagram}")
public Map<String, Set<String>> find(@PathVariable(value="anagram") List<String> anagramWords) {
		
		long startTime = System.currentTimeMillis();
		
		Map<String, Set<String>> anagrams = new HashMap<String, Set<String>>();
		
		anagramWords.stream().forEach(a -> {
				anagrams.put(a, wordListService.find(a));
		});
		
		log.info("Total time: " + (System.currentTimeMillis() - startTime));
		
		return anagrams;
		
	}

	
	
}
