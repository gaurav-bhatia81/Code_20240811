package jpmc;

/*
 * Write a function that accept a number and returns the starting position of the longest continuous sequence of 1s in its binary format.
 * Assumption : positive integers as input
 */
public class Problem2 {

    static int maxOneCounter = -1;
    static int maxOneCounterPos = -1;

    static int totalDigitCounter = 0;

    static int runningOneCounter = 0;
    static int runningOneCounterPos = 0;

    public static int apply(int inputNum) {
        System.out.println("Input : " + inputNum);
        int position = toBinary(inputNum);
        System.out.println("Output : " + position);
        //System.out.println("Max 1s count : " + maxOneCounter);
        //System.out.println("Max 1s position : " + maxOneCounterPos);
        //cleanup
        maxOneCounter = -1;
        maxOneCounterPos = -1;
        totalDigitCounter = 0;
        return position;
    }


    private static int toBinary(int inputNum){
        int d = inputNum / 2;
        int r = inputNum % 2;

        totalDigitCounter++;//We use this for offsetting to find position from left

        //If we find 0, then we check for any running counter and reset it
        if(r == 0) {
            if (runningOneCounter > 0) { //means we had an ongoing counter which must reset now, lets update max variables
                if (runningOneCounter > maxOneCounter) {//if this counter is more than last recorded max counter, we update
                    maxOneCounterPos = runningOneCounterPos;// take care of offset later
                    maxOneCounter = runningOneCounter;
                }
                //reset counters
                runningOneCounter = 0;
                runningOneCounterPos = totalDigitCounter;
            }
        }
        //If we find 1, then restart counter OR increment running counter
        if(r == 1) {
            //increment running counter variables
            runningOneCounter++;
            runningOneCounterPos = totalDigitCounter;

            //lets update max if relevant
            if(runningOneCounter > maxOneCounter) {
                maxOneCounter = runningOneCounter;
                maxOneCounterPos = runningOneCounterPos;
            }
        }
        //System.out.print(r);

        //End of recursion
        if (d == 0) {
            runningOneCounter = 0;
            runningOneCounterPos = 0;
            return maxOnesCounterPos(totalDigitCounter, maxOneCounterPos);
        }
        //End of recursion
        if (d == 1) {
            totalDigitCounter++;
            //System.out.print(d);

            //Note: remainder may be 0 or 1, we need to take this last digit for max counter variable calc
            runningOneCounter++;
            runningOneCounterPos = totalDigitCounter;

            //reset max variables if the case
            if(runningOneCounter > maxOneCounter){
                maxOneCounterPos = runningOneCounterPos;
                maxOneCounter = runningOneCounter;
            }

            //cleanup
            runningOneCounter = 0;
            runningOneCounterPos = 0;
            return maxOnesCounterPos(totalDigitCounter, maxOneCounterPos);
        }

        //continue recursion
        return toBinary(d);
    }

    //With recursion we traversed the digits in opposite order, so we use offset to get correct position of max 1s from left
    private static int maxOnesCounterPos(int totalDigitCounter, int maxOneCounterPos) {
        if(maxOneCounterPos == -1)
            return -1;//no 1s found
        return ((totalDigitCounter - maxOneCounterPos) + 1);//took diff + 1 to get position from left
    }
}
