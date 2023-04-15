package community_health_management.comment.ustils;

import cn.hutool.core.convert.Convert;
import java.util.ArrayList;
import java.util.List;

public class BaseUtil {
    // 列表的类型转换
    public static <T> List<T> convertList(List<?> list, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        for (Object o : list) {
            T t = Convert.convert(clazz, o);
            result.add(t);
        }
        return result;
    }
}

