import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(Integer asteroid : asteroids){
            boolean flag = true;
            while(!stack.empty() && (stack.peek() > 0 && asteroid < 0) ){

                if( Math.abs(stack.peek()) < Math.abs(asteroid)){
                    stack.pop();
                    continue;
                }
                else if(Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                }
                flag = false;
                break;
            }
            if(flag){
                stack.push(asteroid);
            }
        }


        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i++){
            result[i] = stack.pop();
        }
        return result;
    }
}