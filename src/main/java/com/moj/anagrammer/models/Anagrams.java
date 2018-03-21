package com.moj.anagrammer.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("")
public class Anagrams {
		
	private Map<String, List<String>> anagrams = new HashMap<String, List<String>>();

	public Map<String, List<String>> getAnagrams() {
		return anagrams;
	}

	public void setAnagrams(Map<String, List<String>> anagrams) {
		this.anagrams = anagrams;
	} 
	
}
