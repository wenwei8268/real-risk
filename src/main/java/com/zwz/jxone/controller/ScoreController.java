package com.zwz.jxone.controller;

import com.zwz.jxone.po.ModelRulePO;
import com.zwz.jxone.po.ModelStrategyPO;
import com.zwz.jxone.po.UserPO;
import com.zwz.jxone.service.ModelRuleService;
import com.zwz.jxone.service.ModelService;
import com.zwz.jxone.service.ModelStrategyService;
import com.zwz.jxone.service.UserService;
import com.zwz.jxone.util.GroovyUtils;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/models/rules")
public class ScoreController {

  @Autowired
  private ModelService modelService;

  @Autowired
  private ModelStrategyService modelStrategyService;

  @Autowired
  private ModelRuleService modelRuleService;

  @Autowired
  private UserService userService;

  List<ModelRulePO> modelRulePOS;


  @GetMapping(path = "/score")
  public Integer getScore(@RequestParam Integer modelId,@RequestParam(required = false) Integer uid){
    //1：通过uid查询用户的基本信息，比如说年龄，收入等
    UserPO userPO=userService.selectById(uid);
    //2：通过modelId找到策略集合
    modelStrategyService.listStrategyByModelId(modelId);
    //3: 通过策略集合找到规则
    for (ModelStrategyPO modelStrategyPO:modelStrategyService.listStrategyByModelId(modelId)){
      modelRulePOS= modelRuleService.listRulesByStrategyId(modelStrategyPO.getId());
    }

    //4:判断当前的用户是否满足规则，返回规则分
    for (ModelRulePO modelRulePO:modelRulePOS){
      checkActivationScript(modelRulePO.getRuleDefinition(),null,null);
    }
    return 0;

  }



  private Boolean checkActivationScript(String ruleScript, Map data, Map<String, Object> dataCollectionMap) {
    Object[] args = {data, dataCollectionMap};
    Boolean ret = false;
    try {
      ret = (Boolean) GroovyUtils.invokeMethod(ruleScript, "check", args);
    } catch (Exception e) {
     e.printStackTrace();
    }
    return ret;
  }

}
