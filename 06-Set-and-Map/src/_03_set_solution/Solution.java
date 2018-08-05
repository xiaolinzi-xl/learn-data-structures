package _03_set_solution;

import java.util.HashSet;

/**
 * LeetCode 804
 * <p>
 * Created by xiaolinzi on 2018/8/5.
 */
public class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(code[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
