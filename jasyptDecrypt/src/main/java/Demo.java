import org.jasypt.util.binary.AES256BinaryEncryptor;
import org.jasypt.util.binary.BasicBinaryEncryptor;
import org.jasypt.util.binary.StrongBinaryEncryptor;
import org.jasypt.util.digest.Digester;
import org.jasypt.util.numeric.*;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.password.rfc2307.RFC2307MD5PasswordEncryptor;
import org.jasypt.util.password.rfc2307.RFC2307SHAPasswordEncryptor;
import org.jasypt.util.password.rfc2307.RFC2307SMD5PasswordEncryptor;
import org.jasypt.util.password.rfc2307.RFC2307SSHAPasswordEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;
import sun.misc.BASE64Encoder;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author: jas502n
 * Create Time: 2021/9/27 星期一
 * Project_Name: jasyptDecrypt
 * Package_Name: PACKAGE_NAME
 */
public class Demo {
    private final static String saltPassword = "passw0rd";

    public static String AES256Encode(String saltPassword, String encodeText) {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(saltPassword);
        return textEncryptor.encrypt(encodeText);
    }

    public static String AES256Decode(String saltPassword, String text) {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(saltPassword);
        return textEncryptor.decrypt(text);

    }

    public static void main(String[] args) {
        try {
            String plainText = "123456";

            // org.jasypt.util.binary
            AES256BinaryEncryptor aes256BinaryEncryptor = new AES256BinaryEncryptor();
            aes256BinaryEncryptor.setPassword(saltPassword);
            System.out.println(new BASE64Encoder().encode(aes256BinaryEncryptor.encrypt(plainText.getBytes())));

            BasicBinaryEncryptor basicBinaryEncryptor =new BasicBinaryEncryptor();
            basicBinaryEncryptor.setPassword(saltPassword);
            System.out.println(new BASE64Encoder().encode(basicBinaryEncryptor.encrypt(plainText.getBytes())));

            StrongBinaryEncryptor strongBinaryEncryptor =new StrongBinaryEncryptor();
            strongBinaryEncryptor.setPassword(saltPassword);
            System.out.println(new BASE64Encoder().encode(strongBinaryEncryptor.encrypt(plainText.getBytes())));


            // org.jasypt.util.numeric
            AES256DecimalNumberEncryptor aes256DecimalNumberEncryptor = new AES256DecimalNumberEncryptor();
            aes256DecimalNumberEncryptor.setPassword(saltPassword);
            System.out.println(aes256DecimalNumberEncryptor.encrypt(new BigDecimal(plainText)));

            AES256IntegerNumberEncryptor aes256IntegerNumberEncryptor = new AES256IntegerNumberEncryptor();
            aes256IntegerNumberEncryptor.setPassword(saltPassword);
            System.out.println(aes256IntegerNumberEncryptor.encrypt(new BigInteger(plainText)));

            BasicDecimalNumberEncryptor basicDecimalNumberEncryptor = new BasicDecimalNumberEncryptor();
            basicDecimalNumberEncryptor.setPassword(saltPassword);
            System.out.println(basicDecimalNumberEncryptor.encrypt(new BigDecimal(plainText)));

            BasicIntegerNumberEncryptor basicIntegerNumberEncryptor = new BasicIntegerNumberEncryptor();
            basicIntegerNumberEncryptor.setPassword(saltPassword);
            System.out.println(basicIntegerNumberEncryptor.encrypt(new BigInteger(plainText)));

            StrongDecimalNumberEncryptor strongDecimalNumberEncryptor = new StrongDecimalNumberEncryptor();
            strongDecimalNumberEncryptor.setPassword(saltPassword);
            System.out.println(strongDecimalNumberEncryptor.encrypt(new BigDecimal(plainText)));

            StrongIntegerNumberEncryptor strongIntegerNumberEncryptor = new StrongIntegerNumberEncryptor();
            strongIntegerNumberEncryptor.setPassword(saltPassword);
            System.out.println(strongIntegerNumberEncryptor.encrypt(new BigInteger(plainText)));

            //  org.jasypt.util.digest
            Digester digester = new Digester();
            System.out.println(new BASE64Encoder().encode(digester.digest(plainText.getBytes())));

            // org.jasypt.util.password
            BasicPasswordEncryptor basicPasswordEncryptor = new BasicPasswordEncryptor();
            System.out.println("BasicPasswordEncryptor: " + basicPasswordEncryptor.encryptPassword(plainText));

            ConfigurablePasswordEncryptor configurablePasswordEncryptor = new ConfigurablePasswordEncryptor();
            System.out.println("ConfigurablePasswordEncryptor: " + configurablePasswordEncryptor.encryptPassword(plainText));


            // org.jasypt.util.password.rfc2307
            RFC2307MD5PasswordEncryptor rfc2307MD5PasswordEncryptor = new RFC2307MD5PasswordEncryptor();
            System.out.println(rfc2307MD5PasswordEncryptor.encryptPassword(plainText));

            RFC2307SHAPasswordEncryptor rfc2307SHAPasswordEncryptor = new RFC2307SHAPasswordEncryptor();
            System.out.println(rfc2307SHAPasswordEncryptor.encryptPassword(plainText));

            RFC2307SMD5PasswordEncryptor rfc2307SMD5PasswordEncryptor = new RFC2307SMD5PasswordEncryptor();
            System.out.println(rfc2307SMD5PasswordEncryptor.encryptPassword(plainText));

            RFC2307SSHAPasswordEncryptor rfc2307SSHAPasswordEncryptor = new RFC2307SSHAPasswordEncryptor();
            System.out.println(rfc2307SSHAPasswordEncryptor.encryptPassword(plainText));

            // org.jasypt.util.text
            AES256TextEncryptor aes256TextEncryptor = new AES256TextEncryptor();
            aes256TextEncryptor.setPassword(saltPassword);
            System.out.println("AES256TextEncryptor: " + aes256TextEncryptor.encrypt(plainText));

            BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
            basicTextEncryptor.setPassword(saltPassword);
            System.out.println("BasicTextEncryptor: " + basicTextEncryptor.encrypt(plainText));

            StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor();
            strongTextEncryptor.setPassword(saltPassword);
            System.out.println("StrongTextEncryptor: " + strongTextEncryptor.encrypt(plainText));


            System.out.println(AES256Encode(saltPassword, "123456"));
            System.out.println(AES256Decode(saltPassword, "DwxpUm488p5tMykVBJKSGxifp9oTZYrnaMBUqgJdwLPWTy2191XnQwrDaWLkxwdo"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
