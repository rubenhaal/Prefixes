package com.test.startswith.Prefixes.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrefixesServiceTest {

    private PrefixDictionary prefixDictionary;

    @Test
    void shouldFindPrefix_whenMethodIsCallWithAShortNumberOfPrefixes() {

        //Given
        prefixDictionary = new PrefixDictionary();
        prefixDictionary.loadPrefixes("test_examples.txt");

        PrefixesService prefixesServiceTest = new PrefixesService(prefixDictionary);
        String result = prefixesServiceTest.findLongestPrefix("interact");
        assertEquals("inter", result);

    }

    @Test
    void shouldFindShorterPrefix_whenMethodIsCallWithAShortNumberOfPrefixes() {

        //Given
        prefixDictionary = new PrefixDictionary();
        prefixDictionary.loadPrefixes("test_examples.txt");

        PrefixesService prefixesServiceTest = new PrefixesService(prefixDictionary);
        String result = prefixesServiceTest.findLongestPrefix("incoming");
        assertNotEquals("inter", result);
        assertEquals("in", result);

    }

    @Test
    void shouldNotFindPrefix_whenMethodIsCallWithAShortNumberOfPrefixes() {

        //Given
        prefixDictionary = new PrefixDictionary();
        prefixDictionary.loadPrefixes("test_examples.txt");

        PrefixesService prefixesServiceTest = new PrefixesService(prefixDictionary);
        String result = prefixesServiceTest.findLongestPrefix("zzzzzzzzzzzzzz");
        assertTrue(result.isEmpty());


    }


    @Test
    void shouldFindPrefix_whenMethodIsCallWithABigNumberOfPrefixes() {

        //Given
        prefixDictionary = new PrefixDictionary();
        prefixDictionary.loadPrefixes("prefixes.txt");

        PrefixesService prefixesServiceTest = new PrefixesService(prefixDictionary);
        String result = prefixesServiceTest.findLongestPrefix("msqiep3343333");
        assertEquals("msqiep", result);

    }

}