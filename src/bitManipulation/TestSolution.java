package bitManipulation;

public class TestSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Sample s = new Sample();
		//boolean result = s.isIntegerPowerOfTwo(9);
		//boolean result = s.is_power(256);
		//System.out.println("result is : " + result);
		
		//Task1
		Task1 t1 = new Task1();
		int result1 = t1.updateBits(154, 9, 2, 5);
		int result2 = t1.updateBits_M(154, 9, 2, 5);
		boolean result = result1==result2;
		System.out.println("result is : " + result + ","+ result1 + "," + result2);
		
		//Task2 		10111000010100011110101110000101
		Task2 t2 = new Task2();
		System.out.println(new String(t2.printBinary(0.71999999997206032276)));
		
		//Task 5
		Task5 t5 = new Task5();
		System.out.println(t5.numberOfBitsToConvert(31, 14));
		System.out.println(t5.numberOfOnes(31));
		System.out.println(t5.numberOfOnes(14));
		
		System.out.println(32^32);
		
		//Sample
		Sample sample = new Sample();
		//int result_S = sample.findMissingOne(new int[]{1,2,3,4,5,7,8,9,10});
		int[] testArray = new int[1000000];
		for(int i= 0; i< 1000000; i++)
		{
			if(i<76597)
			{testArray[i] = i+1;}
			else
			{
				testArray[i] = i+2;
			}
		}
		int result_S = sample.findMissingOne(testArray);
		System.out.println(result_S);

	}

}
