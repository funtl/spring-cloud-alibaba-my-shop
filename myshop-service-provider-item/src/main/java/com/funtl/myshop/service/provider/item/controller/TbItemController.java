package com.funtl.myshop.service.provider.item.controller;

import com.funtl.myshop.commons.domain.TbItem;
import com.funtl.myshop.commons.service.TbItemService;
import com.funtl.myshop.commons.web.AbstractBaseController;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "item")
public class TbItemController extends AbstractBaseController<TbItem> {
    @Autowired
    private TbItemService tbItemService;

    /**
     * 说明：
     * 消费者传递对象参数，提供者接收参数的方式必须是 POST
     * 并且对象参数前要加上 @RequestBody 的注解
     *
     * @param tbItem
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "商品分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = true, paramType = "path")
    })
    @GetMapping(value = "page/{pageNum}/{pageSize}")
    public PageInfo<TbItem> page(
            @ApiParam(name = "商品信息", required = false) @RequestBody TbItem tbItem,
            @PathVariable int pageNum,
            @PathVariable int pageSize
    ) {
        PageInfo<TbItem> page = tbItemService.page(tbItem, pageNum, pageSize);
        return page;
    }
}
