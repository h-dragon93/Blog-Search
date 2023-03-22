package com.hdragon.blog.domain.kakao.util;

import com.hdragon.blog.domain.kakao.api.dto.KakaoApiRequestDTO;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlBuilderUtil {

    public static String getUrlBuilder(KakaoApiRequestDTO apiRequestDTO, StringBuilder urlBuilder) throws UnsupportedEncodingException {

        urlBuilder = urlBuilder.append("?").append("query=").append(URLEncoder.encode(apiRequestDTO.getQuery(),"UTF-8")).        // 한글 검색어 인코딩
                                append("&").append("sort=").append(apiRequestDTO.getSort()).
                                append("&").append("page=").append(apiRequestDTO.getPage()).
                                append("&").append("size=").append(apiRequestDTO.getSize());

        return urlBuilder.toString();
    }

}
