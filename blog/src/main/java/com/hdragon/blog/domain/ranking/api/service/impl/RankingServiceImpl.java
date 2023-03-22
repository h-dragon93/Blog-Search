package com.hdragon.blog.domain.ranking.api.service.impl;

import com.hdragon.blog.domain.ranking.api.service.RankingService;
import com.hdragon.blog.domain.ranking.data.RankingData;
import com.hdragon.blog.domain.ranking.repository.RankingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {

    private final RankingRepository rankingRepository;

    @Override
    public Optional<List<RankingData>> getTopSearchedKeyword() {

        Optional<List<RankingData>> topSearchedList = rankingRepository.findTop10InKeywordByOrderByCountDesc();
        return topSearchedList;
    }
}
