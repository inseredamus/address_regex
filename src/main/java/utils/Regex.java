package utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static AddressObject getAddressFormated(String text) throws UnsupportedEncodingException {
        text = new String(text.getBytes("ISO-8859-1"), "UTF-8");
        String regex,replacementText1,replacementText2,part1,part2;
        // For the cases where address contains No
        if(text.contains("No")){
            part1 = text.split("No")[0];
            part2 = text.split("No")[1];
        }else{
            try {
                // For the cases where address begins with a digit
                if(text.substring(0,1).matches("[0-9]")){
                    regex = "([0-9]{1,4})[ ,]{1,3}([\\D]{3,})";
                    replacementText1 = "$2";
                    replacementText2 = "$1";
                }else{ // For the cases where address begins with a letter
                    regex = "([^0-9,]{3,})[, ]{1,3}([0-9]{1,4}[ ]?[a-zA-Z]?)";
                    replacementText1 = "$1";
                    replacementText2 = "$2";
                }
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(text);
                String temp1 = m.replaceAll(replacementText1);
                String temp2 = m.replaceAll(replacementText2);
                return new AddressObject(temp1.trim(),temp2.trim());
            }catch (Exception e){
                return null;
            }
        }
        return new AddressObject(part1.trim(),"No "+part2.trim());
    }
}

