package com.test.startswith.Prefixes.controller;

import com.test.startswith.Prefixes.services.PrefixesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrefixController {

    @Autowired
    PrefixesService prefixesService;

    @GetMapping(path = "findPrefix/{word}")
    public String findPrefix(@PathVariable String word){
        return prefixesService.findLongestPrefix(word);
    }
}
