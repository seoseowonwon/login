package com.example.login.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.login.dto.Member;
import com.example.login.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Slf4j
@Service
public class MemberService {
	@Autowired MemberMapper memberMapper;
	
	public int bringMember(Member member){ // 아이디 비밀번호 비교 후 로그인 결정
		log.debug("memberMapper Data --> "+memberMapper.selectMember(member.getId()));
		Map<String, Object> userInfo = memberMapper.selectMember(member.getId());
		//디버깅
		log.debug("userInfo -->"+userInfo.toString());
		log.debug("user password -->"+userInfo.get("password"));
		log.debug("member.getPassword -->"+member.getPassword());
		
		//입력한 ID, PW와 DB의 ID, PW값이 일치할 때,
		if(member.getId().equals(userInfo.get("id")) 
				&& member.getPassword().equals(userInfo.get("password"))){
			return 1; // 일치하면 1을 반환
		} else {
			return 0; // 불일치시 0을 반환
		}
	}
}
