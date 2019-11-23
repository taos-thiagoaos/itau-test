package br.com.thiagoaos.testitau.controller;

import br.com.thiagoaos.testitau.dtos.TotalTweetByHourDTO;
import br.com.thiagoaos.testitau.dtos.TotalTweetBySearchTagLangDTO;
import br.com.thiagoaos.testitau.model.Tweet;
import br.com.thiagoaos.testitau.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private TweetService service;

    @Autowired
    public TweetController(TweetService service) {
        this.service = service;
    }

    @GetMapping("/total-by-hour")
    public ResponseEntity<List<TotalTweetByHourDTO>> findAllGroupByDayHour() {
        return new ResponseEntity<>(this.service.findAllGroupByDayHour(), HttpStatus.OK);
    }

    @GetMapping("/total-by-tag-lang")
    public ResponseEntity<List<TotalTweetBySearchTagLangDTO>> findAllGroupByTagLang() {
        return new ResponseEntity<>(this.service.findAllGroupByTagLang(), HttpStatus.OK);
    }
}