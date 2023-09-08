package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.model.Customer;
import com.tech.servicei.ServiceI;

@Controller
public class MyController {

	@Autowired
	ServiceI si;

	@RequestMapping("/reg")
	public String saveData(Customer cs) {

		int aadhaarNo = si.saveData(cs);

		if (aadhaarNo > 0) {

			return "index";

		} else {
			return "register";
		}
	}

	@RequestMapping("/log")
	public String getData(@RequestParam("userName") String user, @RequestParam("password") String pass, Customer cs,
			Model m) {

		if (user.equals("admin") && pass.equals("a07")) {

			List<Customer> acclist = si.getData(user, pass);
			m.addAttribute("data", acclist);

			return "datapage";
		} else if (user.equals(user) && pass.equals(pass)) {
			List<Customer> list = si.singleData(user, pass);
			m.addAttribute("data", list);

			return "datapage";
		}
		return "index";

	}

	@RequestMapping("/delete")
	public String deleteData(@RequestParam("rd") int addharNo, Model m) {

		si.deleteData(addharNo);

		List<Customer> acclist = si.getAllData();

		m.addAttribute("data", acclist);

		return "datapage";

	}

	@RequestMapping("/edit")
	public String editData(@RequestParam("rd") int addharNo, Model m) {
		Customer c = si.editData(addharNo);
		m.addAttribute("data", c);

		return "updatedata";

	}

	@RequestMapping("/update")
	public String updateData(@ModelAttribute Customer cs, Model m) {

		int addharNo = si.saveData(cs);

		List<Customer> acclist = si.getAllData();

		m.addAttribute("data", acclist);
		return "datapage";

	}

//AadhaarNumber get from database
	@RequestMapping("/deposit")
	public String depositMoney(@RequestParam("rd") int addharNo, Model m) {

		Customer cs = si.depositMoney(addharNo);
		m.addAttribute("data", cs);

		return "amount";

	}

// deposit amount storing in database
	@RequestMapping("/depo")
	public String updateAmount(@ModelAttribute Customer cs, Model m) {
		Customer c = si.updateAmount(cs);
		m.addAttribute("data", c);

		List<Customer> alist = si.getAllData();
		m.addAttribute("data", alist);
		return "datapage";

	}

	@RequestMapping("/withdraw")
	public String withdrawMoney(@RequestParam("rd") int addharNo, Model m) {

		Customer c = si.withdrawMoney(addharNo);
		m.addAttribute("data", c);

		return "withdraw";

	}

	@RequestMapping("/debit")
	public String updateWithdraw(@ModelAttribute Customer cs, Model m) {

		Customer c = si.updateWithdraw(cs);
		m.addAttribute("data", c);

		List<Customer> clist = si.getAllData();
		m.addAttribute("data", clist);

		return "datapage";

	}

}
