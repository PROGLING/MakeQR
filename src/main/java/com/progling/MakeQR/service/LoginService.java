package com.progling.MakeQR.service;

import com.progling.MakeQR.dto.UserDto;
import com.progling.MakeQR.entity.TblUsers;
import com.progling.MakeQR.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UsersRepository usersRepository;

    /** ===============================================
     * 회원가입
     * @param dto UserDto
     * @return Long userSeq
     * =============================================== */
    public Long joinUser(UserDto dto){
        // id 중복 체크

        TblUsers users = TblUsers.builder()
                .userId(dto.getUserId())
                .userPw(dto.getUserPw())
                .userName(dto.getUserName())
                .build();
        return usersRepository.save(users).getUserSeq();
    }

    /** ===============================================
     * 로그인
     * @param dto UserDto
     * @return Long userSeq
     * =============================================== */
    public UserDto login(UserDto dto){
        Optional<TblUsers> user = usersRepository.findByUserIdAndUserPw(dto.getUserId(), dto.getUserPw());
        UserDto result = null;
        if(user.isPresent()){
            TblUsers entity = user.get();
            result = UserDto.builder()
                    .userSeq(entity.getUserSeq())
                    .userId(entity.getUserId())
                    .userName(entity.getUserName())
                    .build();
        }
        return result;
    }
}
