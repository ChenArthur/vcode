package com.val.code.rcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

import com.swetake.util.Qrcode;

public class Rcode {
	
	public static void main(String[] args) throws Exception {
//		QRcodeEncoderTest();
		QRCodeDecoderTest();
	}
	
	/**
	 * 生成二維碼
	 * @throws Exception
	 */
	public static void QRcodeEncoderTest() throws Exception{
		Qrcode code = new Qrcode();
		code.setQrcodeErrorCorrect('M');
		code.setQrcodeEncodeMode('B');
		code.setQrcodeVersion(7);
		
		String testString = "生成二维码";
		byte[] b = testString.getBytes("UTF-8");
		
		BufferedImage bi = new BufferedImage(139, 139, BufferedImage.TYPE_INT_RGB);
		Graphics2D gh = bi.createGraphics();
		gh.setBackground(Color.WHITE);
		gh.clearRect(0, 0, 139, 139);
		
		gh.setColor(Color.BLACK);
		if(b.length > 0 && b.length < 123){
			boolean[][] bn = code.calQrcode(b);
			for (int i = 0; i < bn.length; i++) {
				for (int j = 0; j < bn.length; j++) {
					if(bn[j][i]){
						gh.fillRect(j*3+2, i*3+2, 3, 3);
					}
				}
			}
		}
		
		gh.dispose();
		bi.flush();
		
		String FilePath = "TestQEcode.png";
		File f = new File(FilePath);
		
		ImageIO.write(bi, "png", f);
		System.out.println("doned!");
	}
	
	/**
	 * 读取、解析二维码
	 */
	public static void QRCodeDecoderTest(){
		QRCodeDecoder decoder = new QRCodeDecoder();
		File imageFile = new File("TestQEcode.png");
		BufferedImage image = null;
		try {
			image = ImageIO.read(imageFile);
			String decodedData = new String(decoder.decode(new J2SEImage(image)),"UTF-8");
			System.out.println("decodedData:"+decodedData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
