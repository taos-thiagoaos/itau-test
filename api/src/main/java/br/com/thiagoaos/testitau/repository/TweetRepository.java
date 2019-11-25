package br.com.thiagoaos.testitau.repository;

import br.com.thiagoaos.testitau.dto.TotalTweetByHourDTO;
import br.com.thiagoaos.testitau.dto.TotalTweetBySearchTagLangDTO;
import br.com.thiagoaos.testitau.model.Tweet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {

    List<Tweet> findBySearchTag(String searchTag);

    @Query(
            value="SELECT date(date) as date, HOUR(date) as hour, count(*) as total " +
                    "FROM tweets " +
                    "GROUP BY date(date), hour " +
                    "ORDER BY date(date) ASC, hour ASC",
            nativeQuery = true
    )
    List<TotalTweetByHourDTO> findAllGroupByDayHour();

    @Query(
            value="SELECT searchTag as tag, lang as lang, count(*) as total " +
                    "FROM tweets " +
                    "GROUP BY searchTag, lang " +
                    "ORDER BY searchTag ASC, total ASC, lang ASC"
    )
    List<TotalTweetBySearchTagLangDTO> findAllGroupByTagLang();

    Tweet findById(long id);

}
