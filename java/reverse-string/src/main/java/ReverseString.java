
public class ReverseString {

    public String reverse(final String inputString) {
        String[] alphabets = inputString.split("");
        StringBuilder result = new StringBuilder();

        for(int i = 1; i <= inputString.length(); i++) {
            result.append(alphabets[inputString.length() - i]);
        }
        return result.toString();
    }

    public String reverseOneLine(final String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }
  
}