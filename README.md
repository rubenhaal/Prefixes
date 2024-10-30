# Getting Started

### Prefix find
This app will try to find the longest prefix for a word in a list of prefixes.

To do that we already have a file with loaded prefixes, in resources "sample_prefixes.txt".

Those prefixes will be loaded on start and processes to make the search as quick as we can.

### Prefixes processing
There are two kind of processing that would be done only when the application start:

1. First create a Map with the first letter of the prefix as key, and the value the list of prefixes we have for that letter
2. Order those list from longest to shortest, so when we try to find the prefix the first one will be the longest

### How to run it

1. There are a few test in the class PrefixesServiceTest.java
2. To try the actual application Launch as Springboot the main class PrefixesApplication
3. Load swagger to check the endpoints: http://localhost:8080/swagger-ui/index.html#/prefix-controller


###Improvements