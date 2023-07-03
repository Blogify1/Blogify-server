package com.blogifyserver.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Getter
@Setter

@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;

    @Column(length = 64, unique = true)
    private String email;

    @Column(length = 128)
    private String pass;

    @Column(length = 16)
    private String nickName;

    @Column
    private String profileImg;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "member")
    private Blog blog;

    public void setBlog(Blog blog) {
        this.blog = blog;
        blog.setMember(this);
    }


}


