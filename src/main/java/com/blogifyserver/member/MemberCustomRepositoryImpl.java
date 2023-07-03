package com.blogifyserver.member;

import com.blogifyserver.entity.Member;
import com.blogifyserver.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static com.blogifyserver.entity.QMember.member;

@Repository
public class MemberCustomRepositoryImpl implements MemberCustomRepository {
    public final JPAQueryFactory queryFactory;

    public MemberCustomRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public boolean nickNameCheck(String nickName) {
        long count = queryFactory.selectOne()
                .from(member)
                .where(member.nickName.eq(nickName))
                .fetchCount();
        return count > 0;
    }

    @Override
    public boolean emailCheck(String email) {
        long count = queryFactory.selectOne()
                .from(member)
                .where(member.email.eq(email))
                .fetchCount();
        return count > 0;
    }
}
