package org.jerry.light4j.member.common.page;

/**
 * 分页参数构建实体
 * @author jian
 *
 */
public class PageUtils {
	
	/**
	 * 通过基本参数构建分页对象(数据总数需要单独调汇总接口,主要包括pageNo,pageSize,count三个参数)
	 * @param pageQueryBean
	 * @param actionURL
	 * @return
	 */
	public static PageTools buildPageTools(PageQueryBean pageQueryBean,String actionURL,int count){
		PageTools pageTools = new PageTools();
		if(null == pageQueryBean)return pageTools;
		pageQueryBean.setOffset((pageQueryBean.getPageNo()-1)*pageQueryBean.getPageSize());
		pageTools.setPageNo(pageQueryBean.getPageNo());
		pageTools.setPageSize(pageQueryBean.getPageSize());
		pageTools.setPageSizeOptions("");//通过查询系统参数表设置分页参数集合
		pageTools.setRecordCount(count);
		pageTools.setRecordCountNo(pageQueryBean.getOffset());
		pageTools.setTotalPage(pageTools.getRecordCount()/pageTools.getPageSize());
		pageTools.setUrl(actionURL);
		return pageTools;
	}
	

}
