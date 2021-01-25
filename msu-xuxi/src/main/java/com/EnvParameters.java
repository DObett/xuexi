package com;

import java.util.HashMap;
import java.util.Map;



public class EnvParameters {
    public static String getHostEnv(){
        return System.getenv("API_HOST");
    }

    public static String getDBEnv(){
        return System.getenv("DB_HOST");
    }

    // 缓存 json assert
    public static Map<String,Object> mongoCache = new HashMap<>();

    /**
     * 环境编码
     * @return
     */
    public static String getEnvCode() {
        return System.getenv("ENV_CODE");
    }
}


