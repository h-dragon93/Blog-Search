package com.hdragon.blog.domain.web.search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hdragon.blog.domain.kakao.api.dto.KakaoApiRequestDTO;
import com.hdragon.blog.domain.kakao.api.dto.KakaoApiResponseDTO;
import com.hdragon.blog.domain.kakao.api.service.KakaoApiService;
import com.hdragon.blog.domain.kakao.util.KakaoApiDTOUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchApiController {

    private final KakaoApiService kakaoApiService;

    @GetMapping("/kakao")
    @ResponseBody
    public List<KakaoApiResponseDTO.documents> getBlogSearch(String query, @RequestParam(required = false) String sort, @RequestParam(required = false) Integer page,
                                                    @RequestParam(required = false) Integer size) throws MalformedURLException, UnsupportedEncodingException, ParseException, JsonProcessingException {
        KakaoApiRequestDTO requestDTO = new KakaoApiRequestDTO();
        requestDTO = KakaoApiDTOUtil.getRequestDTO(requestDTO, query, sort, page, size);
        List<KakaoApiResponseDTO.documents> blogData = kakaoApiService.getBlogSearch(requestDTO);
        //JSONArray documentArr = (JSONArray) blogData.get("documents");

        return blogData;
    }

}
