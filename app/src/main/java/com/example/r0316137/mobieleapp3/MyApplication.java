package com.example.r0316137.mobieleapp3;

import android.app.Application;

/**
 * Created by Tom on 17/01/2016.
 */
public class MyApplication extends Application {
    private String GroupId;

    public String getGroupId(){
        return GroupId;
    }

    public void setGroupId(String GroupId)
    {
        this.GroupId = GroupId;
    }
}
