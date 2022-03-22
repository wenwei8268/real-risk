package com.zwz.jxone.dao.mapper;

import com.zwz.jxone.po.ModelRulePO;
import com.zwz.jxone.po.ModelStrategyPO;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

/**
 * ming
 */
@Repository
public interface ModelStrategyMapper {
    ModelStrategyPO insert(ModelStrategyPO modelStrategyPO);
    ModelStrategyPO selectById(Integer id);
    ModelStrategyPO updateById(ModelStrategyPO modelRulePO);
    ModelStrategyPO deleteById(Integer id);
}
