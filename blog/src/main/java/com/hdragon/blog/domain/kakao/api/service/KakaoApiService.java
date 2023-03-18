package com.hdragon.blog.domain.kakao.api.service;

import com.hdragon.blog.domain.kakao.api.dto.KakaoApiRequestDTO;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public interface KakaoApiService {                      // Bean inject by spring proxy

    public JSONObject getBlogSearch(KakaoApiRequestDTO apiRequestDTO) throws MalformedURLException, UnsupportedEncodingException, ParseException;
}
