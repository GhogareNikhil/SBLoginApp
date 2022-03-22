package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bindings.LoginRequest;
import com.example.demo.constatnts.AppConstants;
import com.example.demo.entity.UserEntity;
import com.example.demo.props.AppProoerties;
import com.example.demo.repository.UserRepository;
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
	private UserRepository usRepository;
   
    @Autowired
    private AppProoerties apProoerties;
    
	@Override
	public String login(LoginRequest loginRequest) {
		UserEntity user = usRepository.findByUserEmaillAndUserPwd(loginRequest.getEmail(), loginRequest.getPwd());
		if(null==user) {
			return apProoerties.getMessage().get(AppConstants.INVALID_CREDENTIALS);
		}if(user.getSetUserAccStatus().equals(AppConstants.LOCKED)) {
			return apProoerties.getMessage().get(AppConstants.ACC_LOACKED);
		}
		return AppConstants.SUCCESS;
	}

}
