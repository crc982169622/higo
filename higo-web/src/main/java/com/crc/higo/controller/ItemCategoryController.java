package com.crc.higo.controller;

import com.crc.higo.base.BaseController;
import com.crc.higo.constant.ItemCategoryConstant;
import com.crc.higo.domain.ItemCategory;
import com.crc.higo.domain.UserDomain;
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
@RequestMapping("/itemCategory")
public class ItemCategoryController extends BaseController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @RequestMapping("/toItemCategoryList")
    public String toItemCategoryList(HttpServletRequest request) {
        List<ItemCategory> firstCategoryList = itemCategoryService.findCategoryListByLevel(ItemCategoryConstant.FIRST_CATEGORY_LEVEL);
        request.setAttribute("firstCategoryList", firstCategoryList);
        return "/itemCategory/itemCategoryList";
    }

    @RequestMapping("/findItemCategoryList")
    @ResponseBody
    public ResultPageMessage<ItemCategoryVO> findItemCategoryList(ItemCategoryVO itemCategoryVO) {
        PageHelper.startPage(itemCategoryVO.getPage(), itemCategoryVO.getLimit());
        List<ItemCategoryVO> itemCategoryList = itemCategoryService.findItemCategoryVOList(itemCategoryVO);
        PageInfo pageInfo = new PageInfo<>(itemCategoryList);
        return new ResultPageMessage(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping("/toItemCategoryForm")
    public String toItemCategoryForm(String itemCategoryId, HttpServletRequest request) {
        if (itemCategoryId != null && !itemCategoryId.equals("")) {
            // 编辑商品类别
            ItemCategory itemCategory = itemCategoryService.findItemCategoryById(itemCategoryId);
            request.setAttribute("itemCategory", itemCategory);
        }
        List<ItemCategory> firstCategoryList = itemCategoryService.findCategoryListByLevel(ItemCategoryConstant.FIRST_CATEGORY_LEVEL);
        request.setAttribute("firstCategoryList", firstCategoryList);
        return "/itemCategory/itemCategoryForm";
    }

    @RequestMapping("/findCategoryByNameAndLevel")
    @ResponseBody
    public ResultMessage findCategoryByNameAndLevel(String categoryName, Integer categoryLevel) {
        try {
            ItemCategory itemCategory = itemCategoryService.findItemCategoryByNameAndLevel(categoryName, categoryLevel);
            return new ResultMessage(SUCCESS, itemCategory);
        } catch (Exception e) {
            logger.error("获取商品类别错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "获取商品类别错误");
        }
    }

    @RequestMapping("/addItemCategory")
    @ResponseBody
    public ResultMessage addItemCategory(ItemCategory itemCategory) {
        try {
            itemCategory.setCreateUser(this.getLoginUser().getUserName());
            itemCategory.setCreateDate(new Date());
            itemCategoryService.addItemCategory(itemCategory);
            return new ResultMessage();
        } catch (Exception e) {
            logger.error("添加商品类别错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "添加商品类别错误");
        }
    }

    @RequestMapping("/deleteItemCategoryList")
    @ResponseBody
    public ResultMessage deleteItemCategoryList(String[] categoryIds) {
        try {
            for (String categoryId : categoryIds
                 ) {
                itemCategoryService.deleteItemCategory(categoryId);
            }
            return new ResultMessage();
        } catch (Exception e) {
            logger.error("批量删除商品类别错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "批量删除商品类别错误");
        }
    }

    @RequestMapping("/deleteItemCategory")
    @ResponseBody
    public ResultMessage deleteItemCategory(String categoryId) {
        try {
            itemCategoryService.deleteItemCategory(categoryId);
            return new ResultMessage();
        } catch (Exception e) {
            logger.error("删除商品类别错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "删除商品类别错误");
        }
    }

    @RequestMapping("/editItemCategory")
    @ResponseBody
    public ResultMessage editItemCategory(ItemCategory itemCategory) {
        try {
            itemCategory.setUpdateDate(new Date());
            itemCategory.setUpdateUser(this.getLoginUser().getUserName());
            itemCategoryService.updateItemCategory(itemCategory);
            return new ResultMessage();
        } catch (Exception e) {
            logger.error("修改商品类别错误" + StringUtil.getStackTrace(e));
            return new ResultMessage(ERROR, "修改商品类别错误");
        }
    }


}
