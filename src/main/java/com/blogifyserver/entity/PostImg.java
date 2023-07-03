package com.blogifyserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PostImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgNum;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column
    private String fileName;
}
