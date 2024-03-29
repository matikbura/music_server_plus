package community_health_management.comment.ustils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class SnowflakeUtils {

    public static long snowflake(){
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id = snowflake.nextId();
        return id;
    }

    public static void main(String[] args) {
        long id = snowflake();
        System.out.println(id);
    }


}