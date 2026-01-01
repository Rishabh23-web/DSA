class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
}
class StockSpanner {
    Stack<Pair<Integer,Integer>> stk;
    int ind;
    public StockSpanner() {
        ind= -1;
        stk = new Stack<>();
    }
    
    public int next(int price) {
        ind++;
        while(!stk.isEmpty() && stk.peek().first<= price){
            stk.pop();
        }
        int ans = ind-(stk.isEmpty()?-1: stk.peek().second);
        stk.push(new Pair<>(price,ind));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */