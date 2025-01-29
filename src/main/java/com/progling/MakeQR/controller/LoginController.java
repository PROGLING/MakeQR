package com.progling.MakeQR.controller;

import com.progling.MakeQR.dto.UserDto;
import com.progling.MakeQR.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login/api")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /** ===============================================
     * 회원가입
     * @param dto UserDto
     * @return ResponseEntity<Long>
     * =============================================== */
    @PostMapping("/join")
    public ResponseEntity<Long> joinUser(@RequestBody UserDto dto){
        return ResponseEntity.ok().body(loginService.joinUser(dto));
    }

    /** ===============================================
     * 로그인
     * @param dto UserDto
     * @param request HttpServletRequest
     * @return ResponseEntity<Long>
     * =============================================== */
    @PostMapping("/login")
    public ResponseEntity<Long> login(@RequestBody UserDto dto, HttpServletRequest request){
        UserDto result = loginService.login(dto);
        if(result == null) return ResponseEntity.ok().body(0L);

        // 세션 등록
        HttpSession session = request.getSession();
        session.setAttribute("users", result);
        return ResponseEntity.ok().body(1L);
    }

    /** ===============================================
     * 로그아웃
     * @param request HttpServletRequest
     * @return ResponseEntity<Long>
     * =============================================== */
    @PostMapping("/logout")
    public ResponseEntity<Long> logout(HttpServletRequest request){
        // 세션 삭제
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();

        return ResponseEntity.ok().body(1L);
    }


    /**
     * 회원 탈퇴
     */

    /**
     * 회원 수정
     */

    /**
     * 내 정보 조회
     */

    /**
     * 전체 회원 조회
     */

}
