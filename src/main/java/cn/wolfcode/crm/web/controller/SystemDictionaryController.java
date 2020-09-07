package cn.wolfcode.crm.web.controller;

import cn.wolfcode.crm.domain.SystemDictionary;
import cn.wolfcode.crm.query.QueryObject;
import cn.wolfcode.crm.service.ISystemDictionaryService;
import cn.wolfcode.crm.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/systemDictionary")
public class SystemDictionaryController {
    
    @Autowired
    private ISystemDictionaryService systemDictionaryService;

    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") QueryObject qo){
        PageInfo pageInfo = systemDictionaryService.query(qo);
        model.addAttribute("result", pageInfo);
        return "systemDictionary/list";
    }


    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(SystemDictionary systemDictionary){
        if(systemDictionary.getId() == null){ // 代表新增
            systemDictionaryService.save(systemDictionary);
        }else { // 代表修改
            systemDictionaryService.update(systemDictionary);
        }
        return new JsonResult();
    }


}
