package com.example.debug.circle.customcommentlist;
/*
 * @author xy
 * @emil 384813636@qq.com
 * create at 2018/12/24
 * description:
 */

import android.text.SpannableString;

public class NameClickListener implements ISpanClick{
    private SpannableString userName;
    private String userId;
    public NameClickListener(SpannableString name, String userId){
        userName=name;
        this.userId=userId;
    }
    @Override
    public void onClick(int position) {

    }
}
