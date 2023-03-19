package com.hdragon.blog.domain.kakao.api.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hdragon.blog.domain.kakao.api.dto.KakaoApiResponseDTO;
import com.hdragon.blog.domain.kakao.api.service.KakaoApiService;
import com.hdragon.blog.domain.kakao.api.dto.KakaoApiRequestDTO;

import com.hdragon.blog.domain.kakao.util.HttpUrlConnectionUtil;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Service
public class KakaoApiServiceImpl implements KakaoApiService {

    @Value("${kakao.hosturl}")
    String hosturl;

    @Value("${kakao.bloguri}")
    String bloguri;

    @Value("${kakao.apikey}")
    String apikey;

    @Override
    public List<KakaoApiResponseDTO.documents> getBlogSearch(KakaoApiRequestDTO apiRequestDTO) throws MalformedURLException, UnsupportedEncodingException, ParseException, JsonProcessingException {

        StringBuilder urlBuilder = new StringBuilder(hosturl+bloguri);                          // https://dapi.kakao.com/v2/search/blog
        urlBuilder.append("?").append("query=").append(URLEncoder.encode(apiRequestDTO.getQuery(),"UTF-8")).        // 한글 검색어 인코딩
                   append("&").append("sort=").append(apiRequestDTO.getSort()).
                   append("&").append("page=").append(apiRequestDTO.getPage()).
                   append("&").append("size=").append(apiRequestDTO.getSize());

        URL url = new URL(urlBuilder.toString());
        StringBuilder sb = new StringBuilder();
        StringBuilder blogData = HttpUrlConnectionUtil.getInputStreamData(url, sb, apikey);     // html escape 문자열을 제거해보자

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(blogData.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);   // property 미일치 시에도 우선 통과
        String documentsString = jsonObject.get("documents").toString();
        List<KakaoApiResponseDTO.documents> responseDtoList = Arrays.asList(objectMapper.readValue(documentsString, KakaoApiResponseDTO.documents[].class));

        return responseDtoList;
    }
}
