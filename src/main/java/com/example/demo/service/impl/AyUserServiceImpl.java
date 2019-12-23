package com.example.demo.service.impl;

import com.example.demo.model.AyUser;
import com.example.demo.repository.AyUserRepository;
import com.example.demo.service.AyUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gavin on 2019/12/20.
 */
@Transactional
@Service//会自动烧苗到@Component注解的类并把这些类纳入到Spring容器中管理，也可以用@Component
public class AyUserServiceImpl implements AyUserService {

    @Resource(name = "ayUserRepository")
    private AyUserRepository ayUserRepository;


    @Override
    public AyUser findById(String id) {
        return ayUserRepository.findById(id).get();
    }

    @Override
    public List<AyUser> findAll() {
        return ayUserRepository.findAll();
    }

    //注解添加到方法上，会覆盖类注解
    @Transactional
    @Override
    public AyUser save(AyUser user) {
        AyUser saveUser = ayUserRepository.save(user);
        //出现空指针异常
        String error = null;
        error.split("/");
        return saveUser;
    }

    @Override
    public void delete(String id) {
        ayUserRepository.deleteById(id);
    }

    @Override
    public Page<AyUser> findAll(Pageable pageable) {
        return ayUserRepository.findAll(pageable);
    }

    @Override
    public List<AyUser> findByName(String name) {
        return ayUserRepository.findByName(name);
    }

    @Override
    public List<AyUser> findByNameLike(String name) {
        return ayUserRepository.findByNameLike(name);
    }

    @Override
    public List<AyUser> findByIdIn(Collection<String> ids) {
        return ayUserRepository.findByIdIn(ids);
    }
}
