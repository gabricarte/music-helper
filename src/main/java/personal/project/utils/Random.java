package personal.project.utils;

import java.util.List;

public class Random {
    public static String sortElement(List<String> list) {
        java.util.Random rand = new java.util.Random();

        int randomI = rand.nextInt(list.size());

        return list.get(randomI);
    }
}
