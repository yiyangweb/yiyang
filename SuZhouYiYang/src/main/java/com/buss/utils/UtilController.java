package com.buss.utils;

import io.swagger.annotations.Api;
import org.jeecgframework.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Api(value="CommonFunction",description="公用方法",tags="commonController")
@Controller
@RequestMapping("/utilController")
public class UtilController extends BaseController {

    @RequestMapping(params = "getNo")
    @ResponseBody
    public String list(HttpServletRequest request) {
        String code = request.getParameter("code");
        String result = "";
        if(code != null && code != ""){
            while (code.length() < 3)
                code = code + "0";
            BillNumbers billNum = new BillNumbers();
            result = billNum.commonNumber(code);
        }
        return result;
    }

}