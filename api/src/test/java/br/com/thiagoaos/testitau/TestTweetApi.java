package br.com.thiagoaos.testitau;

import br.com.thiagoaos.testitau.controller.TweetController;
import br.com.thiagoaos.testitau.dto.TotalTweetByHourDTO;
import br.com.thiagoaos.testitau.dto.TotalTweetBySearchTagLangDTO;
import br.com.thiagoaos.testitau.dto.TotalTweetBySearchTagLangDTOImpl;
import br.com.thiagoaos.testitau.service.TweetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TweetController.class)
public class TestTweetApi {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private TweetService service;

	@Test
	public void testFindAllGroupByTagLang()
			throws Exception {

		TotalTweetBySearchTagLangDTO tweet = new TotalTweetBySearchTagLangDTOImpl("#apifirst", "en", 10L);

		List<TotalTweetBySearchTagLangDTO> tweets = new ArrayList<>();
		tweets.add(tweet);
		tweets.add(new TotalTweetBySearchTagLangDTOImpl("#apifirst", "pt", 1L));

		given(service.findAllGroupByTagLang()).willReturn(tweets);

		mvc.perform(get("/api/v1/tweets/total-by-tag-lang")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].tag", is(tweet.getTag())))
				.andExpect(jsonPath("$[0].lang", is(tweet.getLang())))
				.andExpect(jsonPath("$[0].total", is(10)))
				.andExpect(jsonPath("$", hasSize(2)));
	}

	@Test
	public void testFindAllGroupByHour()
			throws Exception {

		Date now = new Date();
		TotalTweetByHourDTO tweet = new TotalTweetByHourDTOImpl(now, 11, 5L);

		List<TotalTweetByHourDTO> tweets = new ArrayList<>();
		tweets.add(tweet);

		given(service.findAllGroupByDayHour()).willReturn(tweets);

		mvc.perform(get("/api/v1/tweets/total-by-hour")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].hour", is(11)))
				.andExpect(jsonPath("$[0].total", is(5)))
				.andExpect(jsonPath("$", hasSize(1)));
	}

}
