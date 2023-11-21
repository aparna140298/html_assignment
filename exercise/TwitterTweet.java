public class TwitterTweet implements IEncryptable{

    private String username;
    private int numCharacters;
    private String tweet;

    public TwitterTweet(String username, String tweet) {
        this.username = username;
        this.tweet = tweet;
        if (this.hasReachedMaximum() == true) {
            this.numCharacters = -1;
        }
        else {
            this.numCharacters = this.tweet.length();
        }

    }

    public boolean hasReachedMaximum() {
        if (this.tweet.length() > 140) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getTweet() {
        return this.tweet;
    }

    @Override
    public String encrypt() {
        String[] words = tweet.split("\\s+");
        StringBuilder encryptedTweet = new StringBuilder();

        for (String word : words) {
            String encryptedWord = encryptWord(word);
            encryptedTweet.append(encryptedWord).append(" ");
        }

        return encryptedTweet.toString().trim();
    }

    @Override
    public boolean isOriginal(String text) {
        String[] encryptedWords = text.split("\\s+");
        String[] originalWords = tweet.split("\\s+");

        if (encryptedWords.length != originalWords.length) {
            return false;
        }

        for (int i = 0; i < encryptedWords.length; i++) {
            String decryptedWord = decryptWord(encryptedWords[i]);
            if (!decryptedWord.equals(originalWords[i])) {
                return false;
            }
        }

        return true;
    }

    private String encryptWord(String word) {
        String firstLetter = word.substring(0, 1);
        String restOfWord = word.substring(1, word.length()) + firstLetter + "eq";
        return restOfWord;
    }

    private String decryptWord(String word) {
        String removeEQ = word.substring(0, word.length() - 2);
        String lastLetter = removeEQ.substring(removeEQ.length() - 1);
        String restOfWord = removeEQ.substring(0, removeEQ.length() - 1);
        return lastLetter + restOfWord;
    }

}
