package com.yang.shopping.service.Impl;



import com.yang.shopping.domain.Good;
import com.yang.shopping.mapper.GoodMapper;
import com.yang.shopping.service.GoodService;
import com.yang.shopping.utils.GoodData;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    GoodMapper goodMapper;

    public GoodServiceImpl() {
    }

    public GoodData selectGoodsByPage(int page, int limit) {
        GoodData goodData = new GoodData();
        goodData.setData(this.goodMapper.selectGoodsListByPage((page - 1) * limit, limit));
        goodData.setMsg("");
        goodData.setCode(0);
        goodData.setCount(this.goodMapper.countGood());
        return goodData;
    }

    public GoodData selectGoodsList(Good goods) {
        GoodData goodData = new GoodData();
        goodData.setMsg("");
        goodData.setCode(0);
        goodData.setCount(this.goodMapper.countGood());
        goodData.setData(this.goodMapper.selectGoodsList(goods));
        return goodData;
    }

    public int insertGoods(Good goods) {
        return this.goodMapper.insertGoods(goods);
    }

    public int updateGoods(Good goods) {
        return this.goodMapper.updateGoods(goods);
    }

    public int deleteGoodsByIds(int[] ids) {
        return this.goodMapper.deleteGoodsByIds(ids);
    }

    public int deleteGoodsById(Long id) {
        return this.goodMapper.deleteGoodsById(id);
    }

    public int countGood() {
        return this.goodMapper.countGood();
    }

    public Double totalSale() {
        return this.goodMapper.totalSale();
    }

    public Double todaySale() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd%");
        return this.goodMapper.todaySale(df.format(new Date()));
    }
}
