public class RaindropConverter {

    public static String convert(int number) {
        final StringBuilder res = new StringBuilder();

        if (number % 3 == 0) {
            res.append("Pling");
        }
        if (number % 5 == 0) {
            res.append("Plang");
        }
        if (number % 7 == 0) {
            res.append("Plong");
        }
        if (res.length() == 0) {
            res.append(number);
        }
        return res.toString();
    }

}
