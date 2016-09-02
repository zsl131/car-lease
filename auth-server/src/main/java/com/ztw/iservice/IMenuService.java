package com.ztw.iservice;

import com.ztw.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by zsl-pc on 2016/9/1.
 */
public interface IMenuService extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Menu m WHERE m.display=1 AND m.type='1' AND m.id in (SELECT rm.mid FROM RoleMenu rm WHERE rm.rid IN (SELECT ur.rid FROM UserRole ur where ur.uid=?1))")
    public List<Menu> findByUser(Integer userId);
}
