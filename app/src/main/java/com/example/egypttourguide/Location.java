package com.example.egypttourguide;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
    private int mImageResourceId;
    private String mMainTitle;
    private String mSubTitle;
    private String mLocationDetails;

    public Location(int ImageResourceId, String MainTitle, String SubTitle, String LocationDetails) {
        mImageResourceId = ImageResourceId;
        mMainTitle = MainTitle;
        mSubTitle = SubTitle;
        mLocationDetails = LocationDetails;
    }

    protected Location(Parcel in) {
        mImageResourceId = in.readInt();
        mMainTitle = in.readString();
        mSubTitle = in.readString();
        mLocationDetails = in.readString();
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getMainTitle() {
        return mMainTitle;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public String getLocationDetails() {
        return mLocationDetails;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResourceId);
        dest.writeString(mMainTitle);
        dest.writeString(mSubTitle);
        dest.writeString(mLocationDetails);
    }

}
