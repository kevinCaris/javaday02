import java.util.HashMap;
public class Ex05 {

    public static HashMap<String, String> myAddElemMap(String key, String newvalue, HashMap<String, String> map) {
        if(key == null || newvalue == null || map == null){
            System.out.println("Vous devez fournir des paramètres valides ");
        }
        map.put(key, newvalue);
        return map;
    }
    public static HashMap<String, String> myDeleteElemMap(String key, HashMap<String, String> map) {
        if(key == null || map == null){
            System.out.println("Vous devez fournir des paramètres valides ");
        }
        map.remove(key);
        return map;
    }

    public static HashMap<String, String> myModifyElemMap(String key, String newvalue, HashMap<String, String> map) {
        if(key == null || newvalue == null || map == null || !map.containsKey(key)){
            System.out.println("Vous devez fournir des paramètres valides ");
        }
        map.put(key, newvalue);
        return map;
    }

   public static boolean myIsElemValid(String key, String value, HashMap<String, String> map) {
        if (key == null || value == null || map == null) {
            System.out.println("Vous devez fournir des paramètres valides\n");
            return false;
        }
        return map.containsKey(key) && value.equals(map.get(key));
    }
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map = myAddElemMap("first", "baris", map);
        map = myAddElemMap("second", "toto", map);
        map = myAddElemMap("third", "life", map);
        map = myModifyElemMap("third", "42", map);
        map = myDeleteElemMap("second", map);
        System.out.println(map);
        System.out.println(myIsElemValid("third", "42", map));
    }
}