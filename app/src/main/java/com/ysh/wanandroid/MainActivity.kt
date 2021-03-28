package com.ysh.wanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wanAndroidAdapter = WanAndroidAdapter()
        rv_wanandroid.apply {
            adapter = wanAndroidAdapter        //设置adapter
            layoutManager = GridLayoutManager(context,1)  //列数为1
        }


        //获取ViewModel  因为viewModel多了一个参数 因此这里也需要放进一个application参数 不然会报错
        val wanAndroidViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application)).get(WanAndroidViewModel::class.java)
        wanAndroidViewModel.articleListLive.observe(this, Observer {
            wanAndroidAdapter.submitList(it)
            swipeRefreshLayout.isRefreshing = false     //当获取完数据后 将下滑刷新的圈圈停止
        })

        wanAndroidViewModel.articleListLive.value?:wanAndroidViewModel.fetchData()    //当这个为空时fetchdata

        swipeRefreshLayout.setOnRefreshListener {
            wanAndroidViewModel.fetchData()       //下滑刷新
        }
    }
}