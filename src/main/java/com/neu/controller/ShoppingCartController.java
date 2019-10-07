package com.neu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.ShoppingCart;
import com.neu.entity.ShoppingItem;
import com.neu.entity.User;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {

	@RequestMapping("addToCart")
	public int addToCart(@RequestBody ShoppingItem shoppingItem, HttpSession session) {
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		User user = (User) session.getAttribute("user");
		// 没有购物车，创建
		if (shoppingCart == null) {
			List<ShoppingItem> shoppingItems = new ArrayList<ShoppingItem>();
			shoppingItems.add(shoppingItem);
			Double total = shoppingItem.getCommodity().getPrice() * shoppingItem.getCount();
			shoppingCart = new ShoppingCart(user, shoppingItems, total);
		} else {
			List<ShoppingItem> shoppingItems = shoppingCart.getShoppingItems();
			int i;
			// 遍历购物车已有商品，如商品id相同，更新该商品数量
			for (i = 0; i < shoppingItems.size(); i++) {
				ShoppingItem item = shoppingCart.getShoppingItems().get(i);
				if (item.getCommodity().getId() == shoppingItem.getCommodity().getId()) {
					int count = item.getCount() + shoppingItem.getCount();
					item.setCount(count);
					shoppingItems.set(i, item);
					break;
				}
			}
			// 已有购物车中无新添加商品，将商品添加到购物车中
			if (i == shoppingItems.size()) {
				shoppingItems.add(shoppingItem);
				shoppingCart.setShoppingItems(shoppingItems);
			}
			// 将新增商品的总金额，与原购物车总金额求和，得到最新的总金额
			Double addTotal = shoppingItem.getCommodity().getPrice() * shoppingItem.getCount();
			shoppingCart.setTotal(shoppingCart.getTotal() + addTotal);
		}
		session.setAttribute("shoppingCart", shoppingCart);
		return 1;
	}
	
	@RequestMapping("getShoppingCart")
	public ShoppingCart getShoppingCart(HttpSession session) {
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		return shoppingCart;
	}
	
	@RequestMapping("updateShoppingCart")
	public int updateShoppingCart(@RequestBody ShoppingCart shoppingCart, HttpSession session) {
		session.setAttribute("shoppingCart", shoppingCart);
		return 1;
	}
}
