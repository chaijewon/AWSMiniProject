package com.sist.web.controller;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.service.*;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequiredArgsConstructor
public class FoodController {
   private final FoodService fService;
   
   @GetMapping("/")
   public String food_main(
		   @RequestParam(value="page",required = false) String page,
		   Model model)
   {
	    if(page==null)
	    	page="1";
	    int curpage=Integer.parseInt(page);
	    List<FoodVO> list=fService.foodListData(curpage);
	    int[] pages=fService.foodPages(curpage);
	    model.addAttribute("list", list);
	    model.addAttribute("curpage", pages[0]);
	    model.addAttribute("totalpage", pages[1]);
	    model.addAttribute("startPage", pages[2]);
	    model.addAttribute("endPage", pages[3]);
	    return "list";
   }
}
