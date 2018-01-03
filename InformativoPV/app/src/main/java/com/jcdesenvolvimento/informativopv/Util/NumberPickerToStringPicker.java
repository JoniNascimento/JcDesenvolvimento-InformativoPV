package com.jcdesenvolvimento.informativopv.Util;

import android.widget.NumberPicker;

/**
 * Created by Desenvolvimento AZ on 03/01/2018.
 */

public class NumberPickerToStringPicker {

    public NumberPickerToStringPicker() {
    }

    public NumberPicker getStringPicker(NumberPicker numberPicker, String[] list){

        //set min value zero
        numberPicker.setMinValue(0);
        //set max value from length array string reduced 1
        numberPicker.setMaxValue(list.length - 1);
        //implement array string to number picker
        numberPicker.setDisplayedValues(list);
        //disable soft keyboard
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        //set wrap true or false, try it you will know the difference
        numberPicker.setWrapSelectorWheel(false);

        return numberPicker;
    }
}
