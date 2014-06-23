package com.ltca.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ltca.dao.AnswerDao;
import com.ltca.entity.Answer;
import com.ltca.entity.Graphic;
import com.ltca.entity.User;
import com.ltca.service.AnswerService;

@Service("answerServiceImpl")
public class AnswerServiceImpl extends BaseServiceImpl<Answer, Integer> implements
		AnswerService {
	
	@Resource(name="answerDaoImpl")
	private AnswerDao answerDao;
	
	public JSONArray getListForPaging(int questionID,int pagenum, int pagesize,
			String pagingHql) {
		@SuppressWarnings("unchecked")
		List<Answer> answers=getListForPaging(questionID,pagenum, pagesize, pagingHql);
		jsonArray=new JSONArray();
		for (Answer answer : answers) {
			jsonObject=new JSONObject();
			jsonObject.put("id", answer.getId());
			jsonObject.put("title", answer.getTitle());
			jsonObject.put("content", answer.getContent());
			jsonObject.put("date", answer.getDate());
			
			jsonArray2=new JSONArray();
			for (Graphic graphic : answer.getGraphics()) {
				jsonObject2=new JSONObject();
				jsonObject2.put("gID", graphic.getId());
				jsonObject2.put("url", graphic.getUrl());
				jsonObject2.put("disk", graphic.getDisk());
				
				jsonArray2.add(jsonObject2);
			}
			
			jsonObject.put("graphics", jsonArray2);
			
			jsonObject2=new JSONObject();
			User answerer=answer.getAnswerer();
			jsonObject2.put("userID", answerer.getId());
			jsonObject2.put("avatar", answerer.getAvatarUrl());
			jsonObject.put("user", jsonObject2);
			
			//可能需要添加点赞数
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	
}
