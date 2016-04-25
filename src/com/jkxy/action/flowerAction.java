package com.jkxy.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.jkxy.model.Catalog;
import com.jkxy.model.Flower;
import com.jkxy.service.ICatalogService;
import com.jkxy.service.IFlowerService;
import com.jkxy.util.Pager;
import com.jkxy.util.uploadFile;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class flowerAction extends ActionSupport {
	private ICatalogService catalogService;
	private IFlowerService flowerService;
	private int catalogid;
	private int currentPage=1;
	private File upload;
	private String uploadFileName;
	private Flower flower;
	private String picture;
	private int flowerid;
	
	
	
	
	
	
	public int getFlowerid() {
		return flowerid;
	}

	public void setFlowerid(int flowerid) {
		this.flowerid = flowerid;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Flower getFlower() {
		return flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

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
	//获取 menu 菜单
	public String browseCatalog() throws Exception{

		List<Catalog> catalogs=catalogService.getAllCatalogs();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("catalogs",catalogs);
		request.put("msg", "nimeide");
		return SUCCESS;
	}
	//获取新入库的 四样花品
	public String browseFlower() throws Exception{
		List<Flower> flowers=flowerService.getNewFlower();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("newflowers",flowers);
		request.put("msg", "flowers");
		
		return SUCCESS;
	}
	//分页获取 所有花品
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
	//花品的 增加 和 信息修改
	public String addOrUpdateFlower() throws Exception {
		//获取 存储路径
		String  path=ServletActionContext.getServletContext().getRealPath("/pic");
		System.out.println("上传路径:"+path);
		//获取 最大的id
		Flower flower1=(Flower) flowerService.getNewFlower().get(0);
		//拼装 上传文件名 和 路径
		int maxId=flower1.getFlowerid()+1;
		path=path+"\\"+maxId+this.getUploadFileName();
		//文件写入
		new uploadFile().upload(this.getUpload(), path);
		//拼装 后的 文件名 
		flower.setPicture(maxId+this.getUploadFileName());
		
		//上传来的 对象 赋给 flower2
		Flower flower2=new Flower();
		flower2.setCatalog(flower.getCatalog());
		flower2.setFlowername(flower.getFlowername());
		flower2.setPrice(flower.getPrice());
 	    flower2.setFlowerid(flower.getFlowerid());
		if(flower.getPicture()==null)
 	    	 flower2.setPicture(picture);	
 	    else
 	    flower2.setPicture(flower.getPicture());
 	    
 	    if (flowerService.addOrUpdateFlower(flower2))

			return SUCCESS;
		else 
			return ERROR;			
	}
	
	//管理花品 获取所有花品
	public String browseAllFlower() throws Exception{
		System.out.println("管理花品");
		List flowers=flowerService.getAllFlower();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("flowers", flowers);
		
		return "success";
	}
	
	//故那里花品  ，查询 要修改的花品
	public String displayOneFolwer() throws Exception{
		Map request =(Map) ActionContext.getContext().get("request");
		Flower moditiedflower=flowerService.getFlowerById(flowerid);
		request.put("flower", moditiedflower);
		return "success";
		
		
	}
	
	public String deleteFlower() throws Exception{
		
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("delete", this.getFlowerid());
		flowerService.deleteFlower(flowerid);
		System.out.println("删除成功");
		return "success";
	}
	
}




