package br.com.thiagoaos.testitau.repository;

import br.com.thiagoaos.testitau.model.Tweet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {

    List<Tweet> findBySearchTag(String searchTag);

    Tweet findById(long id);

}
