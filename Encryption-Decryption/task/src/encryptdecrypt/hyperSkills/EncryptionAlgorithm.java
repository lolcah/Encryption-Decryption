package encryptdecrypt.hyperSkills;

public interface EncryptionAlgorithm {
    public String encrypt(String data, int key);
    public String decrypt(String data, int key);
}
