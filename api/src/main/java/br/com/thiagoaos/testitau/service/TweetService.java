package br.com.thiagoaos.testitau.service;

import br.com.thiagoaos.testitau.dtos.TotalTweetByHourDTO;
import br.com.thiagoaos.testitau.dtos.TotalTweetBySearchTagLangDTO;
import br.com.thiagoaos.testitau.exception.TweetNotFoundException;
import br.com.thiagoaos.testitau.model.Tweet;

import br.com.thiagoaos.testitau.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TweetService {

    private final TweetRepository repository;

    @Autowired
    public TweetService(TweetRepository repository) {
        this.repository = repository;
    }

    public Tweet getOne(long id) {
        return Optional.ofNullable(this.repository.findById(id)).orElseThrow(() -> new TweetNotFoundException(id));
    }

    public List<TotalTweetByHourDTO> findAllGroupByDayHour() {
        return this.repository.findAllGroupByDayHour();
    }

    public List<TotalTweetBySearchTagLangDTO> findAllGroupByTagLang() {
        return this.repository.findAllGroupByTagLang();
    }
}
