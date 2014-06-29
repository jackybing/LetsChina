package com.ltca.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltca.entity.Path;
import com.ltca.entity.Question;
import com.ltca.entity.Tag;
import com.ltca.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionAction {
	@Resource(name="questionServiceImpl")
	private QuestionService questionService;
	
	private JSONObject msg;
	
	@RequestMapping("/create")
	@ResponseBody
	public String createPath(@RequestBody Question  question){
		Integer qID=questionService.save(question);
		msg=new JSONObject();
		msg.put("questionID", qID);
		return msg.toString();
	}
	
	@RequestMapping("/updateTag/{questionID}")
	@ResponseBody
	public String updateTag(@PathVariable Integer questionID,@RequestBody List<Tag> tags){
		questionService.updateTag(questionID, tags);
		msg=new JSONObject();
		msg.put("status", 200);
		return msg.toString();
	}
}
