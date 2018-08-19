package com.crm.controller.sys;

import com.crm.entity.User;
import com.crm.service.sys.UserService;
import com.crm.utils.LayuiResult;
import com.crm.utils.Md5Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by Mankind on 2018/4/17.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/console/index")
    public String index(){
        return "/view/index";
    }

    /**
     * 后台登录入口
     * @return
     */
/*    @RequestMapping(value = {"/sys/login","/"})
    public String loginSystem(){
        return "/view/login";
    }*/
    @RequestMapping("/sys/login")
    public ModelAndView loginSystem(){
        return new ModelAndView("/login");
    }
    /**
     * 后台登录入口
     * @return
     */
    @RequestMapping("/main")
    public ModelAndView loginBackend(){
        return new ModelAndView("/backend.html");
    }

    /**
     * flag不为空则为前台登录
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/console/login",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public LayuiResult login(String account, String password, String code, Model model, HttpSession session, RedirectAttributes redirectAttributes, String loginPath, Boolean flag) throws Exception {
        LayuiResult result=new LayuiResult();
        //处理验证码
        if (flag==null&&!(code.equalsIgnoreCase(session.getAttribute("code").toString()))) {
            result.setMsg( "验证码错误");
            result.setStatus(LayuiResult.FAIL);
            return result;
        }

        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setPassword(new Md5Utils().getkeyBeanofStr(user.getPassword()));
        User currentUser = userService.getByAccount(user.getAccount());
        if(currentUser!=null&&user.getAccount().equals(currentUser.getAccount())){
            session.setAttribute("cUser", currentUser);
            result.setStatus(LayuiResult.OK);
            result.setMsg("/view/main");
        }else{
            //可以写跳转的处理异常的页面
            result.setMsg("账号或者密码错误");
            result.setStatus(LayuiResult.FAIL);
        }
        return result;
    }

    @RequestMapping("/console/tomain")
    public ModelAndView tomain(String account){
        ModelAndView model=new ModelAndView("/main");
        model.addObject("account",account);
        return model;
    }
}
