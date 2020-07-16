<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

<div class="main">
    <h1>欢迎进入系统</h1>
    <div class="w3_login">
        <div class="w3_login_module">
            <div class="module form-module">
                <div class="toggle">
                    切换
                </div>
                <div class="form">
                    <div style="text-align: center;"> <h2>登录账号</h2></div>
                    <form action="/user/login" method="post">
                        <input type="text" name="username" placeholder="用户名" required />
                        <input type="password" name="password" placeholder="密码" required />
                        <input type="submit" value="登录" />
                    </form>
                </div>
                <div class="form">
                    <div style="text-align: center;"><h2>创建一个账号</h2></div>
                    <form action="/user/save" method="post">
                        <input type="text" id="username" name="username" placeholder="用户名" onchange="isUniqueUsername(this)" required />
                        <input type="password" name="password" placeholder="密码" required />
                        <input type="email" name="email" placeholder="Email" required />
                        <input type="text" name="phone" placeholder="电话" required />
                        <input type="submit" value="注册" id="savebtn" />
                    </form>
                </div>
                <div class="cta"><a href="#">忘记密码?</a></div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $('.toggle').click(function(){
        $(this).children('i').toggleClass('fa-pencil');
        $('.form').animate({height: "toggle",'padding-top': 'toggle','padding-bottom': 'toggle',opacity: "toggle"}, "slow");
    });
    //判断用户名的唯一性
    function isUniqueUsername(a) {
        //获取页面输入框输入的用户名
        var username=$("#username").val();
        //请求controller判断用户名的唯一性
        $.ajax({
            //url路径
            url:"/user/isUniqueUsername",
            //data请求数据
            data:{"username":username},
            //dataType json
            type:"get",
            //回调函数
            success:function (data) {
                //回调函数 data 返回流
                if(data==="false"){
                    //如果返回false不可使用
                    //提示用户已存在 ----设置文本框改成红色  宽度为1  样式实线
                    $("#username").attr("style","border:red 1px solid");
                    // 保存按钮禁用
                    $("#savebtn").prop("disabled",true);
                }else {
                    //如果返回的是true    则设置保存按钮可用  恢复原来的样式  文本框还原
                    $("#username").attr("style","");
                    $("#savebtn").prop("disabled",false);
                }
            }
        });
    }
</script>
</body>
</html>