package com.example.board.service;

import com.example.board.dto.ResponseDto;
import com.example.board.dto.SignUpDto;
import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public ResponseDto<?> signUp(SignUpDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();

        // email 중복 확인
        try {
            if(userRepository.existsById(userEmail)){
                return ResponseDto.setFailed("Existed Email!", null);
            }
        } catch (Exception e){
            return ResponseDto.setFailed("DataBase Error!", null);
        }


        if (!userPassword.equals(userPasswordCheck))
            return ResponseDto.setFailed("password does not matched!", null);

        // SignUpDto를 UserEntity로 변환 why? 레포지토리를 사용하기 위해
        UserEntity userEntity = new UserEntity(dto);
        try {
            userRepository.save(userEntity);
        } catch (Exception e){
            return ResponseDto.setFailed("DataBase Error!", null);
        }

        // 성공시 success roponse 반환
        return ResponseDto.setSuccess("SignUp Success!", null);
    }
}
