package com.lj.music_server_plus.body.user.collection;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(name = "CollectionAddBody", description = "收藏移除请求体")
@Data
public class CollectionRemoveBody {
    @Schema(name = "type", description = "收藏目标类型")
    @NotNull(message = "收藏目标类型不能为空")
    private Integer type;
    @Schema(name = "typeId", description = "收藏目标id")
    @NotNull(message = "收藏目标id不能为空")
    private Integer typeId;
    @Schema(hidden = true)
    private Integer userId;
}
