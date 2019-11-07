package org.normal.framework.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@NoRepositoryBean
@Repository
public class BaseRepository<T> {
    @PersistenceContext
    private EntityManager entityManager;

    public List<T> queryAllBySQL(String sql, List<Object> paramValueList,T clazz) {
        if(null==paramValueList)paramValueList = new ArrayList<>();
        Query query = this.entityManager.createNativeQuery(sql,clazz.getClass());
        for(int i = 0 ; i < paramValueList.size() ; i++)
            query.setParameter(i, paramValueList.get(i));
        List<T> list = query.getResultList();
        return list;
    }
}
