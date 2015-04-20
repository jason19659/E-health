function checkUsername(){
	var username;
	username = document.getElementById('username').value;
	
		$.getJSON("api/user/usercheck?username="+username, function(data) {
			document.getElementById("usermsg").innerHTML='<span style="color:red;font-size:16px;">'+data+'</span>';
		})
		
		 
	 
}


function getPath(){
	//获取当前网址，如： http://localhost:8080/Tmall/index.jsp 
	var curWwwPath=window.document.location.href; 

	//获取主机地址之后的目录如：/Tmall/index.jsp 
	var pathName=window.document.location.pathname; 
	var pos=curWwwPath.indexOf(pathName); 

	//获取主机地址，如： http://localhost:8080 
	var localhostPaht=curWwwPath.substring(0,pos); 

	//获取带"/"的项目名，如：/Tmall 
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	
	return localhostPaht+projectName;
	 
}

function sumbitForm(url) {
	var url2 = getPath() + url;
	document.reg.action = url2;
	document.reg.submit();
}