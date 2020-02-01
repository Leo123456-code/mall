package com.imooc.mall.serviceImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.form.CartUpdateForm;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by Leo徐忠春
 * created Time 2020/1/7-4:55
 * email 1437665365@qq.com
 */
@Slf4j
public class CartServiceImplTest extends MallApplicationTests {
    @Autowired
    private ICartService cartService;

    private Gson gson=new GsonBuilder().setPrettyPrinting().create();

    @Before
    @Test
    public  void  add(){
        CartAddForm from = new CartAddForm();
        from.setProductId(28);
        from.setSelected(true);
        ResponseVo<CartVo> cartVo = cartService.add(1, from);
        log.info("cartVo={}",gson.toJson(cartVo));

    }

    @Test
    public void list(){
        ResponseVo<CartVo> list = cartService.list(1);
        log.info("list={}",gson.toJson(list));
    }
    @Test
    public void update(){
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(10);
        ResponseVo<CartVo> responseVo = cartService.update(1, 26,form );
        log.info("list={}",gson.toJson(responseVo));
    }
    @After
    @Test
    public void delete(){
        ResponseVo<CartVo> responseVo = cartService.delete(1, 26);
        log.info("list={}",gson.toJson(responseVo));
    }
    @Test
    public void selectAll(){
        ResponseVo<CartVo> responseVo = cartService.selectAll(1);
        log.info("list={}",gson.toJson(responseVo));
    }
    @Test
    public void unSelectAll(){
        ResponseVo<CartVo> responseVo = cartService.unSelectAll(1);
        log.info("list={}",gson.toJson(responseVo));
    }
    @Test
    public void productSum(){
        ResponseVo<Integer> responseVo = cartService.productSum(1);
        log.info("list={}",gson.toJson(responseVo));
    }
}