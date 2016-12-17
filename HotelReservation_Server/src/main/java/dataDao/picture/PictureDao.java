package dataDao.picture;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PictureDao extends Remote {
	
	public ArrayList<byte[]> getHotelImage(String hotelID) throws RemoteException;
	
	public boolean saveHotelImage(byte[] bs , String hotelID ,String pictureName) throws RemoteException;
	
	public byte[] getUserImage(String userID) throws RemoteException;
	
	public boolean saveUserImage(byte[] bs , String userID) throws RemoteException;
	

}
