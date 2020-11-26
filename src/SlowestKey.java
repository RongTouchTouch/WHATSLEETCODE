/***
 * Index: 1629
 * Difficulty: Easy
 * Related Topic: Array
 */

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        // if (keysPressed.length() == 0)
        //     return 'a';
        char key = keysPressed.charAt(0);
        int max = 0;
        for( int i = 0; i < keysPressed.length(); i++ ){
            int time;
            if( i == 0)
                time = releaseTimes[i];
            else
                time = releaseTimes[i]-releaseTimes[i-1];
            if(time >= max){
                max = time;
                key = keysPressed.charAt(i);
            }
        }
        return key;
    }

    public static void main(String agrv[]){
        int[] releasedTime = {1,3,6,8,10,21,24,27};
        String keysPressed = "absbasda";
        SlowestKey solution = new SlowestKey();
        char result = solution.slowestKey(releasedTime, keysPressed);
        System.out.println(result);
    }
}
