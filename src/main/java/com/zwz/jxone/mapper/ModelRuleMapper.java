package com.zwz.jxone.mapper;


import com.zwz.jxone.po.ModelRulePO;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRuleMapper {
    /**
     *添加
     */
    ModelRulePO insert(ModelRulePO modelPo);
    /**
     * 删除
     */
    ModelRulePO deleteById(Integer id);
    /**
     * 修改
     * @param id
     */
    ModelRulePO updateById(ModelRulePO id);
    /**
     * 查找
     */
    ModelRulePO servicByid(Integer id);
}
