package com.dmsd.tool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Ares on 2017/10/24.
 */
public class JacksonJsonUntil {
    private static final Logger logger = LoggerFactory.getLogger(JacksonJsonUntil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JacksonJsonUntil() {
        throw new IllegalStateException("Utility class");
    }

    public static void beanToJson(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String json = null;

        try {
            json = objectMapper.writeValueAsString(obj);
            PrintWriter out = response.getWriter();
            out.write(json);
        } catch (IOException var4) {
            logger.error("对象转Json失败!!!");
            throw var4;
        }
    }

    public static String objectToJson(Object data) throws JsonProcessingException {
        String string = null;

        try {
            string = objectMapper.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException var3) {
            throw var3;
        }
    }

    public static void beanToUrlJson(HttpServletRequest request, HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("text/plain");
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String callbackFunName = request.getParameter("callbackparam");

        try {
            String json = objectMapper.writeValueAsString(obj);
            PrintWriter out = response.getWriter();
            out.write(callbackFunName + "(" + json + ")");
        } catch (IOException var6) {
            logger.error("对象转Json失败!!!");
            throw var6;
        }
    }

    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) throws IOException {
        Object t = null;

        try {
            t = objectMapper.readValue(jsonData, beanType);
            return (T) t;
        } catch (IOException var4) {
            throw var4;
        }
    }

    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, new Class[]{beanType});
        List list = null;

        try {
            list = (List)objectMapper.readValue(jsonData, javaType);
            return list;
        } catch (IOException var5) {
            throw var5;
        }
    }
}
