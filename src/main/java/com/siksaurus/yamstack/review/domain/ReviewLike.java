package com.siksaurus.yamstack.review.domain;

import com.siksaurus.yamstack.account.domain.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReviewLike {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @Builder
    public ReviewLike(Account account, Review review) {
        this.account = account;
        this.review = review;
    }
}
