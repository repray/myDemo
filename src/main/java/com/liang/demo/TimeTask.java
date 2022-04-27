package com.liang.demo;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * @Author Li Yang
 * @Created on 2022/04/12.
 * @Desc
 */
@Slf4j
public class TimeTask {
    public static void main(String[] args) throws InterruptedException {
        while(true){
            String result="";
            try {
//                result = HttpUtil.get("account-yace.xk12.cn/actuator/health");
                result = HttpUtil.get("http://okteacher-yace.xk12.cn/actuator/health");

                if (result.contains("DOWN")){
                    log.info("项目健康检查报错"+result);
                }else if (result.contains("503 Service Temporarily Unavailable")){
                    log.info("服务503 Service Temporarily Unavailable异常");
                }
                else{
                    log.info("正常");
                }
            }catch (Exception e){
                log.info("健康检查接口异常");
            }
            Thread.sleep(10000);
        }
    }
}
