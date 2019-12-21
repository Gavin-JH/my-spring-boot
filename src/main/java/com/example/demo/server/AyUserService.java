package com.example.demo.server;

import com.example.demo.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Gavin on 2019/12/20.
 */
public interface AyUserService {
    AyUser findById(String id);

    List<AyUser> findAll();

    AyUser save(AyUser user);

    void delete(String id);

    //分页   Pageable分页接口
    Page<AyUser> findAll(Pageable pageable);

    /**
     * 自定义
     * @param name
     * @return
     */

    List<AyUser> findByName(String name);

    List<AyUser> findByNameLike(String name);

    List<AyUser> findByIdIn(Collection<String> ids);

}
