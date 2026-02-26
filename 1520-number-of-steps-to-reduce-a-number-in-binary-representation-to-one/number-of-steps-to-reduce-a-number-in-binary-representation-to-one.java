class Solution {
    public int numSteps(String s) {
        if(s.length()==1)return 0;
        int steps =0;
        int power = 0;
        for(int i= s.length()-1;i>=1;i--){
            if(((s.charAt(i)-'0')+power)%2 ==1){
                steps +=2;
                power =1;
            }else{
                steps +=1;
            }
        }
        return steps+power;
    }
}