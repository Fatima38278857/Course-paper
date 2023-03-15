public class CheckString {

    public static String checkString(String string)throws StringException  {
        if (string == null || string.isEmpty() || string.isBlank()) {
            throw new  StringException("Некоректный вод");
        } else {
            return string;
        }

    }
}