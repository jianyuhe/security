package lab1;

import java.util.HashMap;
import java.util.Map;

public class searchletters {
	public static String newS = null;
	public static int key ;
	public static void main(String[] args) {
		String s= "FEV MRIZRKZFE KF KYV JKREURIU TRVJRI TZGYVI ZJ NYVE KYV RCGYRSVK\r\n" + 
				"ZJ \"BVPVU\" SP LJZEX R NFIU. ZE KYV KIRUZKZFERC MRIZVKP, FEV TFLCU\r\n" + 
				"NIZKV KYV RCGYRSVK FE KNF JKIZGJ REU ALJK DRKTY LG KYV JKIZGJ\r\n" + 
				"RWKVI JCZUZEX KYV SFKKFD JKIZG KF KYV CVWK FI IZXYK. KF VETFUV, PFL\r\n" + 
				"NFLCU WZEU R CVKKVI ZE KYV KFG IFN REU JLSJKZKLKV ZK WFI KYV\r\n" + 
				"CVKKVI ZE KYV SFKKFD IFN. WFI R BVPVU MVIJZFE, FEV NFLCU EFK LJV R\r\n" + 
				"JKREURIU RCGYRSVK, SLK NFLCU WZIJK NIZKV R NFIU (FDZKKZEX\r\n" + 
				"ULGCZTRKVU CVKKVIJ) REU KYVE NIZKV KYV IVDRZEZEX CVKKVIJ FW KYV\r\n" + 
				"RCGYRSVK. WFI KYV VORDGCV SVCFN, Z LJVU R BVP FW \"ILDBZE.TFD\" REU\r\n" + 
				"PFL NZCC JVV KYRK KYV GVIZFU ZJ IVDFMVU SVTRLJV ZK ZJ EFK R CVKKVI.\r\n" + 
				"PFL NZCC RCJF EFKZTV KYV JVTFEU \"D\" ZJ EFK ZETCLUVU SVTRLJV KYVIV\r\n" + 
				"NRJ RE D RCIVRUP REU PFL TRE'K YRMV ULGCZTRKVJ";
		String L = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		HashMap<String, Integer> counter = new HashMap();
		for(char a : L.toCharArray())
			{String letter = a + "";
			counter.put(letter, 0);
			}
		for(char c : s.toCharArray()){
			String str = c+"";
			
	
			 if(!counter.containsKey(str))
			{
				counter.put(str, 1);
			}
				else{
				counter.put(str, counter.get(str)+1);
			}
		}
		System.out.println(counter);
	
		
		
		for(key = 0; key< 26; key++)
		{
			System.out.println("\n Key is: "+ key);
		for(int i =0; i<s.length(); i++) {
			for(int y = 0; y<L.length(); y++)
				
		if(s.charAt(i) == L.charAt(y))
		{
			
			if(y>key || y ==key)
			{
			
				char n = L.charAt(y-key);
				  newS = new StringBuilder().append(n).toString();
				//System.out.print(n);
			}
			else
			{
				char n = L.charAt(26 + y-key);
				  newS = new StringBuilder().append(n).toString();
				//System.out.print(n);
			}
			
		}
		else if(s.charAt(i) == ' ')
		{
			char n = ' ';
			 newS = new StringBuilder().append(n).toString();
		}
			System.out.print(newS);
		}
		
		
		}
	}
	

}
