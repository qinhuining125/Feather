package com.feather.system.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.feather.common.annotation.Log;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.file.FileUtils;

import io.swagger.annotations.Api;

/**
 * 通用请求处理
 * 
 * 分布式时，针对 /profile、/common 在nginx中单独配置
 * 
 * @author feather
 */
@Api(tags = "通用请求处理")
@Controller
public class CommonController {

    /**
     * 通用下载请求
     * 
     * @param fileName
     *            文件名称
     * @throws Exception
     */
    @Log(title = "文件下载", businessType = BusinessType.DOWNLOAD)
    @GetMapping("/system/common/download")
    public void fileDownload(String fileName, HttpServletResponse response, HttpServletRequest request)
            throws Exception {
        FileUtils.downloadFile(fileName, request, response);
    }
}
