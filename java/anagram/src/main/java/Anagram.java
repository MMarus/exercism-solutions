package anagram.src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marek Marusic <mmarusic@redhat.com> on 2/6/19.
 */
public class Anagram {
    private String anagramLowercase;
    private char[] sortedAnagram;

    public Anagram(String anagram) {
        anagramLowercase = anagram.toLowerCase();
        sortedAnagram = sortedLowercase(anagram);
    }

    private char[] sortedLowercase(String s) {
        char[] res = s.toLowerCase().toCharArray();
        Arrays.sort(res);
        return res;
    }

    public List<String> match(List<String> asList) {
        List<String> matchedAnagrams = new ArrayList<>();

        for (String s : asList) {
            if (!s.toLowerCase().equals(anagramLowercase)
                    && Arrays.equals(sortedLowercase(s), sortedAnagram)) {
                matchedAnagrams.add(s);
            }

        }
        return matchedAnagrams;
    }

}
