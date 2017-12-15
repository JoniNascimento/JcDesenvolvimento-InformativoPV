package com.jcdesenvolvimento.informativopv.Util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by joni on 10/12/2017.
 */

public class SecurityPrefereces {

    private final SharedPreferences mSharedPreference;


    public SecurityPrefereces(Context ctx) {

        this.mSharedPreference = ctx.getSharedPreferences("Boletin", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value){
        this.mSharedPreference.edit().putString(key,value); //Método para gravar no arquivo

    }

    public String getStoredString(String key){
      return  this.mSharedPreference.getString(key,"");
    }
}
