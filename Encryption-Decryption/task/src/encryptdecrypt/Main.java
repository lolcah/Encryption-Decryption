package encryptdecrypt;

import encryptdecrypt.hyperSkills.EncryptionAlgorithm;
import encryptdecrypt.hyperSkills.encryption.ShiftAlgo;
import encryptdecrypt.hyperSkills.encryption.UnicodeAlg;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        new ShiftAlgo().decrypt("dbokcebo", 10);
        String data = "";
        int chiper = 0;
        String mode = "";
        String fileOut = "";
        String fileIn = "";
        EncryptionAlgorithm encryptionAlgorithm = null;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode": {
                    mode = args[i + 1];
                }
                break;
                case "-data": {
                    data = args[i + 1];
                }
                break;
                case "-key": {
                    chiper = Integer.parseInt(args[i + 1]);
                }
                break;
                case "-in": {
                    fileIn = args[i + 1];
                }
                break;
                case "-out": {
                    fileOut = args[i + 1];
                }
                break;
                case "-alg": {
                    encryptionAlgorithm = "unicode".equals(args[i + 1]) ? new UnicodeAlg() : new ShiftAlgo();
                }
                break;
            }
            i++;
        }

        if (!"".equals(fileIn)) {
            data = Files.readString(Paths.get(fileIn));
        }

        if (!"".equals(fileOut)) {
            Files.deleteIfExists(Paths.get(fileOut));
            Files.createFile(Paths.get(fileOut));
            System.setOut(new PrintStream(fileOut));
        }

        if ("".equals(data)) {
            Scanner scanner = new Scanner(System.in);
            data = scanner.nextLine();
        }

        assert encryptionAlgorithm != null;
        String result = "enc".equals(mode) ? encryptionAlgorithm.encrypt(data, chiper) : encryptionAlgorithm.decrypt(data, chiper);
        System.out.println(result);
        System.out.close();
    }
}
