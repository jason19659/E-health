function checkUsername(){
	var username;
	username = document.getElementById('firstname').value;
	 if(username.length<6){
		 document.getElementById("usermsg").innerHTML='<span style="color:red;font-size:16px;">字符长度不够!</span>';
	} else {
		$.getJSON("api/user/usercheck/username="+username, function(data) {
			alert(data);
		}
		$.ajax({
		    type:"GET",
		    data:"username=" + username,
		    url:"api/user/usercheck",
		    success:function(msg){
		        alert(msg);//msg就是页面返回的图片地址
		    }
		    error:function(){
		        alert("error");
		    }
		});
	}
	 
}