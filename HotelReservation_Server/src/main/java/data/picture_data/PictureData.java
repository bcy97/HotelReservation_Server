package data.picture_data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import dataDao.picture.PictureDao;

public class PictureData implements PictureDao{

	public byte[] getImageStr(String hotelID,String pictureName) { 
        String imgFile = "d:\\PictureDatabase\\"+hotelID+"\\"+pictureName+".jpg"; 
        File file =new File("d:\\PictureDatabase\\"+hotelID);    
        //如果文件夹不存在则创建    
        if  (!file .exists()  && !file .isDirectory()){       
        	System.out.println("//不存在");  
        	file .mkdir();    
        }  
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

	public boolean saveImage(byte[] bs, String hotelID ,String pictureName){
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
}
