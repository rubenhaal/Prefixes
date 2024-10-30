package com.test.startswith.Prefixes.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class PrefixesService {


    private final PrefixDictionary prefixDictionary;
    public String findLongestPrefix(String word){

        if (word==null || word.isEmpty()){
            return "";
        }

        String findKey = word.substring(0,1);

        List<String> prefixes = prefixDictionary.getPrefixes().get(findKey);

        if(prefixes==null|| prefixes.isEmpty()){
            return "";
        }
        // The List for every word is order from longest to shortest, so the first one should be the longest prefix.
        Optional<String> first = prefixes.stream().filter(word::startsWith).findFirst();

        return first.orElse("");

    }
}
