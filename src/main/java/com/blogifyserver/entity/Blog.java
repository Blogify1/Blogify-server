package com.blogifyserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogNum;


    @OneToOne
    @JoinColumn(name = "member_num")
    private Member member;

    @Column
    private String description;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Category> categories;

    public void addCategory(Category category) {
        categories.add(category);
        category.setBlog(this);
    }
}
