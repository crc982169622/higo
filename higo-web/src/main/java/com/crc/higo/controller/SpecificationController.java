package com.crc.higo.controller;

import com.crc.higo.base.BaseController;
import com.crc.higo.domain.ItemCategory;
import com.crc.higo.service.BrandService;
import com.crc.higo.service.ItemCategoryService;
import com.crc.higo.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/19 23:20
 **/
@Controller
@RequestMapping("/specification")
public class SpecificationController extends BaseController {

    @Autowired
    private SpecificationService specificationService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @RequestMapping("/toMain")
    public String toMain(HttpServletRequest request) {
        return "/specification/specificationMain";
    }

    @RequestMapping("/toSpecificationForm")
    public String toSpecificationForm() {
        return "/specification/specificationForm";
    }

    @RequestMapping("/findSpecificationList")
    public String findSpecificationList() {
        return "/specification/specificationList";
    }


}
