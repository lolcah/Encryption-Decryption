package encryptdecrypt.hyperSkills.encryption;

import encryptdecrypt.hyperSkills.EncryptionAlgorithm;

public class ShiftAlgo implements EncryptionAlgorithm {

    private char encryptChar(char c, int key) {
        char ch = (char) (c + key);
        if(Character.isUpperCase(c)){
            return ch <= 'Z' ? ch : (char) (c - 26 + key);
        }
        return ch <= 'z' ? ch : (char) (c - 26 + key);
    }

    private char decryptChar(char c, int key) {
        char ch = (char) (c - key);
        if(Character.isUpperCase(c)){
            return ch >= 'A' ? ch : (char) (c + 26 - key);
        }
        return ch >= 'a' ? ch : (char) (c + 26 - key);
    }

    @Override
    public String encrypt(String data, int key) {
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i]))
                chars[i] = encryptChar(chars[i], key);
        }
        return new String(chars);
    }

    @Override
    public String decrypt(String data, int key) {
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i]))
                chars[i] = decryptChar(chars[i], key);
        }
        return new String(chars);
    }
}
