package practice.med;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList; 
public class LRUCache { 
	// store keys of cache 
	static LinkedList<Integer> dq; 
	// store references of key in cache 
	static HashMap<Integer, Integer> map; 
	//maximum capacity of cache 
	static int csize; 
	
	LRUCache(int n) 
	{ 
		dq=new LinkedList<>(); 
		map=new HashMap<Integer, Integer>(); 
		csize=n; 
	} 
	
	/* Refers key x with in the LRU cache */
	public void refer(int x) 
	{ 
		if(!map.keySet().contains(x)) 
		{ 
			
			if(dq.size()==csize) 
			{ 
				int last=dq.removeLast(); 
				map.remove(last); 
			} 
			
		} 
		else
		{ 
			/* The found page may not be always the last element, even if it's an 
			intermediate element that needs to be removed and added to the start 
			of the Queue */
			int index =0 , i=0; 
			Iterator<Integer> itr = dq.iterator(); 
			while(itr.hasNext()) 
			{ 
				int val = itr.next();
				if(val==x) 
				{ 
					index = i; 
					break; 
				} 
				i++; 
			} 
			dq.remove(index);
			
			
		} 
		dq.push(x); 
		map.put(x,x);
	
	} 
	
	// display contents of cache 
	public void display() 
	{ 
		Iterator<Integer> itr = dq.iterator(); 
		while(itr.hasNext()) 
		{ 
			System.out.print(itr.next()+" "); 
		} 
	} 
	
	
	public static void main(String[] args) { 
		LRUCache ca=new LRUCache(4); 
		ca.refer(1); 
		ca.refer(2); 
		ca.refer(3); 
		ca.refer(1); 
		ca.refer(4); 
		ca.refer(5); 
		ca.display();
	} 
} 

