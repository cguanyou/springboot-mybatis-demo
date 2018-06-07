$(function(){  
	 var taskbyresult = {};
	 taskbyresult.result = "0";
     $.ajax({     
		 type:"post",
		 url:"findtaskbyresult",
		 data:JSON.stringify(taskbyresult),
		 contentType:"application/json",
		 async : false,
		 success:function(result){
			 if(result){
				 var str = "";//定义用于拼接的字符串
			     for (var i = 0; i < result.length; i++) {
			          //拼接表格的行和列
			         str = "<tr><td>" + result[i].id + "</td>" +
			         		"<td>" + result[i].category + "</td>" +
			         		"<td>" + result[i].bpName + "</td>" +
			         		"<td><input type='button' value='通过' id='"+result[i].id+"' onclick='pass(this)'><input id='"+result[i].id+"' type='button' value='不通过' onclick='fail(this)'></td></tr>";
			          //追加到table中
			          $("#tab").append(str);   
			     }
				 
			 }else{
				 alert("系统异常，请联系管理员");
			 }
	     }});
    
})






function pass(obj){
//	 $("#tab").on("click", ":button", function(event){
////		 id = $("#text").val($(this).closest("tr").find("td").eq(0).text());
//		 id = $(this).closest("tr").find("td").eq(0).text();
//		 category = $(this).closest("tr").find("td").eq(1).text();
//		 bpName = $(this).closest("tr").find("td").eq(2).text();
//	 });
	var taskresult = {};
	taskresult.result = "1";
	taskresult.id=obj.id;
	$.ajax({     
		 type:"post",
		 url:"updatetask",
		 data:JSON.stringify(taskresult),
		 contentType:"application/json",
		 async : false,
		 success:function(result){
			 if(result){
				 alert("系统异常，请联系管理员");
			 }else{
				 alert("通过成功");
				 location.reload();
				 console.log("executetask success");
			 }
	     }});
}


//function fail(obj){
//	var taskfailresult = {};
//	taskfailresult.id=obj.id;
//	$.ajax({     
//		 type:"post",
//		 url:"deletetask",
//		 data:JSON.stringify(taskfailresult),
//		 contentType:"application/json",
//		 async : false,
//		 success:function(result){
//			 if(result){
//				 alert("系统异常，请联系管理员");
//			 }else{
//				 alert("不通过成功");
//				 location.reload();
//				 console.log("executetask success");
//			 }
//	     }});
//}

function fail(obj){
	var taskfailresult = {};
	taskfailresult.result = "2";
	taskfailresult.id=obj.id;
	$.ajax({     
		 type:"post",
		 url:"updatetask",
		 data:JSON.stringify(taskfailresult),
		 contentType:"application/json",
		 async : false,
		 success:function(result){
			 if(result){
				 alert("系统异常，请联系管理员");
			 }else{
				 alert("不通过成功");
				 location.reload();
				 console.log("executetask success");
			 }
	     }});
}



