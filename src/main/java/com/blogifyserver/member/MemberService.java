package com.blogifyserver.member;

import com.blogifyserver.entity.Member;

public interface MemberService {
    boolean signUp(Member member);

    boolean nickNameCheck(String nickName);

    boolean emailCheck(String email);

    void remove();
}
