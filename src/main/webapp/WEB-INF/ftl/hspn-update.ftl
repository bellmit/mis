<!doctype html>
<html>
<head>
<#include "/common/common_css.ftl">

    <!--daterangepicker-->
    <link rel="stylesheet" href="${context.contextPath}/resources/self/daterangepicker.css"/>

    <title>顾客资料编辑</title>
    <style>
        .form-group {
            margin-bottom: 4px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <span class="ace-icon fa fa-home home-icon"></span>
                <a href="${context.contextPath}/" target="_top">Home</a>
            </li>
            <li class="active">过敏性紫癜肾炎患者检查表 <a href="" title="刷新"><span class="fa fa-refresh"></span></a></li>
        </ul>
    </div>

    <div class="page-content">
        <div class="row">
        <#if success??>
            <div class="row">
                <div class="col-sm-offset-3 col-sm-4 alert alert-success">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            class="fa fa-times"></span></button>
                ${success}</div>
            </div>
        </#if>
        <#if error??>
            <div class="row">
                <div class="col-sm-offset-3 col-sm-4 alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            class="fa fa-times"></span></button>
                ${error}</div>
            </div>
        </#if>
        <#if errors??>
            <#list errors as error>
                <div class="row">
                    <div class="col-sm-offset-3 col-sm-4 alert alert-danger">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                                class="fa fa-times"></span></button>
                    ${error}</div>
                </div>
            </#list>
        </#if>
        </div>
    <#--警示行结束-->

        <form method="post" class="form-horizontal" id="hspn-update-form"></form>
        <input name="referer" type="hidden" value="${(referer)!'/'}"/>

        <div class="row">
            <div class="col-md-12">
                <div style="margin-bottom: 4px;">
                    <div class="btn-group btn-corner">
                        <button class="btn btn-success btn-sm" type="submit">
                            <span class="ace-icon fa fa-plus bigger-110"></span>提交
                        </button>
                        <button class="btn btn-warning btn-sm" type="reset">
                            <span class="ace-icon fa fa-undo bigger-110"></span>重置
                        </button>
                        <a class="btn btn-primary btn-sm" href="${(referer)!''}">
                            <span class="ace-icon fa fa-back bigger-110"></span>返回来源页
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <h3>患者一般情况</h3>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <div style="margin-bottom: 4px;"><span class="btn-group btn-corner">
                            <button class="btn btn-success btn-sm" type="submit">
                                <span class="ace-icon fa fa-plus bigger-110"></span>提交
                            </button>
                            <button class="btn btn-warning btn-sm" type="reset">
                                <span class="ace-icon fa fa-undo bigger-110"></span>重置
                            </button>
                            <a class="btn btn-primary btn-sm" href="${(referer)!''}">
                                <span class="ace-icon fa fa-back bigger-110"></span>返回来源页
                            </a></span></div>
            </div>
        </div>
    </div>
<#include "/common/common_js.ftl">
    <script src="${context.contextPath}/resources/ace/assets/js/bootbox.js"></script>

    <!--daterangepicker-->
    <script src="${context.contextPath}/resources/self/moment.min.js"></script>
    <script src="${context.contextPath}/resources/self/daterangepicker.js"></script>

    <script type="text/javascript">
        $(function () {
            $('#hspn-update-form').on('submit', function () {
                ;
            });

            $('#revisit-date-picker').daterangepicker({
                "autoUpdateInput": false,
                "singleDatePicker": true,
                "showDropdowns": true,
                "showWeekNumbers": true,
                "startDate": "2012-11-06",
                "locale": {
                    "format": "YYYY-MM-DD",
                    "separator": " - ",
                    "applyLabel": "Apply",
                    "cancelLabel": "Cancel",
                    "fromLabel": "From",
                    "toLabel": "To",
                    "customRangeLabel": "Custom",
                    "daysOfWeek": ["日", "一", "二", "三", "四", "五", "六"],
                    "monthNames": ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                    "firstDay": 1
                },
                "linkedCalendars": false,
                "minDate": moment().format('YYYY-MM-DD'),
                "maxDate": moment().add(6, 'months').format('YYYY-MM-DD')
            }, function (start, end, label) {
                $('#revisit-date-picker').val(start.format('YYYY年MM月DD日'));
                $('#revisit-date-field').val(start.format('YYYY-MM-DD'));
            });
            $('[data-toggle="tooltip-a"]').tooltip({trigger: 'hover'});
        });
    </script>
</body>
</html>