package com.hdragon.blog.domain.kakao.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class KakaoApiResponseDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class meta {

        private int total_count;
        private int pageable_count;
        private Boolean is_end;

    }

    public static class documents {

        private String title;
        private String contents;
        private String url;
        private String blogname;
        private String thumbnail;
        private LocalDateTime DateTime;
    }
}
