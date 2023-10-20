package com.baizhi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import com.baizhi.mapper.CityMapper;
import org.springframework.stereotype.Service;

/**
* @author 12107
* @description 针对表【t_city】的数据库操作Service实现
* @createDate 2023-10-18 16:02:10
*/
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City>
    implements CityService{

}




