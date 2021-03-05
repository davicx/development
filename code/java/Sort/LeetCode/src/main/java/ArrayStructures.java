public class ArrayStructures {

    public static void main(String[] args){
        ArrayStructures newArray = new ArrayStructures();
        ArrayStructures myArray = new ArrayStructures();

        //newArray.generateRandomArray();
        //int[] myArray = {1, 5, 7, 8, 4, 3, 3, 9, 10, 6};


        newArray.generateRandomArray();
        newArray.printArray();
        //newArray.bubbleSort();
        newArray.insertionSort();
        newArray.printArray();
        newArray.binarySearchForValue(16);

        //System.out.println(newArray.getValueAtIndex(3));
        //System.out.println(newArray.doesArrayContainThisValue(20));
        //System.out.println(myArray.linearSearchForValue());

    }

    private int[] theArray = new int[50];
    private int arraySize = 10;

    //METHOD 5: INSERTION SORT
    public void insertionSort(){

        for (int i = 1; i < arraySize; i++){
            int j = i;
            int toInsert = theArray[i];
            while ((j > 0) && (theArray[j-1] > toInsert)){
                theArray[j] = theArray[j-1];
                j--;

                //printHorzizontalArray(i, j);

            }
            theArray[j] = toInsert;

            //printHorzizontalArray(i, j);

            System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = " + toInsert + "\n");

        }

    }






    //METHOD 5: SELECTION SORT
    public void selectionSort(){

        for(int x=0; x < arraySize; x++){
            int minimum = x;

            for(int y=x; y < arraySize; y++){

                // To change direction of sort just change this from > to <
                if(theArray[minimum]>theArray[y]){
                    minimum = y;
                }
            }

            swapValues(x, minimum);

            printHorzizontalArray(x, -1);
        }

    }

    public void swapValues(int indexOne, int indexTwo){
        int tempIndexOneValue = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = tempIndexOneValue;

    }



    //METHOD 3: Binary Search
    public void binarySearchForValue(int value){

        int lowIndex = 0;
        int highIndex = arraySize - 1;

        System.out.println("Low Index: " + lowIndex + " High Index: " + highIndex);

        while(lowIndex <= highIndex){
            int middleIndex = (highIndex + lowIndex) / 2;
            if(theArray[middleIndex] < value) {
                lowIndex = middleIndex + 1;
            } else if (theArray[middleIndex] > value){
                highIndex = middleIndex - 1;
            } else {
                System.out.println("Found a Match for " + value + " at Index " + middleIndex);
                lowIndex = highIndex + 1;
            }
            //printHorzizontalArray(middleIndex, -1);
        }
    }



    //METHOD 2: Bubble Sort
    public void bubbleSort(){
        for(int i = arraySize - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                //Greater then
                //if(theArray[j] < theArray[j + 1]){
                if(theArray[j] > theArray[j + 1]){
                    //System.out.println(theArray[j] + " Is greater then: " + theArray[j + 1]);
                    swapValues(j, j+1);
                    //printHorzizontalArray(i, j);
                } else {
                    //System.out.println(theArray[j] + " Is smaller then: " + theArray[j + 1]);

                }

            }
        }
    }



    //METHOD 4:
    public void printHorzizontalArray(int i, int j){

        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < arraySize; n++){
            System.out.print("| " + n + "  ");
        }

        System.out.println("|");
        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();

        for(int n = 0; n < arraySize; n++){
            System.out.print("| " + theArray[n] + " ");
        }

        System.out.println("|");

        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();

        if(j != -1){
            for(int k = 0; k < ((j*5)+2); k++)System.out.print("  ");
            System.out.print(j);
        }
        if(i != -1){
            for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
            System.out.print(i);
        }
        System.out.println();
    }



        //METHODS 2: Create Arrays
    //Fills the Array with random values
    public void generateRandomArray(){
        for(int i = 0; i < arraySize; i++){
            // Random number 10 through 19
            theArray[i] = (int)(Math.random()*10)+10;
        }
    }

    public int[] getTheArray(){
        return theArray;
    }

    public int getArraySize(){
        return arraySize;
    }

    // Prints the Array on the screen in a grid
    public void printArray(){
        System.out.println("----------");
        for(int i = 0; i < arraySize; i++){
            System.out.print("| " + i + " | ");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");
        }
    }

    // Gets value at provided index
    public int getValueAtIndex(int index){
        if(index < arraySize) {
            return theArray[index];
        } else {
            return 0;
        }

    }

    // Returns true or false if a value is in the Array
    public boolean doesArrayContainThisValue(int searchValue){
        boolean valueInArray = false;
        for(int i = 0; i < arraySize; i++){
            if(theArray[i] == searchValue){
                valueInArray = true;
            }
        }

        return valueInArray;
    }


    // Delete Array row for the index and move elements up
    public void deleteIndex(int index){

        if(index < arraySize){

            // Overwrite the value for the supplied index
            // and then keep overwriting every index that follows
            // until you get to the last index in the array

            for(int i = index; i < (arraySize - 1); i++){
                theArray[i] = theArray[i+1];
            }
            arraySize--;
        }
    }

    public void insertValue(int value){
        if(arraySize < 50){
            theArray[arraySize] = value;
            arraySize++;
        }
    }

    // Linear Search : Every index must be looked at
    public String linearSearchForValue(int value){

        boolean valueInArray = false;
        String indexsWithValue = "";
        System.out.print("The Value was Found in the Following Indexes: ");
        for(int i = 0; i < arraySize; i++){

            if(theArray[i] == value) {
                valueInArray = true;
                System.out.print(i + " ");
                indexsWithValue+= i + " ";
            }

        }

        if(!valueInArray){
            indexsWithValue = "None";
            System.out.print(indexsWithValue);
        }

        System.out.println();
        return indexsWithValue;

    }

    public void fillMyArray(){
        theArray[0] = 7;
        theArray[1] = 3;
        theArray[2] = 4;
        theArray[3] = 7;
        theArray[4] = 9;
        theArray[5] = 2;
        theArray[6] = 1;
        theArray[7] = 7;
        theArray[8] = 8;
        theArray[9] = 7;
    }


}