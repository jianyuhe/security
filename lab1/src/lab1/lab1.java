package lab1;

public class lab1 {
	
	static int l = 0;
	static String result = "";
	static String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String key = "KISWAHILI";
	static String data = " XQKP IZ IMWEB LK AUVZCXKW PHL VPE RIKD ASOZZSBZI TOIE ESTD\r\n" + 
			" XEJWXM CPS-3. PHPA TA DPW NEZCWB YN S OIE-GPIB KGIPLBTBSWF, WNK UJ\r\n" + 
			" WGV KGEPV TA YVW KF APP NSDW NETITVSVY BIUIWQCBK (KUA WQ IX \r\n" + 
			" QFETPIW 64). QD'A HNOIIMTI BGK LHBP NYZ EA TV IQNOKL PHL NTVKT\r\n" + 
			" VACPATWX, JMP I HU SWZQFC FVZ \"YW KESND.\" PB'D VYB LDAA BSM XMO\r\n" + 
			" DAZP QCXKLEOUA LZOV'L WNF OZWN, QL'O TOIE EO LGJ'T YMLTVG FAEK\r\n" + 
			" WYM. GPWJ WL AEIBBWZ TOQD XBWUASZ JLKU QF 2006, ET SWZSOL SO IM EP\r\n" + 
			" EYCDZ BL VPMNQFC A UMH PKAZ BUUKEQYV KKOU. BSM CPS BATQWG\r\n" + 
			" (GPAYH PA CMKTDU PHZE WP BZA MK4 IYL WL5 XWMPTJ), EKA MJDLZ\r\n" + 
			" TVMZWWSPVR XBMKOUYM QZYU FAW AGAMC WX YRFXEIXIDUSPA. HM\r\n" + 
			" NQVJ'T RVZE RWO HOUO EPO DSNIVCD ARI-2 NWRPIYBC EGQLK ZPUKQF\r\n" + 
			" OEJCCM. LCL ET'Z 2012, IYL CPS-512 ES ZBTTV TGKKPVR OYWV.\r\n" + 
			" AVLV HWBAW, JOUM ZN DPW OHH-3 KLVNQVWTLA TA CQYJIMQNIXBDU\r\n" + 
			" BLBEMB. AGIE HZP NKALAR, ICE VYB GNDLZD WP USCNPBFLO NSOTLZ.\r\n" + 
			" DWWM SNE ZULTVMJ EN OICLGIJA, BBB YWD WJZEYA ZN WIYJIACOM\r\n" + 
			" CUSHLLZ. HPOV KDA-3 PA LVXWMJCLL, T'U QWAJG AW CMMWEIEUL EPKB,\r\n" + 
			" MJLLAD BRM AIPYWGMWMFPS HZP KBQLECHT EW DPWER HXATSKSPIVV,\r\n" + 
			" AMYXDA SAQNS GQLD TOM EZSMV WNK BCCO AZW-512. AA TPICB XKR H\r\n" + 
			" ESQVM. A ZOU'B EPSVC JIZB TA QWAJG AW LVXWMJCL \"VZ IGIJZ\"; I APTVU\r\n" + 
			" QL'O GVQYO DW HECR WYM. KVV KF APP NSDW NETITVSVY, E DVV'E ZOIDHY\r\n" + 
			" OIGM K NSROYQEM. YN UKUYAP Q GIFP SRMTV DW OEN, ICE BRIL'O OBB ZN\r\n" + 
			" ZMJOOUIW XBQVA, NVB QWB AGIE VJUMMBARE YMLAYV. SJD DPTTO Q\r\n" + 
			" DEKL AZUO UGNE APLV YBZARZ, Q EPSVC WNF EZCVL TA ORIJ. EOTD, IAFJP\r\n" + 
			" BRMJA'S VVP ZOIKKN UQDB CPGQLK KSWYAW OKLQY. AUMAJ IZV'E REAL W\r\n" + 
			" HHAS NEVUPIVV, TB'C BZA LHZRM-LTGYK JQAPOZ LDRLMQQCP SJD H\r\n" + 
			" UPKRIFEST BZ BEZF ET PVEW K PSOH MCYKDQGJ. I APTVU BZA WVZWL\r\n" + 
			" KKLQASTJ VOMVO A SICOO-JDKCR KTXRMJ, WNK QQ VSAL YHVWDMC ACAIU,\r\n" + 
			" EP'TV OWP OUM.";
	
	static char[] datac= data.toCharArray();
	static String data1 = data.replaceAll("[^A-Z]", "");
	
	
	
	public static void main(String args[]){
	StringBuilder k=new StringBuilder(key);
    System.out.println("ciphertext: "+data1);
    
    
	String longKey = "";
    if(k.length()!=data1.length()){ 
        
        if(k.length()<data1.length()){
            
            while(k.length()<data.length()){
                k.append(key);
            }
        }
      
        longKey=k.substring(0, data1.length());
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<longKey.length();i++){
        	int row=alpha.indexOf(longKey.charAt(i));
            int col=alpha.indexOf(data1.charAt(i));
            int index;
            if(row>col){
                index=col+26-row;
            }else{
                index=col-row;
            }
            
            sb.append(alpha.charAt(index));
        }
        
        result = sb.toString();
        
    }
    System.out.println("plaintext: "+result);
    StringBuilder r=new StringBuilder(result);
    for(int i=0;i<datac.length;i++)
    {
    	if(alpha.indexOf(datac[i]) >= 0)
    	{
    		datac[i] = r.charAt(l);
    		l = l +1;
    	}
    	System.out.print(datac[i]);
    	
    }
    

    	
    }
   
 
    
}
	

