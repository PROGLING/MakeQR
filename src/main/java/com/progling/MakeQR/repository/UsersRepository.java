package com.progling.MakeQR.repository;

import com.progling.MakeQR.entity.TblUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<TblUsers, Long> {
    Optional<TblUsers> findByUserIdAndUserPw(String userId, String userPw);
}
