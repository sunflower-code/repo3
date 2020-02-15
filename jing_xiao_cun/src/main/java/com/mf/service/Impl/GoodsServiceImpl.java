package com.mf.service.Impl;

import com.mf.entity.Goods;
import com.mf.repository.GoodsRepository;
import com.mf.service.GoodsService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {


    @Resource
    private GoodsRepository goodsRepository;


    @Override
    public List<Goods> list(Goods goods, Integer page, Integer pageSize, Sort.Direction direction, String... properties) {
        return null;
    }

    @Override
    public Long getCount(Goods goods) {
        return null;
    }

    @Override
    public List<Goods> listNoInventoryQuantityByCodeName(String codeOrName, Integer page, Integer pageSize, Sort.Direction direction, String... properties) {
        return null;
    }

    @Override
    public Long getCountNoInventoryQuantityByCodeOrName(String codeOrName) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Goods findById(Integer id) {
        return null;
    }

    @Override
    public void save(Goods goods) {

    }

    @Override
    public List<Goods> listAlarm() {
        return goodsRepository.listAlarm();
    }
}
