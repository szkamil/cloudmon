package hello;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskPiString {
    public static String checkForPi(String data) {


//        final String regex = "(?i)((up)|(down)|(unknown)(name)|(account)|(age))";
        final String regex = "(?i)((pair)|(up)|(down)(java)(xml))";

//        final String input = "Account Name 45676543 testtest foo bar UP down Unknown unknown up  supern";
        final String subst = "**MASKED**";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(data);

// The substituted value will be contained in the result variable
        final String result = matcher.replaceAll(subst);

        System.out.println("Substitution result: " + result);

        return result;




    }
}
