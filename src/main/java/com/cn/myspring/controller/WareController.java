package com.cn.myspring.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cn.comm.validation.ValidGroup1;
import com.cn.myspring.po.Ware;
import com.cn.myspring.po.WareExtend;
import com.cn.myspring.po.WareExtendPo;
import com.cn.myspring.service.WareService;

@Controller
public class WareController {

	@Autowired
	WareService wareService;

	@RequestMapping("/editWareInfo/{id}")
	public ModelAndView editWareInfo(@PathVariable("id") Integer id)
			throws Exception {
		Ware ware = wareService.selectByPrimaryKey(id);
		ModelAndView modelAndView = new ModelAndView("editWareInfo");
		modelAndView.addObject(ware);
		return modelAndView;
	}

	@RequestMapping("/editWareSubmit")
	public String editWareSubmit(HttpServletRequest request,
			@Validated(value = { ValidGroup1.class }) Ware ware,
			MultipartFile ware_pic) throws Exception {
		// 原始名称
		String originalFilename = ware_pic.getOriginalFilename();
		// 上传图片
		if (ware_pic != null && originalFilename != null
				&& originalFilename.length() > 0) {
			// 存储图片的物理路径
			String pic_path = request.getSession().getServletContext()
					.getRealPath("/picpath/");
			// 新图片
			System.out.println(pic_path + File.separator + originalFilename);
			File newFile = new File(pic_path + File.separator
					+ originalFilename);
			// 将内存中的数据写入磁盘
			ware_pic.transferTo(newFile);
			// 将新图片名称写到itemsCustom中
			ware.setPic(originalFilename);
		}
		wareService.updateWareInfo(ware);
		return "success";
	}

	@RequestMapping("/wareInfoList")
	public ModelAndView wareInfoList(WareExtend wareExtend) throws Exception {
		List<WareExtend> wareExtends = wareService.findWaresList(wareExtend);
		ModelAndView modelAndView = new ModelAndView("wareInfoList");
		modelAndView.addObject("wareExtends", wareExtends);
		modelAndView.addObject("name", wareExtend.getName());
		return modelAndView;
	}

	@RequestMapping("/deleterWares")
	public String deleterWares(WareExtendPo wareExtendPo) throws Exception {
		wareService.deleterWares(wareExtendPo);
		return "success";
	}

}