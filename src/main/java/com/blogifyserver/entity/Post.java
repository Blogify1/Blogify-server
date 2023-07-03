package com.blogifyserver.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNum;

    @Column
    private int hit;

    @Column
    private int recommend;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_num")
    private Category category;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Reply> replies;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImg> postImgs;

    public void addPostImg(PostImg postImg) {
        postImgs.add(postImg);
        postImg.setPost(this);
    }

    public void addReply(Reply reply) {
        replies.add(reply);
        reply.setPost(this);
    }


}
