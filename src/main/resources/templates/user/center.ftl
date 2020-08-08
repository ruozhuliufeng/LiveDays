<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>个人中心</title>
    <#include "../common/link.ftl">
</head>
<body>
<div class="uk-container">
    <div class="uk-background-cover uk-height-medium uk-panel uk-flex uk-flex-center uk-flex-middle"
         style="background-image: url(./images/backimg.jpg); ">
        <div class="uk-width-1-1">
            <#include "../common/header.ftl">
        </div>
        <br>
        <div class="uk-width-1-1">
            <div class="uk-width-1-4">
                <img class="uk-card uk-card-default uk-card-body" data-src="/images/banner.jpg" width="100px"
                     height="50px" uk-img>
            </div>
            <div class="uk-width-1-4">
                <div>
                    你好，${currentUser.username}
                </div>
                <div>
                    <#--                用户名：${currentUser.username}    您的另一伴是：<#if currentUser.bing??> ${currentUser.bing} <#else>您尚未选择另一伴 </#if>-->
                </div>
            </div>
            <div class="uk-width-expand">
                <a href="#" class="uk-button uk-button-primary uk-width-1-1 uk-margin-small-bottom">个人信息修改</a>
            </div>
        </div>
    </div>

    <div uk-grid>
        <ul class="uk-subnav uk-subnav-pill uk-width-1-1" uk-tab="animation: uk-animation-fade">
            <li class="uk-width-1-3"><a href="#">基本信息</a></li>
            <li class="uk-width-1-3"><a href="#">安全设置</a></li>
            <li class="uk-width-1-3"><a href="#">注销账号</a></li>
        </ul>
        <br>
        <ul id="component-tab-left" class="uk-switcher uk-margin uk-width-1-1">
            <li class="uk-width-1-1 uk-text-center">
                <table class="uk-table uk-table-hover">
                    <tr>
                        <td>用户昵称</td>
                        <td>${currentUser.username}</td>
                    </tr>
                    <tr>

                        <td>用户性别</td>
                        <td>${currentUser.sex}</td>
                    </tr>
                    <tr>
                        <td>手机号码</td>
                        <td>${currentUser.phone}</td>
                    </tr>
                    </tbody>
                </table>
            </li>
            <li class="uk-width-1-1 uk-text-center">
                <table class="uk-table uk-table-hover">
                    <tr>
                        <td>密码设置</td>
                        <td>Table Data</td>
                    </tr>
                    <tr>

                        <td>邮箱验证</td>
                        <td>${currentUser.email}</td>
                        <td>验证邮箱</td>
                    </tr>
                    <tr>
                        <td>另一伴</td>
                        <td>Table Data</td>
                        <td>添加(存在，则改为取消绑定)</td>
                    </tr>
                    </tbody>
                </table>
            </li>
            <li class="uk-width-1-1 uk-text-center">
                <a href="#" class="btn btn-danger">注销账号</a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
