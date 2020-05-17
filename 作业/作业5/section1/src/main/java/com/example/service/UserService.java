package com.example.service;

import com.example.dao.LoginLogRepository;
import com.example.dao.UserRepository;
import com.example.domain.LoginLog;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    LoginLogRepository loginLogRepository;

    @Autowired
    UserRepository userRepository;

    public void setLoginLogRepository(LoginLogRepository loginLogRepository) {
        this.loginLogRepository = loginLogRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean hasMatcher(String username,String password){
        long matchCount=userRepository.getMatchCount(username,password);
        return matchCount>0;
    }

    public User findUserByUserName(String userName){
        return userRepository.findUserByUserName(userName);
    }

    public LoginLog saveLog(User user){
        LoginLog loginLog=new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());

        LoginLog loginLog1=loginLogRepository.save(loginLog);
        return loginLog1;
    }


}
