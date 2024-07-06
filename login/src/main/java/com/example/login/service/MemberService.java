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
	
	public boolean bringMember(Member member){
		log.debug("memberMapper Data --> "+memberMapper.selectMember(member.getId()));
		Map<String, Object> userInfo = memberMapper.selectMember(member.getId());
		
		if(member.getId().equals(userInfo.get("id")) 
				&& member.getPassword().equals(userInfo.get("password"))){
			return true;
		} else {
			return false;
		}
	}
}
