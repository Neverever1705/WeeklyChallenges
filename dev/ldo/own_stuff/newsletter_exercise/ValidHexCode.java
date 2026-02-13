package dev.ldo.own_stuff.newsletter_exercise;//Create a function that determines whether a string is a valid hex code.

//A hex code must begin with a pound key # and is exactly 6 characters in length.

//Each character must be a digit from 0-9 or an alphabetic character from A-F. All alphabetic characters may be uppercase or lowercase.

public class ValidHexCode {


    public boolean isValidHexCode(String hexCode) {
        if (hexCode.charAt(0) != '#' || hexCode.trim().length() > 7)
            return false;
        for (int i = 1 ; i < hexCode.length(); i++) {
            switch (hexCode.toUpperCase().charAt(i)){
                case 'A','B','C','D','E','F','0','1','2','3','4','5','6','7','8','9' ->{

                }
                default -> {
                    return false;
                }
            }
        }
        return true;


    }
}
