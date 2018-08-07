package com.buss.sale.utils;

import net.sf.json.JSONObject;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.cgform.enhance.IFillRuleHandler;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
/**
 * 当前用户信息填值规则生成类
 * @author xlzhang
 */
public class UserInfoFillRule implements IFillRuleHandler {

    @Override
    public Object execute(String paramJson) {
        String param = "name";
        String rs = "";
        TSUser user = ResourceUtil.getSessionUser();
        if(paramJson!=null && !"".equals(paramJson)){
            JSONObject jsonObject = JSONObject.fromObject(paramJson);
            Object obj = jsonObject.get("param");
            if(obj!=null)param=obj.toString();
        }
        if("userName".equals(param)){
          rs = user.getUserName();
        }
        if("realName".equals(param)){
            rs = user.getRealName();
        }
        if("userKey".equals(param)){
            rs = user.getUserKey();
        }
        if("userId".equals(param)){
            rs = user.getId();
        }
        if("departid".equals(param)){
            rs = user.getDepartid();
        }
        //currentDepart
        if("currentDepart".equals(param)){
            TSDepart tsDepart = user.getCurrentDepart();
           rs = tsDepart.getDepartname();
        }
        return rs;
    }
}
