package hello;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskPiAccount {
    public static Integer checkForPi(int account) {


//        final String regex = "(?i)((up)|(down)|(unknown)(name)|(account)|(age))";
        final String regex = "(?i)([0-9]{8})";

//        final String input = "Account Name 45676543 testtest foo bar UP down Unknown unknown up  supern";
        final String subst = "**MASKED**";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(String.valueOf( account ));

// The substituted value will be contained in the result variable
        final String result = matcher.replaceAll(subst);

        System.out.println("Substitution result: " + result);

        return  Integer.valueOf( result );




    }
}
