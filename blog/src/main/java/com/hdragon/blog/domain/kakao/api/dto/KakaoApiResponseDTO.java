package com.hdragon.blog.domain.kakao.api.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

public class KakaoApiResponseDTO {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class documents {

        private String title;
        private String contents;
        private String url;
        private String blogname;
        private String thumbnail;
        @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone="Asia/Seoul")  // Object Mapper with ISO 8601
        private Date datetime;                                                                                      // zoned Time을 위해 Date 사용

    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class meta {

        private int total_count;
        private int pageable_count;
        private Boolean is_end;
    }

}
