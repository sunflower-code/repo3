package com.mf.controller.admin;


import com.mf.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/goods")
public class GoodsAdminController {

    @Resource
    private GoodsService goodsService;


}
