package com.val.code.rcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

public class J2SEImage implements QRCodeImage {
	BufferedImage image;

	public J2SEImage(BufferedImage image) {
		this.image = image;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return image.getHeight();
	}

	@Override
	public int getPixel(int x, int y) {
		// TODO Auto-generated method stub
		return image.getRGB(x, y);
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return image.getWidth();
	}

}
