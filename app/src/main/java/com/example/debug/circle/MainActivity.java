package com.example.debug.circle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.debug.circle.customcommentlist.CommentAdapter;
import com.example.debug.circle.customcommentlist.CommentItem;
import com.example.debug.circle.customcommentlist.CommentListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CommentListView commentListView;
    private List<CommentItem> list;
    private CommentAdapter commentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdata();
        initview();
    }
    private void initdata(){
        list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(new CommentItem("ace","0","你好",i+"","zz","1"));
        }
    }
    private void initview(){
        commentListView=findViewById(R.id.commentlist);
        commentAdapter=new CommentAdapter(this,list);
        commentListView.setAdapter(commentAdapter);
        commentListView.setOnItemClickListener(new CommentListView.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,"zz",Toast.LENGTH_SHORT).show();
            }
        });
        commentListView.setOnItemLongClickListener(new CommentListView.onItemLongClickListener() {
            @Override
            public void onItemLongClick(int position) {
                Toast.makeText(MainActivity.this,"zzzz",Toast.LENGTH_SHORT).show();
            }
        });
        commentAdapter.notifyDataSetChanged();
    }
}
