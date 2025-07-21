import java.util.*;

public class Ex08 {
    public static ArrayList<ArrayList<String>> myOrderClassName(Object... objs) {
        HashMap<Integer, TreeSet<String>> map = new HashMap<>();

        for (Object obj : objs) {
            String className = (obj == null) ? "null" : obj.getClass().getSimpleName();
            int len = className.length();

            map.putIfAbsent(len, new TreeSet<>(String.CASE_INSENSITIVE_ORDER));
            map.get(len).add(className);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<Integer> lengths = new ArrayList<>(map.keySet());
        Collections.sort(lengths);

        for (Integer len : lengths) {
            result.add(new ArrayList<>(map.get(len)));
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(true);
        list.add(76);
        list.add(false);
        list.add(12.5);
        list.add("Coucou !");
        list.add(new int[]{1, 2, 3});
        list.add(new MyClass());
        list.add(null);

        System.out.println(myOrderClassName(list.toArray()));
        // Résultat attendu :
        // [[null], [int[]], [Double, String], [Boolean, Integer, MyClass]]
    }
}
class MyClass {
    // Une classe vide pour le test
}
