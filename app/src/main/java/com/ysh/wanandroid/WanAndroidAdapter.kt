package com.ysh.wanandroid


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import kotlinx.android.synthetic.main.item_wanandroid.*
import kotlinx.android.synthetic.main.item_wanandroid.view.*

class WanAndroidAdapter:ListAdapter<AndroidDatas,MyViewHolder>(DIFFCALLBACK){
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int):MyViewHolder{
        val holder = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_wanandroid,parent,false))
        holder.itemView.setOnClickListener{}
        return holder
    }
    override fun onBindViewHolder(holder: MyViewHolder,position:Int){
        holder.itemView.tv_first_2.text = getItem(position).shareUser    //绑定数据
        holder.itemView.tv_second.text = getItem(position).title
        holder.itemView.tv_third_2.text = getItem(position).chapterName
    }

    //比较器
    object DIFFCALLBACK:DiffUtil.ItemCallback<AndroidDatas>(){
        override fun areItemsTheSame(oldItem: AndroidDatas, newItem: AndroidDatas): Boolean {
            return oldItem === newItem  //判断两个item是否相等  ===是判断是否为同一个对象
        }

        override fun areContentsTheSame(oldItem: AndroidDatas, newItem: AndroidDatas): Boolean {
            return oldItem.id == newItem.id   //判断两个内容是否相等 用id来判断
        }

    }

}
class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)