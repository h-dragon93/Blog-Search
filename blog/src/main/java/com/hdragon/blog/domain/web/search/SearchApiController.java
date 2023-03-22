package com.hdragon.blog.domain.web.search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hdragon.blog.domain.kakao.api.dto.KakaoApiRequestDTO;
import com.hdragon.blog.domain.kakao.api.dto.KakaoApiResponseDTO;
import com.hdragon.blog.domain.kakao.api.service.KakaoApiService;
import com.hdragon.blog.domain.kakao.util.KakaoApiDTOUtil;
import com.hdragon.blog.domain.ranking.api.service.RankingService;
import com.hdragon.blog.domain.ranking.data.RankingData;
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
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchApiController {

    private final KakaoApiService kakaoApiService;
    private final RankingService rankingService;

    @GetMapping("/kakao")
    @ResponseBody
    public List<KakaoApiResponseDTO.documents> getBlogSearch(@RequestParam String query, @RequestParam(required = false) String sort,
                                                             @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size)
                                                                    throws MalformedURLException, UnsupportedEncodingException, ParseException, JsonProcessingException {
        KakaoApiRequestDTO requestDTO = new KakaoApiRequestDTO();
        requestDTO = KakaoApiDTOUtil.getRequestDTO(requestDTO, query, sort, page, size);
        List<KakaoApiResponseDTO.documents> blogData = kakaoApiService.getBlogSearch(requestDTO);

        return blogData;
    }

    @GetMapping("/topKeyword")
    @ResponseBody
    public Optional<List<RankingData>> getTopKeyword() {
        Optional<List<RankingData>> topKeyword = rankingService.getTopSearchedKeyword();

        return topKeyword;
    }
}
