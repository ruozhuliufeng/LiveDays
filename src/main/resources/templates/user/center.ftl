<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>个人中心</title>
    <#include "../common/link.ftl">
</head>
<body>
<#include "../common/header.ftl">
<div class="uk-child-width-1-2@s" uk-grid>
    <div>
        <div uk-grid>
            <div class="uk-width-auto@m">
                <ul class="uk-tab-left" uk-tab="connect: #component-tab-left; animation: uk-animation-fade">
                    <li><a href="#">基本信息</a></li>
                    <li><a href="#">安全设置</a></li>
                    <li><a href="#">注销账号</a></li>
                </ul>
            </div>
            <div class="uk-width-expand@m">
                <ul id="component-tab-left" class="uk-switcher">
                    <li>
                        <form class="uk-form-horizontal uk-margin-large" method="post" action="/user/update" enctype="multipart/form-data">
                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-text">用户昵称</label>
                                <div class="uk-form-controls">
                                    <input name="username" class="uk-input" id="form-horizontal-text" type="text" disabled value="${currentUser.username}">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-text">用户性别</label>
                                <div class="uk-form-controls ">
                                    <input name="sex" class="uk-input" id="form-horizontal-text" type="text" disabled value="${currentUser.sex}">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-text">手机号码</label>
                                <div class="uk-form-controls">
                                    <input name="phone" class="uk-input" id="form-horizontal-text" type="text" disabled value="${currentUser.phone}">
                                </div>
                            </div>
                        </form>
                    </li>
                    <li>
                        <form class="uk-form-horizontal uk-margin-large">

                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-text">密码设置：</label>
                                <div class="uk-form-controls uk-inline">
                                    <input name="password" class="uk-input" id="form-horizontal-text" type="text" disabled value="${currentUser.password}">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-text">邮箱验证：</label>
                                <div class="uk-form-controls">
                                    <input name="email" class="uk-input" id="form-horizontal-text" type="text" disabled value="${currentUser.email}">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-text">另一伴：</label>
                                <div class="uk-form-controls uk-inline">
                                    <input name="phone" class="uk-input" id="form-horizontal-text" type="text" disabled placeholder="另一伴">
                                </div>
                            </div>
                        </form>
                    </li>
                    <li>
                        <a href="/user/cancel" class="btn btn-danger">注销账号</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
