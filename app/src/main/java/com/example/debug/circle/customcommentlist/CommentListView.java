package com.example.debug.circle.customcommentlist;
/*
 * @author xy
 * @emil 384813636@qq.com
 * create at 2018/12/24
 * description:
 */

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class CommentListView extends LinearLayout {
    private onItemClickListener mOnItemClickListener;
    private onItemLongClickListener mOnItemLongClickListener;
    public CommentListView(Context context) {
        super(context);
    }

    public CommentListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommentListView(Context context, AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setAdapter(CommentAdapter adapter){
        adapter.bindListView(this);
    }
    public void setOnItemClickListener(onItemClickListener listener){
        mOnItemClickListener=listener;
    }
    public void setOnItemLongClickListener(onItemLongClickListener listener){
        mOnItemLongClickListener=listener;
    }
    public onItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public onItemLongClickListener getOnItemLongClickListener() {
        return mOnItemLongClickListener;
    }
    public static interface onItemClickListener{
        void onItemClick(int position);
    }
    public static interface onItemLongClickListener{
        void onItemLongClick(int position);
    }
}
