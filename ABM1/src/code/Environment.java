package code;

import java.awt.*;
import sim.engine.*;
import sim.field.continuous.*;
import sim.util.*;

public class Environment extends SimState
    {

    public int round=10;
    public int pn=6;
    public int sn=4;

   // public double PAgent [] pa =new PAgent[round][pn];
    //public double SAgent [] sa=new SAgent[round][sn];

    private static final long serialVersionUID = 1;

    public Environment(long seed)
        {
        super(seed);
        }
        
  
    public void start()
        {
    	int count=0;;
    	double minValue=40;
    	double maxValue=300;
    	int ns=3;
    	int ps=3;
    	Moderator m=new Moderator(ns,ps);
         
        super.start();  // clear out the schedule
        minValue=2;    
		PAgent pa1=new PAgent(0,m);
        schedule.scheduleRepeating(pa1);
            
        PAgent pa2=new PAgent(1,m);
        schedule.scheduleRepeating(pa2);
       
        PAgent pa3=new PAgent(2,m);
        schedule.scheduleRepeating(pa3);
            
        SAgent sa1=new SAgent(0,m);
        schedule.scheduleRepeating(sa1);

        SAgent sa2=new SAgent(1,m);
        schedule.scheduleRepeating(sa2);
        
        SAgent sa3=new SAgent(2,m);
        schedule.scheduleRepeating(sa3);
        
        schedule.scheduleRepeating(m);
        }

    public static void main(String[] args)
        {
        doLoop(Environment.class, args);
        System.exit(0);
        }    

    
    }
