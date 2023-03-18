package com.hdragon.blog.domain.web;

import com.hdragon.blog.domain.kakao.api.dto.KakaoApiRequestDTO;
import com.hdragon.blog.domain.kakao.api.service.KakaoApiService;
import com.hdragon.blog.domain.kakao.util.KakaoApiDTOUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

@Slf4j
@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchApiController {

    private final KakaoApiService kakaoApiService;

    @GetMapping("/kakao")
    @ResponseBody
    public JSONObject getBlogSearch(String query, @RequestParam(required = false) String sort, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) throws MalformedURLException, UnsupportedEncodingException, ParseException {
        KakaoApiRequestDTO requestDTO = new KakaoApiRequestDTO();
        requestDTO = KakaoApiDTOUtil.getRequestDTO(requestDTO, query, sort, page, size);
        JSONObject blogData = kakaoApiService.getBlogSearch(requestDTO);
        JSONArray documentArr = (JSONArray) blogData.get("documents");
        //blogData.get("meta");
        //System.out.println("documentArr" + documentArr);

        return blogData;
    }


}
