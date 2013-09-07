package com.dolph.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.model.Menu;
import com.dolph.service.AclService;
import com.dolph.utils.JSONUtils;
import com.dolph.vo.AuthMenuTreeVO;
import com.dolph.vo.LoginInfoVO;

@Controller("indexAction")
@Scope("prototype")
public class IndexAction  extends BaseAction{

	@Resource
	private AclService aclService;
	
	public void menu(){
		LoginInfoVO user=currentUser();
		List<Menu> authMenus=aclService.findPermitMenu(user.getId());
		List<AuthMenuTreeVO> vos=new ArrayList<AuthMenuTreeVO>();
		for(Menu m:authMenus){
			AuthMenuTreeVO vo=new AuthMenuTreeVO(m);
			vos.add(vo);
		}
		JSONUtils.toJSON(vos);
	}
}
