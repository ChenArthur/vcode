package com.val.code.cacheCode;

import java.io.IOException;
import java.util.Date;

public class ValidateCodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateCode vCode = new ValidateCode(120,40,5,100);  
        try {  
            String path="F:/"+new Date().getTime()+".png";
            System.out.println(vCode.getCode()+" >"+path);
            System.out.println(new Date().getTime());
            vCode.write(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
