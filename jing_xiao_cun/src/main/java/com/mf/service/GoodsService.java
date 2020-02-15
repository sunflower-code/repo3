package com.mf.service;

import com.mf.entity.Goods;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * 商品Service接口
 * @author Administrator
 *
 */

public interface GoodsService {

    /**
     * 根据条件分页查询商品信息
     * @param goods
     * @param page
     * @param pageSize
     * @param direction
     * @param properties
     * @return
     */
    public List<Goods> list(Goods goods, Integer page, Integer pageSize, Sort.Direction direction,String...properties);

    /**
     * 获取总记录数
     * @param goods
     * @return
     */
    public Long getCount(Goods goods);

    /**
     * 根据商品编码或商品名称条件分页查询没有库存的商品信息
     * @param codeOrName
     * @param page
     * @param pageSize
     * @param direction
     * @param properties
     * @return
     */
    public List<Goods> listNoInventoryQuantityByCodeName(String codeOrName, Integer page, Integer pageSize, Sort.Direction direction,String...properties);

    /**
     * 根据商品编码或商品名称查询没有库存的商品信息的总记录数
     * @param codeOrName
     * @return
     */
    public Long getCountNoInventoryQuantityByCodeOrName(String codeOrName);

    /**
     * 根据id删除商品
     * @param id
     */
    public void delete(Integer id);

    /**
     * 根据id查询实体
     * @param id
     * @return
     */
    public Goods findById(Integer id);

    /**
     * 添加或者修改商品信息
     * @param goods
     */
    public void save(Goods goods);


    /**
     * 查询库存报警商品，实际库存小于库存下限的商品
     * @return
     */
    public List<Goods> listAlarm();

}
