package br.com.thiagoaos.testitau.exception;

public class TweetNotFoundException extends RuntimeException {
    public TweetNotFoundException(Integer id) {
        super("Tweet with id not found " + id);
    }
}
