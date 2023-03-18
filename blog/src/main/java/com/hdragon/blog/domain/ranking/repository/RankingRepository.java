package com.hdragon.blog.domain.ranking.repository;

import com.hdragon.blog.domain.ranking.data.RankingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface RankingRepository extends JpaRepository<RankingData, Long> {
    Optional<RankingData> findByKeyword(String keyword);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update RankingData r set r.count = r.count+1 where r.id = :id")
    void searchCountPlusOne(Long id);
}
