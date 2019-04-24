public class PigLatinTranslator {

    //vowels: xr, yt, a, e, o,u,i, y (only inside or when yt)
    private static final String VOWELS = "AÀÁÂÃÄÅĀĂĄǺȀȂẠẢẤẦẨẪẬẮẰẲẴẶḀÆǼEȄȆḔḖḘḚḜẸẺẼẾỀỂỄỆĒĔĖĘĚÈÉÊËIȈȊḬḮỈỊĨĪĬĮİÌÍÎÏĲOŒØǾȌȎṌṎṐṒỌỎỐỒỔỖỘỚỜỞỠỢŌÒÓŎŐÔÕÖU";

    public static String translate(String input) {

        String[] words = input.split(" ");
        StringBuilder out = new StringBuilder();
        String space = "";
        int prefixLength;

        for (String word : words) {
            prefixLength = countPrefixLength(word);

            if (prefixLength > 0) {
                //move the consonant || consonant cluster to the end
                word = movePrefixToEnd(word, prefixLength);
            }
            word = addAY(word);
            out.append(space).append(word);
            space = " ";
        }

        return out.toString();
    }

    private static int countPrefixLength(String word) {
        int prefixLength = 0;

        for(int i = 0; i < word.length(); i++) {
            if( (isVowel(word.charAt(i)) || makesVowelSound(word, prefixLength))
                    && ! isUWithPrecedingQ(word, prefixLength)) {
                return prefixLength;
            } else {
                prefixLength++;
            }
        }
        return prefixLength;
    }

    private static String movePrefixToEnd(String input, int prefixLenght) {
        return input.substring(prefixLenght) + input.substring(0, prefixLenght);
    }

    private static String addAY(String input) {
        return input + "ay";
    }

    private static boolean isVowel(char c) {
        return VOWELS.indexOf(Character.toUpperCase(c)) >= 0;
    }

    private static boolean makesVowelSound(String input, int beginIndex){
        return isYInsideOfWord(input, beginIndex) || isXROrYT(input, beginIndex);
    }

    private static boolean isUWithPrecedingQ(String input, int beginIndex) {
        return beginIndex > 0 && input.charAt(beginIndex) == 'u' && input.charAt(beginIndex-1) == 'q';
    }

    private static boolean isYInsideOfWord(String input, int beginIndex) {
        return beginIndex > 0 && input.charAt(beginIndex) == 'y';
    }

    private static boolean isXROrYT(String input, int beginIndex){
        return (input.length() > beginIndex+1 && (
                (input.charAt(beginIndex) == 'x' && input.charAt(beginIndex+1) == 'r' )
                        || (input.charAt(beginIndex) == 'y' && input.charAt(beginIndex+1) == 't' )
        ));
    }


    //a lot nicer solution from community solutions :
//    static String consVocals = "(?!yt|xr)";
//    static String consonants = "(?>qu|[^aeiou ])*";
//    static String pattern = String.format("(?<consonants>%s%s)?(?<rest>\\w+)", consVocals, consonants);
//
//    public static String translate2(String input) {
//        return input.replaceAll(pattern, "${rest}${consonants}ay");
//    }

}