package com.example.meteoepal;

import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.annotation.NonNull;

// This a helper class to store info for each School, in order to attach them to the Pin
public class PinInfo{
    public String schoolName;
    public Integer moreInf;
    //doumou: add more school info

    public PinInfo(String theName) {
        setSchoolName(theName);
        moreInf = 1;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    @NonNull
    @Override
    public String toString() {
        return getSchoolName() + "\n" + moreInf;
    }
}
