package problems;

public class ProductExceptItselfInArray {
	
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        double product = 1;
        int zeros = 0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0)
                product *= nums[i];
            else
                zeros++;
        }
        
        long[] result = new long[n];
        
        if(zeros >= 2) {
            
            for(int i=0;i<n;i++) 
                result[i] = 0;
                
        } else if(zeros == 0){
            
            for(int i=0;i<n;i++) 
                result[i] = (long)product/nums[i];
        
            
        } else if(zeros == 1) {
            for(int i=0;i<n;i++) {
                if(nums[i] != 0)
                    result[i] = 0;
                else
                    result[i] = (long)product;
            }
        }
        return result;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
