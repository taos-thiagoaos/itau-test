package br.com.thiagoaos.testitau.controller;

import br.com.thiagoaos.testitau.model.Tweet;
import br.com.thiagoaos.testitau.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/tweets")
@Validated
public class TweetController {

    private TweetService service;

    @Autowired
    public TweetController(TweetService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tweet> getOne(@PathVariable Integer id) {
        Tweet tweet = this.service.getOne(id);
        return new ResponseEntity<>(tweet, HttpStatus.OK);
    }
}