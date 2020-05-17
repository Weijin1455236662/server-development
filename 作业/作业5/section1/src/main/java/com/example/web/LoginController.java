package com.example.web;

import com.example.domain.ErrorMessage;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping(value = "/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/loginCheck")
    public String loginCheck(HttpServletRequest request, @Valid LoginInfo loginInfo, Errors errors, Model model){
        if(errors.hasErrors()){
            FieldError usernameError = errors.getFieldError("userName"),
                    passwordError = errors.getFieldError("password");
            String m3 = usernameError==null?"":usernameError.getDefaultMessage(),
                    m4 = passwordError==null?"":passwordError.getDefaultMessage();
            ErrorMessage errorMessage =new ErrorMessage(m3,m4);
            model.addAttribute(errorMessage);
            return "login";
        }else{
            boolean match = userService.hasMatcher(loginInfo.getUserName(), loginInfo.getPassword());
            if(!match){
                ErrorMessage errorMessage =new ErrorMessage("","用户名或密码错误！");
                model.addAttribute(errorMessage);
                return "login";
            }else{
                User user = userService.findUserByUserName(loginInfo.getUserName());
                user.setLastIp(request.getLocalAddr());
                user.setLastVisit(new Date());
                userService.saveLog(user);
                model.addAttribute(user);
                return "main";
            }
        }
    }
}
