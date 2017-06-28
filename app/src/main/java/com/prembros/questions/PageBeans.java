package com.prembros.questions;

import android.os.Parcel;
import android.os.Parcelable;

/*
 * Created by Prem $ on 4/13/2017.
 */

class PageBeans implements Parcelable {

    private int logoSrc;
    private String name = "";
    private String currentValue;
    private String withdrawalAmount;

    PageBeans(){
        //Empty constructor
    }

    private PageBeans(Parcel parcel){
        logoSrc = parcel.readInt();
        name = parcel.readString();
        currentValue = parcel.readString();
        withdrawalAmount = parcel.readString();
    }

    void setLogoSrc(int logoSrc){
        this.logoSrc = logoSrc;
    }

    void setName(String name){
        this.name = name;
    }

    void setCurrentValue(float currentValue){
        this.currentValue = "\u20B9 " + currentValue;
    }

    void setWithdrawalAmount(float withdrawalAmount){
        this.withdrawalAmount =  "\u20B9 " + withdrawalAmount;
    }

    int getLogoSrc(){
        return logoSrc;
    }

    String getName(){
        return name;
    }

    String getCurrentValue(){
        return currentValue;
    }

    String getWithdrawalAmount(){
        return withdrawalAmount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(logoSrc);
        parcel.writeString(name);
        parcel.writeString(currentValue);
        parcel.writeString(withdrawalAmount);
    }

    public static final Creator<PageBeans> CREATOR = new Creator<PageBeans>() {
        @Override
        public PageBeans createFromParcel(Parcel parcel) {
            return new PageBeans(parcel);
        }

        @Override
        public PageBeans[] newArray(int size) {
            return new PageBeans[size];
        }
    };
}
