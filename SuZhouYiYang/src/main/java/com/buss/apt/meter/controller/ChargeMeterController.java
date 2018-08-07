package com.buss.apt.meter.controller;

import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title: Controller
 * @Description: 水电费用信息
 * @author caijunrong
 * @date 2018-05-25 15:00:00
 * @version V1.0
 *
 */
@Api(value="ChargeMater",description="水电费用",tags="chargeMeterController")
@Controller
@RequestMapping("/chargeMeterController")
public class ChargeMeterController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(com.buss.apt.meter.controller.ChargeMeterController.class);

    /**
     * 水电费用信息 界面跳转
     *
     * @return
     */
    @RequestMapping(params = "getMeterTabs")
    public ModelAndView getMeterTabs(HttpServletRequest req) {
        //req.setAttribute("type", "");
        return new ModelAndView("com/buss/apt/meter/chargeMeterTabs");
    }

    @RequestMapping(params = "getMeterTab")
    public ModelAndView getMeterTab(Integer type, HttpServletRequest req) {
        String url = "";
        if(type == 1) url = "cgReportController.do?datagrid&configId=water_meter_info"; //水表
        else if(type == 2) url = "cgReportController.do?datagrid&configId=electronic_meter_info"; //电表
        else if(type == 3) url = "cgReportController.do?datagrid&configId=gas_meter_info"; //燃气表
        req.setAttribute("url", url);
        return new ModelAndView("com/buss/apt/meter/chargeMeterTab");
    }

}
