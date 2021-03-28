package com.ysh.wanandroid

import com.google.gson.annotations.SerializedName

data class WanAndroid(
    val errorCode:Int,
    val errorMessage:String,
    val data:AndroidData
)

data class AndroidData(
    val curPage:Int,
    val over:Boolean,
    val size:Int,
    val datas:Array<AndroidDatas>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AndroidData

        if (curPage != other.curPage) return false
        if (over != other.over) return false
        if (size != other.size) return false
        if (!datas.contentEquals(other.datas)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = curPage
        result = 31 * result + over.hashCode()
        result = 31 * result + size
        result = 31 * result + datas.contentHashCode()
        return result
    }
}

data class AndroidDatas(
    val chapterName:String,
    val shareUser:String,
    val title:String,
    val id:Int
)