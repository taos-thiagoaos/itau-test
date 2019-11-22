package br.com.thiagoaos.testitau.service;

import br.com.thiagoaos.testitau.exception.TweetNotFoundException;
import br.com.thiagoaos.testitau.model.Tweet;

import br.com.thiagoaos.testitau.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

    private final TweetRepository repository;

    @Autowired
    public TweetService(TweetRepository repository) {
        this.repository = repository;
    }

    public Tweet getOne(Integer id) {
        return this.repository.getOne(id).orElseThrow(() -> new TweetNotFoundException(id));
    }

}
