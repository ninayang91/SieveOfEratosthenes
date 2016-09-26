import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean[] flags=sieveOfEratosthenes2(1000);
		int count=0;
		for(int i=0;i<flags.length;i++){
			if(flags[i]){
				count++;
				System.out.print(i + (count%10==0?"\n":" "));
			}
		}
	}

	public static boolean[] sieveOfEratosthenes2(int max){
		int size=max+1;
		boolean[] flags=new boolean[size];
		for(int i=2;i<size;i++){
			flags[i]=true;
		}
		for(int n=2;n*n<size;n++){
			if(flags[n]){
				for(int m=n;m*n<size;m++){
					flags[m*n]=false;
				}
			}
		}
		return flags;
	}
	
	public static boolean[] sieveOfEratosthenes(int max){
		boolean[] flags=new boolean[max+1];
		int count=0;
		
		for(int i=2;i<flags.length;i++){
			flags[i]=true;
		}
		int prime=2;
		
		while(prime<=Math.sqrt(max)){
			crossOff(flags,prime);
			prime=getNextPrime(flags,prime);
			if(prime>=flags.length){
				break;
			}
		}
		return flags;
	}
	
	public static void crossOff(boolean[] flags, int prime){
		for(int i=prime*prime;i<flags.length;i+=prime){
			flags[i]=false;
		}
	}
	
	public static int getNextPrime(boolean[] flags, int prime){
		int next=prime+1;
		while(next<flags.length && !flags[next]){
			next++;
		}
		return next;
	}

}
