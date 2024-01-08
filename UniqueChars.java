/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String newS = "";
        char currentChar;
        for(int i = 0; i < s.length()-1; i++)
        {

            if(s.charAt(i) != ' ')
            {
                currentChar = s.charAt(i);
                for (int j = i+1; j<s.length(); j++)
                {
                    if( currentChar == s.charAt(j))
                    {
                        s = (s.substring(0,j) + s.substring(j+1));
                        j --;
                    }
                }
            }

        }
        return s;
    }
}