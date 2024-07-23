package com.ruoyi.web.controller.api;

import com.ruoyi.XdBanners.domain.XdBanners;
import com.ruoyi.XdUserFeedback.domain.XdUserFeedback;
import com.ruoyi.XdUserFeedback.service.IXdUserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class publicApi {

    @Autowired
    private IXdUserFeedbackService xdUserFeedbackService;

    @PostMapping("/addXdUserFeedback")
    public Map<String,Object> addXdUserFeedback(@RequestBody XdUserFeedback xdUserFeedback){
        Map<String,Object> map=new HashMap<String, Object>();
        if(xdUserFeedback.getuId()==null||xdUserFeedback.getDeptId()==null){
            map.put("code",201);
            map.put("msg","反馈失败，请先登录");
            return  map;
        }
        xdUserFeedback.setStatus("2");
        xdUserFeedbackService.insertXdUserFeedback(xdUserFeedback);
        map.put("code",200);
        map.put("msg","操作成功");
        return  map;
    }
}
