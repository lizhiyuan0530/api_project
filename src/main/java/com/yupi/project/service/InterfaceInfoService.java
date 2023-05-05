package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;


/**
* @author 18148
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-03-17 00:40:14
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
