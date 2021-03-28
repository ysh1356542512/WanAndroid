package com.ysh.wanandroid

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleySingleton private constructor(context: Context){  //将constructor私有化 这样外部类就无法使用构造器来形成实例 实现单例
    //对应java中静态的域或类
    companion object{
        private var INSTANCE:VolleySingleton?=null
        fun getInstance(context: Context) =
            INSTANCE?: synchronized(this){
                VolleySingleton(context).also { INSTANCE = it }
            }   //判断是否为空  若为空则new 一个实例
    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }
}