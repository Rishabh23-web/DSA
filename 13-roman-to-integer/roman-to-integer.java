class Solution {
    public int getval(char num){
        switch(num){
            case'I':
            return 1;
            case 'V' :
            return 5;
            case'X':
            return 10;
            case'L':
            return 50;
            case'C':
            return 100;
            case 'D':
            return 500 ;
            case'M':
            return 1000; 
            default : return 0;
        }
        
    }
    public int romanToInt(String s) {
        HashMap <Character,Integer> map = new HashMap<>();
        int number =0;
        
        int n= s.length();
        for(int i=0;i<n;i++){
            if(i+1<n  && getval(s.charAt(i)) < getval(s.charAt(i+1)))
            number -=getval(s.charAt(i));

            else{
                number += getval(s.charAt(i));
            }
        }return number;
    }
}