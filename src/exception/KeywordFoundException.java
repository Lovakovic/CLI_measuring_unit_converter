package exception;

public class KeywordFoundException extends RuntimeException{

    private String keyword;

    public KeywordFoundException(String keyword) {
        this.keyword = keyword;
    }
}
