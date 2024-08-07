class Solution {
    public static String[] ones = {" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public static String[] beltwenty = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public static String[] belhundred = {" ","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }

        else{
            return numtoword(num);
        }
    }


    public static String numtoword(int num){

        if(num<10){
            return ones[num];
        }

        if(num<20){
            return beltwenty[num-10];
        }

        if(num<100){
            return belhundred[num/10] + (num%10!=0? " "+numtoword(num%10):"");
        }

        if(num<1000){
            return numtoword(num/100) + " Hundred" + (num%100!=0 ? " "+numtoword(num%100):"");
        }

        if(num<1000000){
            return numtoword(num/1000) + " Thousand" + (num%1000!=0 ? " " + numtoword(num%1000):"");
        }
        if(num<1000000000){
            return numtoword(num/1000000) + " Million" + (num%1000000!=0 ? " " + numtoword(num%1000000):"");
        }

        return numtoword(num/1000000000) + " Billion" + (num%1000000000!=0 ? " " + numtoword(num%1000000000):"");
        
    }
}