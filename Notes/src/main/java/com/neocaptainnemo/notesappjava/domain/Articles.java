package com.neocaptainnemo.notesappjava.domain;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class Articles implements Parcelable {

    @StringRes
    private int name;

    @DrawableRes
    private int coat;

    public void Article(int name, int coat) {
        this.name = name;
        this.coat = coat;
    }

    protected Articles(Parcel in) {
        name = in.readInt();
        coat = in.readInt();
    }

    public static final Creator<Articles> CREATOR = new Creator<Articles>() {
        @Override
        public Articles createFromParcel(Parcel in) {
            return new Articles(in);
        }

        @Override
        public Articles[] newArray(int size) {
            return new Articles[size];
        }
    };

    public Articles(int name, int coat) {
        this.name = name;
        this.coat = coat;
    }

    public int getName() {
        return name;
    }

    public int getCoat() {
        return coat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(name);
        dest.writeInt(coat);
    }
}
