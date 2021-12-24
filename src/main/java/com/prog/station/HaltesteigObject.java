package com.prog.station;

import java.util.Arrays;

public class HaltesteigObject extends ObjectTemplate{
    public HaltesteigObject(String[] valueString) {
        String[] newValueString = Arrays.copyOf(valueString, 36);
        setSameVariables(newValueString);
        setSameVariablesWithOffset(newValueString,1);
        setVariables(newValueString);
        System.out.println(this + "angelegt");
    }

    private void setVariables(String[] valueString){
        //System.out.println("unique variables set...");
    }
}
