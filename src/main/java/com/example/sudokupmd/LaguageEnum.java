package com.example.myapplication;

public enum LaguageEnum
    {
        ENUM1("English"),
        ENUM2("Español");

        private String friendlyName;

        private LaguageEnum(String friendlyName){
            this.friendlyName = friendlyName;
        }

        @Override public String toString(){
            return friendlyName;
        }
    }

