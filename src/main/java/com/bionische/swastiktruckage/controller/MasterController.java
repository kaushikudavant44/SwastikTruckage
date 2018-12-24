package com.bionische.swastiktruckage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.mastermodel.City;
import com.bionische.swastiktruckage.mastermodel.Goods;
import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.mastermodel.OfficeDetails;
import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.mastermodel.StaffRoles;
import com.bionische.swastiktruckage.mastermodel.States;
import com.bionische.swastiktruckage.model.GetStaffDetails;
import com.bionische.swastiktruckage.repository.CityRepository;
import com.bionische.swastiktruckage.repository.GetStaffDetailsRepository;
import com.bionische.swastiktruckage.repository.GoodsRepository;
import com.bionische.swastiktruckage.repository.OfficeDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.StaffRolesRepository;
import com.bionische.swastiktruckage.service.StateDetailsService;

@Controller
public class MasterController {

	@Autowired
	StateDetailsService stateDetailsService;

	@Autowired
	OfficeDetailsRepository officeDetailsRepository;
	
	@Autowired
	StaffRolesRepository staffRolesRepository;
	
	@Autowired
	OfficeStaffRepository officeStaffRepository;
	
	@Autowired
	GetStaffDetailsRepository getStaffDetailsRepository;
	
	@Autowired
	GoodsRepository goodsRepository;
	
	@Autowired
	CityRepository cityRepository;

	/*@RequestMapping(value = "/showHome", method = RequestMethod.GET)

	public ModelAndView showPatientLoginPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/offices");
		try {

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}*/

	@RequestMapping(value = "/showOfficeReg", method = RequestMethod.GET)

	public ModelAndView showOfficeReg(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/officeRegistration");
		try {
			OfficeDetails officeDetails = new OfficeDetails();
			List<City> cityList = new ArrayList<>();
			List<States> stateList = stateDetailsService.getAllStates();
			model.addObject("stateList", stateList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}

	@RequestMapping(value = "/insertOffice", method = RequestMethod.POST)

	public String inserOffice(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/officeRegistration");

		String url = "";
		try {
			OfficeDetails officeDetails = new OfficeDetails();

			try {
				officeDetails.setOfficeId(Integer.parseInt(request.getParameter("officeId")));
			} catch (Exception e) {
				// TODO: handle exception
			}
			officeDetails.setOfficeName(request.getParameter("officeName"));
			officeDetails.setOfficeAddress(request.getParameter("officeAddress"));
			officeDetails.setFaxNo(request.getParameter("faxNo"));
			officeDetails.setPincode(Integer.parseInt(request.getParameter("pincode")));
			officeDetails.setOfficeStateId(Integer.parseInt(request.getParameter("officeStateId")));
			officeDetails.setOfficeCityId(Integer.parseInt(request.getParameter("officeCityId")));
			officeDetails.setOfficeContactNo(request.getParameter("officeContactNo"));
			officeDetails.setUsed(true);
			OfficeDetails officeDetailsRes = officeDetailsRepository.save(officeDetails);
			if (officeDetailsRes != null) {
				url = "redirect:/showOfficeReg";
			}

		} catch (Exception e) {
			e.printStackTrace();
			url = "redirect:/errorMessage";

		}

		return url;

	}

	@RequestMapping(value = "/showStaffRoleReg", method = RequestMethod.GET)

	public ModelAndView showStaffRoleReg(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/staffRoleReg");
		try {

			
			StaffRoles staffRoles=new StaffRoles();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/insertStaffRole", method = RequestMethod.POST)

	public String insertStaffRole(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/staffRoleReg");
	
		String url = "";
		try {
			
			
			StaffRoles staffRoles=new StaffRoles();
			
			staffRoles.setRole(request.getParameter("role"));
			staffRoles.setRoleName(request.getParameter("roleName"));
			staffRoles.setUsed(true);
			StaffRoles staffRolesRes=staffRolesRepository.save(staffRoles);
			
			if(staffRolesRes!=null) {
			url="redirect:/showStaffRoleReg";
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			url = "redirect:/errorMessage";;
		}

		return url;

	}
	
	
	@RequestMapping(value = "/showOfficeStaffReg", method = RequestMethod.GET)

	public ModelAndView showOfficeStaffReg(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/officeStaffReg");
		try {

			List<OfficeDetails> officeList = officeDetailsRepository.findByIsUsed(true);
			List<StaffRoles> roleList= staffRolesRepository.findAll();
			
			model.addObject("roleList", roleList);
			model.addObject("officeList", officeList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/insertOfficeStaff", method = RequestMethod.POST)
	public String insertOfficeStaff(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/staffRoleReg");
	
		OfficeStaff officeStaff=new OfficeStaff();
		String url = "";
		try {
			
			try {
				officeStaff.setStaffId(Integer.parseInt(request.getParameter("staffId")));
			} catch (Exception e) {
				// TODO: handle exception
			}
			officeStaff.setPassword(request.getParameter("password"));
			officeStaff.setRoleId(Integer.parseInt(request.getParameter("roleId")));
			officeStaff.setStaffAddress(request.getParameter("staffAddress"));
			officeStaff.setStaffContactNo(request.getParameter("staffContactNo"));
			officeStaff.setStaffName(request.getParameter("staffName"));
			officeStaff.setStaffOfficeId(Integer.parseInt(request.getParameter("staffOfficeId")));
			officeStaff.setUserName(request.getParameter("userName"));
			officeStaff.setUsed(true);
		
			OfficeStaff officeStaffRes=officeStaffRepository.save(officeStaff);
			if(officeStaffRes!=null) {
			url="redirect:/showOfficeStaffReg";
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			url = "redirect:/errorMessage";;
		}

		return url;

	}

	@RequestMapping(value = "/showOfficesDetails", method = RequestMethod.GET)

	public ModelAndView officesDetails(HttpServletRequest request) {
		ModelAndView model;
		 model = new ModelAndView("master/offices");
		try {
			
			List<OfficeDetails> officeList=new ArrayList<>();
			
			officeList=officeDetailsRepository.findByIsUsed(true);
			System.out.println(""+officeList.toString());
			model.addObject("officeList", officeList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			model = new ModelAndView("common/errorMsg");
		}

		return model;

	}   
	
	@RequestMapping(value = "/editOfficeDetails/{officeId}", method = RequestMethod.GET)

	public ModelAndView editOfficeDetails(HttpServletRequest request,@PathVariable int officeId) {
		ModelAndView model;
		 model = new ModelAndView("master/editOfficeDetails");
		try {
			//int officeId=Integer.parseInt(request.getParameter("officeId"));
			OfficeDetails officeDetails=officeDetailsRepository.findByOfficeId(officeId);
			List<States> stateList=stateDetailsService.getAllStates();
			List<City> cityList=stateDetailsService.getAllCity();
			
			model.addObject("officeDetails", officeDetails);
			model.addObject("stateList",stateList);
			model.addObject("cityList", cityList);
			
		} catch (Exception e) {
			model =new ModelAndView("common/errorMsg");
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value="/removeOffice", method=RequestMethod.GET)

	public @ResponseBody int removeOffice(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView model=new ModelAndView("master/offices");
		
		int officeDetails=0;
		int officeId=Integer.parseInt(request.getParameter("officeId"));
		try {
		
		 officeDetails=officeDetailsRepository.removeOfficeByOfficeId(officeId);
		if(officeDetails== 1) {
			System.out.println("deleted");
		}else {
			System.out.println("false");	
		}

		} catch (Exception e) {
		e.printStackTrace();
		}
		return officeDetails;
	}	
	
	
	@RequestMapping(value = "/showStaffDetails", method = RequestMethod.GET)

	public ModelAndView staffDetails(HttpServletRequest request) {
		ModelAndView model;
		 model = new ModelAndView("master/staffDetails");
		try {
			
			
			List<GetStaffDetails> staffList=new ArrayList<>();
			
			staffList=getStaffDetailsRepository.findAllStaff();
			System.out.println(staffList.toString());
			model.addObject("staffList", staffList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			model = new ModelAndView("common/errorMsg");
		}

		return model;

	}
	
	@RequestMapping(value = "/editStaffDetails/{staffId}", method = RequestMethod.GET)

	public ModelAndView editStaffDetails(HttpServletRequest request,@PathVariable int staffId) {
		ModelAndView model;
		 model = new ModelAndView("master/editStaffDetails");
		try {
			//int officeId=Integer.parseInt(request.getParameter("officeId"));
			OfficeStaff staffDetails=officeStaffRepository.findByStaffId(staffId);
			List<OfficeDetails> officeList=new ArrayList<>();			
			officeList=officeDetailsRepository.findByIsUsed(true);
			List<StaffRoles> roleList= staffRolesRepository.findAll();
			System.out.println(roleList.toString());
			model.addObject("staffDetails", staffDetails);
			model.addObject("officeList", officeList);
			model.addObject("roleList", roleList);
			
		} catch (Exception e) {
			model =new ModelAndView("common/errorMsg");
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value="/removeStaff", method=RequestMethod.GET)

	public @ResponseBody int removeStaff(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView model=new ModelAndView("master/staffDetails");
		
		int staffDetails=0;
		int staffId=Integer.parseInt(request.getParameter("staffId"));
		try {
		
			staffDetails=officeStaffRepository.removeStaffByStaffId(staffId);
		if(staffDetails== 1) {
			System.out.println("deleted");
		}else {
			System.out.println("false");	
		}

		} catch (Exception e) {
			model =new ModelAndView("common/errorMsg");
		e.printStackTrace();
		}
		return staffDetails;
	}
	
	@RequestMapping(value="/staffContactValidation", method=RequestMethod.GET)

	public @ResponseBody int staffContactValidation(HttpServletRequest request,HttpServletResponse response)
	{		
		OfficeStaff officeDetails = new OfficeStaff();
		String contactNo = request.getParameter("contactNo");
		int i = 0;
		
		try {
		
		 officeDetails=officeStaffRepository.findByStaffContactNo(contactNo);	
		 
		 if(officeDetails==null)
		 {
			i=1;
		 }
		 

		} catch (Exception e) {
		e.printStackTrace();
		}
		return i;
	}	
	
	@RequestMapping(value = "/showGoodsReg", method = RequestMethod.GET)

	public ModelAndView showGoodsReg(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/goods");
		try {
			List<Goods> goodsList=goodsRepository.findByIsUsedOrderByGoodsIdDescIsUsed(true);
			model.addObject("goodsList", goodsList);
				
		} catch (Exception e) {
			model =new ModelAndView("common/errorMsg");
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/insertGoods", method = RequestMethod.POST)

	public String insertGoods(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/goods");
		try {
			Goods goods=new Goods();
			try {
				goods.setGoodsId(Integer.parseInt(request.getParameter("goodsId")));
			}catch(Exception e) {
				
			}
			
			goods.setGoodsName(request.getParameter("goods"));
			goods.setUsed(true);
			Goods goodsRes=goodsRepository.save(goods);
		} catch (Exception e) {
			model =new ModelAndView("common/errorMsg");
			System.out.println(e.getMessage());
		}

		return "redirect:/showGoodsReg";

	}
	
	@RequestMapping(value = "/editGoodsDetails/{goodsId}", method = RequestMethod.GET)

	public ModelAndView editGoodsDetails(HttpServletRequest request,@PathVariable int goodsId) {
		ModelAndView model;
		 model = new ModelAndView("master/goods");
		try {
			Goods goods=goodsRepository.findByGoodsId(goodsId);
			model.addObject("goods", goods);
			
		} catch (Exception e) {
			model =new ModelAndView("common/errorMsg");
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/deleteGoods/{goodsId}", method = RequestMethod.GET)

	public String deleteGoods(HttpServletRequest request,@PathVariable int goodsId) {
		ModelAndView model;
		 model = new ModelAndView("master/goods");
		try {
			int goods=goodsRepository.removeGoodsByGoodsId(goodsId);
			//model.addObject("goods", goods);
			Info info=new Info();
			if(goods==1) {
				info.setMessage("deleted");
			}else {
				info.setMessage("Something went wrong");
			}
			
			
		} catch (Exception e) {
			model =new ModelAndView("common/errorMsg");
			System.out.println(e.getMessage());
		}

		return "redirect:/showGoodsReg";

	}
	
	/*@RequestMapping(value = "/showGoodsRate", method = RequestMethod.GET)

	public ModelAndView showGoodsRate(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/goodsRate");
		try {

				
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}*/
	
	
}
