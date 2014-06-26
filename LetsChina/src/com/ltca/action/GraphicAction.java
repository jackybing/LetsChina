package com.ltca.action;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltca.service.GraphicService;

@Controller
@RequestMapping("/graphic")
public class GraphicAction {
	
	@Resource(name="graphicServiceImpl")
	private GraphicService graphicService;
	
	private JSONObject msg;
	@RequestMapping("/delete/{gID}")
	@ResponseBody
	public String delete(@PathVariable Integer gID){
		graphicService.deleteGraphic(gID);
		msg=new JSONObject();
		msg.put("stutas", 200);
		return msg.toString();		
	}
}
