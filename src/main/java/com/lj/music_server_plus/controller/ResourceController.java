package com.lj.music_server_plus.controller;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import com.lj.music_server_plus.common.ustils.FfmpegUtils;
import com.lj.music_server_plus.config.NonStaticResourceHttpRequestHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;
    //图片压缩
    @GetMapping(value = {"/img/{type}/{path}"})
    @Operation(summary = "图片资源",parameters = {
            @Parameter(name = "type",description = "图片类型"),
            @Parameter(name = "path",description = "图片路径"),
            @Parameter(name = "cpNum",description = "图片压缩比例")
    })
    public void compressImage(@PathVariable(required = true) String path, @PathVariable(required = true) String type, String cpNum, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        //默认品质最低
        if (cpNum == null) {
            cpNum = "1";
        }
        //获取文件后缀
        String suffix = path.substring(path.lastIndexOf(".") + 1);
        //获取文件名
        String fileName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
        String tageFileName = "";
        //如果品质不是最高
        if (!cpNum.equals("height")) {
            tageFileName = fileName + "_" + cpNum + "." + suffix;
        } else {
            tageFileName = fileName + "." + suffix;
        }
        String outPutFilePath = "C:\\music_data\\img" + File.separator + type + File.separator + tageFileName;
        //文件是否存在
        if (FileUtil.exist(outPutFilePath)) {
            System.out.println("文件存在");
            request.setAttribute(NonStaticResourceHttpRequestHandler.FILE_PATH, outPutFilePath);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            System.out.println("文件不存在");
            String heightFilePath = "C:\\music_data\\img" + File.separator + type + File.separator + path;
            File file = FileUtil.file(heightFilePath);
            if (FileUtil.exist(heightFilePath)) {
                System.out.println("文件存在");
                float cpNumFloat = Float.parseFloat(cpNum) / 10;
                ImgUtil.scale(file, FileUtil.file(outPutFilePath), cpNumFloat);
                request.setAttribute(NonStaticResourceHttpRequestHandler.FILE_PATH, outPutFilePath);
                nonStaticResourceHttpRequestHandler.handleRequest(request, response);
            } else {
                throw new RuntimeException("最高品质的图片不存在");
            }
        }

        //TODO
    }

    @GetMapping(value = {"/music/{path}"})
    @Operation(summary = "音乐资源",parameters = {
            @Parameter(name = "path",description = "音乐路径")
    })
    public void compressMusic(@PathVariable String path, HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException {
        String filePath = "C:\\music_data\\music" + File.separator + path;
        request.setAttribute(NonStaticResourceHttpRequestHandler.FILE_PATH, filePath);
        nonStaticResourceHttpRequestHandler.handleRequest(request, response);
    }

    @GetMapping(value = {"/mv/{path}"})
    @Operation(summary = "mv资源",parameters = {
            @Parameter(name = "path",description = "mv路径"),
            @Parameter(name = "type",description = "mv类型")
    })
    public void compressVideo(@PathVariable String path, String type, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {

        String filePath = "C:\\music_data\\mv" + File.separator + path;
        String suffix = path.substring(path.lastIndexOf(".") + 1);
        String fileName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
        String tageFileName = "";
        if (type==null){
            type="低品质";
        }
        //如果品质不是最高
        if (!type.equals("高品质")) {
            tageFileName = fileName + "_" + type + "." + suffix;
        } else {
            tageFileName = fileName + "." + suffix;
        }
        String outPutFilePath = "C:\\music_data\\mv" + File.separator + tageFileName;
        if (FileUtil.exist(outPutFilePath)) {
            System.out.println("文件存在");
            request.setAttribute(NonStaticResourceHttpRequestHandler.FILE_PATH, outPutFilePath);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            System.out.println("文件不存在");
            String heightFilePath = "C:\\music_data\\mv" + File.separator + path;
            File file = FileUtil.file(heightFilePath);
            if (FileUtil.exist(heightFilePath)) {
                System.out.println("文件存在");
                FfmpegUtils.videoChange(filePath, outPutFilePath, type);
                request.setAttribute(NonStaticResourceHttpRequestHandler.FILE_PATH, outPutFilePath);
                nonStaticResourceHttpRequestHandler.handleRequest(request, response);
            } else {
                throw new RuntimeException("最高品质的图片不存在");
            }
        }
    }
}
