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

            HashMap<String, Object> paramMap = new HashMap<>();
            HashMap<String, String> header = new HashMap<>();
            header.put("requestid","1234556");
            paramMap.put("header",header);
            String result="";
//            String result = HttpUtil.get("http://account-yace.xk12.cn/actuator/health",paramMap);
            try {
                result = HttpUtil.get("account-yace.xk12.cn/actuator/health",paramMap);
                if (result.contains("DOWN")){
                    log.info("项目检查检查报错"+result);
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
