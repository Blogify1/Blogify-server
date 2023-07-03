package com.blogifyserver.member;

import com.blogifyserver.entity.Member;

public interface MemberCustomRepository {

    boolean nickNameCheck(String nickName);

    boolean emailCheck(String email);
}
