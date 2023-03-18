package com.hdragon.blog.domain.ranking.data;


import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
@SequenceGenerator(
        name = "RANKING_SEQ_GENERATOR",
        sequenceName = "RANKING_SEQ",
        initialValue = 1,
        allocationSize = 50)            // 대량 insert를 가정하여 1이 아닌 50으로 설정, DB에서 시퀀스 직접 사용시 한번에 50 증가
public class RankingData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RANKING_SEQ_GENERATOR")
    private Long id;

    private String keyword;

    private Integer count;

    @PrePersist
    public void prePersist() {
        this.count = this.count == null ? 1 : this.count;
    }

}
