package com.jcdesenvolvimento.informativopv.Util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by joni on 19/12/2017.
 */

public class Functions {


    public Functions() {

    }

    //converte bitmap para byte
    public byte[] bitmapToByte(Bitmap bmp){
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG,100,saida);
        byte[] img = saida.toByteArray();

        return  img;
    }

    //converte byte para bitmap
    public Bitmap byteToBitmap(byte[] imgBytes){
        if (imgBytes != null) {
            return BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length);
        }
        else{
            return null;
        }
    }
}
