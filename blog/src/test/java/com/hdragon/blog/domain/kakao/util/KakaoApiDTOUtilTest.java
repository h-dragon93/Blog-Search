package com.hdragon.blog.domain.kakao.util;

import com.hdragon.blog.domain.kakao.api.dto.KakaoApiRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class KakaoApiDTOUtilTest {

    @Test
    @DisplayName("RequestDTO Builder 생성 테스트")
    void RequestDTOTest() {

        KakaoApiRequestDTO requestDTO = KakaoApiRequestDTO.builder().query("키워드").sort("recency").page(8).size(5).build();

        Assertions.assertEquals(requestDTO.getSize(), 5);
        Assertions.assertEquals(requestDTO.getPage(), 8);
        Assertions.assertEquals(requestDTO.getQuery(), "키워드");
        Assertions.assertEquals(requestDTO.getSort(), "recency");

    }

}