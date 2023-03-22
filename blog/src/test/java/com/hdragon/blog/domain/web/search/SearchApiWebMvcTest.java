package com.hdragon.blog.domain.web.search;

import com.hdragon.blog.domain.kakao.api.service.KakaoApiService;
import com.hdragon.blog.domain.ranking.repository.RankingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(SearchApiController.class)
@DisplayName("SearchApiController WebMvc Test")
class SearchApiWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KakaoApiService kakaoApiService;

    @MockBean
    private RankingRepository rankingRepository;

    @Test
    public void testCategoryController() throws Exception {

        this.mockMvc.perform(get("/search/kakao")
                                .param("query","블로그")
                                .param("sort","recency")
                                .param("page","1")
                                .param("query","1")
                            ).andExpect(status().isOk());
    }

    @AfterEach
    void After() {
    }

}
