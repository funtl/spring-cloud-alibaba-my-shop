package com.funtl.myshop.service.consumer.item.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.funtl.myshop.commons.domain.TbItem;
import com.funtl.myshop.commons.dto.AbstractBaseResult;
import com.funtl.myshop.commons.utils.MapperUtils;
import com.funtl.myshop.commons.web.AbstractBaseController;
import com.funtl.myshop.service.consumer.item.service.TbItemService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "item")
public class TbItemController extends AbstractBaseController<TbItem> {

    @Autowired
    private TbItemService tbItemService;

    @ApiOperation(value = "商品分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = true, paramType = "path")
    })
    @GetMapping(value = "page/{pageNum}/{pageSize}")
    public AbstractBaseResult page(
            @ApiParam(name = "商品信息", required = false) TbItem tbItem,
            @PathVariable int pageNum,
            @PathVariable int pageSize) {
        String json = tbItemService.page(tbItem, pageNum, pageSize);
        try {
            JavaType javaType = MapperUtils.getCollectionType(PageInfo.class, TbItem.class);
            PageInfo<TbItem> pageInfo = MapperUtils.getInstance().readValue(json, javaType);
            return success(request.getRequestURI(), pageInfo.getNextPage(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
