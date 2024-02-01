import java.util.*;
import java.util.zip.ZipEntry;

public class Main {
    int j = 0;

    public static void main(String[] args) {


        Main m = new Main();
        m.uniqueNumber();
        m.duplicatedLeastNumber();
        m.caseChangeOfString();
        m.presenceOfString();
        //m.replaceChars();
        int[] array = {7,4,8,3,2,10,6,5};
        BubbleSort(array);
        printArray(array);
        //m.secondHighestNumber();
        m.wordsInString();
        m.removeElementFromTreeSet();
        m.hashSetToArray();
        m.countUsingHashMap();
        m.removeFromArrayList();
        m.removeLinkedHashSetValue();
        m.hashSetToObjectArray();



    }


    public void uniqueNumber() {
        String str1 = "I love java programming";
        String str2 = str1.substring(4, 14);
        String str3 = str2.replace(" ","");
        char[] str4 = str3.toCharArray();
        char[] result = new char[str4.length];
        Set<Character> charSet = new HashSet<>();
        for(int i=0;i<str4.length;i++){

            charSet.add(str4[i]);

        }
        System.out.println(charSet);
    }

    // Given input string= “ABCAABCAEBE” find which character is duplicated least number of times. o/p= ”E, C”
    public void duplicatedLeastNumber(){

        String input = "ABCAABCAEBE";
        char[] str = input.toCharArray();
        int count_a = 0,count_b=0,count_c=0,count_e=0;

        for(int i=0;i<str.length;i++){
            switch (str[i]){
                case 'A':
                    count_a+=1;
                    break;
                case 'B':
                    count_b+=1;
                    break;
                case 'C':
                    count_c+=1;
                    break;
                case 'E':
                    count_e+=1;
                    break;
                default:
                    System.out.println("no valid input");
            }
        }

        //System.out.println(count_a);
        int minValue = Math.min(count_a,Math.min(count_c,Math.min(count_b,count_e)));
        System.out.println(minValue);

        if(count_a==minValue){
            System.out.println("A");
        }
        if(count_b==minValue){
            System.out.println("B");
        }
        if(count_e==minValue){
            System.out.println("E");
        }
        if(count_c==minValue){
            System.out.println("C");

        }

    }

    //Convert Uppercase to Lowercase in java without using built in method?
    public void caseChangeOfString() {
        String upperCaseString = "hello";
        char[] a = upperCaseString.toCharArray();
        for(int i=0;i<a.length;i++){
            char lc = (char) (a[i]-32);
            System.out.println(lc);
            // System.out.println(a[i]);
        }


    }

    //String a="HeyDearHowareyou";
    //String b="Howareyou";
    //Write a code to find that string b is present in String a?

    public void presenceOfString(){
        String a="HeyDearHowareyou";
        String b="Howareyou";

        if(a.contains(b)){
            System.out.println("Stirng b is present in a");
        }
        else{
            System.out.println("String b is not present in a");
        }
    }

// Given an array of strings ={“hello”,”ello”}, replace all ll with aa without using inbuilt method.

    public void replaceChars() {
        String[] arrayOfStrings = {"hello", "ello"};

        char replaceWith = 'a';
        char[] value1 = arrayOfStrings[0].toCharArray();
        char[] value2 = arrayOfStrings[1].toCharArray();
        // System.out.println(value2);
        // System.out.println(value1);


        for(int i=0;i<arrayOfStrings.length;i++) {
            System.out.println(arrayOfStrings[i]);
            for (int j = 0; j < arrayOfStrings[i].length(); i++) {
                char[] value = arrayOfStrings[i].toCharArray();
                for (int k = 0; k < value1.length; k++) {
                    if (value1[k] == 'l') {
                        value1[k] = replaceWith;

                    }
                }
            }
        }
        System.out.println(arrayOfStrings);
//        char[] replacedFirstString = new char[value1.length];
//        for (int i = 0; i < value1.length; i++) {
//            if (value1[i] == 'l') {
//                value1[i] = replaceWith;
//            }
//            replacedFirstString = value1;
//
//        }
//        System.out.println(replacedFirstString);
    }



    //  WJP: given an array of elements print 1 even and 1 odd number in sorted
    // way. input : 7 4 8 3 2 10 6 5
    //  output: 2 3 4 5 6 7 8

    static void BubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped;

        for(int i=0;i<n;i++){
            swapped = false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;
                    swapped=true;
                }
            }
            if (!swapped) {
                break;
            }
        }

    }

    static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // Write a Java Program to find the second-highest number in an user array.

    //int[] num = {3,8,2};
    //o/p: 3 is the second highest number.

    public void secondHighestNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = scanner.nextInt();
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int[] arraySize  =new int[size];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<arraySize.length;i++){
            arraySize[i] = scanner.nextInt();
        }
        for (int num : arraySize){
            //System.out.println(arraySize[i]);
            if(num>firstMax){
                secondMax = firstMax;
                firstMax=num;
            }
            else if(num>secondMax && num!=firstMax){
                secondMax = num;
            }
        }
        System.out.println(secondMax);
    }



    // Write a Java Program to count the number of words in a string using HashMap
    public void wordsInString(){
        String wholeString = "This is a sample string. This string has some words.";
        HashMap<String,Integer> hashMap = new HashMap<>();
        String word = wholeString.replace(("."),"");
        String[] words = word.split("\\s+");
        for(String finalString : words){
            System.out.println(finalString);
            hashMap.put(finalString,hashMap.getOrDefault(finalString,0)+1);

        }
        System.out.println(hashMap);
    }

    // Basic Java program to Remove specified element from TreeSet example

    public void removeElementFromTreeSet(){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("apple");
        treeSet.add("orange");

        System.out.println(treeSet);
        for(int i=0;i<treeSet.size();i++){
            if(treeSet.contains("apple")){
                treeSet.remove("apple");
                break;
            }
        }
        System.out.println(treeSet);
    }

    //Write a program to convert HashSet to Array?

    public void hashSetToArray() {

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("jasmine");
        hashSet.add("rose");
        hashSet.add("lilly");

        String[] stringArray = new String[hashSet.size()];
        hashSet.toArray(stringArray);

        for(String array : stringArray) {
            System.out.println(array);
        }
    }

    //Write a Java Program to count the number of words in a string using HashMap.
    public void countUsingHashMap() {

        String initialString = "Today is a beautiful day day!";
        String cleanedString = initialString.replaceAll("[^a-zA-Z]", " ");
        String[] words = cleanedString.split("\\s+");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            System.out.println(word);
            hashMap.put(word,hashMap.getOrDefault(word,0)+1);
        }
        for(String finalWord : hashMap.keySet()){
            System.out.println(finalWord +":"+hashMap.get(finalWord));
        }
    }

    //Write a program to remove element from specified index ofArrayList?
    public void removeFromArrayList(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList);
        for(int i=0;i<arrayList.size();i++){
            if(i==2){
                arrayList.remove(i);
                break;
            }
        }
        System.out.println(arrayList);
    }



    public void removeLinkedHashSetValue(){
        LinkedHashSet<Integer> linkedHasSet = new LinkedHashSet<>();
        linkedHasSet.add(4);
        linkedHasSet.add(5);
        linkedHasSet.add(9);

        System.out.println(linkedHasSet);
        linkedHasSet.clear();
        System.out.println(linkedHasSet);

    }

    public void hashSetToObjectArray(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("mon");
        hashSet.add("wed");
        hashSet.add("sat");

        Object[] arr = hashSet.toArray();

        for(Object a : arr){
            System.out.println(a);
        }
    }
}
