package com.yang.shopping.mapper;


import com.yang.shopping.domain.OrderRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface OrderRecordMapper {
    /**
     * 批量删除【请填写功能名称】
     *
     * @param rids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecordByRids(int[] rids);

    public List<OrderRecord> selectRecordList(OrderRecord orderRecord);
    public List<OrderRecord> selectRecordListByPage(@Param("page")int page, @Param("limit")int limit);
    public int countOrder();
}
