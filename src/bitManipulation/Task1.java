package bitManipulation;

public class Task1 {

	//Crack Interview Page 91
	//Sample Answer
	public int updateBits(int n, int m, int i, int j)
	{
		int allOnes = ~0;
		int left = allOnes << (j+1);
		int right = ((1<<i)-1);
		int mask = left|right;
		int n_cleared = n&mask;
		int m_shifted = m<< i;
		return n_cleared | m_shifted;
	}
	
	//my answer
	public int updateBits_M(int n, int m, int i, int j)
	{
		int jminsiOnes = (1 << ((j-i)+1)) -1;
		int mask = jminsiOnes << i;
		return (int)n & (~mask) | (m<<i);
	}
}
