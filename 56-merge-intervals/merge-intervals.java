class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length ;
        Arrays.sort(arr,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(arr[0]);
        for(int i=1;i<n;i++){
            if(arr[i][0]<=ans.get(ans.size()-1)[1]){
                ans.get(ans.size()-1)[0] = Math.min(arr[i][0],ans.get(ans.size()-1)[0]);
                ans.get(ans.size()-1)[1] = Math.max(arr[i][1],ans.get(ans.size()-1)[1]);
            }else{
                ans.add(arr[i]);
            }
        }
        
        return  ans.toArray(new int[ans.size()][]);
    }
    

}