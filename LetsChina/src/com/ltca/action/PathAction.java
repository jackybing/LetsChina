package com.ltca.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltca.entity.DateEditor;
import com.ltca.entity.Graphic;
import com.ltca.entity.Path;
import com.ltca.service.PathService;

@Controller
@RequestMapping("/path")
public class PathAction {
	
	@Resource(name="pathServiceImpl")
	private PathService pathService;
	
	private JSONObject msg;
	
	/*@InitBinder  
	protected void initBinder(HttpServletRequest request,  
	                              ServletRequestDataBinder binder) throws Exception {  
	    //对于需要转换为Date类型的属性，使用DateEditor进行处理  
	    binder.registerCustomEditor(Date.class, new DateEditor());  
	}  */
	
	@RequestMapping("/create")
	@ResponseBody
	public String createPath(@RequestBody Path path){
		Integer pathID=pathService.save(path);
		msg=new JSONObject();
		msg.put("pathID", pathID);
		return msg.toString();		
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/addGraphic/{pathID}")
	@ResponseBody
	public String addGraphic(@PathVariable Integer pathID,@RequestBody List<Graphic> graphics){
		pathService.addGraphic(pathID, graphics);
		msg=new JSONObject();
		msg.put("status", 200);
		return msg.toString();
	}
	
	@RequestMapping("/update/{pathID}")
	@ResponseBody
	public String updatePath(@PathVariable Integer pathID,@RequestBody Path newPath){
		pathService.updatePath(pathID, newPath);
		msg=new JSONObject();
		msg.put("status", 200);
		return msg.toString();
	}
	
	@RequestMapping("/paging")
	@ResponseBody
	public String getPagingList(@RequestParam int pagenum, @RequestParam int pagesize){
		JSONArray paths=pathService.getPagingList(pagenum, pagesize, "from path  order by date");
		Long totalNum=pathService.getTotalCount();
		msg=new JSONObject();
		msg.put("totalNum", totalNum);
		msg.put("pathArray", paths.toString());
		
		return msg.toString();
	}
		
	
}
