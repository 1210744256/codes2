package com.baizhi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baizhi.entity.Tag;
import com.baizhi.service.TagService;
import com.baizhi.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author 12107
* @description 针对表【t_tag】的数据库操作Service实现
* @createDate 2023-10-18 17:36:40
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




