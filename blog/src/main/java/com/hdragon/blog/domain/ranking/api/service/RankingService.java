package com.hdragon.blog.domain.ranking.api.service;

import com.hdragon.blog.domain.ranking.data.RankingData;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RankingService {

    public Optional<List<RankingData>> getTopSearchedKeyword ();
}
