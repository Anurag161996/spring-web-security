package com.project.security.service;

import com.project.security.model.UserInfo;
import com.project.security.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetailsService userDetailsService() {
        return username -> {
            Optional<UserInfo> userDetail = repository.findByName(username);

            // Converting userDetail to UserDetails
            return userDetail.map(UserInfoDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));

        };
    }





}
