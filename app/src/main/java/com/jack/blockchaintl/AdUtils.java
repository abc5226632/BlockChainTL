package com.jack.blockchaintl;

import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import static com.jack.blockchaintl.Constant.ADMOD_ID;
import static com.jack.blockchaintl.Constant.TEST_Device;

/**
 * Created by Administrator on 2018/6/30.
 */

public class AdUtils {


    public static AdRequest loadAd(Context context){
        MobileAds.initialize(context,ADMOD_ID);
        AdRequest adRequest;
        if (BuildConfig.DEBUG){
            adRequest = new AdRequest.Builder().addTestDevice(TEST_Device).build();
        }else {
            adRequest = new AdRequest.Builder().build();
        }
        return adRequest;
    }
}
