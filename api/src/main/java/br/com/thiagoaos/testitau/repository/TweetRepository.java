package br.com.thiagoaos.testitau.repository;

import br.com.thiagoaos.testitau.model.Tweet;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TweetRepository {

    public Optional<Tweet> getOne(Integer id) {
        return Optional.ofNullable(null);
    }

}
