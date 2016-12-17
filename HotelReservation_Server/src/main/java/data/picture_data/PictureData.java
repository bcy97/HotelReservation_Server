package data.picture_data;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataDao.picture.PictureDao;

public class PictureData implements PictureDao{
	
	public static void main(String[] args) {
		PictureData pictureData = new PictureData();
		pictureData.getHotelImage("00001");
	}

	public ArrayList<byte[]> getHotelImage(String hotelID) { 
        String imgFile = "d:\\PictureDatabase\\"+hotelID; 
        File file =new File("d:\\PictureDatabase\\"+hotelID);
        ArrayList<byte[]> datas = new ArrayList<byte[]>();
        //如果文件夹不存在则创建    
        if  (!file .exists()  && !file .isDirectory()){       
        	System.out.println("//不存在");  
        	file .mkdir();    
        }  
        File[] files = file.listFiles();
        for (File file2 : files) {
			if (file2.isFile()) {
				String temp = imgFile+"\\"+file2.getName();
				InputStream in = null;  
				byte[] data = null;
				try {  
					in = new FileInputStream(temp);  
					data = new byte[in.available()];  
					in.read(data);
					in.close();
					datas.add(data);
				} catch (IOException e) {  
					e.printStackTrace();  
				}
			}
		}
        return datas;
    }

	public boolean saveHotelImage(byte[] bs, String hotelID ,String pictureName){
		if (bs==null) {
			return false;
		}
		for (int i = 0; i < bs.length; i++) {
			if (bs[i]<0) {
				bs[i]+=256;
			}
		}
		String imgFilePath = "d:\\PictureDatabase\\"+hotelID;
		File file =new File("d:\\PictureDatabase\\"+hotelID);    
        //如果文件夹不存在则创建    
        if  (!file .exists()  && !file .isDirectory()){       
        	file .mkdir();    
        } 
		OutputStream out;
		try {
			out = new FileOutputStream(imgFilePath+"\\"+pictureName+".jpg");
			out.write(bs);
			out.flush();
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public byte[] getUserImage(String userID) throws RemoteException {
		String imgFile = "d:\\PictureDatabase\\userhead\\"+userID+".jpg"; 
        InputStream in = null;  
        byte[] data = null;
        try {  
            in = new FileInputStream(imgFile);  
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return data;
	}

	public boolean saveUserImage(byte[] bs, String userID) throws RemoteException {
		if (bs==null) {
			return false;
		}
		for (int i = 0; i < bs.length; i++) {
			if (bs[i]<0) {
				bs[i]+=256;
			}
		}
		String imgFilePath = "d:\\PictureDatabase\\userhead\\"+userID+".jpg";
		OutputStream out;
		try {
			out = new FileOutputStream(imgFilePath);
			out.write(bs);
			out.flush();
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;	}

}
