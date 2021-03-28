package com.ysh.wanandroid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.toolbox.StringRequest
import com.android.volley.Request
import com.android.volley.Response
import com.google.gson.Gson

//继承Android的ViewModel 因为需要传application这个参数
class WanAndroidViewModel(application: Application) : AndroidViewModel(application) {
    //实现封装 只能在外部得到LiveData的数据 而不能在外部改变其中的数据
    private val _articleListLive = MutableLiveData<List<AndroidDatas>>()
    val articleListLive :LiveData<List<AndroidDatas>>
    get() = _articleListLive

    fun fetchData(){
        val stringRequest = StringRequest(
            Request.Method.GET,
            getUrl(),
            Response.Listener {
                _articleListLive.value = Gson().fromJson(it,WanAndroid::class.java).data.datas.toList()  //解析Gson
            },
            Response.ErrorListener {  }
        )
        VolleySingleton.getInstance(getApplication()).requestQueue.add(stringRequest)
    }

    private fun getUrl():String{
        return "https://www.wanandroid.com/article/list/${keyWords.random()}/json?cid=60"
    }

    private val keyWords = arrayOf(0,1,2) //随机页数 我发现好像只有3页
}