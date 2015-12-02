<!-- #section:basics/sidebar -->
<div id="sidebar" class="sidebar responsive">
    <ul class="nav nav-list">
        <li class="">
            <a href="javascript:;" class="dropdown-toggle">
                <span class="menu-icon fa fa-ambulance"></span>
                <span class="menu-text">医疗数据</span>
                <span class="arrow fa fa-angle-down"></span>
            </a>
            <span class="arrow"></span>
            <ul class="submenu">
                <li><a href="${context.contextPath}/hspn" target="mainFrame"><span
                        class="menu-icon fa fa-table light-red"></span><span class="menu-text">紫癜性肾炎</span></a></li>

                <li><a href="/customer/stats" target="mainFrame"><span
                        class="menu-icon fa fa-line-chart light-red"></span><span class="menu-text">狼疮性肾炎</span></a>
                </li>
                <li><a href="${context.contextPath}/customer/add" target="mainFrame"><span
                        class="menu-icon fa fa-file-o light-grey"></span><span class="menu-text">多囊肾</span></a></li>
                <li><a href="${context.contextPath}/customer/revisit/today" target="mainFrame"><span
                        class="menu-icon fa fa-envelope-o"></span><span class="menu-text">高血压肾损害</span></a></li>
                <li><a href="${context.contextPath}/customer/revisit/week" target="mainFrame"><span
                        class="menu-icon fa fa-envelope-o"></span><span class="menu-text">糖尿病肾病</span></a></li>
                <li><a href="${context.contextPath}/customer/revisit/month" target="mainFrame"><span
                        class="menu-icon fa fa-envelope-o"></span><span class="menu-text">iga肾病</span></a></li>
            </ul>
        </li>

        <li>
            <a href="${context.contextPath}/user/update-password" target="mainFrame"><span
                    class="menu-icon fa fa-lock"></span><span class="menu-text">修改密码</span></a>
        </li>
        <li>
            <a href="${context.contextPath}/logout" target="_top"><span class="menu-icon fa fa-power-off"></span>
                <span class="menu-text">退出</span></a>
        </li>
    </ul>
    <!-- /.nav-list -->

    <!-- #section:basics/sidebar.layout.minimize -->
    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <span class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left"
              data-icon2="ace-icon fa fa-angle-double-right"></span>
    </div>

    <!-- /section:basics/sidebar.layout.minimize -->
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>