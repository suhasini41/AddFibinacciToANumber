package package1;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddFibonacciToGetANumber 
{
	private static int fibonacciThatFormTheNumber(int n) 
	{
		List<Integer> list = generateFibonacciList(n);
		int sum=0;
		List<Integer> fb = new ArrayList<>();
		fb.add(list.get(list.size()-1));
		sum = sum + list.get(list.size()-1);
		int setSize = list.size()-3;
		if(sum<n)
		{
			for(int i=setSize;i>0;i--)
			{
				sum = sum + list.get(i);
				if(sum>n)
				{
					sum = sum - list.get(i);
				}
				else if(sum==n)
				{
					fb.add(list.get(i));
					break;
				}
				else
				{
					fb.add(list.get(i));
				}
			}
			
		}
		System.out.println(fb);
		return fb.size();
	}

	private static List<Integer> generateFibonacciList(int n) {
		List<Integer> list = new ArrayList<>();
		int x=0,y=1;
		list.add(y);
		while(true)
		{
			int z = x+y;
			x=y;
			y=z;
			if(z>n)
				break;
			else
				list.add(z);
		}
		return list;
	}
	
	@Test
	public void testCase1()
	{
		Assert.assertEquals(fibonacciThatFormTheNumber(65), 3);
	}
	
	@Test
	public void testCase2()
	{
		Assert.assertEquals(fibonacciThatFormTheNumber(8), 1);
	}
	
	@Test
	public void testCase3()
	{
		Assert.assertEquals(fibonacciThatFormTheNumber(88), 5);
	}

}
