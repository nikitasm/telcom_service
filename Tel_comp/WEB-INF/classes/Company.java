import java.io.IOException;//kanoume import tis aparaithtes vivlio8hkes
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Company extends HttpServlet { // dimiourgoume tin klasi mas
	
	
	public double findDebt(double min2,double min ){//h findept kaleitai ka8e fora gia na upologizetai h nea xrewsh
		double debt;								//ta orismata min2 kai min einai ta lepta mexri ekeinh thn stigmh pou kaleitai h sunarthsh kai ta kainouria lepta pros xrewsh
		if(min2+min<=15){//an to sunolo einai mikrotro twn 15 leptwn tote h xrewsh einai mono to pagio
			
			debt=10;
		}
		else{//se anti8eti periptwsh upologizetai h xrewsh opws anaferetai sthn ekfwnhsh
				debt=(min2+min-15)*0.12+10;
			
			}
		
		
		return debt;// epistrefoume thn timh ths xrewshs
	}
	

		
	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	
	{// h doGet apotelei thn me8odo mesa sthn opoia trexei to servlet
		
		response.setContentType("text/html");
		String mobnumb =  request.getParameter("mobnumb");// sto mobnumb pername to kinito tou xrhsth gia ton opoio 8eloume na ginei h anazhthsh
		PrintWriter out = response.getWriter();	//orizoume to out gia na mporoume na pros8etoume html sthn sunexeia
		String col="Background-Picture-Html2";//orizoume background color gia thn selida pou 8a dhmiourgeitai
		String url="/Tel_comp/Orange_0.jpg";//orizoume url ths eikonas pou 8eloume na emfanizetai sthn seloda mas
        String namepic="telephone-gsm-mobile-phone-logo";// onoma eikonas
        
        
        out.println("<html>");// diamorfwnoume thn selida mas"eikona,epikefalida,background color"me vash ta parapanw stoixeia pou orisame
        out.println ("<img src="+url+" alt="+namepic+">");
        out.println("<br>");
        out.println("<h1>These is your account information!</h1>");
        out.println ("<br/><br><br>");
        out.println("<body bgcolor=" +col+">");
		out.println(" You chose the user with number"+ mobnumb);
		out.println("<br><br>");
		  
		
		  Connection con = null;  //sto shmeio auto 3ekinaei o kwdikas gia na ginei h sundesh me thn vash dedomenwn
		  Statement stmt = null;
		  
		  ResultSet rs = null;
		 
		  try {
		  Class.forName("com.mysql.jdbc.Driver");// url tou driver 
		  con =DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");//"url ths vashs","onoma xrhsth sto workbench sthn prokeimenh periptwsh","kwdikos tou workbench"
		  //sto shmeio auto exei ginei sundesh k 8a kanoume query erwthma sthn vash gia na organwsoume ta stoixeia pou 8eloume wste na kanoume tous upologismous mas 
		  stmt = con.createStatement();
		  // kanoume inner join twn pinakwn gia tis pleiades ekeines pou exoun idio to tel_number kai tautoxrona auto na tautizetai me auto pou exei dwsei o xrhsths
		  rs = stmt.executeQuery("SELECT user.name,user.surname,calls.date,calls.start_time,calls.end_time FROM user INNER JOIN calls ON user.tel_number=calls.tel_number AND user.tel_number="+mobnumb+";");

		  
		  
		  double[] xrewshmhn;//orizoume 3 pinakes stous opoious 8a periexoume xrewseis,lepta kai ari8mo klhsewn ana mhna
		  double[] leptamhn;//etsi wste na emfanisoume ta telika apotelesmata
		  int[] klhseismhn;
	        
	      xrewshmhn = new double[12];
	      leptamhn = new double[12];
	      klhseismhn = new int [12];
	      for(int i=0;i<12;i++){//mhdenizoume ola ta stoixeia twn pinakwn mas
	    	  xrewshmhn[i]=0;
	    	  leptamhn[i]=0;
	    	  klhseismhn[i]=0;
	    	  
	      }
		  
	      int km=0;//orizoume metrhth klhsewn
		  
	      while(rs.next()){//oso uparxoun stoixeia sthn 8ewrhsh pou exoume dhmiourghsei me to query trexei h while
			  km=km+1;//pros8etoume mia klhsh
			  
		 String onoma=rs.getObject(1).toString();// kratame to onoma
		 
		  String epitheto=rs.getObject(2).toString();// kratame to epitheto
		  if(km==1){// an einai h prwth epanalhyh emfanuzoume mhnuma gia na enhmerwsoume gia poion xrhsth ginetai anazhthsh
			out.println("The customer with the number: "+mobnumb+ " is "+onoma+" "+epitheto); 
			out.println("<br>");
			out.println("<br>");
		  }
		  String date=rs.getObject(3).toString();//kratame hmeromhnia
		  
		  
		 
		  String e=rs.getObject(4).toString();//kratame wra enar3hs klhshs
		 
		  String f=rs.getObject(5).toString();//kratame wra telous klhshs
		  
	//		  String mhnas=date.substring(3, 5);
		  String[] hmnia = date.split("-");
		  String mhnas = hmnia[1];
		  int mhnasint=Integer.parseInt(mhnas);
		  
		  String wra = e.substring(0, 2);  //xwrizoume se 3 string wra-lepta-deuterolepta gia thn wra enar3hs klhshs
		  String lepta = e.substring(3, 5);
		  String deutera = e.substring(6, 8);
		  
		  
		  String wratel = f.substring(0,2);//xwrizoume se 3 string wra-lepta-deuterolepta gia thn wra telous klhshs
		  String leptatel = f.substring(3, 5);
		  String deuteratel=f.substring(6, 8);
			
			int n=Integer.parseInt(wra);//metatrepoume ta parapanw string se int
			int k=Integer.parseInt(lepta);
			int r=Integer.parseInt(deutera);
			int ntel=Integer.parseInt(wratel);
			int ktel=Integer.parseInt(leptatel);
			int rtel=Integer.parseInt(deuteratel);
			
			n=n*3600;//kratame sunolo deuteroleptwn enar3hs
			k=k*60;
			int sunolodeuteroleptaarx=n+k+r;
			
			ntel=ntel*3600;//kratame sunolo deuteroleptwn lh3hs
			ktel=ktel*60;
			int sunolodeuteroleptatel=ntel+ktel+rtel;
			
			
			  
			int sunolodeuterolepta=sunolodeuteroleptatel-sunolodeuteroleptaarx;//vriskoume thn diafora tous pou einai telika o xronos klhshs
			
			  
			if (sunolodeuterolepta<60){//an h klhsh einai ligotero tous enos leptou tote thn 8etoume 1 lepto
				sunolodeuterolepta=60;}
					
				
			double xrewsimalepta=sunolodeuterolepta/60;	//metatrepoume to sunolo apo deuterolepta se lepta
			
			
			  for(int i=0;i<12;i++){//gia ka8e mhna
				if (i+1==mhnasint){//an o mhnas tautizetai me to antistoixo keli twn pinakwn
					
					double debt=findDebt(xrewsimalepta,leptamhn[i]);// kaloume thn sunarthsh debt gia ton upologismo ths xrewshs
					xrewshmhn[i]=debt;// kataxwroume sta antistoixa kelia tou pinaka tis antistoixes times
					leptamhn[i]=leptamhn[i]+xrewsimalepta;
					klhseismhn[i]=klhseismhn[i]+1;
				}
			
			}
			
			}
		  
		  double sunololeptwn=0;
		  for(int i=1;i<=12;i++){
			  sunololeptwn=sunololeptwn+leptamhn[i-1];//upologizoume to sunolo leptwn olwn twn klhsewn tou xrhsth 
		  }
		  
		  for(int i=1;i<=12;i++){
		  double momhn=leptamhn[i-1]/klhseismhn[i-1];//MO MHNIAIOS upologisthke diairwntas lepta tou ka8e mhna me ari8mo klhsewn tou ka8e  mhna
		  //emfanizoume analogo mhnuma gia ta apotelesmata
		  out.println("The debt for the month: "+i+" is: "+xrewshmhn[i-1]+" and the time average of this month is: "+momhn+" minutes.");
		  out.println("<br>");
		  out.println("<br>");
		  }
		  double mosun=sunololeptwn/km;//MO GENIKOS upologisthke diairwntas sunololeptwn olwn twn klhsewn me metrhth klhsewn
		  out.println("The average of the call time for all of the months is: "+mosun+"minutes.");
		  out.println("<br>");
		  out.println("<br>");
		  
		  
		  } catch (SQLException e) {//xeirismos exceptions
			  System.out.println(e.getMessage());
			  throw new ServletException("Servlet Could not display records.", e);
		 
		  } catch (ClassNotFoundException e) {
			  System.out.println("class not found EXCEPTION E");
		  throw new ServletException("JDBC Driver not found.", e);
		  
		  }
		  out.println("</body></html>");//kleinoume to body ths selidas k thn selida
          out.close();
		} 
	}
	
	
