public interface IEncryptable {
    String encrypt();  // Method to return an encrypted string

    boolean isOriginal(String text);  // Method to check if the provided value is the same as the original text
}

