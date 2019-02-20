package com.funtl.myshop.commons.service.impl;

import com.funtl.myshop.commons.domain.TbItem;
import com.funtl.myshop.commons.mapper.TbItemMapper;
import com.funtl.myshop.commons.service.TbItemService;
import org.springframework.stereotype.Service;

@Service
public class TbItemServiceImpl extends BaseCrudServiceImpl<TbItem, TbItemMapper> implements TbItemService {

}
