package com.example.debug.circle.customcommentlist;
/*
 * @author xy
 * @emil 384813636@qq.com
 * create at 2018/12/24
 * description:
 */

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.debug.circle.R;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter {
    private Context mContext;
    private CommentListView mListview;
    private List<CommentItem> mDatas;

    public CommentAdapter(Context context){
        mContext=context;
        mDatas=new ArrayList();
    }
    public CommentAdapter(Context context,List datas){
        mContext=context;
        mDatas=datas;
    }
    public void bindListView(CommentListView listView){
        if(listView==null){
            throw new IllegalArgumentException("listview is null");
        }
        mListview=listView;
    }
    public void setDatas(List<CommentItem> datas){
        if(datas==null){
            datas=new ArrayList<CommentItem>();
        }
        mDatas=datas;
    }

    private View getView(final int position){
        View convertView=View.inflate(mContext,R.layout.item_social_comment,null);
        TextView commentTv=convertView.findViewById(R.id.commentTv);
        final CircleMovementMethod circleMovementMethod=new CircleMovementMethod(R.color.circle_name_selector_color,R.color.circle_name_selector_color);
        CommentItem bean= mDatas.get(position);
        String name=bean.getUserNickname();
        String toReplyName="";
        if(bean.getAppointUserid()!=null){
            toReplyName=bean.getAppointUserNickname();
        }
        SpannableStringBuilder builder=new SpannableStringBuilder();
        builder.append(setClickableSpan(name,bean.getUserId(),0));
        if(!TextUtils.isEmpty(toReplyName)){
            builder.append("回复");
            builder.append(setClickableSpan(toReplyName,bean.getAppointUserNickname(),1));
        }
        builder.append(":");
        builder.append(bean.getContent());
        commentTv.setMovementMethod(circleMovementMethod);
        commentTv.setText(builder);
        commentTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(circleMovementMethod.isPassToTv()){
                    mListview.getOnItemClickListener().onItemClick(position);
                }
            }
        });
        commentTv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(circleMovementMethod.isPassToTv()){
                    mListview.getOnItemLongClickListener().onItemLongClick(position);
                    return true;
                }
                return false;
            }
        });
        return convertView;
    }
    private SpannableString setClickableSpan(String textStr,String userId,int position){
        SpannableString subjectSpanText=new SpannableString(textStr);
        subjectSpanText.setSpan(new NameClickable(new NameClickListener(subjectSpanText,userId),position),0,subjectSpanText.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return subjectSpanText;
    }
    public void notifyDataSetChanged(){
        if(mListview==null){
            throw new NullPointerException("listview is null");
        }
        mListview.removeAllViews();
        if(mDatas==null||mDatas.size()==0){
            return;
        }
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        for(int i=0;i<mDatas.size();i++){
            final int index=i;
            View view=getView(index);
            if(view==null){
                throw new NullPointerException("listview item layout is null");
            }
            mListview.addView(view,index,layoutParams);
        }
    }
}
