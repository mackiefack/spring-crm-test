package cn.wolfcode.crm.service;

import cn.wolfcode.crm.domain.SystemDictionaryItem;
import cn.wolfcode.crm.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ISystemDictionaryItemService {
    void delete(Long id);
    void save(SystemDictionaryItem systemDictionaryItem);
    SystemDictionaryItem get(Long id);
    List<SystemDictionaryItem> listAll();
    void update(SystemDictionaryItem systemDictionaryItem);

    /**
     * 分页
     * @param qo
     * @return
     */
    PageInfo query(QueryObject qo);

    /**
     * 根据目录编码查询明细
     * @param sn
     * @return
     */
    List<SystemDictionaryItem> selectByDicSn(String sn);
}
