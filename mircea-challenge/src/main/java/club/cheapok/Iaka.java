package club.cheapok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Iaka {
    static char[] result = new char[30];
    static int counter;

    public static void main(String[] args) {
        String cool = "Eugen";
        permutate(cool);
        System.out.println(counter);

    }

    private static void permutate(final String cool) {
        List<Character> chars = new ArrayList<>();
        for (char c : cool.toCharArray()) {
            chars.add(c);
        }
        perm2(chars,0);
    }


    public static void perm2(List<Character> list, int len) {
        //stop case
        if (list.size() == 1) {
            result[len] = list.get(0);
            System.out.println(Arrays.toString(result));
            counter++;
            return;
        }
        // main
        for (int i = 0; i < list.size(); i++) {
            result[len] = list.get(i);
            List<Character> copy = removeIndex(list, i);
            perm2(copy,len+1);
        }
    }

    private static List<Character> removeIndex(final List<Character> list, final int i) {
        List<Character> copy = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            if(j!=i) copy.add(list.get(j));
        }
        return copy;
    }

}
