package com.hdragon.blog.domain.kakao.api.service.impl;


import com.hdragon.blog.domain.kakao.api.service.KakaoApiService;
import com.hdragon.blog.domain.kakao.api.dto.KakaoApiRequestDTO;

import com.hdragon.blog.domain.kakao.util.HttpUrlConnectionUtil;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class KakaoApiServiceImpl implements KakaoApiService {

    @Value("${kakao.hosturl}")
    String hosturl;

    @Value("${kakao.bloguri}")
    String bloguri;

    @Value("${kakao.apikey}")
    String apikey;

    @Override
    public JSONObject getBlogSearch(KakaoApiRequestDTO apiRequestDTO) throws MalformedURLException, UnsupportedEncodingException, ParseException {

        StringBuilder urlBuilder = new StringBuilder(hosturl+bloguri);  // https://dapi.kakao.com/v2/search/blog
        urlBuilder.append("?").append("query=").append(URLEncoder.encode(apiRequestDTO.getQuery(),"UTF-8")).        // 한글 검색어 인코딩
                   append("&").append("sort=").append(apiRequestDTO.getSort()).
                   append("&").append("page=").append(apiRequestDTO.getPage()).
                   append("&").append("size=").append(apiRequestDTO.getSize());

        URL url = new URL(urlBuilder.toString());
        StringBuilder sb = new StringBuilder();
        StringBuilder blogData = HttpUrlConnectionUtil.getInputStreamData(url, sb, apikey);     // html escape 문자열을 제거해보자

        JSONParser jsonParser = new JSONParser();    // JSON 파싱부터해라
        JSONObject jsonObject = (JSONObject) jsonParser.parse(blogData.toString());


        return jsonObject;
    }
}
