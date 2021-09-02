package com.yang.shopping.service;


import com.yang.shopping.domain.OrderRecord;
import com.yang.shopping.utils.OrderRecordData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderRecordService {
    /**
     * 批量删除【请填写功能名称】
     *
     * @param rids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecordByRids(int[] rids);

    public OrderRecordData selectRecordList(OrderRecord orderRecord);
    public OrderRecordData selectRecordListByPage(int page, int limit);
}
