package com.yang.shopping.mapper;

import com.yang.shopping.domain.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface GoodMapper {

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public List<Good> selectGoodsListByPage(@Param("page")int page, @Param("limit")int limit);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param goods 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Good> selectGoodsList(Good goods);

    /**
     * 新增【请填写功能名称】
     *
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    public int insertGoods(Good goods);

    /**
     * 修改【请填写功能名称】
     *
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    public int updateGoods(Good goods);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteGoodsById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsByIds(int[] ids);

    int countGood();

    Double totalSale();

    Double todaySale(String date);
}
