package dataDao.picture;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PictureDao extends Remote {
	
	public byte[] getImageStr(String hotelID,String pictureName) throws RemoteException;
	
	public boolean saveImage(byte[] bs , String hotelID ,String pictureName) throws RemoteException;

}
