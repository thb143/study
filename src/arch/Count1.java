package arch;

/**
 * 例如：
 * 
 * uint32_t i=58585858;
 * 
 * i的二进制表示是：
 * 
 * 0000 0011 0111 1101 1111 0011 0000 0010
 * 
 * 于是，i的二进制表示包含15个1。
 * 
 *
 */
public class Count1 {
	public static void main(String[] args) {
		int result = 0,i = 0;
		int n = 58585858;
		do{
			/*
			 * n&1 == 1，表示最右边的位数为1。
			 * 3=0011,1=0001， 3&1 == 1 
			 * n>>=1，将n往右位移一位，3=0011，位移后 = 0001
			 * 位移后再继续为1比较，Int是八个字节32位，位移32次即可
			 */
		    if ((n&1)==1){
		       result++;
		    }
		    n>>= 1;
		    i++;
		} while(i<32);
		
		System.out.println(result);
//		System.err.println(9 & 8);// 1001(9)&1000(8) 1000(8)&(0111) 2的n次方&2的n次方-1 = 0
	}
}
