package com.wizinno.lims.user.repository;

import com.wizinno.lims.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LiuMei on 2017-05-22.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据用户ID查询用户权限码列表
     * @param userId
     * @return
     */
    @Query(value = "select  DISTINCT code from permission p INNER JOIN role_permission_r rp on p.id = rp.permission_id " +
            "INNER JOIN role r on rp.role_id = r.id INNER JOIN user_role_r ur on r.id = ur.role_id  " +
            "INNER JOIN user u on ur.user_id = u.id  WHERE  u.id=?1",
                    nativeQuery = true)
    List<Integer> getUserPermissionsCode(Long userId);
}
