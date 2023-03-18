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

    @Builder.Default
    private String sort = "accuracy";

    @Max(value=50)
    @Builder.Default
    private int page = 1 ;

    @Max(value=50)
    @Builder.Default
    private int size = 1;
}
