import java.util.HashMap;
public class Ex02 {

    public static HashMap<Object, Object> myCreateMap(Object[]... arrays) {
        HashMap<Object, Object> map = new HashMap<>();

        for (Object[] arr : arrays) {
            if (arr == null || arr.length < 2) {
                System.out.println("Les arguments donnés ne sont pas valides.");
                return null;
            }
            map.put(arr[0], arr[1]);
        }

        return map;
    }
    public static void main(String[] args) {
        Object[] array1 = {"pi", 3.14};
        Object[] array2 = {"answer", 42};
        Object[] invalid = {"bad"};
        System.out.println(myCreateMap(array1, array2)); 
        myCreateMap(array1,invalid);
    }
}