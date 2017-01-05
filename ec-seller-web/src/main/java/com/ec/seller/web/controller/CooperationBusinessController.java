package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.FlagBitUtil;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.PropertyConstants;
import com.ec.seller.dao.UserDao;
import com.ec.seller.dao.UserInfoDAO;
import com.ec.seller.domain.CooperationBusiness;
import com.ec.seller.domain.UserInfo;
import com.ec.seller.domain.query.CooperationBusinessQuery;
import com.ec.seller.manager.UserManager;
import com.ec.seller.service.CooperationBusinessService;
import com.ec.seller.service.UserService;
import com.ec.seller.service.result.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.texen.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/cooperationBusiness")
public class CooperationBusinessController {

	@Autowired
	private CooperationBusinessService cooperationBusinessService;

	@Autowired
	private UserInfoDAO userInfoDAO;

	private final static Log log = LogFactory.getLog(CooperationBusinessController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(CooperationBusinessQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		PaginatedList<CooperationBusiness> list = cooperationBusinessService.findPage(query);
		content.put("list", list);
		content.put("query", query);
		return "cooperationBusiness/index";
	}

	@RequestMapping(value="/updateStatus", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result updateStatus(Long id, Integer status, Integer type, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			CooperationBusiness cooperationBusiness = this.cooperationBusinessService.selectById(id);
			cooperationBusiness.setStatus(status);
			cooperationBusiness.setAgreeTime(new Date());
			cooperationBusiness.setAgreeUserId(CookieUtil.getUserId(request));
			cooperationBusiness.setAgreeUserName(CookieUtil.getLoginName(request));

			UserInfo userInfo = this.userInfoDAO.selectByPrimaryKey(cooperationBusiness.getUid());
			if(type == 1){
				userInfo.setProperties(FlagBitUtil.sign(userInfo.getProvince(), PropertyConstants.USER_FENXIAOSHANG));

			}
			if(type == 3){
				userInfo.setProperties(FlagBitUtil.sign(userInfo.getProvince(), PropertyConstants.USER_B2B));

			}

			if(type == 2){
				//高级分销商
				cooperationBusiness.setType(2);
				userInfo.setProperties(FlagBitUtil.sign(userInfo.getProperties(), PropertyConstants.USER_FENXIAOSHANG_2));
			}

			this.userInfoDAO.updateUser(userInfo);
			this.cooperationBusinessService.modify(cooperationBusiness);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
			log.error("", e);
		}

		return result;
	}

}

