package com.blogifyserver.member;


import com.blogifyserver.entity.Member;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;

@Service
public class MemberServiceImpl implements MemberService {
    final MemberRepository repository;
    final MemberCustomRepository customRepository;

    public MemberServiceImpl(MemberRepository repository, MemberCustomRepository customRepository) {

        this.repository = repository;
        this.customRepository = customRepository;
    }

    @Override
    public boolean signUp(Member member) {
        String email = member.getEmail();
        String nickName = member.getNickName();

        if (emailCheck(email) || nickNameCheck(nickName)) {
            return false;
        }

        repository.save(member);
        return true;
    }

    @Override
    public boolean emailCheck(String email) {

        return customRepository.emailCheck(email);
    }

    @Override
    public void remove() {
        repository.deleteById(1L);
    }

    @Override
    public boolean nickNameCheck(String nickName) {

        return customRepository.nickNameCheck(nickName);
    }
}

