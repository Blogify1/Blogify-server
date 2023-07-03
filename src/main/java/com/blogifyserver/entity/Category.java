package com.blogifyserver.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryNum;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "blog_num")
    private Blog blog;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Post> posts;

    public void addPost(Post post) {
        posts.add(post);
        post.setCategory(this);
    }
}
