class Solution {
    public List<List<Integer>> generate(int n)
    {
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<n;i++){
            List<Integer> row = new ArrayList<>();
            for(int k=0;k<=i;k++){
                row.add(1);
            }
            for(int j=1;j<i;j++){
                row.set(j,result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }
            result.add(row);
        }return result;
    }
}