
public class ZigzagConversion {

	public static void main(String[] args) {
		
		//input array example; input=1,2,3,4; output=1,3,2,4
		int []arr = {4,2,3,4,7,6,5,9,1,2};
		//int[] arr = {3, 5, 2, 1, 6, 4};
		boolean flag=true;
		
		for(int i=1; i<arr.length; i++)
		{	
			

				if (flag) /* "<" relation expected */
				{
					/* If we have a situation like A > B > C,
					we get A > B < C by swapping B and C */
					if (arr[i-1] > arr[i])
						{	
							int temp = arr[i-1];
							arr[i-1]= arr[i];
							arr[i]=temp;
						}
				}
				else /* ">" relation expected */
				{
					/* If we have a situation like A < B < C,
					we get A < C > B by swapping B and C */
					if (arr[i-1] < arr[i])
						{
							int temp = arr[i-1];
							arr[i-1]= arr[i];
							arr[i]=temp;
						}
				}
				flag = !flag; /* flip flag */
			
		}
		
		for(int i=0; i<arr.length; i++)
		{System.out.print(arr[i]+" ");}
	}

}
