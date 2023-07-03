class Solution implements solutionInterface{
    int n;
    int result = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] kids = new int[k];
        n = cookies.length;
        for(int i = 0; i < k; i++)
            solve(cookies, kids, 0, i);

        return result;
    }

    public void solve(int[] cookies, int[] kids, int curCookies, int curKid){
        
        kids[curKid] += cookies[curCookies];
        if(curCookies == n - 1){
            int max = 0;
            for(int i = 0; i < kids.length ; i++){
                if(kids[i] > max)
                    max = kids[i];
            }
                
            if(max < result)
                result = max;
            kids[curKid] -= cookies[curCookies];
            return;
        }
        for(int i = 0; i < kids.length; i++){
            solve(cookies, kids, curCookies + 1, i);
        }
        kids[curKid] -= cookies[curCookies];
        return;
    }
}