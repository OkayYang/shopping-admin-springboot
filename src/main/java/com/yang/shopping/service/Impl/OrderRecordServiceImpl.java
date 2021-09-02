package com.yang.shopping.service.Impl;

import com.yang.shopping.domain.OrderRecord;
import com.yang.shopping.mapper.OrderRecordMapper;
import com.yang.shopping.service.OrderRecordService;
import com.yang.shopping.utils.OrderRecordData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderRecordServiceImpl implements OrderRecordService {
    @Autowired
    private OrderRecordMapper orderRecordMapper;

    public OrderRecordServiceImpl() {
    }

    public int deleteRecordByRids(int[] rids) {
        return this.orderRecordMapper.deleteRecordByRids(rids);
    }

    public OrderRecordData selectRecordList(OrderRecord orderRecord) {
        OrderRecordData orderRecordData = new OrderRecordData();
        orderRecordData.setData(this.orderRecordMapper.selectRecordList(orderRecord));
        orderRecordData.setCount(this.orderRecordMapper.countOrder());
        orderRecordData.setCode(0);
        orderRecordData.setMsg("");
        return orderRecordData;
    }

    public OrderRecordData selectRecordListByPage(int page, int limit) {
        OrderRecordData orderRecordData = new OrderRecordData();
        orderRecordData.setData(this.orderRecordMapper.selectRecordListByPage((page - 1) * limit, limit));
        orderRecordData.setCount(this.orderRecordMapper.countOrder());
        orderRecordData.setCode(0);
        orderRecordData.setMsg("");
        return orderRecordData;
    }
}
