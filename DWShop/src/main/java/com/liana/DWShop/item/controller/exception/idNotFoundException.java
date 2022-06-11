package com.liana.DWShop.item.controller.exception;

public class idNotFoundException extends RuntimeException{
    public idNotFoundException()
    {
        super("Id Not Found");
    }
}
