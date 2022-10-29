package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        char[] words = s.toCharArray();
        int i = 0;
        int l = 0;
        for (;i < words.length; i++) {
            if (words[i] == ' ' || i == words.length - 1) {
                int r = (i == words.length - 1) ? i : i - 1;
                while (l < r) {
                    char tmp = words[l];
                    words[l] = words[r];
                    words[r] = tmp;
                    l++;
                    r--;
                }
                l = i + 1;
            }
        }
        return new String(words);
    }

}
