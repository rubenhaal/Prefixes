package com.test.startswith.Prefixes.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.*;
@Component
public class PrefixDictionary {

    private Map<String, List<String>>  prefixes;

    @Value("${app.file:sample_examples}")
    private String file;

    public PrefixDictionary(){
        if(file==null || file.isEmpty()){
            file= "prefixes.txt";
        }
        loadPrefixes();

    }

    public  void loadPrefixes(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);

        this.prefixes= new HashMap<>();
        if (inputStream == null) {
            throw new RuntimeException("File not found: "+file);
        }
        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line
                String firstChar= line.substring(0,1);
                List<String> pre= prefixes.get(firstChar);
                if(prefixes.get(firstChar)==null){
                    pre= new ArrayList<>();
                    prefixes.put(firstChar,pre);
                }
                if(!pre.contains(line)){
                    pre.add(line);
                }
            }
        }

        for(String key: prefixes.keySet()){
            List<String> values= prefixes.get(key);
            Collections.sort(values, (s1,s2)-> Integer.compare(s2.length(), s1.length()));
        }

    }

    public  void loadPrefixes(String file){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);

        this.prefixes= new HashMap<>();
        if (inputStream == null) {
            throw new RuntimeException("File not found:"+ file);
        }
        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line
                if(!line.isEmpty()) {
                    String firstChar = line.substring(0, 1);
                    List<String> pre = prefixes.get(firstChar);
                    if (prefixes.get(firstChar) == null) {
                        pre = new ArrayList<>();
                        prefixes.put(firstChar, pre);
                    }
                    if (!pre.contains(line)) {
                        pre.add(line);
                    }
                }
            }
        }

        for(String key: prefixes.keySet()){
            List<String> values= prefixes.get(key);
            Collections.sort(values, (s1,s2)-> Integer.compare(s2.length(), s1.length()));
        }

    }
    public Map<String, List<String>> getPrefixes(){
        return prefixes;
    }

}
