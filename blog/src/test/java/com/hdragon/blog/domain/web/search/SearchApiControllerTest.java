package com.hdragon.blog.domain.web.search;

import com.hdragon.blog.domain.kakao.api.service.KakaoApiService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("SearchApiController Spring Boot Test")
class SearchApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private KakaoApiService kakaoApiService;

    @InjectMocks
    private SearchApiController searchApiController;

    @BeforeEach
    public void setUp()  {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(searchApiController).build();
    }

    @Test
    public void testCategoryController() throws Exception {

        mockMvc.perform(get("/search/kakao")
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