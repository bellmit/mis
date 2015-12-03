<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="/resources/components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <link href="/resources/startbootstrap/css/sb-admin-2.css" rel="stylesheet">
    <link href="/resources/components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!--daterangepicker-->
    <link rel="stylesheet" href="/resources/self/daterangepicker.css"/>

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
                <a href="/" target="_top">Home</a>
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
                        <a class="btn btn-primary btn-sm" href="${(referer)!'/default'}">
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

        <div class="col-lg-4">
            <div class="panel panel-default">
                <div class="panel-heading">患者一般情况</div>
                <div class="panel-body"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt
                    est vitae ultrices
                    accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p></div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-md-4 control-label">姓名</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control" id="name" name="name" placeholder="姓名" title="姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">入院时间</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control" id="admissionDate" name="admissionDate"
                                   placeholder="入院时间" title="入院时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">性别</label>

                        <div class="col-md-8">
                            <label class="radio-inline"><input type="radio" name="sex" id="male"
                                                               value="1" checked>女性</label>
                            <label class="radio-inline"><input type="radio" name="sex" id="female"
                                                               value="2">男性</label>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-3">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-md-4 control-label">出院时间</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control" id="dischargeDate" name="dischargeDate"
                                   placeholder="出院时间" title="出院时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">年龄</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control" id="age" name="age"
                                   placeholder="年龄" title="年龄">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">病区</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control" id="ward" name="ward"
                                   placeholder="病区" title="病区">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-md-4 control-label">肾脏病理</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control" id="renalPathology" name="renalPathology"
                                   placeholder="肾脏病理" title="肾脏病理">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">发病年龄</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control" id="ageOfOnset" name="ageOfOnset"
                                   placeholder="发病年龄" title="发病年龄">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">住院编号</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control" id="patientId" name="patientId"
                                   placeholder="住院编号" title="住院编号">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-md-4 control-label">血压</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control" id="bloodPressure" name="bloodPressure"
                                   placeholder="血压" title="血压">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">过敏源</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control" id="allergens" name="allergens"
                                   placeholder="过敏源" title="过敏源">
                        </div>
                    </div>
                </div>
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
                            <a class="btn btn-primary btn-sm" href="${(referer)!'/default'}">
                                <span class="ace-icon fa fa-back bigger-110"></span>返回来源页
                            </a></span></div>
            </div>
        </div>
    </div>

    <script src="/resources/components/jquery/dist/jquery.min.js"></script>
    <script src="/resources/components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/resources/components/metisMenu/dist/metisMenu.min.js"></script>
    <script src="/resources/startbootstrap/js/sb-admin-2.js"></script>

    <script src="/resources/ace/assets/js/bootbox.js"></script>

    <!--daterangepicker-->
    <script src="/resources/self/moment.min.js"></script>
    <script src="/resources/self/daterangepicker.js"></script>

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