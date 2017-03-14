package sort;

import java.util.Arrays;

/**
 * Ã°ÅÝÅÅÐò
 * @author kevin
 *
 */
public class Test {

	public static void main(String[] args) {
		int[] a = {6,10,2,-1,7,45,18};
		int tmp;
		for (int tt : a) {
			System.out.print(tt + "\t");
		}
		System.out.println();
		boolean flag = true;
		for (int i = a.length-1;i > 0 && flag;i--) {
			flag = false;
			for (int j = 0;j < i; j++) {
				if (a[j] > a[j + 1]) {
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					flag = true;
				}
			}
			System.out.print(i + ":\t");
			for (int tt : a) {
				System.out.print(tt + "\t");
			}
			System.out.println();
		}
	
		
	}
}
