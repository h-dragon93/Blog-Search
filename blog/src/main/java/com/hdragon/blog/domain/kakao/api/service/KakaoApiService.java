package com.hdragon.blog.domain.kakao.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hdragon.blog.domain.kakao.api.dto.KakaoApiRequestDTO;
import com.hdragon.blog.domain.kakao.api.dto.KakaoApiResponseDTO;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

public interface KakaoApiService {                      // Bean inject by spring proxy

    List<KakaoApiResponseDTO.documents> getBlogSearch(KakaoApiRequestDTO apiRequestDTO) throws MalformedURLException, UnsupportedEncodingException,
                                                                                                      ParseException, JsonProcessingException;
}
