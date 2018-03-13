package code;

import java.awt.*;
import java.util.Random;

import ec.util.MersenneTwisterFast;
import sim.portrayal.*;
import sim.util.*;
import sim.engine.*;

public class SAgent implements Steppable
{
    private static final long serialVersionUID = 1;
    public int minV;
    public int timer=2;
    int cont=1;
    int cur_pos;
    public int id;
    Moderator m;
    int oldvalue=0;;
    int indicator=1;
    int counn=0;
    int mybid;
    
    public SAgent(int id1,Moderator m1){
    	m=m1;
    	this.indicator=1;
    	oldvalue=m.giveavg();
    	Random rand=new Random();
    	int temp=rand.nextInt(1000)+oldvalue;
    	MersenneTwisterFast mf=new MersenneTwisterFast(temp);
        this.minV=mf.nextInt(2000);
        //this.minV=1000=
    	this.id=id1;
    	this.mybid=minV;
     }
    

    public void step( final SimState state ){
    	if(timer%2==0&&cont==1){
            Environment environment = (Environment)state;
            //
            oldvalue=m.giveavg();
        	Random rand=new Random();
        	int temp=rand.nextInt(1000)+oldvalue;
        	MersenneTwisterFast mf=new MersenneTwisterFast(temp);
            this.minV=mf.nextInt(2000);
            this.minV=temp;
        	//this.id=id1;
        	this.mybid=minV;
            if(counn==0){
            	m.setsr(id,minV,this,counn);
            	counn=1;
            }
            else
            	m.setsr(this.cur_pos, minV, this, counn);
            if(timer<10);
            //System.out.println("SAgent "+id+" timer: "+timer);
           }
    	else if(timer%2==0&&timer<10 && cont ==0)

        	System.out.println("I'm OUT");
        timer++;
    }
}
