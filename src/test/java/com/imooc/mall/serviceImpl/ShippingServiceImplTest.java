package com.imooc.mall.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.service.IShippingService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * created by Leo徐忠春
 * created Time 2020/1/8-3:02
 * email 1437665365@qq.com
 */
@Slf4j
public class ShippingServiceImplTest extends MallApplicationTests {
    @Autowired
    private IShippingService shippingService;
    private Integer uid = 1;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private ShippingForm form;

    @Before
    public void  before(){
        ShippingForm form = new ShippingForm();
        form.setReceiverName("徐忠春");
        form.setReceiverAddress("湖北武汉");
        form.setReceiverCity("武汉");
        form.setReceiverMobile("18257624255");
        form.setReceiverPhone("027-10100056");
        form.setReceiverProvince("湖北");
        form.setReceiverDistrict("洪山区");
        form.setReceiverZip("027");
        this.form=form;
    }
    @Test
    public void add() {
        ShippingForm form = new ShippingForm();

        ResponseVo<Map<String, Integer>> responseVo =
                shippingService.add(uid, form);
        log.info("responseVo={}",gson.toJson(responseVo));


    }

    @Test
    public void delete() {
        Integer shippingId = 5;
        ResponseVo responseVo = shippingService.delete
                (uid, shippingId);
        log.info("responseVo={}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),
                responseVo.getStatus());
    }

    @Test
    public void update() {
        Integer shippingId = 4;
        ResponseVo responseVo =
                shippingService.update(uid, shippingId, form);
        form.setReceiverCity("杭州");
        form.setReceiverPhone("1888888888");
        log.info("responseVo={}",gson.toJson(responseVo));
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> list = shippingService.list
                (uid, 1, 10);
        log.info("list={}",gson.toJson(list));

    }
}