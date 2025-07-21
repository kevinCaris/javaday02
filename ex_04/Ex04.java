import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
public class Ex04 {

     private static String md5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 non supporté sur cette machine");
        }
    }
    public static HashMap<String, String> myPasswordHash(String password){
        HashMap<String, String> result = new HashMap<>();

        byte[] saltBytes = new byte[16];
        new SecureRandom().nextBytes(saltBytes);
        String salt = Base64.getEncoder().encodeToString(saltBytes);

            String hash = md5Hash(password + salt);

        result.put("salt", salt);
        result.put("hash", hash);

        return result;
    }

    public static boolean myPasswordVerify(String password, String salt, String hash) {
        String computedHash = md5Hash(password + salt);
        return computedHash.equals(hash);
    }
    public static void main(String[] args) {
        HashMap<String, String> result = myPasswordHash("toto");
        System.out.println(result);
        System.out.println(myPasswordVerify("toto", result.get("salt"), result.get("hash")));
    }
}