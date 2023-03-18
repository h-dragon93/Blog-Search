package com.hdragon.blog.domain.kakao.api.web;

import com.hdragon.blog.domain.kakao.api.service.KakaoApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class KakaoApiController {

    private final KakaoApiService kakaoApiService;

}
