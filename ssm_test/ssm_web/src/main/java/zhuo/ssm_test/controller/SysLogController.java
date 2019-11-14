package zhuo.ssm_test.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import zhuo.ssm_test.domain.SysLog;
import zhuo.ssm_test.service.ISysLogService;

import java.util.List;
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private ISysLogService iSysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> list = iSysLogService.findAll(page,size);
        //pageinfo是一个分页bean
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }
}
