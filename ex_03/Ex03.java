import java.security.MessageDigest;
public class Ex03 {

    public static String md5(String password){
        try {
            MessageDigest.getInstance("MD5");
            MessageDigest md=MessageDigest.getInstance("MD5");
            byte[] messageDigest=md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", 0xFF & b));
            }
            return hexString.toString();
        } catch (Exception e) {
            System.out.println("MD5 non disponible");
            return null;
        }
        
    }
    public static void main(String[] args) {
        String passwordhash="21232f297a57a5a743894a0e4a801fc3";
        String[] wordList={"password","azerty","admin", "123456", "qwerty"};

        for(String word : wordList){
            String hashed=md5(word);
            if(hashed.equals(passwordhash)){
                System.out.println("Mot de passe trouvé: "+word);
                break;
            }
        }
    }
}