package com.baizhi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baizhi.entity.Group;
import com.baizhi.service.GroupService;
import com.baizhi.mapper.GroupMapper;
import org.springframework.stereotype.Service;

/**
* @author 12107
* @description 针对表【t_group】的数据库操作Service实现
* @createDate 2023-10-18 18:18:08
*/
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group>
    implements GroupService{

}




