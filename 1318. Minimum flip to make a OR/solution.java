class Solution implements solutionInterface{
    public int minFlips(int a, int b, int c) {
        StringBuilder A = new StringBuilder(Integer.toBinaryString(a));
        StringBuilder B = new StringBuilder(Integer.toBinaryString(b));
        StringBuilder C = new StringBuilder(Integer.toBinaryString(c));
        
        int steps = 0;
        int length_a = A.length();
        int length_b = B.length();
        int length_c = C.length();
        int max_length = Math.max( Math.max(length_a, length_b), length_c);
        if(length_a < max_length){
            for(int i = 0; i < (max_length - length_a); i++){
                A.insert(0, "0");
            }
        }
        if(length_b < max_length){
            for(int i = 0; i < (max_length - length_b); i++){
                B.insert(0, "0");
            }
        }
        if(length_c < max_length){
            for(int i = 0; i < (max_length - length_c); i++){
                C.insert(0, "0");
            }
        }


        for(int i = 0; i < max_length; i++){
            char a_digit = A.charAt(i);
            char b_digit = B.charAt(i);
            char c_digit = C.charAt(i);
            if(c_digit == '0' && ( (a_digit == '1') || (b_digit == '1') )){
                if(a_digit == '1' && b_digit == '1')
                    steps += 2;
                else
                    steps++;
            }
            else if(c_digit == '1' && (a_digit == '0' && b_digit == '0'))
                steps++;
        }
        return steps;
    }
}