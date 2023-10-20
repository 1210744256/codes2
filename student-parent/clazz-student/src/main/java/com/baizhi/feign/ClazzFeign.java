package com.baizhi.feign;

import com.baizhi.entity.Clazz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("CLAZZ")
public interface ClazzFeign {
    @GetMapping("/clazzs/list")
    public List<Clazz> list();
}
