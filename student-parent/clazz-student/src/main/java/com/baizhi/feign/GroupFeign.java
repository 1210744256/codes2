package com.baizhi.feign;

import com.baizhi.entity.Group;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient("GROUP")
public interface GroupFeign {
    @GetMapping("/groups")
    public List<Group> queryAll();
}
