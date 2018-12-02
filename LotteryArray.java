

public class LotteryArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NMAX = 10;
	
		//allocate triangular array
		int[][] odds = new int[NMAX+1][];
		for (int i = 0; i < odds.length; i++) {
			odds[i] = new int[i+1];
		}
		
		//fill triangular array
		for (int i = 0; i < odds.length; i++) {
			for (int j = 0; j < odds[i].length; j++) {
				/**
				 * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
				 */
				int lotteryOdds = 1;
				for (int k = 1; k <= j; k++) {
					lotteryOdds = lotteryOdds * (i - k + 1)/k;
				}
				odds[i][j] = lotteryOdds;
			}
		}
		
		//print triangular array
		for (int[] row : odds){
			for (int odd : row){
				System.out.printf("%4d", odd);
			}
			System.out.println();
		}
		
	}

}
