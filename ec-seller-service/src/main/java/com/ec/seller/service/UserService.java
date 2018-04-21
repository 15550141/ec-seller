package com.ec.seller.service;

import com.ec.seller.domain.UserInfo;

import java.util.List;

public interface UserService {

	UserInfo queryUser(String loginname, String loginpwd);
	
	UserInfo queryByMobile(String mobile);

	Integer addUser(UserInfo user);

	void updateUser(UserInfo user);

	List<UserInfo> selectUserInfoByMobile(String mobile);

}
