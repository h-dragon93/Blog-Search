package com.hdragon.blog.domain.kakao.util;

import static org.mockito.BDDMockito.given;

import com.hdragon.blog.domain.kakao.api.dto.KakaoApiRequestDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.UnsupportedEncodingException;


class UrlBuilderUtilTest {

    KakaoApiRequestDTO requestDTO = KakaoApiRequestDTO.builder()
                                                      .query("블로그")
                                                      .sort("recency")
                                                      .page(5)
                                                      .size(5)
                                                      .build();

    @ParameterizedTest
    @ValueSource(strings = {"https://dapi.kakao.com/v2/search/blog?query=블로그&sort=recency&page=5&size=5"})
    @DisplayName("UrlBuilderUtil Static 메소드 테스트")
    void urlBuilderTest(String url) throws UnsupportedEncodingException {

        MockedStatic<UrlBuilderUtil> urlBuilderUtilMockedStatic = Mockito.mockStatic(UrlBuilderUtil.class);

        given(UrlBuilderUtil.getUrlBuilder(requestDTO, new StringBuilder("https://dapi.kakao.com/v2/search/blog"))).willReturn(url);

    }
}