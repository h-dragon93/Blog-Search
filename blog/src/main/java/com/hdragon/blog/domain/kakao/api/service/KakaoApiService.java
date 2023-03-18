package com.hdragon.blog.domain.kakao.api.service;

import com.hdragon.blog.domain.kakao.api.vo.KakaoApiRequestVO;
import org.springframework.stereotype.Service;

public interface KakaoApiService {                      // spring proxy bean inject

    public String getBlogSearch(KakaoApiRequestVO apiServiceVO);
}
