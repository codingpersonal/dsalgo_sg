package snap_pretest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Snap1 {

class Request {
	public Integer startDate;
	public Integer endDate;

	public Request(int sd, int ed) {
		this.startDate = sd;
		this.endDate = ed;
	}
}

//class Main {
//
//	private Map<String, Integer> dp = new HashMap<String, Integer>();  // the key would be the startDate::endDate
//
//	public Integer findBestRequests(List<Request> inReq) {
//		if (inReq == null || inReq.isEmpty()) {
//			return 0;
//		}
//
//		int startDate = inReq.get(0).startDate;
//		
//		int ed = -1;
//		for (Request req: inReq) {
//			ed = Math.max(ed, req.endDate);
//		}
//
//		return this.findBestRequestsHelper(inReq, startDate, ed);
//
//	}
//
//	//this function would find the maximun days among the requests between startDate and endDate (both inclusive)
//	private Integer findBestRequestsHelper(List<Request> inReq, Integer startDate, Integer endDate) {
//
//		if (startDate > endDate)  {
//			return 0;
//		}
//
//
//		String mapIdentifier = String.valueOf(startDate) + "::" + String.valueOf(endDate);
//		if (this.dp.containsKey(mapIdentifier)) {
//			return dp.get(mapIdentifier);
//		}    
//
//		int maxDays = 0;
//
//		for (Request req: inReq) {
//
//			// consider each request one by one
//			if (req.startDate < startDate || req.endDate > endDate) {
//				// ignore this request
//				continue;
//			}
//
//			int tempMax = (req.endDate - req.startDate + 1) + this.findBestRequestsHelper(inReq, startDate, req.startDate - 1) + this.findBestRequestsHelper(inReq, req.endDate + 1, endDate);
//			System.out.println("tempMax is : " +  tempMax + " for start date: " + req.startDate);
//			maxDays = Math.max(tempMax, maxDays);
//		}
//
//		dp.put(mapIdentifier, maxDays);
//		return maxDays;
//	}
//
//	public static void main(String [] args) {
//
//		List<Request> input = new ArrayList();
//		input.add(new Request(5, 9));
//		input.add(new Request(8, 15));
//		input.add(new Request(12, 13));
//		
//		Main obj = new Main();
//
//		int maxDays = obj.findBestRequests(input);
//		System.out.println("the max days are: " + maxDays);
//	}

//}



}
