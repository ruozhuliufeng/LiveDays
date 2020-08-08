<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <#include "../common/link.ftl">
</head>
<body>
<#include "../common/header.ftl">
<div class="uk-child-width-1-2@s uk-grid-match" uk-grid>
    <div>
        <div class="uk-card uk-card-hover uk-card-body">
            <#if relationship.status==1>
                <h3 class="uk-card-title">对方状态 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    <span style="color: red">黑名单中</span>
                </h3>
            <#elseif relationship.status==0>
                <h3 class="uk-card-title">对方状态 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    <span style="color: green">正常</span>
                </h3>
            </#if>
            <a class="uk-button uk-button-default uk-width-1-1 uk-margin-small-bottom"
               href="/livedays/daytime/into?id=${currentUser.id}">拉入黑名单</a>
            <a class="uk-button uk-button-primary uk-width-1-1 uk-margin-small-bottom"
               href="/livedays/daytime/out?id=${currentUser.id}">解除黑名单</a>
        </div>
    </div>
    <div>
        <div class="uk-card uk-card-default uk-card-hover uk-card-body">
            <h3 class="uk-card-title">对方的所有计划</h3>
            <table class="uk-table uk-table-hover uk-table-divider">
                <thead>
                <tr>
                    <th>开始日期</th>
                    <th>结束日期</th>
                    <th>计划用时</th>
                    <th>问题原因</th>
                    <th>解决计划</th>
                    <th>是否实施</th>
                    <th>手动操作</th>
                </tr>
                </thead>
                <tbody>
                <#list planslist as plan>

                    <tr>
                        <td>${plan.startTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${plan.endTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${plan.duration}</td>
                        <td>${plan.problem}</td>
                        <td>${plan.solvePlan}</td>
                        <#if plan.isCarry==1>
                            <td>准许实施</td>
                        <#elseif plan.isCarry==0>
                            <td>重新修改</td>
                        </#if>
                        <td><a href="/livedays/daytime/carry?id=${plan.id}" class="uk-button uk-button-primary">准许实施</a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <div>
        <div class="uk-card uk-card-primary uk-card-hover uk-card-body uk-light">
            <h3 class="uk-card-title">对方所有问题</h3>
            <table class="uk-table uk-table-striped">
                <tr>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>持续时长</th>
                    <th>结束原因</th>
                    <th>是否解决</th>
                    <th>最终解决</th>
                    <th>手动操作</th>
                </tr>
                <#if dayslist??>
                    <#list dayslist as day>
                        <tr>
                            <td>${day.startTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                            <td>${day.endTime?string("yyyy-MM-dd HH:mm:ss")}</td>
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
                            <td><a href="/livedays/daytime/endcomplete?id=${day.id}" class="uk-button uk-button-primary">最终解决</a>
                            </td>
                        </tr>
                    </#list>
                </#if>

            </table>
        </div>
    </div>
    <div>
        <div class="uk-card uk-card-secondary uk-card-hover uk-card-body uk-light">
            <h3 class="uk-card-title">通知</h3>
            <p>通知对方</p>
        </div>
    </div>
</div>
</body>
</html>
