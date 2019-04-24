import static java.lang.String.format;

public class Proverb {
    private static String firstSentence = "For want of a %s the %s was lost.";
    private static String secondSentence = "And all for the want of a %s.";

    private String[] words;

    public Proverb(String[] words) {
        this.words = words;
    }

    public String recite() {
        StringBuilder res = new StringBuilder();

        if(words.length > 0) {
            for(int i = 0; i < words.length-1; i++) {
                res.append(format(firstSentence, words[i], words[i+1]));
                res.append(System.lineSeparator());
            }
            res.append(format(secondSentence, words[0]));
        }

        return res.toString();
    }
}
