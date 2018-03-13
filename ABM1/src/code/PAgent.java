package code;

import java.awt.*;
import java.util.Random;

import ec.util.MersenneTwisterFast;
import sim.portrayal.*;
import sim.util.*;
import sim.engine.*;

public class PAgent implements Steppable
{
    private static final long serialVersionUID = 1;
    public int minV;
    public  int timer=2;
    int cont=1;
    int id;
    int cur_pos;
    int oldvalue=0;
    Moderator m;
    int pp;
    int indicator;
    int counn=0;
    int mybid;
    int counter=0;
    public PAgent(int id1,Moderator m1){
    	m=m1;
    	this.id=id1;
    	this.indicator=1;
    	Random rand=new Random();
    	int temp=rand.nextInt(1000);
        oldvalue=m.giveavg();
        MersenneTwisterFast mf=new MersenneTwisterFast(temp);
        this.minV=mf.nextInt(1000);
        this.mybid=minV;
    }
    public void step( final SimState state ){   
        if(timer%2==0&&cont==1){
            Environment environment = (Environment)state;
            if(counter==0)
            	m.setpr(id,minV,this,counn++);
            counter=1;
            if(timer<10);
            //System.out.println("PAgent "+id+"  timer: "+timer);
            }
        else if(timer%2==0&&timer<10)
        	System.out.println("I'm OUT");
        timer++;
    }
}
