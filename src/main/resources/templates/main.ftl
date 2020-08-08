<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8"/>
    <title>首页</title>
    <#include "common/link.ftl">
</head>
<body>
<div>
    <#include "common/header.ftl"/>
    <div class="uk-grid-large uk-child-width-expand@s uk-text-center" uk-grid>
        <div>
            <div class="uk-card uk-card-default uk-card-body">
                <#if currentUser.isBlacklist==1>
                    <h3 class="uk-heading-line uk-text-center">当前状态&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
                                style="color: red;font-size: 0.8em;">黑名单中</span></h3>
                    <table class="uk-table uk-table-divider">
                        <tr>
                            <td>
                                开始时间：
                            </td>
                            <td>
                                ${userOutputDTO.startTime?string("yyyy-MM-dd HH:mm:ss")}
                            </td>
                        </tr>
                        <tr>
                            <td> 结束时间：</td>
                            <td> ${userOutputDTO.endTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        </tr>
                        <tr>
                            <td>持续时长：</td>
                            <td>${userOutputDTO.duration}</td>
                        </tr>
                        <tr>
                            <td>结束原因：</td>
                            <td>
                                <#if userOutputDTO.cause??>
                                    ${userOutputDTO.cause!" "}
                                <#else>
                                    <a class="uk-button uk-button-default" href="#modal4-sections" uk-toggle>添加结束原因</a>
                                    <div id="modal4-sections" uk-modal>
                                        <div class="uk-modal-dialog">
                                            <button class="uk-modal-close-default" type="button" uk-close></button>
                                            <div class="uk-modal-header">
                                                <h2 class="uk-modal-title">结束原因</h2>
                                            </div>
                                            <div class="uk-modal-body">
                                                <#--                                                <input type="hidden" name="id" value="${userOutput.id}"/>-->
                                                <input class="uk-input uk-form-width-medium uk-form-large"
                                                       type="text" name="cause" placeholder="填写结束原因"/>
                                            </div>
                                            <div class="uk-modal-footer uk-text-right">
                                                <button class="uk-button uk-button-default uk-modal-close"
                                                        type="button">Cancel
                                                </button>
                                                <a class="uk-button uk-button-primary" href="/livedays/daytime/cause">添加</a>
                                            </div>
                                        </div>
                                    </div>
                                </#if>
                            </td>
                        </tr>
                        <#--                        <tr>-->
                        <#--                            <td>解决方案：</td>-->
                        <#--                            <td>-->
                        <#--                                <#if userOutputDTO.isPlan==1>-->
                        <#--                                    有-->
                        <#--                                <#elseif userOutputDTO.isPlan==0>-->
                        <#--                                    <a href="#modal1-sections" uk-toggle>制定计划</a>-->
                        <#--                                    <div id="modal1-sections" uk-modal>-->
                        <#--                                        <div class="uk-modal-dialog">-->
                        <#--                                            <button class="uk-modal-close-default" type="button" uk-close></button>-->
                        <#--                                            <div class="uk-modal-header">-->
                        <#--                                                <h2 class="uk-modal-title">制定计划</h2>-->
                        <#--                                            </div>-->
                        <#--                                            <div class="uk-modal-body">-->
                        <#--                                                <input type="hidden" name="id" value="${userOutputDTO.dayId}"/>-->
                        <#--                                                <input class="uk-input uk-form-width-medium uk-form-large" type="date"-->
                        <#--                                                       name="startTime" placeholder="开始时间"/><br>-->
                        <#--                                                <input class="uk-input uk-form-width-medium uk-form-large" type="date"-->
                        <#--                                                       name="endTime" placeholder="结束时间"/><br>-->
                        <#--                                                <input class="uk-input uk-form-width-medium uk-form-large" type="text"-->
                        <#--                                                       name="solvePlan" placeholder="计划内容"/>-->
                        <#--                                            </div>-->
                        <#--                                            <div class="uk-modal-footer uk-text-right">-->
                        <#--                                                <button class="uk-button uk-button-default uk-modal-close"-->
                        <#--                                                        type="button">取消-->
                        <#--                                                </button>-->
                        <#--                                                <a class="uk-button uk-button-primary" href="/plan/add">保存</a>-->
                        <#--                                            </div>-->
                        <#--                                        </div>-->
                        <#--                                    </div>-->
                        <#--                                </#if>-->
                        <#--                            </td>-->
                        <#--                        </tr>-->
                    </table>
                <#elseif currentUser.isBlacklist==0>
                    <h3 class="uk-heading-line uk-text-center">当前状态&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
                                style="color: green;font-size: 0.8em;">正常</span>
                    </h3>
                    <table class="uk-table uk-table-divider">
                        <tr>
                            <td>
                                开始时间：
                            </td>
                            <td>
                                ${userOutputDTO.startTime?string("yyyy-MM-dd HH:mm:ss")}
                            </td>
                        </tr>
                        <tr>
                            <td>当前时长：</td>
                            <td>${userOutputDTO.sustain}</td>
                        </tr>
                        <tr>
                            <td>备注：</td>
                            <td><a href="#modal1-sections" uk-toggle>添加备注</a>
                                <div id="modal1-sections" uk-modal>
                                    <div class="uk-modal-dialog">
                                        <button class="uk-modal-close-default" type="button" uk-close></button>
                                        <div class="uk-modal-header">
                                            <h2 class="uk-modal-title">添加备注</h2>
                                        </div>
                                        <div class="uk-modal-body">
                                            <input type="hidden" name="id" value="${userOutputDTO.id}"/>
                                            <input class="uk-input uk-form-width-medium uk-form-large" type="text"
                                                   name="content" placeholder="计划内容"/>
                                        </div>
                                        <div class="uk-modal-footer uk-text-right">
                                            <button class="uk-button uk-button-default uk-modal-close" type="button">
                                                取消
                                            </button>
                                            <a class="uk-button uk-button-primary" href="/livedays/memo/add">保存</a>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </#if>
            </div>
        </div>
        <div>
            <div class="uk-card uk-card-default uk-card-body">
                <h3 class="uk-heading-line uk-text-center">最新信息</h3>
                <table class="uk-table uk-table-striped">
                    <tr>
                        <td>用户昵称：</td>
                        <td> ${currentUser.username}</td>
                    </tr>
                    <tr>
                        <td>最新时长：</td>
                        <td> ${currentUser.duration}</td>
                    </tr>
                    <tr>
                        <td>最新问题：</td>
                        <td>
                            <#--                ${currentUser.problem}<br>-->
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <#if currentUser.isMaster==0>
        <table class="uk-table uk-table-hover uk-table-divider">
            <tr>
                <td>开始时间</td>
                <td>结束时间</td>
                <td>结束原因</td>
                <td>解决方案</td>
            </tr>
            <#if planslist??>
                <#list planslist as plan>
                    <tr>
                        <td>${plan.startTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${plan.endTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${plan.problem}</td>
                        <td>${plan.solvePlan}</td>
                    </tr>
                </#list>
            </#if>
        </table>
    </#if>
</div>

<div style="width:300px;margin:0 auto; padding:20px 0;">
    <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=32058102001444"
       style="display:inline-block;text-decoration:none;height:20px;line-height:20px;"><img src="/images/beian.png" style="float:left;"/>
        <p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#939393;">苏公网安备
            32058102001444号</p></a>
</div>

</body>
</html>