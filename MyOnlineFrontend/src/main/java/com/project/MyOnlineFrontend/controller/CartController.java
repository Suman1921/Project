package com.project.MyOnlineFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.MyOnlineFrontend.service.CartLineService;

@Controller               //for url mapping
@RequestMapping("/cart")
public class CartController 
{
	@Autowired
	CartLineService cartLineService;
	
	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result)
	{
		ModelAndView mv = new ModelAndView("page");
		
		if(result != null)
		{
			switch (result) 
			{
			case "unavailable":
				mv.addObject("message", "Product quantity is not available!");					
				break;
				
			case "updated":
				mv.addObject("message", "Cart has been updated successfully!");					
				break;
				
			case "deleted":
				mv.addObject("message", "CartLine has been successfully removed!");
				break;
				
			case "added":
				mv.addObject("message", "CartLine has been successfully added!");
				break;
				
			case "maximum":
				mv.addObject("message", "Maximum product count reached!");
				break;
				
			case "modified":
				mv.addObject("message", "One or more items inside cart has been modified!");
				break;

			default:
				break;
			}
		}
		
		mv.addObject("title", "Shopping Cart");
		mv.addObject("userclickshowcart", true);
		mv.addObject("cartLines", cartLineService.getCartLines());
		
		return mv;
	}
	
	@RequestMapping("/add/{productId}/product")
	public String addProduct(@PathVariable int productId)
	{
		String response = cartLineService.addCartLineProduct(productId);
		return "redirect:/cart/show?"+response;
	}
	
	
	@RequestMapping("/{cartLineId}/remove")
	public String removeCartLine(@PathVariable int cartLineId) 
	{
		String response = cartLineService.removeCartLine(cartLineId);
		return "redirect:/cart/show?"+response;
	}
	
	
	@RequestMapping("/{cartLineId}/update")
	public String udpateCartLine(@PathVariable int cartLineId, @RequestParam("count") int count) 
	{
		String response = cartLineService.manageCartLine(cartLineId, count);		
		return "redirect:/cart/show?"+response;		
	}
}
