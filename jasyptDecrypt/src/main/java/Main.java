import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * @author: jas502n
 * Create Time: 2021/9/27 星期一
 * Project_Name: jasyptDecrypt
 * Package_Name: PACKAGE_NAME
 */
public class Main {

    private static String CryptoPassword = "EbfYkitulv73I2p0mXI50JMXoaxZTKJ7";

    public static String decryptor(String CryptoPassword, String EncodeText) {
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword(CryptoPassword);
        String decodeText = decryptor.decrypt(EncodeText);
        return decodeText;
    }

    public static String encryptor(String CryptoPassword, String Text) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(CryptoPassword);
        String encryptedPassword = encryptor.encrypt(Text);
        return encryptedPassword;
    }

    public static void main(String[] args) {

        try {
            String bannerInfo = "       _                 _____  _   _____                             _   \n" +
                    "      | |               |  __ \\| | |  __ \\                           | |  \n" +
                    "      | | __ _ ___ _   _| |__) | |_| |  | | ___  ___ _ __ _   _ _ __ | |_ \n" +
                    "  _   | |/ _` / __| | | |  ___/| __| |  | |/ _ \\/ __| '__| | | | '_ \\| __|\n" +
                    " | |__| | (_| \\__ \\ |_| | |    | |_| |__| |  __/ (__| |  | |_| | |_) | |_ \n" +
                    "  \\____/ \\__,_|___/\\__, |_|     \\__|_____/ \\___|\\___|_|   \\__, | .__/ \\__|\n" +
                    "                    __/ |                                  __/ | |        \n" +
                    "                   |___/                                  |___/|_|        \n" +
                    "\n" +
                    "Usage:\n" +
                    "[*] java -jar jasyptDecrypt.jar decode password EncodeText\n" +
                    "[*] java -jar jasyptDecrypt.jar encode password Text\n";
            if (args.length == 0) {
                System.out.println(bannerInfo);
                System.exit(0);
            }
            if (args.length == 3) {
                String option = args[0];
                if (option.toLowerCase().equals("decode")) {
                    String CryptoPassword = args[1];
                    String EncodeText = args[2];
                    System.out.println(bannerInfo);
                    System.out.println("[-] Decrypt: \n" + EncodeText + "   >>>   " + decryptor(CryptoPassword, EncodeText) + "\n");
                }
                if (option.toLowerCase().equals("encode")) {
                    String CryptoPassword = args[1];
                    String Text = args[2];
                    System.out.println(bannerInfo);
                    System.out.println("[-] Encrypt: \n" + Text + "   >>>   " + encryptor(CryptoPassword, Text) + "\n");
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
