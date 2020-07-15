<nav class="uk-navbar-container uk-margin" uk-navbar>
    <div class="uk-navbar-center">
        <ul class="uk-navbar-nav">
            <li class="uk-active"><a href="/main">首页</a></li>
            <#if currentUser??>
                <li>
                    <a href="#">我的</a>
                    <div class="uk-navbar-dropdown">
                        <ul class="uk-nav uk-navbar-dropdown-nav">
                            <#if currentUser.isMaster==1>
                                <li><a href="/user/center">个人中心</a></li>
                                <li><a href="/user/other">对方管理</a></li>
                            <#elseif currentUser.isMaster == 0>
                                <li><a href="/user/center">个人中心</a></li>
                                <li><a href="/user/self">个人管理</a></li>
                            </#if>
                        </ul>
                    </div>
                </li>
            </#if>
            <li>
                <a href="#">用户</a>
                <div class="uk-navbar-dropdown">
                    <ul class="uk-nav uk-navbar-dropdown-nav">
                        <#if currentUser??>
                            <li><a href="/user/logout">退出</a></li>
                        <#else>
                            <li><a href="/login">登录</a></li>
                            <li><a href="/register">注册</a></li>
                        </#if>
                    </ul>
                </div>
            </li>
        </ul>

    </div>
</nav>