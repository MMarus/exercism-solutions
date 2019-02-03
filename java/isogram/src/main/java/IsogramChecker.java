import java.util.HashSet;

class IsogramChecker {

    public static boolean isIsogram(String phrase) {
        final HashSet<Character> chars = new HashSet<>();

        for(int i = 0; i < phrase.length(); i++) {
            Character character = Character.toLowerCase(phrase.charAt(i));

            if (Character.isAlphabetic(character) && chars.add(character) == false)
                return false;
        }
        return true;
    }
//
//    public static boolean isIsogram2(String phrase) {
//        phrase = phrase.replace("-", "").replace(" ", "").toLowerCase();
//        return phrase.chars().distinct().count() == phrase.length();
//    }
}
