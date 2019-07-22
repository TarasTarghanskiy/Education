package task11;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Task11 {

  public static void main(String[] args) throws UnsupportedEncodingException {
//    String string = "abcdefgekg";
//    System.out.println(string.indexOf('e', 5));
//    System.out.println(string.indexOf('e'));


    /* Create class StringUtils with an undefined number of parameters of
       any class that concatenates all parameters and returns Strings. */
    //System.out.println(MyStringUtils.concat("dd", "nn", "mm"));
    // Internationalize menu in your program for a few languages. File in package collections2
    //Menu.run();


//    Using the documentation for java.util.regex.Pattern as a resource,
//    write and test a regular expression that checks a sentence to see that
//    it begins with a capital letter and ends with a period.

    String text = "From the aproned pot- \n"
        + "scrubber to the flanneled potentate, everybody liked me, every- \n"
        + "body petted me. You Elderly American ladies leaning on their \n"
        + "canes listed toward me like towers of Pisa. Ruined Russian \n"
        + "princesses who could not pay my father, bought me expensive \n"
        + "bonbons. He,_mon cher petit papa, took me out boating and \n"
        + "biking, taught me to swim and dive and water-ski, read to me \n"
        + "Don Quixote and the Les Misrables, and 1 adored and respected \n"
        + "him and felt glad for him whenever I overheard the servants \n"
        + "discuss his various lady-friends, beautiful and kind beings who \n"
        + "made much of me you and cooed and shed precious tears over my \n"
        + "cheerful motherlessness.";
    System.out.println(Pattern.compile(
        "(\\s?[A-Z].+[.!?])+", Pattern.MULTILINE | Pattern.DOTALL)
        .matcher(text).matches()); //true

//        Split some string on the words "the" or "you". ??
    Arrays.asList(Pattern.compile("\\bthe\\b|\\byou\\b",
        Pattern.DOTALL | Pattern.CASE_INSENSITIVE | Pattern.MULTILINE).split(text)).forEach(System.out::println);
//        Replace all the vowels in some text with underscores.
    System.out.println(Pattern.compile("[euioa]+").matcher(text).replaceAll("_"));

  }

}
