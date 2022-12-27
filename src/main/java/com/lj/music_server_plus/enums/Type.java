package com.lj.music_server_plus.enums;

import lombok.Getter;

@Getter
public enum Type {
    MUSIC(1, "音乐"),
    PLAYLIST(2, "歌单"),
    SINGER(3, "歌手"),
    ALBUM(4, "MV"),
    MV(5, "专辑"),
    ;
    final int typeNum;
    final String typeName;
    Type(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }
}
