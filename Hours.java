
public class Hours { //nested class of hours of each day 
		public int openTime;
		public int closeTime;
		
		public Hours(String t) { //nested Class constructor 
			
			//String[] times = s.split("\\s+") // 1 line -> first split it by the space 
				//System.out.println("t equals " + t);
				String[] b = t.split("\\-"); // 11:00-12:00 -> 
				if(b.length==1) { //defsult case when there is no time in data for that specific day
					openTime= -1;
					closeTime = -1;
				}
				else{
				String[] opTime = b[0].split("\\:"); //splitting "11:00"
				//System.out.println(opTime[0]);
				String[] clTime = b[1].split("\\:"); //split "12:00"
				
				String h = String.join("",opTime);
				String m = String.join("",clTime);
				openTime = Integer.parseInt(h);
				closeTime = Integer.parseInt(m);
				}
				
			}
		public int getOpenTime() {
			return openTime;
		}
		
		public int getCloseTime() {
			return closeTime;
		}
			
				
		}