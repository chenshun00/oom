package com.example.reproduce.oom.ctrl;

import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author chenshun00@gmail.com
 * @since 2021/8/17 1:40 下午
 */
@RestController
@RequestMapping("/local")
public class TestCtrl {

    @GetMapping("test")
    public JSONObject test() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("ff.json");
        try (final InputStream inputStream = classPathResource.getInputStream()) {
            byte[] bytes = new byte[inputStream.available()];
            IOUtils.readFully(inputStream, bytes);
            return JSONObject.parseObject(new String(bytes, StandardCharsets.UTF_8));
        }
    }

}
