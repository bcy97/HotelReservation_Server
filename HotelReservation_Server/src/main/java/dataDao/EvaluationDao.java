package dataDao;

import java.rmi.Remote;
import java.util.ArrayList;

import po.EvaluationPO;

public interface EvaluationDao extends Remote{
	public boolean addEvalution(EvaluationPO po);
	
	public boolean deleteEvaluation(EvaluationPO po);
	
	public EvaluationPO getEvaluationByOrderID(String order_id);
	
	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID);
}
