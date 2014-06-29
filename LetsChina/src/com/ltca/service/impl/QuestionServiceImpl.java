package com.ltca.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ltca.dao.QuestionDao;
import com.ltca.entity.Graphic;
import com.ltca.entity.Question;
import com.ltca.entity.Tag;
import com.ltca.entity.User;
import com.ltca.service.QuestionService;

@Service("questionServiceImpl")
public class QuestionServiceImpl extends BaseServiceImpl<Question, Integer>
		implements QuestionService {
	@Resource(name="questionDaoImpl")
	private QuestionDao questionDao;

	public JSONArray getPagingList(int pagenum, int pagesize,
			String pagingHql) {
		List<Question> questions=getListForPaging(pagenum, pagesize, pagingHql);
		jsonArray=new JSONArray();
		for (Question question : questions) {
			jsonObject=new JSONObject();
			jsonObject.put("id", question.getId());
			jsonObject.put("title", question.getTitle());
			jsonObject.put("content", question.getContent());
			jsonObject.put("date", question.getDate());
			for (Graphic graphic : question.getGraphics()) {
				jsonObject2=new JSONObject();
				jsonObject2.put("graphicID", graphic.getId());
				jsonObject2.put("url", graphic.getUrl());
				jsonObject2.put("disk", graphic.getDisk());
				jsonArray2.add(jsonObject2);
			}
			
			jsonObject.put("graphics", jsonArray2);
			
			jsonObject2=new JSONObject();
			User asker=question.getAsker();
			jsonObject2.put("userID", asker.getId());
			jsonObject2.put("avatar", asker.getAvatarUrl());
			jsonObject.put("user", jsonObject2);
			
			//缺少赞数指标
			
			jsonArray.add(jsonObject);
		}
		return jsonArray;
		
	}
	
	public void updateTag(Integer questionID,List<Tag> tags){
		questionDao.updateTag(questionID, tags);
	}

}
