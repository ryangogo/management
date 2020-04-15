package com.dafeng.management.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * describe：
 * Created with IDEA
 * author:ryan
 * Date:2019/8/10
 * Time:上午9:28
 */
@Controller
@RequestMapping("/test/")
public class TestController {

    @RequestMapping("jqueryUi")
    public String test2(){
        return "jquery-ui";
    }

    @RequestMapping("test3")
    public String test3(){
        return "blank";
    }

    @RequestMapping("toForm")
    public String toForm(){
        return "form-elements";
    }

    @RequestMapping("jqgrid")
    public String jqgrid(){
        return "jqgrid";
    }

    @RequestMapping("tables")
    public String tables(){
        return "employee/salesMan/tables";
    }

}
