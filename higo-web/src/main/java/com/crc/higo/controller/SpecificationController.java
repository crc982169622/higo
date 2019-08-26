package com.crc.higo.controller;

import com.crc.higo.base.BaseController;
import com.crc.higo.domain.ItemCategory;
import com.crc.higo.domain.Specification;
import com.crc.higo.service.BrandService;
import com.crc.higo.service.ItemCategoryService;
import com.crc.higo.service.SpecificationService;
import com.crc.higo.util.ResultMessage;
import com.crc.higo.util.ResultPageMessage;
import com.crc.higo.util.StringUtil;
import com.crc.higo.vo.SpecificationVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/toSpecificationList")
    public String toSpecificationList() {
        return "/specification/specificationList";
    }

    @RequestMapping("/findSpecificationList")
    @ResponseBody
    public ResultPageMessage<SpecificationVO> findSpecificationList(SpecificationVO specificationVO) {
        PageHelper.startPage(specificationVO.getPage(), specificationVO.getLimit());
        List<SpecificationVO> specificationVOList = specificationService.findSpecificationVOList();
        PageInfo pageInfo = new PageInfo<>(specificationVOList);
        return new ResultPageMessage<>(pageInfo.getTotal(), pageInfo.getList());
    }


}
