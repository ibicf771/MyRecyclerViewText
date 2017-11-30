package com.myrecyclerview.myrecyclerviewtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView mAddItem, mDeleteItem;
    private RecycleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mAddItem = (TextView)findViewById(R.id.add_item);
        mDeleteItem = (TextView)findViewById(R.id.delete_item);
//        mLayoutManager=new GridLayoutManager(MainActivity.this,3, GridLayoutManager.VERTICAL,false);//设置为一个3列的纵向网格布局

//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter = new RecycleAdapter(MainActivity.this, getData()));
//        mRecyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                MainActivity.this, DividerItemDecoration.VERTICAL));

        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                MainActivity.this, DividerItemDecoration.HORIZONTAL));


//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        mAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.addNewItem();
                // 由于Adapter内部是直接在首个Item位置做增加操作，增加完毕后列表移动到首个Item位置
                mLayoutManager.scrollToPosition(0);
            }
        });
        mDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.deleteItem();
                // 由于Adapter内部是直接在首个Item位置做删除操作，删除完毕后列表移动到首个Item位置
                mLayoutManager.scrollToPosition(0);
            }
        });
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for(int i = 0; i < 20; i++) {
            data.add(i + temp);
        }

        return data;
    }



//    private RecyclerView mRecyclerView;
//
//    private RecyclerView.Adapter mAdapter;
//
//    private RecyclerView.LayoutManager mLayoutManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rv);
//        initData();
//        initView();
//    }
//
//    private void initData() {
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        mAdapter = new MyAdapter(getData());
//    }
//
//    private void initView() {
//        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//        // 设置布局管理器
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        // 设置adapter
//        mRecyclerView.setAdapter(mAdapter);
//    }
//
//    private ArrayList<String> getData() {
//        ArrayList<String> data = new ArrayList<>();
//        String temp = " item";
//        for(int i = 0; i < 20; i++) {
//            data.add(i + temp);
//        }
//
//        return data;
//    }

}

