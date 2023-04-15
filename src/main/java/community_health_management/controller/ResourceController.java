package community_health_management.controller;

import community_health_management.config.StaticResourceHttpRequestHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("resource")
@Tag(name = "资源模块")
public class ResourceController {
    @Autowired
    StaticResourceHttpRequestHandler staticResourceHttpRequestHandler;
    @Value("${filePath}")
    private String filePath;
    @GetMapping(value = {"{fileName}"})
    @Operation(summary = "图片资源")
    public void img(@PathVariable(required = true) String fileName, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException, ServletException {
        request.setAttribute(StaticResourceHttpRequestHandler.FILE_PATH, filePath+File.separator+fileName);
        staticResourceHttpRequestHandler.handleRequest(request, response);
    }
}
