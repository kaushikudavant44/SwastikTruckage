package com.bionische.swastiktruckage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;

import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.mastermodel.OperationOfAccessRight;
import com.bionische.swastiktruckage.mastermodel.StaffRoles;
import com.bionische.swastiktruckage.model.NavBarMainMenu;
import com.bionische.swastiktruckage.model.NavBarSubMainMenu;
import com.bionische.swastiktruckage.repository.NavBarMainMenuRepository;
import com.bionische.swastiktruckage.repository.NavBarSubMainMenuRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.StaffRolesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SessionScope
public class AccessRightController {

	@Autowired
	NavBarSubMainMenuRepository navBarSubMainMenuRepository;
	@Autowired
	NavBarMainMenuRepository navBarMainMenuRepository;
	@Autowired
	OfficeStaffRepository officeStaffRepository;
	@Autowired
	StaffRolesRepository staffRolesRepository;
	
	List<NavBarMainMenu> navBarMainMenuList;
	@RequestMapping(value="/showAccessRightPage", method=RequestMethod.GET)
	public String showAccessRightPage(HttpServletRequest request, Model model)   
	{
		
		try {
			
			List<OfficeStaff> officeStaffList=officeStaffRepository.findByIsUsed(true);
			
			  navBarMainMenuList=navBarMainMenuRepository.findAll();
			System.out.println("navBarMainMenuList" +navBarMainMenuList.toString());
			for(int i=0;i<navBarMainMenuList.size();i++) {
				List<NavBarSubMainMenu> navBarSubMainMenuList=navBarSubMainMenuRepository.findByIsUsedAndMenuId(true, navBarMainMenuList.get(i).getMenuId());
		navBarMainMenuList.get(i).setNavBarSubMainMenuList(navBarSubMainMenuList);
			}
		 model.addAttribute("officeStaffList",officeStaffList);
		model.addAttribute("navBarMainMenuList",navBarMainMenuList);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return "accessRight/assignRight";
		
	}
	
	
	@RequestMapping(value="/submitAccessRight", method=RequestMethod.POST)
	public String submitAccessRight(HttpServletRequest request, Model model)   
	{
		

		List<NavBarSubMainMenu> navBarSubMainMenuList=new ArrayList<NavBarSubMainMenu>();
		
		for(int i=0;i<navBarMainMenuList.size();i++) {
			
			for(NavBarSubMainMenu navBarSubMainMenu : navBarMainMenuList.get(i).getNavBarSubMainMenuList()) 
			{
				
				NavBarSubMainMenu navBarSubMainMenuRight=navBarSubMainMenu;
				
				String [] subMenuIdList=request.getParameterValues(""+navBarSubMainMenu.getSubMenuId());
				
				if(subMenuIdList!=null)
				{
					navBarSubMainMenuRight.setAdd(0);
					navBarSubMainMenuRight.setEdit(0);
					navBarSubMainMenuRight.setMdelete(0);
					navBarSubMainMenuRight.setView(0);
					
					for(int k=0;k<subMenuIdList.length;k++)
					{
						System.out.println(subMenuIdList[k]);
						
						if(subMenuIdList[k].equals("view"))
						{
							navBarSubMainMenuRight.setView(1);
						}
						else 
							 if(subMenuIdList[k].equals("add"))
						{
							navBarSubMainMenuRight.setAdd(1);
						}
						 else if(subMenuIdList[k].equals("edit"))
						{
							navBarSubMainMenuRight.setEdit(1);
						}
						 else if(subMenuIdList[k].equals("delete"))
						{
							navBarSubMainMenuRight.setMdelete(1);
						}
						 
						
					}
					 navBarSubMainMenuList.add(navBarSubMainMenuRight);	
					
					
				}
				
				 
			}
			StaffRoles staffRoles=new StaffRoles();
		 
			 
				System.out.println(navBarSubMainMenuList.toString());
				 
				ObjectMapper mapper = new ObjectMapper();
				try {
					String roleJson = mapper.writeValueAsString(navBarSubMainMenuList);
					
					System.out.println(roleJson);
					//roleJson.replace("{", "[");
					//roleJson.replace("}", "]");
			//   roleJson="{"+navBarSubMainMenuList.toString().substring(1, roleJson.length()-1)+"}";
		 
			 staffRoles.setRole(roleJson);
			 
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				staffRoles.setRoleName("");
				
				staffRoles.setStaffId(Integer.parseInt(request.getParameter("staffOfficeId")));
				staffRoles.setUsed(true);
				
				StaffRoles staffRolesRes=staffRolesRepository.findByStaffId(Integer.parseInt(request.getParameter("staffOfficeId")));
				if(staffRolesRes!=null)
				{
					staffRoles.setRoleId(staffRolesRes.getRoleId());
				}
				staffRolesRepository.save(staffRoles);
				
		 
		}
return "redirect:/showAccessRightPage";
	}
	

	@RequestMapping(value="/getAccessrightByStaffId", method=RequestMethod.GET)
	public @ResponseBody String getAccessrightByStaffId(HttpServletRequest request, Model model)   
	{
 
		int staffOfficeId=Integer.parseInt(request.getParameter("staffOfficeId"));
		 
		
		StaffRoles staffRoles=staffRolesRepository.findByStaffId(staffOfficeId);
		
		 
			 
	 
		return staffRoles.getRole();
	}
	@RequestMapping(value="/setAccessRight", method=RequestMethod.GET)
	public void setAccessRight(HttpServletRequest request)
	{
		System.out.println("setAccessRight");
		int subMenuId=Integer.parseInt(request.getParameter("subMenuId"));
		int menuId=Integer.parseInt(request.getParameter("menuId"));
		
		int view=Integer.parseInt(request.getParameter("view"));
		int edit=Integer.parseInt(request.getParameter("edit"));
		int mdelete=Integer.parseInt(request.getParameter("mdelete"));
		int add=Integer.parseInt(request.getParameter("add"));
		
		HttpSession session = request.getSession();
		
		/*session.setAttribute("subMenuId", subMenuId);
		session.setAttribute("menuId", menuId);
		session.setAttribute("view", view);
		session.setAttribute("edit", edit);
		session.setAttribute("mdelete", mdelete);
		session.setAttribute("add", add);*/
		 
		OperationOfAccessRight operationOfAccessRight=new OperationOfAccessRight();
		operationOfAccessRight.setMenuId(menuId);
		operationOfAccessRight.setSubMenuId(subMenuId);
		operationOfAccessRight.setMdelete(mdelete);
		operationOfAccessRight.setAdd(add);
		operationOfAccessRight.setEdit(edit);
		operationOfAccessRight.setView(view);
		
		session.setAttribute("operationOfAccessRight", operationOfAccessRight);
		
	}
	
}
