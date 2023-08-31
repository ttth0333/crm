package com.cybersoft.crm.service;

import com.cybersoft.crm.model.MemberModel;
import com.cybersoft.crm.repository.MemberRepository;

import java.util.List;

public class MemberService {
    private MemberRepository memberRepository = new MemberRepository();

    public List<MemberModel> getAllMembers() {
        return memberRepository.getMembers();
    }

    public boolean deleteMemberById(int id) {
        int result = memberRepository.deleteMemberById(id);
        return  result > 0 ? true : false;
    }
}
