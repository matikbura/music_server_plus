package com.lj.music_server_plus.common.ustils;

import cn.hutool.core.convert.Convert;
import com.lj.music_server_plus.exception.AuthException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseUtil {
    // Convert a list of objects to a list of objects of the same type
    public static <T> List<T> convertList(List<?> list, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        for (Object o : list) {
            T t = Convert.convert(clazz, o);
            result.add(t);
        }
        return result;
    }
    //获取loginId 如果为空抛出异常
    public static Integer getLoginId(HttpServletRequest request, boolean isThrow) {
        if (isThrow){
            return  Optional.ofNullable(request.getHeader("loginId")).map(Integer::valueOf).orElseThrow(() -> new AuthException("请先登录"));
        }else {
            return  Optional.ofNullable(request.getHeader("loginId")).map(Integer::valueOf).orElse(null);
        }
    }
}

