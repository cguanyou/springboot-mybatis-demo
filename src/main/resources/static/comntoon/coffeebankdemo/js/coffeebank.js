

function submit(obj){
	$(obj).css("visibility","hidden");
	$("#shuazheng").show();
//	var data = '{"functionid":"'+obj.value+'"}';
//	JSON.stringify(data);
//	 $.ajax({     
//		 type:"post",
//		 url:"forwardPath",
//		 data:data,
//		 contentType:"application/json",
//		 success:function(result){
//			alert(result);
//		    window.location.href = result;
////			alert(result);
////	        $("#div1").html(result);
//	     }});
}


var time;

function checkcard(obj){
	var data = '{"customcard":"'+obj.value+'"}';
	JSON.stringify(data);
	 $.ajax({     
		 type:"post",
		 url:"findcustom",
		 data:data,
		 contentType:"application/json",
		 success:function(result){
			 if(result){
				 var checkresult = result.checkresult;
					if(checkresult == "1"){
						$("#shuazheng").hide();
						$("#shuaka").show();
						$("#name").val(result.bpName);
					}else{
						$("#name").val(result.bpName);
						var checkdata = {};
						checkdata.bpName = result.bpName;
						checkdata.category = "a";
						checkdata.result = "0";
						createtask(checkdata);
						time = setInterval(function(){
							querytask(taskid);
						},3000);
						$("#check").css("visibility","");
						$("#shuazheng").hide();
					}
				 
			 }else{
				 alert("请重刷身份证！");
			 }
	     }});
}






function lurusubmit(obj){
	$("#luru").hide();
	$("#yanmi").show();
}


function mimasubmit(obj){
	$("#yanmi").hide();
	$("#jieguo").show();
	var str = "";//定义用于拼接的字符串
    str = "<tr><td>卡下挂定期</td><td>chen</td><td>22.00</td><td>成功</td><td>利率：1.98,存期：三个月,币种：人民币,到期处理方式：自动存续,开户金额：20000.00,账户账号：50000000000000232818</td></tr>";
    $("#jieguotab").append(str);   
}




function querytask(taskid){
	var taskbyid = {};
	taskbyid.id = taskid;
	$.ajax({     
		 type:"post",
		 url:"findtaskbyid",
		 data:JSON.stringify(taskbyid),
		 contentType:"application/json",
		 async : false,
		 success:function(result){
			 if(result){
				 if(result.result == 1){
					 clearInterval(time);
					 $("#check").css("visibility","hidden");
					 $("#shuazheng").hide();
					 $("#shuaka").show();
				 }
				 if(result.result == 2){
					 clearInterval(time);
					 $("#check").css("visibility","hidden");
					 $("#shuazheng").hide();
					 $("#checkfail").css("visibility","");
				 }
			 }else{
				 alert("系统异常，请联系管理员");
			 }
	     }});
}


function yue(obj){
	var yuedata = {};
	yuedata.cardno = obj.value;
	$.ajax({     
		 type:"post",
		 url:"querycardyue",
		 data:JSON.stringify(yuedata),
		 contentType:"application/json",
		 async : false,
		 success:function(result){
			 if(result){
				 $("#mimayue").text("余额为："+result.yue);
			 }else{
				 $("#mimayue").text("余额为：");
				 alert("系统异常，请联系管理员");
			 }
	     }});
}

function card(obj){
	$("#cardno").val(obj.value);
	$("#shuaka").hide();
	$("#luru").show();
}

var taskid;


function createtask(checkdata){
	$.ajax({     
		 type:"post",
		 url:"inserttask",
		 data:JSON.stringify(checkdata),
		 contentType:"application/json",
		 async : false,
		 success:function(result){
			 if(result){
				 taskid = result;
				 console.log("createtask success");
			 }else{
				 alert("系统异常，请联系管理员");
			 }
	     }});
}
