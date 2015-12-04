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
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span class="fa fa-times"></span></button>
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
                        <button form="hspn-update-form" class="btn btn-success btn-sm" type="submit">
                            <span class="ace-icon fa fa-plus bigger-110"></span>提交
                        </button>
                        <button form="hspn-update-form" class="btn btn-warning btn-sm" type="reset">
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
                <h3>紫癜肾患者</h3>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <div class="panel panel-default">
                    <div class="panel-heading">患者一般情况</div>
                    <div class="panel-body">

                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">姓名</label>

                                        <div class="col-md-8">
                                            <input form="hspn-update-form" type="text" class="form-control"
                                                   name="profile.name" placeholder="姓名" title="姓名"
                                                   value="${(mcd.profile.name)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">入院时间</label>

                                        <div class="col-md-8">
                                            <input form="hspn-update-form" type="text" class="form-control"
                                                   name="profile.admissionDate" placeholder="入院时间" title="入院时间"
                                                   value="${(mcd.profile.admissionDate?string('yyyy-MM-dd'))!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">性别</label>

                                        <div class="col-md-8">
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="profile.sex" value="1"
                                                                               <#if ((mcd.profile.sex.code)!1)==1>checked</#if>>女性</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="profile.sex"
                                                                               value="2"
                                                                               <#if ((mcd.profile.sex.code)!0)==2>checked</#if>>男性</label>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">出院时间</label>

                                        <div class="col-md-8">
                                            <input form="hspn-update-form" type="text" class="form-control"
                                                   name="profile.dischargeDate" placeholder="出院时间" title="出院时间"
                                                   value="${(mcd.profile.dischargeDate?string('yyyy-MM-dd'))!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">年龄</label>

                                        <div class="col-md-8">
                                            <input form="hspn-update-form" type="text" class="form-control"
                                                   name="profile.age" placeholder="年龄" title="年龄"
                                                   value="${(mcd.profile.age)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">病区</label>

                                        <div class="col-md-8">
                                            <input form="hspn-update-form" type="text" class="form-control"
                                                   name="profile.ward" placeholder="病区" title="病区"
                                                   value="${(mcd.profile.ward)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">肾脏病理</label>

                                        <div class="col-md-8">
                                            <input form="hspn-update-form" type="text" class="form-control"
                                                   name="profile.renalPathology" placeholder="肾脏病理" title="肾脏病理"
                                                   value="${(mcd.profile.renalPathology)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">发病年龄</label>

                                        <div class="col-md-8">
                                            <input form="hspn-update-form" type="text" class="form-control"
                                                   name="profile.ageOfOnset" placeholder="发病年龄" title="发病年龄"
                                                   value="${(mcd.profile.ageOfOnset)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">住院编号</label>

                                        <div class="col-md-8">
                                            <input form="hspn-update-form" type="text" class="form-control"
                                                   name="profile.patientId" placeholder="住院编号" title="住院编号"
                                                   value="${(mcd.profile.patientId)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">血压</label>

                                        <div class="col-md-8">
                                            <input form="hspn-update-form" type="text" class="form-control"
                                                   name="profile.bloodPressure" placeholder="血压" title="血压"
                                                   value="${(mcd.profile.bloodPressure)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">过敏源</label>

                                        <div class="col-md-8">
                                            <input form="hspn-update-form" type="text" class="form-control"
                                                   name="profile.allergens" placeholder="过敏源" title="过敏源"
                                                   value="${(mcd.profile.allergens)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <div class="panel panel-default">
                    <div class="panel-heading">本次入院指标对照</div>
                    <div class="panel-body">

                        <div class="row" style="border-bottom-style: dashed;border-bottom-width: 1px;">
                            <div class="col-md-11 col-md-offset-1">
                                <div class="row">
                                    <div class="col-md-3 col-md-offset-2">
                                        入院时
                                    </div>
                                    <div class="col-md-3">
                                        住院期间
                                    </div>
                                    <div class="col-md-3">
                                        出院时
                                    </div>
                                </div>
                            </div>
                        </div>

                    <#--检查大项行-->
                        <div class="row" style="border-bottom-style: dashed;border-bottom-width: 1px;">
                            <div class="col-md-1">
                                <h4>双肾B超</h4>
                            </div>

                            <div class="col-md-11">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">左肾大小</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="左肾大小"
                                                   placeholder="左肾大小" name="before.renalBModeUS.lKidneySize"
                                                   value="${(mcd.before.renalBModeUS.lKidneySize)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="左肾大小"
                                                   placeholder="左肾大小" name="during0.renalBModeUS.lKidneySize"
                                                   value="${(mcd.during0.renalBModeUS.lKidneySize)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="左肾大小"
                                                   placeholder="左肾大小" name="after.renalBModeUS.lKidneySize"
                                                   value="${(mcd.after.renalBModeUS.lKidneySize)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">右肾大小</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="右肾大小"
                                                   placeholder="右肾大小" name="before.renalBModeUS.rKidneySize"
                                                   value="${(mcd.before.renalBModeUS.rKidneySize)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="右肾大小"
                                                   placeholder="右肾大小" name="during0.renalBModeUS.rKidneySize"
                                                   value="${(mcd.during0.renalBModeUS.rKidneySize)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="右肾大小"
                                                   placeholder="右肾大小" name="after.renalBModeUS.rKidneySize"
                                                   value="${(mcd.after.renalBModeUS.rKidneySize)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">左肾实质厚度</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="左肾实质厚度" placeholder="左肾实质厚度"
                                                   name="before.renalBModeUS.lRenalParenchymaThickness"
                                                   value="${(mcd.before.renalBModeUS.lRenalParenchymaThickness)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="左肾实质厚度" placeholder="左肾实质厚度"
                                                   name="during0.renalBModeUS.lRenalParenchymaThickness"
                                                   value="${(mcd.during0.renalBModeUS.lRenalParenchymaThickness)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="左肾实质厚度" placeholder="左肾实质厚度"
                                                   name="after.renalBModeUS.lRenalParenchymaThickness"
                                                   value="${(mcd.after.renalBModeUS.lRenalParenchymaThickness)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">右肾实质厚度</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="右肾实质厚度" placeholder="右肾实质厚度"
                                                   name="before.renalBModeUS.rRenalParenchymaThickness"
                                                   value="${(mcd.before.renalBModeUS.rRenalParenchymaThickness)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="右肾实质厚度" placeholder="右肾实质厚度"
                                                   name="during0.renalBModeUS.rRenalParenchymaThickness"
                                                   value="${(mcd.during0.renalBModeUS.rRenalParenchymaThickness)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="右肾实质厚度" placeholder="右肾实质厚度"
                                                   name="after.renalBModeUS.rRenalParenchymaThickness"
                                                   value="${(mcd.after.renalBModeUS.rRenalParenchymaThickness)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">血流情况</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血流情况"
                                                   placeholder="血流情况" name="before.renalBModeUS.bloodFlow"
                                                   value="${(mcd.before.renalBModeUS.bloodFlow)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血流情况"
                                                   placeholder="血流情况" name="during0.renalBModeUS.bloodFlow"
                                                   value="${(mcd.during0.renalBModeUS.bloodFlow)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血流情况"
                                                   placeholder="血流情况" name="after.renalBModeUS.bloodFlow"
                                                   value="${(mcd.after.renalBModeUS.bloodFlow)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row" style="border-bottom-style: dashed;border-bottom-width: 1px;">
                            <div class="col-md-1">
                                <h4>双肾CT</h4>
                            </div>

                            <div class="col-md-11">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">左肾血流灌注峰值</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="左肾血流灌注峰值" placeholder="左肾血流灌注峰值"
                                                   name="before.renalScan.lPerfusion"
                                                   value="${(mcd.before.renalScan.lPerfusion)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="左肾血流灌注峰值" placeholder="左肾血流灌注峰值"
                                                   name="during0.renalScan.lPerfusion"
                                                   value="${(mcd.during0.renalScan.lPerfusion)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="左肾血流灌注峰值" placeholder="左肾血流灌注峰值"
                                                   name="after.renalScan.lPerfusion"
                                                   value="${(mcd.after.renalScan.lPerfusion)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">右肾血流灌注峰值</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="右肾血流灌注峰值" placeholder="右肾血流灌注峰值"
                                                   name="before.renalScan.rPerfusion"
                                                   value="${(mcd.before.renalScan.rPerfusion)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="右肾血流灌注峰值" placeholder="右肾血流灌注峰值"
                                                   name="during0.renalScan.rPerfusion"
                                                   value="${(mcd.during0.renalScan.rPerfusion)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="右肾血流灌注峰值" placeholder="右肾血流灌注峰值"
                                                   name="after.renalScan.rPerfusion"
                                                   value="${(mcd.after.renalScan.rPerfusion)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">左肾</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="左肾"
                                                   placeholder="左肾" name="before.renalScan.lKidney"
                                                   value="${(mcd.before.renalScan.lKidney)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="左肾"
                                                   placeholder="左肾" name="during0.renalScan.lKidney"
                                                   value="${(mcd.during0.renalScan.lKidney)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="左肾"
                                                   placeholder="左肾" name="after.renalScan.lKidney"
                                                   value="${(mcd.after.renalScan.lKidney)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">右肾</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="右肾"
                                                   placeholder="右肾" name="before.renalScan.rKidney"
                                                   value="${(mcd.before.renalScan.rKidney)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="右肾"
                                                   placeholder="右肾" name="during0.renalScan.rKidney"
                                                   value="${(mcd.during0.renalScan.rKidney)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="右肾"
                                                   placeholder="右肾" name="after.renalScan.rKidney"
                                                   value="${(mcd.after.renalScan.rKidney)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border-bottom-style: dashed;border-bottom-width: 1px;">
                            <div class="col-md-1">
                                <h4>血常规</h4>
                            </div>

                            <div class="col-md-11">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">红细胞计数</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="红细胞计数" placeholder="红细胞计数"
                                                   name="before.bloodTest.erythrocyteAmount"
                                                   value="${(mcd.before.bloodTest.erythrocyteAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="红细胞计数" placeholder="红细胞计数"
                                                   name="during0.bloodTest.erythrocyteAmount"
                                                   value="${(mcd.during0.bloodTest.erythrocyteAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="红细胞计数" placeholder="红细胞计数"
                                                   name="after.bloodTest.erythrocyteAmount"
                                                   value="${(mcd.after.bloodTest.erythrocyteAmount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">血红蛋白</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血红蛋白"
                                                   placeholder="血红蛋白" name="before.bloodTest.hemoglobinAmount"
                                                   value="${(mcd.before.bloodTest.hemoglobinAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血红蛋白"
                                                   placeholder="血红蛋白" name="during0.bloodTest.hemoglobinAmount"
                                                   value="${(mcd.during0.bloodTest.hemoglobinAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血红蛋白"
                                                   placeholder="血红蛋白" name="after.bloodTest.hemoglobinAmount"
                                                   value="${(mcd.after.bloodTest.hemoglobinAmount)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border-bottom-style: dashed;border-bottom-width: 1px;">
                            <div class="col-md-1">
                                <h4>尿常规</h4>
                            </div>

                            <div class="col-md-11">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">尿蛋白</label>

                                        <div class="col-md-3">
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="before.urineTest.proteinuriaDs"
                                                                               value="0"
                                                                               <#if ((mcd.before.urineTest.proteinuriaDs.code)!0)==0>checked</#if>>-</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="before.urineTest.proteinuriaDs"
                                                                               value="1"
                                                                               <#if ((mcd.before.urineTest.proteinuriaDs.code)!0)==1>checked</#if>>±</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="before.urineTest.proteinuriaDs"
                                                                               value="2"
                                                                               <#if ((mcd.before.urineTest.proteinuriaDs.code)!0)==2>checked</#if>>+</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="before.urineTest.proteinuriaDs.code"
                                                                               value="3"
                                                                               <#if ((mcd.before.urineTest.proteinuriaDs.code)!0)==3>checked</#if>>++</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="before.urineTest.proteinuriaDs.code"
                                                                               value="4"
                                                                               <#if ((mcd.before.urineTest.proteinuriaDs.code)!0)==4>checked</#if>>+++</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="before.urineTest.proteinuriaDs.code"
                                                                               value="5"
                                                                               <#if ((mcd.before.urineTest.proteinuriaDs.code)!0)==5>checked</#if>>++++</label>

                                        </div>
                                        <div class="col-md-3">
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="during0.urineTest.proteinuriaDs"
                                                                               value="0"
                                                                               <#if ((mcd.during0.urineTest.proteinuriaDs.code)!0)==0>checked</#if>>-</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="during0.urineTest.proteinuriaDs"
                                                                               value="1"
                                                                               <#if ((mcd.during0.urineTest.proteinuriaDs.code)!0)==1>checked</#if>>±</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="during0.urineTest.proteinuriaDs"
                                                                               value="2"
                                                                               <#if ((mcd.during0.urineTest.proteinuriaDs.code)!0)==2>checked</#if>>+</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="during0.urineTest.proteinuriaDs"
                                                                               value="3"
                                                                               <#if ((mcd.during0.urineTest.proteinuriaDs.code)!0)==3>checked</#if>>++</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="during0.urineTest.proteinuriaDs"
                                                                               value="4"
                                                                               <#if ((mcd.during0.urineTest.proteinuriaDs.code)!0)==4>checked</#if>>+++</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="during0.urineTest.proteinuriaDs"
                                                                               value="5"
                                                                               <#if ((mcd.during0.urineTest.proteinuriaDs.code)!0)==5>checked</#if>>++++</label>
                                        </div>
                                        <div class="col-md-3">
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="after.urineTest.proteinuriaDs"
                                                                               value="0"
                                                                               <#if ((mcd.after.urineTest.proteinuriaDs.code)!0)==0>checked</#if>>-</label>
                                            <label class="radio-inline"><input form="hspn-update-form" type="radio"
                                                                               name="after.urineTest.proteinuriaDs"
                                                                               value="1"
                                                                               <#if ((mcd.after.urineTest.proteinuriaDs.code)!0)==1>checked</#if>>±</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="after.urineTest.proteinuriaDs"
                                                                                value="2"
                                                                                <#if ((mcd.after.urineTest.proteinuriaDs.code)!0)==2>checked</#if>>+</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="after.urineTest.proteinuriaDs"
                                                                                value="3"
                                                                                <#if ((mcd.after.urineTest.proteinuriaDs.code)!0)==3>checked</#if>>++</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="after.urineTest.proteinuriaDs"
                                                                                value="4"
                                                                                <#if ((mcd.after.urineTest.proteinuriaDs.code)!0)==4>checked</#if>>+++</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="after.urineTest.proteinuriaDs"
                                                                                value="5"
                                                                                <#if ((mcd.after.urineTest.proteinuriaDs.code)!0)==5>checked</#if>>++++</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">尿潜血</label>

                                        <div class="col-md-3">
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="before.urineTest.urineOccultBloodDs"
                                                                                value="0"
                                                                                <#if ((mcd.before.urineTest.urineOccultBloodDs.code)!0)==0>checked</#if>>-</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="before.urineTest.urineOccultBloodDs"
                                                                                value="1"
                                                                                <#if ((mcd.before.urineTest.urineOccultBloodDs.code)!0)==1>checked</#if>>±</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="before.urineTest.urineOccultBloodDs"
                                                                                value="2"
                                                                                <#if ((mcd.before.urineTest.urineOccultBloodDs.code)!0)==2>checked</#if>>+</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="before.urineTest.urineOccultBloodDs"
                                                                                value="3"
                                                                                <#if ((mcd.before.urineTest.urineOccultBloodDs.code)!0)==3>checked</#if>>++</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="before.urineTest.urineOccultBloodDs"
                                                                                value="4"
                                                                                <#if ((mcd.before.urineTest.urineOccultBloodDs.code)!0)==4>checked</#if>>+++</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="before.urineTest.urineOccultBloodDs"
                                                                                value="5"
                                                                                <#if ((mcd.before.urineTest.urineOccultBloodDs.code)!0)==5>checked</#if>>++++</label>
                                        </div>
                                        <div class="col-md-3">
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="during0.urineTest.urineOccultBloodDs"
                                                                                value="0"
                                                                                <#if ((mcd.during0.urineTest.urineOccultBloodDs.code)!0)==0>checked</#if>>-</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="during0.urineTest.urineOccultBloodDs"
                                                                                value="1"
                                                                                <#if ((mcd.during0.urineTest.urineOccultBloodDs.code)!0)==1>checked</#if>>±</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="during0.urineTest.urineOccultBloodDs"
                                                                                value="2"
                                                                                <#if ((mcd.during0.urineTest.urineOccultBloodDs.code)!0)==2>checked</#if>>+</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="during0.urineTest.urineOccultBloodDs"
                                                                                value="3"
                                                                                <#if ((mcd.during0.urineTest.urineOccultBloodDs.code)!0)==3>checked</#if>>++</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="during0.urineTest.urineOccultBloodDs"
                                                                                value="4"
                                                                                <#if ((mcd.during0.urineTest.urineOccultBloodDs.code)!0)==4>checked</#if>>+++</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="during0.urineTest.urineOccultBloodDs"
                                                                                value="5"
                                                                                <#if ((mcd.during0.urineTest.urineOccultBloodDs.code)!0)==5>checked</#if>>++++</label>
                                        </div>
                                        <div class="col-md-3">
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="after.urineTest.urineOccultBloodDs"
                                                                                value="0"
                                                                                <#if ((mcd.after.urineTest.urineOccultBloodDs.code)!0)==0>checked</#if>>-</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="after.urineTest.urineOccultBloodDs"
                                                                                value="1"
                                                                                <#if ((mcd.after.urineTest.urineOccultBloodDs.code)!0)==1>checked</#if>>±</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="after.urineTest.urineOccultBloodDs"
                                                                                value="2"
                                                                                <#if ((mcd.after.urineTest.urineOccultBloodDs.code)!0)==2>checked</#if>>+</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="after.urineTest.urineOccultBloodDs"
                                                                                value="3"
                                                                                <#if ((mcd.after.urineTest.urineOccultBloodDs.code)!0)==3>checked</#if>>++</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="after.urineTest.urineOccultBloodDs"
                                                                                value="4"
                                                                                <#if ((mcd.after.urineTest.urineOccultBloodDs.code)!0)==4>checked</#if>>+++</label>
                                            <label class="radio-inline"> <input form="hspn-update-form" type="radio"
                                                                                name="after.urineTest.urineOccultBloodDs"
                                                                                value="5"
                                                                                <#if ((mcd.after.urineTest.urineOccultBloodDs.code)!0)==5>checked</#if>>++++</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">24小时尿蛋白定量</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="24小时尿蛋白定量" placeholder="24小时尿蛋白定量"
                                                   name="before.urineTest.protein24Amount"
                                                   value="${(mcd.before.urineTest.protein24Amount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="24小时尿蛋白定量" placeholder="24小时尿蛋白定量"
                                                   name="during0.urineTest.protein24Amount"
                                                   value="${(mcd.during0.urineTest.protein24Amount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="24小时尿蛋白定量" placeholder="24小时尿蛋白定量"
                                                   name="after.urineTest.protein24Amount"
                                                   value="${(mcd.after.urineTest.protein24Amount)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border-bottom-style: dashed;border-bottom-width: 1px;">
                            <div class="col-md-1">
                                <h4>肾功能</h4>
                            </div>

                            <div class="col-md-11">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">血肌酐</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血肌酐"
                                                   placeholder="血肌酐" name="before.renalFunction.bloodCreatinineAmount"
                                                   value="${(mcd.before.renalFunction.bloodCreatinineAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血肌酐"
                                                   placeholder="血肌酐" name="during0.renalFunction.bloodCreatinineAmount"
                                                   value="${(mcd.during0.renalFunction.bloodCreatinineAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血肌酐"
                                                   placeholder="血肌酐" name="after.renalFunction.bloodCreatinineAmount"
                                                   value="${(mcd.after.renalFunction.bloodCreatinineAmount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">血尿素氮</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血尿素氮"
                                                   placeholder="血尿素氮" name="before.renalFunction.bloodBunAmount"
                                                   value="${(mcd.before.renalFunction.bloodBunAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血尿素氮"
                                                   placeholder="血尿素氮" name="during0.renalFunction.bloodBunAmount"
                                                   value="${(mcd.during0.renalFunction.bloodBunAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血尿素氮"
                                                   placeholder="血尿素氮" name="after.renalFunction.bloodBunAmount"
                                                   value="${(mcd.after.renalFunction.bloodBunAmount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">血尿酸</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血尿酸"
                                                   placeholder="血尿酸" name="before.renalFunction.bloodUricAcidAmount"
                                                   value="${(mcd.before.renalFunction.bloodUricAcidAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血尿酸"
                                                   placeholder="血尿酸" name="during0.renalFunction.bloodUricAcidAmount"
                                                   value="${(mcd.during0.renalFunction.bloodUricAcidAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="血尿酸"
                                                   placeholder="血尿酸" name="after.renalFunction.bloodUricAcidAmount"
                                                   value="${(mcd.after.renalFunction.bloodUricAcidAmount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">胱抑素C</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="胱抑素C"
                                                   placeholder="胱抑素C" name="before.renalFunction.cystatinCAmount"
                                                   value="${(mcd.before.renalFunction.cystatinCAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="胱抑素C"
                                                   placeholder="胱抑素C" name="during0.renalFunction.cystatinCAmount"
                                                   value="${(mcd.during0.renalFunction.cystatinCAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="胱抑素C"
                                                   placeholder="胱抑素C" name="after.renalFunction.cystatinCAmount"
                                                   value="${(mcd.after.renalFunction.cystatinCAmount)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border-bottom-style: dashed;border-bottom-width: 1px;">
                            <div class="col-md-1">
                                <h4>内生肌酐清除率</h4>
                            </div>

                            <div class="col-md-11">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label"></label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="内生肌酐清除率" placeholder="内生肌酐清除率" name="before.crCl"
                                                   value="${(mcd.before.crCl)!''}"></div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="内生肌酐清除率" placeholder="内生肌酐清除率" name="during0.crCl"
                                                   value="${(mcd.during0.crCl)!''}"></div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="内生肌酐清除率" placeholder="内生肌酐清除率" name="after.crCl"
                                                   value="${(mcd.after.crCl)!''}"></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row" style="border-bottom-style: dashed;border-bottom-width: 1px;">
                            <div class="col-md-1">
                                <h4>淋巴细胞亚群</h4>
                            </div>

                            <div class="col-md-11">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">T抑制细胞</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="T抑制细胞" placeholder="T抑制细胞"
                                                   name="before.lymphocyteSubsets.tregsAmount"
                                                   value="${(mcd.before.lymphocyteSubsets.tregsAmount)!''}"></div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="T抑制细胞" placeholder="T抑制细胞"
                                                   name="during0.lymphocyteSubsets.tregsAmount"
                                                   value="${(mcd.during0.lymphocyteSubsets.tregsAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="T抑制细胞" placeholder="T抑制细胞"
                                                   name="after.lymphocyteSubsets.tregsAmount"
                                                   value="${(mcd.after.lymphocyteSubsets.tregsAmount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">T辅助细胞</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="T辅助细胞" placeholder="T辅助细胞"
                                                   name="before.lymphocyteSubsets.thCellsAmount"
                                                   value="${(mcd.before.lymphocyteSubsets.thCellsAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="T辅助细胞" placeholder="T辅助细胞"
                                                   name="during0.lymphocyteSubsets.thCellsAmount"
                                                   value="${(mcd.during0.lymphocyteSubsets.thCellsAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="T辅助细胞" placeholder="T辅助细胞"
                                                   name="after.lymphocyteSubsets.thCellsAmount"
                                                   value="${(mcd.after.lymphocyteSubsets.thCellsAmount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">B细胞</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="B细胞"
                                                   placeholder="B细胞" name="before.lymphocyteSubsets.bCellAmount"
                                                   value="${(mcd.before.lymphocyteSubsets.bCellAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="B细胞"
                                                   placeholder="B细胞" name="during0.lymphocyteSubsets.bCellAmount"
                                                   value="${(mcd.during0.lymphocyteSubsets.bCellAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="B细胞"
                                                   placeholder="B细胞" name="after.lymphocyteSubsets.bCellAmount"
                                                   value="${(mcd.after.lymphocyteSubsets.bCellAmount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">T辅助细胞/T抑制细胞</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="T辅助细胞/T抑制细胞" placeholder="T辅助细胞/T抑制细胞"
                                                   name="before.lymphocyteSubsets.hrRatio"
                                                   value="${(mcd.before.lymphocyteSubsets.hrRatio)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="T辅助细胞/T抑制细胞" placeholder="T辅助细胞/T抑制细胞"
                                                   name="during0.lymphocyteSubsets.hrRatio"
                                                   value="${(mcd.during0.lymphocyteSubsets.hrRatio)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="T辅助细胞/T抑制细胞" placeholder="T辅助细胞/T抑制细胞"
                                                   name="after.lymphocyteSubsets.hrRatio"
                                                   value="${(mcd.after.lymphocyteSubsets.hrRatio)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row" style="border-bottom-style: dashed;border-bottom-width: 1px;">
                            <div class="col-md-1">
                                <h4>免疫系列</h4>
                            </div>

                            <div class="col-md-11">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">IgE</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="IgE"
                                                   placeholder="IgE" name="before.immuneSeries.igeAmount"
                                                   value="${(mcd.before.immuneSeries.igeAmount)!''}"></div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="IgE"
                                                   placeholder="IgE" name="during0.immuneSeries.igeAmount"
                                                   value="${(mcd.during0.immuneSeries.igeAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="IgE"
                                                   placeholder="IgE" name="after.immuneSeries.igeAmount"
                                                   value="${(mcd.after.immuneSeries.igeAmount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">IgG</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="IgG"
                                                   placeholder="IgG" name="before.immuneSeries.iggAmount"
                                                   value="${(mcd.before.immuneSeries.iggAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="IgG"
                                                   placeholder="IgG" name="during0.immuneSeries.iggAmount"
                                                   value="${(mcd.during0.immuneSeries.iggAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="IgG"
                                                   placeholder="IgG" name="after.immuneSeries.iggAmount"
                                                   value="${(mcd.after.immuneSeries.iggAmount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">IgA</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="IgA"
                                                   placeholder="IgA" name="before.immuneSeries.igaAmount"
                                                   value="${(mcd.before.immuneSeries.igaAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="IgA"
                                                   placeholder="IgA" name="during0.immuneSeries.igaAmount"
                                                   value="${(mcd.during0.immuneSeries.igaAmount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="IgA"
                                                   placeholder="IgA" name="after.immuneSeries.igaAmount"
                                                   value="${(mcd.after.immuneSeries.igaAmount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">C3</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="C3"
                                                   placeholder="C3" name="before.immuneSeries.c3Amount"
                                                   value="${(mcd.before.immuneSeries.c3Amount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="C3"
                                                   placeholder="C3" name="during0.immuneSeries.c3Amount"
                                                   value="${(mcd.during0.immuneSeries.c3Amount)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text" title="C3"
                                                   placeholder="C3" name="after.immuneSeries.c3Amount"
                                                   value="${(mcd.after.immuneSeries.c3Amount)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">IgA/C3</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="IgA/C3" placeholder="IgA/C3"
                                                   name="before.immuneSeries.igaC3Ratio"
                                                   value="${(mcd.before.immuneSeries.igaC3Ratio)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="IgA/C3" placeholder="IgA/C3"
                                                   name="during0.immuneSeries.igaC3Ratio"
                                                   value="${(mcd.during0.immuneSeries.igaC3Ratio)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="IgA/C3" placeholder="IgA/C3"
                                                   name="after.immuneSeries.igaC3Ratio"
                                                   value="${(mcd.after.immuneSeries.igaC3Ratio)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row" style="border-bottom-style: dashed;border-bottom-width: 1px;">
                            <div class="col-md-1">
                                <h4>中性粒明胶酶载脂蛋白</h4>
                            </div>

                            <div class="col-md-11">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">尿NGAL</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="尿NGAL" placeholder="尿NGAL" name="before.ngal.urinaryNgal"
                                                   value="${(mcd.before.ngal.urinaryNgal)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="尿NGAL" placeholder="尿NGAL" name="during0.ngal.urinaryNgal"
                                                   value="${(mcd.during0.ngal.urinaryNgal)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="尿NGAL" placeholder="尿NGAL" name="after.ngal.urinaryNgal"
                                                   value="${(mcd.after.ngal.urinaryNgal)!''}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">血NGAL</label>

                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="血NGAL" placeholder="血NGAL" name="before.ngal.bloodNgal"
                                                   value="${(mcd.before.ngal.bloodNgal)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="血NGAL" placeholder="血NGAL" name="during0.ngal.bloodNgal"
                                                   value="${(mcd.during0.ngal.bloodNgal)!''}">
                                        </div>
                                        <div class="col-md-3">
                                            <input form="hspn-update-form" class="form-control" type="text"
                                                   title="血NGAL" placeholder="血NGAL" name="after.ngal.bloodNgal"
                                                   value="${(mcd.after.ngal.bloodNgal)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <div style="margin-bottom: 4px;"><span class="btn-group btn-corner">
                            <button form="hspn-update-form" class="btn btn-success btn-sm" type="submit">
                                <span class="ace-icon fa fa-plus bigger-110"></span>提交
                            </button>
                            <button form="hspn-update-form" class="btn btn-warning btn-sm" type="reset">
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