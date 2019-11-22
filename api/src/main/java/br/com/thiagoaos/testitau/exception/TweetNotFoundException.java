package br.com.thiagoaos.testitau.exception;

public class TweetNotFoundException extends RuntimeException {
    public TweetNotFoundException(long id) {
        super("Tweet with id not found " + id);
    }
}
