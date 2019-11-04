package zhuo.ssm_test.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import zhuo.ssm_test.service.IOrdersService;
import zhuo.ssm_test.domain.Orders;
import zhuo.ssm_test.domain.Traveller;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;

    @RequestMapping("/findAll.do")
    @Secured("ROLE_USER")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "4")Integer size) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<Orders> list = iOrdersService.findAll(page,size);

        //pageinfo是一个分页bean
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");

        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true)String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Orders orders = iOrdersService.findById(id);
        List<Traveller> travellers = orders.getTravellers();
        System.out.println("要打印信息啦");
        for(Traveller t : travellers){
            System.out.println("打印出信息");
            System.out.println(t);
        }
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;

    }
}
