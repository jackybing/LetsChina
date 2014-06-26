function testJsonList(){
	/*var postParams=[{addInfo:"tianjin"},{addInfo:"nanchang"}];
	alert(JSON.stringify(postParams));
	$.ajax( {
		type : "POST",
		url : "user/addAddresses/1",//注意不要写成/user/demo,否则请求的url将没有项目名称，即IP:port/user/demo形式
		data : JSON.stringify(postParams),
		success : function(data) {
			alert(JSON.stringify(data));
		},
		contentType : "application/json"
	});*/
	
	/*$.ajax( {
		type : "POST",
		url : "test",//注意不要写成/user/demo,否则请求的url将没有项目名称，即IP:port/user/demo形式
		data : "",
		success : function(data) {
			alert(JSON.stringify(data));
		},
		contentType : "application/json"
	});*/
	
	/*var newPath={title:'tiananmen',content:'hello world',date:'2014-06-16',price:1000}
	$.ajax( {
		type : "POST",
		url : "path/create",//注意不要写成/user/demo,否则请求的url将没有项目名称，即IP:port/user/demo形式
		data : JSON.stringify(newPath),
		success : function(data) {
			alert(JSON.stringify(data));
			//data为json数据格式：'{pathID:'1'}，返回线路ID
		},
		contentType : "application/json"
	});*/
	
	/*var graphics=[{url:'url',disk:'disk',isMain:true},{url:'url',disk:'disk',isMain:false}];
	alert(JSON.stringify(graphics));
	var graphics=[{url:'url',disk:'disk',isMain:true},{url:'url',disk:'disk',isMain:false}];
	//其中graphics为图片数组，每个图片有三个属性，url为图片的网络地址，disk为图片的本地地址，isMain标识当前图片是否为主图片
	//图片的相关属性在图片上传成功时获得，请参考图片上传接口说明
	$.ajax( {
		type : "POST",
		url : "path/addGraphic/3",//3 为路线ID,该值由上一接口获得
		data : JSON.stringify(graphics),
		success : function(data) {
			alert(JSON.stringify(data));
			//data为json数据格式：'{status:'200'}，返回执行状态码
		},
		contentType : "application/json"
	});
	*/
	
	/*$.ajax( {
		type : "POST",
		url : "graphic/delete/3",//3 为图片ID
		data : '',
		success : function(data) {
			alert(JSON.stringify(data));
			//data为json数据格式：'{status:'200'}，返回执行状态码
		},
		contentType : "application/json"
	});*/
	
	/*var newPath={title:'gugong',content:'hello world',date:'2014-06-18',price:1200};
	//修改过的路线实体
	$.ajax({
		type : "POST",
		url : "path/update/3",//3 为路线ID,该值由上一接口获得
		data : JSON.stringify(newPath),
		success : function(data) {
			alert(JSON.stringify(data));
			//data为json数据格式：'{status:'200'}，返回执行状态码
		},
		contentType : "application/json"
	});*/
	
	/*$.ajax({
		type : "POST",
		url : "path/paging?pagenum=1&pagesize=1",//pagenum是当前页码，pagesize是一页包含的项数
		data : '',
		success : function(data) {
			alert(JSON.stringify(data));
			//data为json数据格式：'{totalNum:5,pathArray:[{},{}]}'，返回当前数据库所有的路线总线及当前页所有路线信息
		},
		contentType : "application/json"
	});*/
	
	
	
	
	
	
}