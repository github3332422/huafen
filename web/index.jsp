
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("Base_Path",request.getContextPath());%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
    <script type="text/javascript" src="${Base_Path }/static/js/jquery-1.12.4.min.js"></script>
    <link href="${Base_Path }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${Base_Path }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container ">
    <!-- 员工修改的模态框 -->
    <div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">员工修改</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-2 control-label">empName</label>--%>
                            <%--<div class="col-sm-10">--%>
                                <%--<p class="form-control-static" id="empName_update_static"></p>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">empName</label>
                            <div class="col-sm-10">
                                <input type="text" name="emp_name" class="form-control" id="empName_updata_input" placeholder="empName">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">email</label>
                            <div class="col-sm-10">
                                <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email@atguigu.com">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">gender</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="gender" id="gender2_update_input" value="F"> 女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">deptName</label>
                            <div class="col-sm-4">
                                <!-- 部门提交部门id即可 -->
                                <select class="form-control" name="dId" id="dept_updata_select">
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 标题栏 -->
    <div class="row">
        <div class=".col-xs-6">
            <h1>客户管理系统</h1>
        </div>
    </div>

    <!-- 显示按钮 -->
    <div class="row">
        <div class="col-md-3 col-md-offset-0">
            <button type="button" class="btn btn-success" id="emp_add_modal_btn">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
            </button>
            <button type="button" class="btn btn-danger" id="emp_del_all_modal_btn">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
    </div>

    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                    <tr>
                        <th>
                            <input type="checkbox" id="check_all"/>
                        </th>
                        <th>员工ID</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>邮箱</th>
                        <th>部门</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>

    <!-- 分页 -->
    <div class="row">
        <div class="col-md-6" id="page_info_message">
        </div>
        <div class="col-md-6" id="page_info_nova">
        </div>
    </div>

    <!-- 员工添加的模态框 -->
    <div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">员工添加</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">empName</label>
                            <div class="col-sm-10">
                                <input type="text" name="emp_name" class="form-control" id="empName_add_input" placeholder="empName">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <input type="text" name="email" class="form-control" id="empEmail_add_input" placeholder="email@qq.com">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">empGender</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="emp_gender" id="gender1_add_input" value="M" checked="checked"> 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="emp_gender" id="gender2_add_input" value="F"> 女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">empDepartment</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="dept_id" id="dept_add_select">

                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    var totalRecord,currentPage;
    $(function(){
        to_page(1);
    })
    //查询第n页的数据
    function to_page(pn) {
        $.ajax({
            url:"${Base_Path}/empsJson",
            data:"pn="+pn,
            type:"get",
            success:function (result) {
                // console.log(result);
                //解析并显示员工数据

                build_emps_table(result);
                //解析并显示分页数据
                build_page_info(result)
                buil_page_nav(result)
            }
        });
    }
    //把客户信息填写到表格
    function build_emps_table(result) {
        //先进行清空，避免把上回的数据也加上
        $("#emps_table tbody").empty();
        var emps = result.extend.pageInfo.list;
        $.each(emps,function (index,item) {
            var checkBoxTD=$("<td><input type='checkbox' class='check_item'/></td>");
            var empidTd =  $("<td></td>").append(item.emp_id);
            var empnameTd =  $("<td></td>").append(item.emp_name);
            var empgenderTd =  $("<td></td>").append(item.emp_gender == 'M'?"男":"女");
            var empemailTd =  $("<td></td>").append(item.email);
            var empDeptTd =  $("<td></td>").append(item.department.deptName);

            var editButton = $("<button></button>").addClass("btn btn-warning btn-sm edit_btn").append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            editButton.attr("edit-id",item.emp_id);
            var delButton = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append($("<span></span>").addClass("glyphicon glyphicon-remove")).append("删除");
            delButton.attr("del-id",item.emp_id);
            var btnTd = $("<td></td>").append(editButton).append(" ").append(delButton);
            $("<tr></tr>").append(checkBoxTD)
                .append(empidTd)
                .append(empnameTd)
                .append(empgenderTd)
                .append(empemailTd)
                .append(empDeptTd)
                .append(btnTd)
                .appendTo("#emps_table tbody");
        })
    }
    //解释显示分页信息
    function build_page_info(result) {
        $("#page_info_message").empty();
        var str = "当前页"+ result.extend.pageInfo.pageNum+ "总页数" + result.extend.pageInfo.pages+" 总记录数" + result.extend.pageInfo.total;
        var mess = $("<h4></h4>").append(str);
        mess.appendTo("#page_info_message")
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }
    //解析显示分页条
    function buil_page_nav(result){
        $("#page_info_nova").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        // var fristPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
        if(result.extend.pageInfo.isFirstPage == true){
            // fristPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }
        else{
            // fristPageLi.click(function () {
            //     to_page(1);
            // })
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum-1);
            })
        }
        //添加首页和前一页
        ul.append(prePageLi);
        $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
            //当前页表示禁用
            if(result.extend.pageInfo.pageNum == item){
                numLi.addClass("active");
            }
            else{
                numLi.click(function () {
                    to_page(item);
                })
            }
            //
            ul.append(numLi);

        });
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));
        if(result.extend.pageInfo.isLastPage == true){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum+1);
            })
            // lastPageLi.click(function () {
            //     to_page(result.extend.pageInfo.pages-1);
            // })
        }
        //添加后一页和尾页
        ul.append(nextPageLi);
        var navEle = $("<nav></nav>").append(ul)
        navEle.appendTo("#page_info_nova")
    }
    //清空表单
    function reset_form(ele){
        $(ele)[0].reset();
        $(ele).removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }
    //打开新建模态框
    $("#emp_add_modal_btn").click(function () {
        reset_form("#empAddModal form");
        // $("#empAddModal form")[0].reset();
        //查询所有的部门信息
        getDepts("#dept_add_select");
        //弹出添加模态框
        $("#empAddModal").modal({
            backdrop:"static"
        })
    });
    //查询所有的部门列表
    function getDepts(ele){
        //清空数据列表
        $(ele).empty();
        //后端查询
        $.ajax({
            url:"${Base_Path}/depts",
            type:"get",
            success:function (result) {
                console.log(result);
                $.each(result.extend.depts,function(){
                    var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
                    optionEle.appendTo(ele);
                });
            }
        });
    }
    //判断插入用户的邮箱是否已经存在
    $("#empEmail_add_input").change(function () {
        var email = this.value;
        $.ajax({
            url:"${Base_Path}/checkuser",
            data:"email=" + email,
            type:"POST",
            success:function (result) {
                console.log(result.stateCode);
                if(result.stateCode == 200){
                    show_validate_msg("#empEmail_add_input","success","");
                    $("#emp_save_btn").attr("ajax-va","success");
                }else{
                    show_validate_msg("#empEmail_add_input","error","邮箱不可用");
                    $("#emp_save_btn").attr("ajax-va","error");
                }
            }
        });
    });
    //执行添加功能,将模态框中的表单数据提交
    $("#emp_save_btn").click(function () {
        //对要发送的请求进行校验:
        if(!validate_add_form()){
            return false;
        };

        //对用户的邮箱进行校验
        if($(this).attr("ajax-va") == "error"){
            return false;
        };
        //发送ajax请求
        console.log($("#empAddModal form").serialize());
        $.ajax({
            url:"${Base_Path}/emp",
            type:"post",
            data:$("#empAddModal form").serialize(),
            success:function (result) {
                // alter(result);
                //关闭模态框
                $("#empAddModal").modal("hide");
                //来到最后一页显示数据
                to_page(totalRecord);
            }
        });
    });
    //校验表单数据
    function validate_add_form(){
        var empName = $("#empName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,5}$)/;
        if(!regName.test(empName)){
            show_validate_msg("#empName_add_input","success","用户名可以是3-16位数字或英文或者是2-5位中文");
            // alert("用户名可以是3-16位数字或英文或者是2-5位中文");
            // $("#empName_add_input").parents().removeClass("has-success has-error");
            // $("#empEmail_add_input").next("span").text("");
            // $("#empName_add_input").parents().addClass(".has-error");
            // $("#empName_add_input").next("span").text("用户名可以是3-16位数字或英文或者是2-5位中文");
            return false;
        }else{
            show_validate_msg("#empName_add_input","error","");
            // $("#empName_add_input").parents().removeClass("has-success has-error");
            // $("#empEmail_add_input").next("span").text("");
            // $("#empName_add_input").parents().addClass(".has-success");
            // $("#empName_add_input").next("span").text("");
        }
        var empEmali = $("#empEmail_add_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(!regEmail.test(empEmali)){
            show_validate_msg("#empEmail_add_input","success","输入的邮箱格式错误");
            // $("#empEmail_add_input").parents().removeClass("has-success has-error");
            // $("#empEmail_add_input").next("span").text("");
            // $("#empEmail_add_input").parents().addClass(".has-error");
            // $("#empEmail_add_input").next("span").text("输入的邮箱格式错误");
            return false;
        }else{
            show_validate_msg("#empEmail_add_input","error","");
            // $("#empEmail_add_input").parents().removeClass("has-success has-error");
            // $("#empEmail_add_input").next("span").text("");
            // $("#empEmail_add_input").parents().addClass(".has-success");
            // $("#empEmail_add_input").next("span").text("");
        }
        return true;
    }
    //对提交的数据进行处理
    function show_validate_msg(ele,status,msg){
        //清除原来的校验状态信息
        $(ele).parents().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if("success" == status){
            $(ele).parents().addClass(".has-success");
            $(ele).next("span").text(msg);
        }else if("error" == status){
            $(ele).parents().addClass(".has-error");
            $(ele).next("span").text(msg);
        }
    }


    //修改事件
    $(document).on("click",".edit_btn",function () {
        // alert("编辑按钮绑定成功");
        //查询部门信息，显示部门列表
        getDepts("#dept_updata_select");
        getEmp($(this).attr("edit-id"))
        //弹出模态框
        //把员工id传送过去
        $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"))
       $("#empUpdateModal").modal({
            backdrop:"static"
        })
    });

    //查询返回数据
    function getEmp(id){
        $.ajax({
            url:"${APP_PATH}/emp/" + id,
            type:"GET",
            success:function (result) {
                console.log(result);
                var empData = result.extend.emp;
                $("#empName_updata_input").val(empData.emp_name);
                $("#email_update_input").val(empData.email);
                $("#empUpdateModal input[type=radio]").val([empData.emp_gender]);
                $("#empUpdateModal select").val([empData.dept_id]);
            }
        })
    }

    //点击更新
    $("#emp_update_btn").click(function () {
       //验证邮箱是否合法
        //保存更新
        console.log($("#empUpdateModal form").serialize());
        $.ajax({
            url:"${Base_Path}/emp/" + $(this).attr("edit-id"),
            // type:"POST",
            // data:$("#empUpdateModal form").serialize() + "&_method=PUT",
            type:"PUT",
            data:$("#empUpdateModal form").serialize(),
            success:function (result) {
                console.log(result);
                //关闭模态框
                $("#empUpdateModal").modal("hide");
                //来到最后一页显示数据
                to_page(currentPage);
            }
        })
    });


    //删除客户(单个)
    $(document).on("click",".delete_btn",function () {
        //1.弹出是否 确认删除对话框
        // alert("Hello World");
        // alert($(this).parents("tr").find("td:eq(1)").text());
        var empName = $(this).parents("tr").find("td:eq(2)").text();
        var empId = $(this).attr("del-id");
        if(confirm("确认删除【"+empName+"】吗？")){
            $.ajax({
                url:"${Base_Path}/emp/" + empId,
                type:"DELETE",
                success:function () {
                    to_page(currentPage);
                }
            });
        }

    });

    //完成全选
    $("#check_all").click(function(){
        // alert("Hello World");
        //attr是获取自定义属性的值$(this).attr("checked");
        //prop是修改和读取dom原始属性的值
        // alert($(this).prop("checked"));  // $(this).prop("checked") 返回值为true和false
        $(".check_item").prop("checked",$(this).prop("checked"));
    });

    $(document).on("click",".check_item",function(){
        var flag=$(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked",flag);
    });
    //点击全部删除   即批量删除
    $("#emp_del_all_modal_btn").click(function(){
        var empNames="";
        var del_ids=""
        $.each($(".check_item:checked"),function(){   //遍历已经选中的元素
            empNames+=$(this).parents("tr").find("td:eq(2)").text()+",";//找到父元素的tr里面的索引为2的td
            //组装员工ids
            del_ids+=$(this).parents("tr").find("td:eq(1)").text()+"-";
        });
        empNames.substring(0,empNames.length-1);
        del_ids.substring(0,del_ids.length-1);
        if(confirm("确认删除【"+empNames+"】吗？")){
            //发送ajax请求
            $.ajax({
                url:"${path}/emp/"+del_ids,
                type:"DELETE",
                success:function(result){
                    console.log(result);
                    alert(result.mes);
                    //回到当前页面
                    to_page(currentPage);
                }
            });
        }
    });
</script>
</body>
</html>
