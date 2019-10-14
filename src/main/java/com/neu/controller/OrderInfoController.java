package com.neu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neu.entity.OrderInfo;
import com.neu.entity.ShoppingCart;
import com.neu.entity.ShoppingItem;
import com.neu.entity.User;
import com.neu.service.OrderInfoService;

@RestController
@RequestMapping("orderInfo")
public class OrderInfoController {
	@Autowired
	private OrderInfoService orderInfoService;

	@RequestMapping("delete")
	public int delete(int id) {
		return orderInfoService.delete(id);

	}

	@RequestMapping("update")
	public int update(OrderInfo orderInfo) {
		return orderInfoService.update(orderInfo);
	}

	@RequestMapping("insert")
	public int insert(@RequestBody ShoppingCart commdityOrder,HttpSession session) {
		List<ShoppingItem> shoppingItems = commdityOrder.getShoppingItems();
		Integer orderNumber = (int) (Math.random() * 100000);
		
		User user = (User)session.getAttribute("user");
		
		Date date = new Date();

		for (ShoppingItem s : shoppingItems) {
			OrderInfo orderInfo = new OrderInfo(orderNumber, date, s.getCommodity(), user, (double) s.getCount());
			orderInfoService.insert(orderInfo);
		}
		
		session.setAttribute("shoppingCart", null);

		return 1;
	}


	@RequestMapping("getByUserIdPaged")
	public PageInfo<OrderInfo> getByUserIdPaged(
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pageSize, 
			@RequestBody User user) {
		return orderInfoService.getByUserIdPaged(pageNum, pageSize, user);
	}

	@RequestMapping("getPaged")
	public PageInfo<OrderInfo> getPaged(
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pageSize, 
			@RequestBody Map<String, Object> params) {
		return orderInfoService.getPaged(pageNum, pageSize, params);
	}
	
	@RequestMapping("export")
	public void export(@Required HttpServletResponse response) throws IOException {
		List<OrderInfo> list = orderInfoService.getAll();
		
		//创建一个工作簿
		Workbook wb = new HSSFWorkbook();
		//创建工作表
		Sheet sheet = wb.createSheet("sheet1");
		Row row;
		Cell cell;
		
		List<String> titles = new ArrayList<String>();
		titles.add(0, "序号");
		titles.add(1, "订单编号");
		titles.add(2, "订单时间");
		titles.add(3, "商品名称");
		titles.add(4, "用户名称");
		titles.add(5, "购买数量");
		titles.add(6, "订单状态");
		titles.add(7, "商家状态");
		
		//创建行
		row = sheet.createRow(0);
		for(int j = 0; j < titles.size(); j++) {
			//创建单元格
			cell = row.createCell(j+1);
			//设置单元格的值
			cell.setCellValue(titles.get(j));
		}
		
		
		for(int i = 0; i < list.size(); i++) {
			//创建行
			row = sheet.createRow(i+1);
			
			//创建单元格
			cell = row.createCell(1);
			//设置单元格的值
			cell.setCellValue(list.get(i).getId()==null?null:list.get(i).getId());
			
			//创建单元格
			cell = row.createCell(2);
			//设置单元格的值
			cell.setCellValue(list.get(i).getOrderNumber()==null?null:list.get(i).getOrderNumber());
			
			//创建单元格
			cell = row.createCell(3);
			//设置单元格的值
			cell.setCellValue(list.get(i).getOrderTime()==null?null:list.get(i).getOrderTime());
			
			//创建单元格
			cell = row.createCell(4);
			//设置单元格的值
			cell.setCellValue(list.get(i).getCommodity()==null?null:list.get(i).getCommodity().getComname());
			
			//创建单元格
			cell = row.createCell(5);
			//设置单元格的值
			cell.setCellValue(list.get(i).getUser()==null?null:list.get(i).getUser().getUsername());
			
			//创建单元格
			cell = row.createCell(6);
			//设置单元格的值
			cell.setCellValue(list.get(i).getConstantItem1()==null?null:list.get(i).getConstantItem1().getName());
			
			//创建单元格
			cell = row.createCell(7);
			//设置单元格的值
			cell.setCellValue(list.get(i).getConstantItem2()==null?null:list.get(i).getConstantItem2().getName());	
		}
		
		//设置响应内容类型
		response.setContentType("application/vnd.ms-excel");
		//设置响应头
		response.setHeader("Content-disposition", "attachment;filename=OrederInfo.xls");
		//得到响应字节流
		ServletOutputStream outputStream = response.getOutputStream();
		//将工作簿写入到响应流中
		wb.write(outputStream);
		//关闭响应流
		outputStream.close();
	}

}
