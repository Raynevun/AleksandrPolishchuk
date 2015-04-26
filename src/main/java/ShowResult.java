import java.util.*;

public class ShowResult {


    public static void getResponse(String s) {
        Map<Character, Integer> redirect = new HashMap<Character, Integer>();
        System.out.println("INPUT" + s);


        List<Character> charList = new ArrayList<Character>();


        for (char c : s.toCharArray()) {
            charList.add(c);
        }
        Set<Character> stringSet = new HashSet<Character>();
        stringSet.addAll(charList);
        System.out.println(charList.toString());
        System.out.println(stringSet.toString());
        for (Character temp : stringSet) {
          //  System.out.println("temp" + temp);
          //  System.out.println(temp + ": " + Collections.frequency(charList, temp));
            redirect.put(temp, Collections.frequency(charList, temp));

        }
    }
}
