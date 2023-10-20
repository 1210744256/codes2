package com.baizhi.feign;

import com.baizhi.entity.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("TAG")
public interface TagFeign {
    @GetMapping("/tags")
    public List<Tag> queryAll();
}
