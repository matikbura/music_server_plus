package community_health_management.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import community_health_management.comment.result.Result;
import community_health_management.comment.ustils.SnowflakeUtils;

@RequestMapping("upload")
@RestController
public class UploadController {
    @Value("${filePath}")
    String filePath;

    @PostMapping("uploadImg")
    public Result<String> uploadImg(MultipartFile file) throws IOException {
        String savePath = filePath;
        //保存文件
        String old = file.getOriginalFilename();
        assert old != null;
        String newFileName = "IMG" + SnowflakeUtils.snowflake() + old.substring(old.lastIndexOf("."));
        //保存文件
        file.transferTo(new File(savePath + newFileName));
        return Result.success("/resource/" + newFileName);
    }
}
