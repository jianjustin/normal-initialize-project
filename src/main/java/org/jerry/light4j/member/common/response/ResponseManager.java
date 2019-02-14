package org.jerry.light4j.member.common.response;

import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.common.page.PageTools;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * 响应实体封装
 * @author admin
 *
 */
public class ResponseManager {
	
	/**
	 * 根据参数集产生响应实体
	 * @param status
	 * @param headers
	 * @param datas
	 * @return
	 */
	public static ResponseEntity<Map<String,Object>> getResponse(HttpStatus status,MultiValueMap<String, String> headers,Map<String,Object> datas){
		ResponseEntity<Map<String,	Object>> responseEntity = new ResponseEntity<Map<String,Object>>(datas,headers,HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * 通过设置返回数据获取responseEntity
	 * @param domain
	 * @param domainList
	 * @param status
	 * @param msg
	 * @param dataMap
	 * @param pageTools
	 * @return
	 */
	public static <T> ResponseEntity<ResponseDomain<T>> handerResponse(Class<T> clazz,T domain,List<T> domainList,HttpStatus status,String msg,Map<String,Object> dataMap,PageTools pageTools){
		ResponseDomain<T> responseDomain = new ResponseDomain<T>();
		responseDomain.setDataMap(dataMap);
		responseDomain.setDomain(domain);
		responseDomain.setMsg(msg);
		responseDomain.setPageTools(pageTools);
		responseDomain.setStatus(status.toString());//需要手动去设置状态码参数
		responseDomain.setDomainList(domainList);
		ResponseEntity<ResponseDomain<T>> responseEntity = new ResponseEntity<ResponseDomain<T>>(responseDomain,status);
		return responseEntity;
	}

}
