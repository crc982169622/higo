package com.crc.higo.controller;

import com.crc.higo.base.BaseController;
import com.crc.higo.constant.ItemCategoryConstant;
import com.crc.higo.domain.ItemCategory;
import com.crc.higo.service.BrandService;
import com.crc.higo.service.ItemCategoryService;
import com.crc.higo.util.ResultMessage;
import com.crc.higo.util.ResultPageMessage;
import com.crc.higo.util.StringUtil;
import com.crc.higo.vo.ItemCategoryVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/19 23:20
 **/
@Controller
@RequestMapping("/brand")
public class BrandController extends BaseController {


    @RequestMapping("/toBrandList")
    public String toBrandList() {
        return "/brand/brandList";
    }

    @RequestMapping("/toBrandForm")
    public String toBrandForm() {
        return "/brand/brandForm";
    }


}
