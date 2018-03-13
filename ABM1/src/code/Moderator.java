package code;

import java.awt.*;
import sim.portrayal.*;
import sim.util.*;
import sim.engine.*;

public class Moderator implements Steppable
{
    private static final long serialVersionUID = 1;
    public int minV;
    public int timer=2;
    public int count; 
    int [][]pr;
    int [][]sr;
    static int counter=0;
    static int z_count=0;
    int avg=0;
    int x=0;
    //int z_count=0;
    
    PAgent []parr;
    SAgent []sarr;
    
    public Moderator(int nsk,int prk){		
    		parr=new PAgent[prk];
    		sarr=new SAgent[nsk];
    		pr=new int[2][prk];
            sr=new int[2][nsk];
     }
    public void setpr(int k,int pr11,PAgent pp,int counn){
    	parr[k]=pp;
    	parr[k].mybid=pr11;
    	pr[0][k]=pr11;
    	pr[1][k]=1;
    }
    public void setsr(int k,int sr11,SAgent ss,int counn){
    	sarr[k]=ss;
    	sarr[k].mybid=sr11;
    	sr[0][k]=sr11;
    	sr[1][k]=1;
    }
    public int giveavg(){
    	return avg;
    }
    
    public void Psorting(PAgent parr[],int m,int n){
    	for(int i=0;i<3;i++){
			for(int j=0;j<2-i;j++){
				if(parr[j+1].mybid<parr[j].mybid){
					PAgent t=parr[j+1];
					parr[j+1]=parr[j];
					parr[j]=t;
				}
			}
		}
    	parr[0].cur_pos=0;
    	parr[1].cur_pos=1;
    	parr[2].cur_pos=2;
    	
    }
    
    public void Ssorting(SAgent sarr[],int m){
    	for(int i=m;i<3;i++){
			for(int j=m;j<2-i+m;j++){
				if(sarr[j+1].mybid>sarr[j].mybid){
					SAgent t=sarr[j+1];
					sarr[j+1]=sarr[j];
					sarr[j]=t;
				}
			}
		}
    	sarr[0].cur_pos=0;
    	sarr[1].cur_pos=1;
    	sarr[2].cur_pos=2;
    	
    }
    public void step( final SimState state )
    {  
    	int count=0;
    	int scount=0;
    	
    	int pcount=0;
    	
    	
        if(timer%2==1){
            Environment environment = (Environment)state;
            if(timer<10){
            	counter++;
            	System.out.println("=====================================");
            	System.out.println("Parr[0]: "+parr[0].mybid+" , "+parr[0].indicator+" Parr[1]: "+parr[1].mybid+" , "+parr[1].indicator+" Parr[2]:"+parr[2].mybid+" , "+parr[2].indicator);
            	System.out.println("Sarr[0]: "+sarr[0].mybid+" , "+sarr[0].indicator+" Sarr[1]: "+sarr[1].mybid+" , "+sarr[1].indicator+" Sarr[2]:"+sarr[2].mybid+" , "+sarr[2].indicator);
    
            	for(int i=0;i<3;i++){
        			for(int j=0;j<2-i;j++){
        				if(parr[j+1].mybid<parr[j].mybid){
        					PAgent t=parr[j+1];
        					parr[j+1]=parr[j];
        					parr[j]=t;
        				}
        			}
        		}
            	parr[0].cur_pos=0;
            	parr[1].cur_pos=1;
            	parr[2].cur_pos=2;
            	
        /*    	for(int i=0;i<3;i++){
        			for(int j=0;j<2-i;j++){
        				if(sarr[j+1].mybid>sarr[j].mybid){
        					SAgent t=sarr[j+1];
        					sarr[j+1]=sarr[j];
        					sarr[j]=t;
        				}
        			}
        		}
            	sarr[0].cur_pos=0;
            	sarr[1].cur_pos=1;
            	sarr[2].cur_pos=2;
          */	System.out.println("Pairs formed: "+z_count);
            	Ssorting(sarr,z_count);
            	int o=0;
            	avg=0;
            //	while(o<3){
            	//	if(pr[1][o]==1)
            		//	avg=avg+pr[0][o];
            		//o++;
            	//}
            	//o=0;
            	while(o<3){
            		if(parr[o].indicator==1)
            			avg=avg+parr[o].mybid;
            		o++;
            	}
            	int i=0;
          //  	while(i<3){
            //		if(pr[1][i]!=0)
            	//		count++;
            		//i++;
            	//}
            	while(i<3){
            		if(parr[i].indicator!=0)
            			count++;
            		i++;
            	}
            	if(count!=0)
            	avg=avg/count;
            	i=0;
         //   	while(i<3){
           // 		if(pr[0][i]<=avg)
            //			pcount++;
            	//	if(sr[0][i]>=avg)
            		//	scount++;
            		//i++;
            	//}
            	while(i<3){
            		if(parr[i].mybid<=avg)
            			pcount++;
            		if(sarr[i].mybid>=avg)
            			scount++;
            		i++;
            	}
            	System.out.println(pcount+" "+scount+" "+ avg);
            	i=0;
            	int j=0;
            	int k=0;
            	
            	System.out.println("----------------Initial Bids----------------");
            	System.out.print("primary: ");
            	while (i<3)
            	{
            		if(parr[i].indicator==1)
            			System.out.print(parr[i].mybid+" "+" "+parr[i].indicator+" ");
            		i++;
            	}
            	i=0;
            	System.out.println();
            	System.out.print("Secondary: ");
            	while (i<3)
            	{
            		if(sarr[i].indicator==1)
            			System.out.print(sarr[i].mybid+" "+sarr[i].indicator+" ");
            		i++;
            	}
            	System.out.println();
            	System.out.println(sarr[0].mybid+" "+sarr[1].mybid+" "+sarr[2].mybid);
            	i=0;
            	//	while(i<3){
            	//	if(pr[0][i]<=avg && pr[1][i]!=0){
            		//	j++;
            		//}
            		//if(sr[0][i]>=avg && sr[1][i]!=0){
            			//k++;
            		//}
            		//i++;
            	//}
            	while(i<3){
            		if(parr[i].mybid<=avg && parr[i].indicator!=0){
            			j++;
            		}
            		if(sarr[i].mybid>=avg && sarr[i].indicator!=0){
            			k++;
            		}
            		i++;
            	}
            	 x=j;
            	if(j>k)
            		x=k;
            	System.out.println("x:"+x);
            	System.out.println("z_count: "+z_count);;
            	i=z_count;
            	j=0;
            	System.out.println("---------------Active Bids------------------");
            	System.out.print("Primary: ");
         //   	while(j<x){
           // 		pr[1][i]=0;
            //		parr[i].cont=0;
            	//	System.out.print(" "+pr[0][i]);
            		//i++;
            		//j++;
            	//}
            	j=z_count;
            	while(j<x+z_count){
            		parr[j].indicator=0;
            		parr[j].cont=0;
            		System.out.print(" "+parr[j].mybid);
            		j++;
            	}
            	
            	System.out.println();
            	System.out.print("Secondry: ");
         //   	while(j<x){
           // 		sr[1][i]=0;
            //		sarr[i].cont=0;
            	//	System.out.print(" "+sr[0][i]);
            		//i--;
            		//j++;
            	//}
            	j=z_count;
            	while(j<x+z_count){
            		sarr[j].indicator=0;
            		sarr[j].cont=0;
            		System.out.print(" "+sarr[j].mybid);
            		j++;
            	}
            	System.out.println();
            	System.out.println("Mod  timer: "+timer);
            	z_count=z_count+x;
            	System.out.println("Parr[0]: "+parr[0].mybid+" Parr[1]: "+parr[1].mybid+" Parr[2]:"+parr[2].mybid);
            	System.out.println("Sarr[0]: "+sarr[0].mybid+" , "+sarr[0].indicator+" Sarr[1]: "+sarr[1].mybid+" , "+sarr[1].indicator+" Sarr[2]:"+sarr[2].mybid+" , "+sarr[2].indicator);
    
            }
        }
        timer++;
    }
}
