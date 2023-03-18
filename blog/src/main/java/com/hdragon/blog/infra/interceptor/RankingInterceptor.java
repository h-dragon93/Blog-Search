package com.hdragon.blog.infra.interceptor;


import com.hdragon.blog.domain.ranking.data.RankingData;
import com.hdragon.blog.domain.ranking.repository.RankingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class RankingInterceptor implements HandlerInterceptor {

    private final RankingRepository rankingRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String keyword = request.getParameter("query");
        Optional<RankingData> rankingData = rankingRepository.findByKeyword(keyword);
        if(rankingData.isEmpty()) {
            RankingData rankingdata = RankingData.builder().keyword(keyword).build();
            rankingRepository.save(rankingdata);
        } else {
            System.out.println("id in else : " + rankingData.get().getId());
            rankingRepository.searchCountPlusOne(rankingData.get().getId());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //Logger.info("postHandle 1");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        //Logger.info("afterCompletion 1");
    }
}
