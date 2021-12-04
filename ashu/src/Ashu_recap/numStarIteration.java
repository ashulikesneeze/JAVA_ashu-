package Ashu_recap;

public class numStarIteration {

	public static void main(String[] args) {
		/* 123   method 1 =
		 * 456   i가 3의 배수이면 엔터
		 * 789   method 2 =3*i-2 
		 */
		int i,j;
		for(i=1; i<=9;i++) {
			System.out.print(i + " ");
			if(i % 3 == 0) {
				System.out.println();
			}
		}
		
		for(i=1; i<=3; i++) {
			for(j=3*i-2; j<=3*i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
			
		/* a  start with: a end with a        
		 * ab             a          b
		 * abc            a          c 
		 * abcd..z        a          z
		 */
		char ch, ch2;
		for(ch='a' ; ch<='z'; ch++) {
			for(ch2='a'; ch2<=ch; ch2++) {
				System.out.print(ch2);
			}
			System.out.println();
		}
		
		
		/* *****
		 * *****
		 * *****
		 * *****
		 * *****
		 */
		for(i=1; i<=5; i++) {
			for(j=1; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		/* *
		 * **
		 * ***
		 * ****
		 * *****
		 */
		i=1;
		while(i<=5) {
			j=1;
			while(j<=i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		
		
		/*      * i=1 space=4 *=1 enter
               ** i=2 space=3 *=2 enter
              *** i=3 space=2 *=3 enter
             **** i=4 space=1 *=4 enter
            ***** i=5 space=0 *=5 enter
        */
		int num =5;
		for(i=1; i<=5; i++) {
			for(j=1; j<=num-i;j++) {
				System.out.print(" ");
			}
			for(j=1; j<=i; j++) {
				System.out.print("*");		
	    	}
			System.out.println();
		}
		
		/*      *        i=1 space=4 *=1 enter  
		 	   ** *      i=2 space=3 *=3 enter
              *** **     i=3 space=2 *=5 enter
             **** ***    i=4 space=1 *=7 enter
            ***** ****   i=5 space=0 *=9 enter or *= i *=i-1
       */
		while(i<=num) {
			j=1;
			while(j<=num-1) {
				System.out.print(" ");
				j++;
			}
			j=1;
			while(j<=2*i-1) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		
		
		for(i=1; i<=num; i++) {
			for(j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for(j=1; j<=i; j++) {
				System.out.print("*");
			}
			for(j=1;j<=i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
			}
		}

}
