package lab1;

public class vigenere {
	

	    /**��д��ĸ��**/
	    static String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    /**
	     * ������Կ
	     * @param str �ַ���
	     * @param K ��Կ
	     * @return ��str������ȵ���Կ�ַ���
	     */
	    public static String dealK(String str,String K){   
	        K=K.toUpperCase();// ����Կת���ɴ�д
	        K=K.replaceAll("[^A-Z]", "");//ȥ�����з���ĸ���ַ�  
	        StringBuilder sb=new StringBuilder(K);
	        String key="";
	        if(sb.length()!=str.length()){ 
	            //�����Կ������str��ͬ������Ҫ������Կ�ַ���
	            if(sb.length()<str.length()){
	                //�����Կ���ȱ�str�̣����Բ����ظ���Կ�ķ�ʽ������Կ�ַ���
	                while(sb.length()<str.length()){
	                    sb.append(K);
	                }
	            }
	            //��ʱ����Կ�ַ����ĳ��ȴ��ڻ����str����
	            //����Կ�ַ�����ȡΪ��str�ȳ����ַ���
	            key=sb.substring(0, str.length());
	        }
	        return key;
	    }

	    /**
	     * ����vigenere�����㷨�����Ľ��м���
	     * @param P ����
	     * @param K ��Կ
	     * @return ����
	     */
	    public static String encrypt(String P,String K){
	        P=P.toUpperCase();// ������ת���ɴ�д
	        P=P.replaceAll("[^A-Z]", "");//ȥ�����з���ĸ���ַ�   
	        K=dealK(P,K);
	        int len=K.length();
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<len;i++){
	            int row=alpha.indexOf(K.charAt(i));//�к�
	            int col=alpha.indexOf(P.charAt(i));//�к�
	            int index=(row+col)%26;
	            sb.append(alpha.charAt(index));
	        }
	        return sb.toString();       
	    }

	    /**
	     * ����vigenere�����㷨�����Ľ��н���
	     * @param C ����
	     * @param K ��Կ
	     * @return ����
	     */
	    public static String decrypt(String C,String K){
	        C=C.toUpperCase();// ������ת���ɴ�д
	        C=C.replaceAll("[^A-Z]", "");//ȥ�����з���ĸ���ַ�   
	        K=dealK(C,K);
	        int len=K.length();
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<len;i++){
	            int row=alpha.indexOf(K.charAt(i));//�к�
	            int col=alpha.indexOf(C.charAt(i));//�к�
	            int index;
	            if(row>col){
	                index=col+26-row;
	            }else{
	                index=col-row;
	            }
	            sb.append(alpha.charAt(index));
	        }
	        return sb.toString();     
	    }

	    public static void main(String args[]){
	       // String P="explanation";
	        String K="KISWAHILI";
	       // String C=encrypt(P,K);
	        String data = "XQKP IZ IMWEB LK AUVZCXKW PHL VPE RIKD ASOZZSBZI TOIE ESTD\r\n" + 
	        		"XEJWXM CPS-3. PHPA TA DPW NEZCWB YN S OIE-GPIB KGIPLBTBSWF, WNK UJ\r\n" + 
	        		"WGV KGEPV TA YVW KF APP NSDW NETITVSVY BIUIWQCBK (KUA WQ IX \r\n" + 
	        		"QFETPIW 64). QD'A HNOIIMTI BGK LHBP NYZ EA TV IQNOKL PHL NTVKT\r\n" + 
	        		"VACPATWX, JMP I HU SWZQFC FVZ \"YW KESND.\" PB'D VYB LDAA BSM XMO\r\n" + 
	        		"DAZP QCXKLEOUA LZOV'L WNF OZWN, QL'O TOIE EO LGJ'T YMLTVG FAEK\r\n" + 
	        		"WYM. GPWJ WL AEIBBWZ TOQD XBWUASZ JLKU QF 2006, ET SWZSOL SO IM EP\r\n" + 
	        		"EYCDZ BL VPMNQFC A UMH PKAZ BUUKEQYV KKOU. BSM CPS BATQWG\r\n" + 
	        		"(GPAYH PA CMKTDU PHZE WP BZA MK4 IYL WL5 XWMPTJ), EKA MJDLZ\r\n" + 
	        		"TVMZWWSPVR XBMKOUYM QZYU FAW AGAMC WX YRFXEIXIDUSPA. HM\r\n" + 
	        		"NQVJ'T RVZE RWO HOUO EPO DSNIVCD ARI-2 NWRPIYBC EGQLK ZPUKQF\r\n" + 
	        		"OEJCCM. LCL ET'Z 2012, IYL CPS-512 ES ZBTTV TGKKPVR OYWV.\r\n" + 
	        		"AVLV HWBAW, JOUM ZN DPW OHH-3 KLVNQVWTLA TA CQYJIMQNIXBDU\r\n" + 
	        		"BLBEMB. AGIE HZP NKALAR, ICE VYB GNDLZD WP USCNPBFLO NSOTLZ.\r\n" + 
	        		"DWWM SNE ZULTVMJ EN OICLGIJA, BBB YWD WJZEYA ZN WIYJIACOM\r\n" + 
	        		"CUSHLLZ. HPOV KDA-3 PA LVXWMJCLL, T'U QWAJG AW CMMWEIEUL EPKB,\r\n" + 
	        		"MJLLAD BRM AIPYWGMWMFPS HZP KBQLECHT EW DPWER HXATSKSPIVV,\r\n" + 
	        		"AMYXDA SAQNS GQLD TOM EZSMV WNK BCCO AZW-512. AA TPICB XKR H\r\n" + 
	        		"ESQVM. A ZOU'B EPSVC JIZB TA QWAJG AW LVXWMJCL \"VZ IGIJZ\"; I APTVU\r\n" + 
	        		"QL'O GVQYO DW HECR WYM. KVV KF APP NSDW NETITVSVY, E DVV'E ZOIDHY\r\n" + 
	        		"OIGM K NSROYQEM. YN UKUYAP Q GIFP SRMTV DW OEN, ICE BRIL'O OBB ZN\r\n" + 
	        		"ZMJOOUIW XBQVA, NVB QWB AGIE VJUMMBARE YMLAYV. SJD DPTTO Q\r\n" + 
	        		"DEKL AZUO UGNE APLV YBZARZ, Q EPSVC WNF EZCVL TA ORIJ. EOTD, IAFJP\r\n" + 
	        		"BRMJA'S VVP ZOIKKN UQDB CPGQLK KSWYAW OKLQY. AUMAJ IZV'E REAL W\r\n" + 
	        		"HHAS NEVUPIVV, TB'C BZA LHZRM-LTGYK JQAPOZ LDRLMQQCP SJD H\r\n" + 
	        		"UPKRIFEST BZ BEZF ET PVEW K PSOH MCYKDQGJ. I APTVU BZA WVZWL\r\n" + 
	        		"KKLQASTJ VOMVO A SICOO-JDKCR KTXRMJ, WNK QQ VSAL YHVWDMC ACAIU,\r\n" + 
	        		"EP'TV OWP OUM.";
	       // System.out.println("���ģ�"+C);
	        System.out.println("���ģ�"+decrypt(data,K));
	    }
}


