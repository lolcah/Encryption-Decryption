package encryptdecrypt.hyperSkills.encryption;

import encryptdecrypt.hyperSkills.EncryptionAlgorithm;

public class UnicodeAlg implements EncryptionAlgorithm {

    private char encryptChar(char c, int key) {
        return (char) (c + key);
    }

    private char decryptChar(char c, int key) {
        return (char) (c - key);
    }

    @Override
    public String encrypt(String data, int key) {
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = encryptChar(chars[i], key);
        }
        return new String(chars);
    }

    @Override
    public String decrypt(String data, int key) {
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = decryptChar(chars[i], key);
        }
        return new String(chars);
    }
}
