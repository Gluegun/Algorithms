package rabin_karp;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RabinKarpExtended {
    private String text;

    public RabinKarpExtended(String text) {
        this.text = text;
    }

    public List<Integer> search (String pattern) {
        int alphabetLength = 256;
        int q = 101;

        ArrayList<Integer> indices = new ArrayList<>();

        int patternLength = pattern.length();
        int textLength = text.length();

        int j;

        int patternHash = 0;
        int textHash = 0;
        int h = 1;


        for (int i = 0; i < patternLength - 1; i++) {
            h = (h * alphabetLength) % q;
        }

        for (int i = 0; i < patternLength; i++) {

            patternHash = (alphabetLength * patternHash + pattern.charAt(i)) % q;
            textHash = (alphabetLength * textHash + text.charAt(i)) % q;

        }


        for (int i = 0; i <= textLength - patternLength; i++) {


            if (patternHash == textHash) {

                for (j = 0; j < patternLength; j++) {

                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == patternLength) {
                    indices.add(i);
                }
            }

            if (i < textLength - patternLength) {

                textHash = (alphabetLength * (textHash - text.charAt(i) * h) + text.charAt(i + patternLength)) % q;
                if (textHash < 0) {
                    textHash = (textHash + q);
                }
            }
        }
        return indices;
    }
}