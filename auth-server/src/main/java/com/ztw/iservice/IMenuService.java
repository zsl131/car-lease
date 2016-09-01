package com.ztw.iservice;

import com.ztw.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zsl-pc on 2016/9/1.
 */
public interface IMenuService extends JpaRepository<Menu, Integer> {

}
