package com.myrecyclerview.myrecyclerviewtext;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangsimin on 2017/11/13.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<String> mDatas;

    private Context mContext;

    public RecycleAdapter(Context context, List<String> datas){
        mContext = context;
        mDatas = datas;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);//这个布局就是一个imageview用来显示图片
        MyViewHolder holder = new MyViewHolder(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(view instanceof TextView){
//
//                    Toast.makeText(mContext, ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder){
            ((MyViewHolder)holder).tv.setText(mDatas.get(position));

            ((MyViewHolder)holder).tv.setHeight(10 + position*10);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addNewItem() {
        if(mDatas == null) {
            mDatas = new ArrayList<>();
        }
        mDatas.add(0, "new Item");
        notifyItemInserted(5);
    }

    public void deleteItem() {
        if(mDatas == null || mDatas.isEmpty()) {
            return;
        }
        mDatas.remove(0);
        notifyItemRemoved(0);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;
        public MyViewHolder(View view) {
            super(view);
            tv = (TextView)view.findViewById(R.id.text_item);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, tv.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
