package com.hdragon.blog.domain.kakao.api.dto;


import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KakaoApiRequestDTO {

    @NotEmpty
    private String query;

    @Builder.Default                    // 파라미터가 입력되지 않았을때 default 값 셋팅
    private String sort = "accuracy";   // Builder의 인스턴스 리턴 방식에 의해 @Builder.Default 필요

    @Max(value=50)
    @Builder.Default
    private int page = 1 ;

    @Max(value=50)
    @Builder.Default
    private int size = 1;
}
