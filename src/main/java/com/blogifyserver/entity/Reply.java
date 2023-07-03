package com.blogifyserver.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyNum;

    @ManyToOne
    @JoinColumn(name = "post_num")
    private Post post;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_num")
    private Member member;

}
