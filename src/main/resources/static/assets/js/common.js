$(document).ready(function(){
    //注册键盘事件
    $(document).keyup(function(event){
        //判断回车键的CODE 13是主键盘区的Enter 108是数字键盘区的Enter
        if(event.keyCode == 13 || event.keyCode == 108){
            //回车点击提交按钮
            $("#selectFormButton").click();
        }
    })
});

/*******清空表单*******/
 function clearForm(id) {
    var objId = document.getElementById(id);
    if (objId == undefined) {
        return;
    }
    for (var i = 0; i < objId.elements.length; i++) {
        if (objId.elements[i].type == "text") {
            objId.elements[i].value = "";
        }
        else if (objId.elements[i].type == "password") {
            objId.elements[i].value = "";
        }
        else if (objId.elements[i].type == "hidden") {
            objId.elements[i].value = "";
        }
        else if (objId.elements[i].type == "radio") {
            objId.elements[i].checked = false;
        }
        else if (objId.elements[i].type == "checkbox") {
            objId.elements[i].checked = false;
        }
        else if (objId.elements[i].type == "select-one") {
            objId.elements[i].options[0].selected = true;
        }
        else if (objId.elements[i].type == "select-multiple") {
            for (var j = 0; j < objId.elements[i].options.length; j++) {
                objId.elements[i].options[j].selected = false;
            }
        }
        else if (objId.elements[i].type == "textarea") {
            objId.elements[i].value = "";
        }
    }
}


/******注册autocomplete******/
function registerAC(id,url){
    $("#" + id).autocomplete({
        source: url,
        minLength: 0,
        autoFocus: false
    }).focus(function(){
            $(this).autocomplete("search");
            return false;
        }
    );
}

/****** 判空 ******/
function checkIsNullOrEmpty(value) {
    //正则表达式用于判斷字符串是否全部由空格或换行符组成
    var reg = /^\s*$/
    //返回值为true表示不是空字符串
    return (value != null && value != undefined && !reg.test(value))
}
