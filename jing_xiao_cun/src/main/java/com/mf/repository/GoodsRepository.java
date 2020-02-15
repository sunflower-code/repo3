package com.mf.repository;

import com.mf.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 商品Repository接口
 * @author Administrator
 *
 */

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer>, JpaSpecificationExecutor<Goods> {

    /**
     * 查询库存报警商品，实际库存小于库存下限的商品
     * @return
     */
    @Query(value="SELECT * FROM t_goods WHERE inventory_quantity<min_inventory",nativeQuery=true)
    public List<Goods> listAlarm();
    
}
