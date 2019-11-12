package practice.med;
import java.util.LinkedList;
import java.util.Arrays;
public class HashTable<T, U>{

	private LinkedList<Entry<T,U>>[] map = new LinkedList[100];


	public void put(T key, U value){
		if(key ==null){
			throw new RuntimeException("Key Null");
		}

		Entry<T, U> entry = new Entry<T, U>(key, value);
		int bucket = getBucket(entry.getKey());
		
		//System.out.println(bucket);
		//System.out.println(entry);		

		LinkedList<Entry<T, U>> list = map[bucket];
		if(null==list){
			list = new LinkedList<Entry<T, U>>();
			map[bucket] = list;
		}else{
			int index = list.indexOf(entry);
			if(index != -1){
				list.remove(index);
			}
		}
		list.add(entry);		
		System.out.println(Arrays.toString(map));
	
	}

	
	public U get(T key){
		int bucket = getBucket(key);
		LinkedList<Entry<T, U>> list = map[bucket];
                if(null!=list){
			Entry<T, U> entry = new Entry<T, U>(key, null);
			int index = list.indexOf(entry);
			if(-1 != index){
				return list.get(index).getValue();
			}
			
		}
		return null;
	}

	

	private int getBucket(T key){
		return key.hashCode() % this.map.length;
	}

	public static void main(String [] args){
		
		HashTable<Integer, String> ht  = new HashTable<Integer, String>();
		ht.put(1,"abc");
		ht.put(1,"nnn");
		ht.put(101,"mno");
		ht.put(12123123,"klm");
		ht.put(3,"xyz");

		System.out.println(ht.get(1));
		System.out.println(ht.get(101));

		
		
	}

}

class Entry<T, U>{
	private T key;
	private U value;
	
	public Entry (T t, U u){
		this.key = t;
		this.value = u;
		
	}	

	public T getKey(){
		return key;	
	}
	public U getValue(){
		return value;
	}
	public boolean equals(Object o){
		
		if(null == o) return false;

		if( o instanceof Entry<?, ?> ){
			Entry<T, U> x = (Entry<T, U>) o;
			if(x.getKey()==this.getKey()){
				return true;
			}
						
		} 
		return false;
	}

	public String toString(){
		return this.key.toString() + " " + this.value.toString();
	}		

}

