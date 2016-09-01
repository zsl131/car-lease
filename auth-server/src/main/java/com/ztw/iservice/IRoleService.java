package com.ztw.iservice;

import com.ztw.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zsl-pc on 2016/9/1.
 */
public interface IRoleService extends JpaRepository<Role, Integer> {

    public Role findBySn(String sn);

//    public List<Integer>
}
