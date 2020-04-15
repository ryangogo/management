package com.dafeng.management.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * describe：
 * Created with IDEA
 * author:ryan
 * Date:2019/8/27
 * Time:下午1:50
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/blank")
    public String test3(){
        return "index/blank";
    }

}
