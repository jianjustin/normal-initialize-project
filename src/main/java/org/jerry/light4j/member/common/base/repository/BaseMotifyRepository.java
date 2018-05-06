package org.jerry.light4j.member.common.base.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/***************************************
 * 基础操作接口
 * @author janine
 * @param <T>
 * @since 2017-12-12
 *
 ***************************************/
@NoRepositoryBean
@Repository
public interface BaseMotifyRepository<T,ID extends Serializable> extends JpaRepository<T, Serializable>,CrudRepository<T, Serializable>,PagingAndSortingRepository<T,Serializable>,JpaSpecificationExecutor<T>{


}
