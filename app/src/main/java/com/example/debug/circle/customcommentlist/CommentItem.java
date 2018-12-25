package com.example.debug.circle.customcommentlist;
/*
 * @author xy
 * @emil 384813636@qq.com
 * create at 2018/12/24
 * description:
 */

import android.os.Parcel;
import android.os.Parcelable;

public class CommentItem implements Parcelable {
    private String appointUserNickname;
    private String appointUserid;
    private String content;
    private String createTime;
    private String id;
    private String pictures;
    private String publishId;
    private String userId;
    private String userNickname;

    public CommentItem(String appointUserNickname, String appointUserid, String content, String publishId, String userId, String userNickname){
        this.appointUserNickname=appointUserNickname;
        this.appointUserid=appointUserid;
        this.content=content;
        this.publishId=publishId;
        this.userId=userId;
        this.userNickname=userNickname;
    }

    public static final Creator<CommentItem> CREATOR = new Creator<CommentItem>() {
        @Override
        public CommentItem createFromParcel(Parcel in) {
            return new CommentItem(in);
        }

        @Override
        public CommentItem[] newArray(int size) {
            return new CommentItem[size];
        }
    };

    protected CommentItem(Parcel in) {
        this.appointUserNickname=in.readString();
        this.content=in.readString();
        this.appointUserid=in.readString();
        this.createTime=in.readString();
        this.id=in.readString();
        this.pictures=in.readString();
        this.publishId=in.readString();
        this.userId=in.readString();
        this.userNickname=in.readString();
    }

    public String getAppointUserid() {
        return appointUserid;
    }

    public String getAppointUserNickname() {
        return appointUserNickname;
    }

    public String getContent() {
        return content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getId() {
        return id;
    }

    public String getPictures() {
        return pictures;
    }

    public String getPublishId() {
        return publishId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setAppointUserid(String appointUserid) {
        this.appointUserid = appointUserid;
    }

    public void setAppointUserNickname(String appointUserNickname) {
        this.appointUserNickname = appointUserNickname;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appointUserNickname);
        parcel.writeString(this.appointUserid);
        parcel.writeString(this.content);
        parcel.writeString(this.createTime);
        parcel.writeString(this.id);
        parcel.writeString(this.pictures);
        parcel.writeString(this.publishId);
        parcel.writeString(this.userId);
        parcel.writeString(this.userNickname);
    }
}
