package com.example.login.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	Map<String, Object>selectMember(String id);
}	