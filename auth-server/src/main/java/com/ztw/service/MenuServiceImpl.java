package com.ztw.service;

import com.ztw.iservice.IMenuService;
import com.ztw.model.Menu;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by zsl-pc on 2016/9/2.
 */
@Component
public class MenuServiceImpl {

    @PersistenceContext
    EntityManager em;

    public List<Menu> findByPid(Integer pid, String type) {
        String hql = "FROM Menu m WHERE 1=1 ";
        if(pid!=null && pid>0) {hql += " AND m.pid="+pid;}
        else {hql += " AND m.pid is null ";}
        if(type!=null && ("1".equals(type) || "2".equals(type))) {
            hql += " AND m.type='"+type+"'";
        }
        hql += " ORDER BY m.orderNum ASC";
        Query q = em.createQuery(hql);
        return q.getResultList();
    }
}
