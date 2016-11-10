package com.welcomecure.gridviewedittext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajeshG on 09-11-2016.
 */
public class Constants {

    private static Constants constants;
    private List<String> editTextValues = new ArrayList<>();

    public static Constants getInstance(){

        if(constants == null){
            constants = new Constants();
        }
        return constants;
    }

    public List<String> getEditTextValues() {
        return editTextValues;
    }

    public void setEditTextValues(List<String> editTextValues) {
        this.editTextValues = editTextValues;
    }
}
