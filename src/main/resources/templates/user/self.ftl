<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <#include "../common/link.ftl"/>
</head>
<body>
<#include "../common/header.ftl">
<div class="uk-child-width-1-2@s uk-grid-collapse uk-text-center" uk-grid>
    <!-- 问题列表 -->
    <div>
        <div class="uk-tile uk-tile-xsmall">

            <p class="uk-h4">问题列表</p>
            <table class="uk-table uk-table-striped">
                <thead>
                <tr>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>持续时长</th>
                    <th>结束原因</th>
                    <th>是否解决</th>
                    <th>最终解决</th>
                    <th>手动操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list daylist as day>
                    <tr>
                        <td>${day.startTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td><#if day.endTime??>
                            ${day.endTime?string("yyyy-MM-dd HH:mm:ss")}
                                <#else>
                                正在进行中
                            </#if>
                        </td>
                        <td>${day.duration}</td>
                        <td>${day.cause}</td>
                        <td>
                            <#if day.isComplete == 1>
                                已完成
                                <#elseif day.isComplete==0>
                                未完成
                            </#if>
                        </td>
                        <td>
                            <#if day.isEndComplete == 1>
                                已完成
                            <#elseif day.isEndComplete==0>
                                未完成
                            </#if>
                        </td>
                        <td><a href="/livedays/daytime/complete?id=${day.id}" class="btn btn-block">点击完成</a> </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
    <!-- 计划列表 -->
    <div>
        <div class="uk-tile uk-tile-muted">
            <p class="uk-h4">计划列表</p>
            <table class="uk-table uk-table-hover uk-table-divider">
                <tr>
                    <th>开始日期</th>
                    <th>结束日期</th>
                    <th>计划用时</th>
                    <th>问题原因</th>
                    <th>解决计划</th>
                    <th>是否实施</th>
                    <th>计划操作</th>
                </tr>
                <#if planlist??>
                    <#list planlist as plan>
                        <tr>
                            <td>${plan.startTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                            <td>${plan.endTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                            <td>${plan.duration}</td>
                            <td>${plan.problem}</td>
                            <td>${plan.solvePlan}</td>
                            <td>
                                <#if plan.isCarry == 1>
                                    计划准许
                                <#elseif plan.isCarry==0>
                                    重新修改
                                </#if>
                            </td>
                            <td>
                                <a href="#modal-sections" uk-toggle>修改</a>
                                ||<a href="/livedays/plan/delete?id=${plan.id}">删除</a>
                                <div id="modal-sections" uk-modal>
                                    <div class="uk-modal-dialog">
                                        <button class="uk-modal-close-default" type="button" uk-close></button>
                                        <div class="uk-modal-header">
                                            <h2 class="uk-modal-title">计划修改</h2>
                                        </div>
                                        <div class="uk-modal-body">
                                            <input type="hidden" name="id" value="${plan.id}"/>
                                            <input class="uk-input uk-form-width-medium uk-form-large" type="text" name="solvePlan" placeholder="修改计划内容"/>
                                        </div>
                                        <div class="uk-modal-footer uk-text-right">
                                            <button class="uk-button uk-button-default uk-modal-close" type="button">取消</button>
                                            <a class="uk-button uk-button-primary" href="/livedays/plan/update">保存</a>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </#list>
                </#if>
            </table>
        </div>
    </div>
    <!-- 备忘列表 -->
    <div>
        <div class="uk-tile uk-tile-primary">
            <p class="uk-h4">备忘列表</p>
            <table class="uk-table uk-table-divider">
                <tr>
                    <th>序号</th>
                    <th>记录时间</th>
                    <th>备忘内容</th>
                </tr>
                <#if momolist??>
                    <#list  memolist as memo>
                        <tr>
                            <td>${momo_index+1}</td>
                            <td>${momo.startTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                            <td>${momo.content}</td>
                        </tr>
                    </#list>
                </#if>
            </table>
        </div>
    </div>
    <div>
        <div class="uk-tile uk-tile-default">
            <p class="uk-h4">通知列表</p>
            <span style="color:red">暂未实现该功能</span>
            <dl class="uk-description-list uk-description-list-divider uk-align-left">
                <dt>通知标题</dt>
                <dd>通知内容</dd>
            </dl>
        </div>
    </div>
</div>
</body>
</html>
