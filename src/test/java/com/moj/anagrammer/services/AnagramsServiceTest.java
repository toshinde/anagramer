package com.moj.anagrammer.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.moj.anagrammer.dao.WordListDao;

@RunWith(MockitoJUnitRunner.class)
public class AnagramsServiceTest {

	@Mock
	private WordListDao wordListDao;
	
	@InjectMocks
	private AnagramsService serviceToTest;
	
	List<String> testWordsList;
	
	@Before
	public void setUp() {
		testWordsList = Arrays.asList("river", "mountain", "RIVER", "MOUNTAIN", "verri", "tainmoun", "rive", "tain", "", " ");
	}
	
	@Test
	/**
	 * Test to check if anagram is found for given string
	 * 
	 * Condition:
	 * - Valid string passed
	 * - Is anagram of more than one strings to search 
	 * 
	 * Expected Result:
	 * - Expected list of anagrams returned
	 * 
	 */
	public void testFind() {
		
		String test_find_word = "erriv";
		
		when(wordListDao.getWordList()).thenReturn(testWordsList);
		
		Set<String> expectedResults = new HashSet<>(Arrays.asList("river", "verri"));
		
		Set<String> results = serviceToTest.find(test_find_word);
		
		assertTrue(results.equals(expectedResults));
				
	}
	
	@Test
	/**
	 * Test to check if anagram is found for given string
	 * 
	 * Condition:
	 * - empty string passed ""
	 * 
	 * Expected Result:	
	 * - No anagram returned
	 * x
	 */
	public void testFind_empty_word() {
		
		String test_find_word = " ";
		
		when(wordListDao.getWordList()).thenReturn(testWordsList);
		
		Set<String> expectedResults = new HashSet<>(Arrays.asList(" "));
		
		Set<String> results = serviceToTest.find(test_find_word);
		
		assertTrue(results.equals(expectedResults));
				
	}

}
