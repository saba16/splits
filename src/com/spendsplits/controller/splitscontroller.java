package com.spendsplits.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spendsplits.bo.splitsBo;
import com.spendsplits.model.splits;
import com.spendsplits.service.splitsService;
import com.spendsplits.service.splitsServiceImpl;

/**
 * @author saba
 *
 */
@Controller
public class splitscontroller {

	@Autowired
	private splitsService splitsservice;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveamount(@ModelAttribute("command") splitsBo splitsbo, BindingResult result,
			@RequestParam("hsd") String s, @RequestParam("amt") String amt) {

		splitsservice.splitedamount(s, amt);
		return new ModelAndView("/success");
	}

	@RequestMapping(value = "/splits", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command") splitsBo splitsbo, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("splits", prepareListofBean(splitsservice.getList()));
		return new ModelAndView("splits", model);
	}

	private List<splitsBo> prepareListofBean(List<splits> splits) {
		List<splitsBo> beans = null;
		if (splits != null && !splits.isEmpty()) {
			beans = new ArrayList<splitsBo>();
			splitsBo bean = null;
			for (splits split : splits) {
				bean = new splitsBo();
				bean.setName(split.getName());
				bean.setId(split.getId());
				bean.setAmount(split.getAmount());
				beans.add(bean);
			}
		}
		return beans;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

}
