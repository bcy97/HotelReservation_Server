package dataDao.picture;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PictureDao extends Remote {
	
	/**
	 * 获取酒店图片
	 * @param hotelID
	 * @return 酒店图片的二进制流
	 * @throws RemoteException
	 */
	public ArrayList<byte[]> getHotelImage(String hotelID) throws RemoteException;
	
	/**
	 * 保存酒店图片
	 * @param bs 酒店图片的二进制流
	 * @param hotelID
	 * @param pictureName
	 * @return 
	 * @throws RemoteException
	 */
	public boolean saveHotelImage(byte[] bs , String hotelID ,String pictureName) throws RemoteException;
	
	/**
	 * 获取用户头像
	 * @param userID
	 * @return
	 * @throws RemoteException
	 */
	public byte[] getUserImage(String userID) throws RemoteException;
	
	/**
	 * 保存用户头像
	 * @param bs
	 * @param userID
	 * @return
	 * @throws RemoteException
	 */
	public boolean saveUserImage(byte[] bs , String userID) throws RemoteException;
	

}
