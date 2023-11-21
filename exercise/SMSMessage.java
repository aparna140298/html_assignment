public class SMSMessage implements IEncryptable{

    private String originalText;
    private String encryptedText;
    private String from;
    private String to;
    private String message;

    public SMSMessage(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public void sendMessage() {
        //@NOTE: Do not change this function!
        System.out.println("The following message has been sent by " + this.encrypt() + " to " + this.to);
        System.out.println("\t" + this.message);
    }

    @Override
    public String encrypt() {
        StringBuilder encryptedPhoneNumber = new StringBuilder();
        for(char c : from.toCharArray()){
            if(Character.isDigit(c)){
                encryptedPhoneNumber.append(MorseCodeUtilites.getMorseCode(c));
            }

        }
        return encryptedPhoneNumber.toString();
    }

    @Override
    public boolean isOriginal(String text) {
        // Implement your logic to check if the provided value is the same as the original text
        // For simplicity, let's compare the reversed text with the original text
        return text.equals(encrypt());
    }

    public String getOriginalText() {
        return originalText;
    }

    public String getEncryptedText() {
        return encryptedText;
    }
}
