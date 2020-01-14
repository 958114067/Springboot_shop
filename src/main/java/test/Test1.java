package test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.regex.Pattern;

public class Test1 {
    private static String decrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) {
        try {
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = Base64.getDecoder().decode(sSrc); //先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original, encodingFormat);
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(decrypt(getData(), "UTF-8", "1234667890123456", "1234567892546398"));
    }

    public static String getData() {
        return
"x3EtCKEbhKbeBkisDSESqLJtpXyC2+0anH65EKJqtYVmwQZz8o66k1P7JGK5qG4TQgIBm2N9c6BTdfDfOh5/8F7+T0EnZnqX0DVX/5X+hMA4hjw23s3g4REOM4ei/C8qsfPjef2USuznjWw+eXSldgu0k4XDz8VFRHTS69e8++3xm6aLSPLcm/mRqK7PLfENXmwDvL70po4DqevcAlECOum6qLbTwx+GtjO7RsT1/1Jl7sBmFz4nZGmgg8gfP9nUztwtqcTVa7WZQS1jhPnXIOvuNJojXY4eTfv/05O63D9tKZvy1YVtkbnB4CNEwKIhaA12e3J0JX1IovNF1en3aFC6yYFODYE+axXCmPLg9Wc1fVnPdn2WLqTJDCPikE7s1fkoqazm/C958K3iI9lbNO5OGc8/0dUYGuCQ+jnOAYSWYcpglGdJgdybKD4AyKuiT8qwPGKMdI/UG/WhiRRruUZX9WX90DJ0UgZF0tO/9Fv0ypqu3FrQ/CzYpRxTmoH+";}}
