package com.blogifyserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Follows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followsNum;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "follower_num")
    private Member follower;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "followed_num")
    private Member followed;
}
