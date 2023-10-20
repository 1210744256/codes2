package com.baizhi.feign;

import com.baizhi.entity.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("CITY")
public interface CityFeign {
    @GetMapping("/cities")
     List<City> queryAll();
}
