package com.hdragon.blog.domain.ranking.api.service;

import com.hdragon.blog.domain.ranking.data.RankingData;

import java.util.List;
import java.util.Optional;

public interface RankingService {

    Optional<List<RankingData>> getTopSearchedKeyword ();
}
