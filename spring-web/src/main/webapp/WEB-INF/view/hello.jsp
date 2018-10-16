<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spring</title>
</head>
<body>
<h2>hello</h2>
<button id="send" name ="发送" onclick="send()">发送</button>
<button id="receive" name="接收" onclick="receiver()">接收</button>
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    function send() {
        $.ajax({
            type:'post',
            url:'http://localhost:8080/activemq/queueSender',
            data:{
                message : "消息1"
            },
            dataType:'json',
            success:function(data){
               alert(data);
            }
        });
    }
    function receiver() {
        $.ajax({
            type:'post',
            url:'http://localhost:8080/activemq/topicSender',
            data:{
                message : "主题消息1"
            },
            dataType:'json',
            success:function(data){
                alert(data);
            }
        });
    }
</script>
</body>
</html>