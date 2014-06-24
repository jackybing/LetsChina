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
	
	var postParams=[{type:'aa'},{title:'bb'}];
	alert(JSON.stringify(postParams));
	$.ajax( {
		type : "POST",
		url : "user/demo",//注意不要写成/user/demo,否则请求的url将没有项目名称，即IP:port/user/demo形式
		data : JSON.stringify({type:'aa'},{title:'bb'}),
		success : function(data) {
			alert(JSON.stringify(data));
		},
		contentType : "application/json"
	});
}