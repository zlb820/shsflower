package com.jkxy.action;

import java.util.List;
import java.util.Map;

import com.jkxy.model.Catalog;
import com.jkxy.model.Flower;
import com.jkxy.service.ICatalogService;
import com.jkxy.service.IFlowerService;
import com.jkxy.util.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class flowerAction extends ActionSupport {
	private ICatalogService catalogService;
	private IFlowerService flowerService;
	private int catalogid;
	private int currentPage=1;
	
	
	
	
	

	public int getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	

	public IFlowerService getFlowerService() {
		return flowerService;
	}

	public void setFlowerService(IFlowerService flowerService) {
		this.flowerService = flowerService;
	}

	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public String browseCatalog() throws Exception{

		List<Catalog> catalogs=catalogService.getAllCatalogs();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("catalogs",catalogs);
		request.put("msg", "nimeide");
		return SUCCESS;
	}
	
	public String browseFlower() throws Exception{
		List<Flower> flowers=flowerService.getNewFlower();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("newflowers",flowers);
		request.put("msg", "flowers");
		
		return SUCCESS;
	}
	public String browseFlowerPaging() throws Exception{
		int totalSize=flowerService.getTotalByCatalog(catalogid);
		Pager pager=new Pager(currentPage,totalSize);
		Map request=(Map) ActionContext.getContext().get("request");
		List<Flower> flowers=flowerService.getFlowerByCatalogidPaging(catalogid, currentPage, pager.getPageSize());
		request.put("flowers", flowers);
		request.put("pager", pager);
		request.put("msg", "分页查询");
		
		return SUCCESS;
	}
	
}
