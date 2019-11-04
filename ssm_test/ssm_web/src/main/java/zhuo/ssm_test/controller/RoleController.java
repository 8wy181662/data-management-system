package zhuo.ssm_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import zhuo.ssm_test.domain.Permission;
import zhuo.ssm_test.domain.Role;
import zhuo.ssm_test.service.IRoleService;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,@RequestParam(name = "ids",required = true)String[] ids) throws Exception{
        iRoleService.addPermissionToRole(roleId,ids);
        String str = "redirect:findById.do?id="+roleId;
        return str;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = iRoleService.findById(id);
        List<Permission> otherPermission = iRoleService.findOtherPermission(id);
        mv.addObject("role",role);
        mv.addObject("permissionList",otherPermission);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String rid) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = iRoleService.findById(rid);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role)throws Exception{
        iRoleService.save(role);

        return ("redirect:findAll.do");
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> all = iRoleService.findAll();

        mv.addObject("roleList",all);
        mv.setViewName("role-list");
        return mv;
    }
}
