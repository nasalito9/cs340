package edu.sfsu;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


import java.util.*;


public class Main {

    public static void main(String[] args) {//creating dictionary from enum values
        HashMap<String, ArrayList> map = new HashMap<>();
        ArrayList<String> userList = new ArrayList<>();
        ArrayList<String> wordCheck = new ArrayList<>();
        int counter = 0;

        for(Definitions s: Definitions.values()) {
            String unparsedString = s.getWord() + ";" + s.getTense() + ";" + s.getDef();//can parse out ; later
            wordCheck.add(s.getWord());
            if(userList.size() > 0){
                if(!wordCheck.get(wordCheck.size() - 2).equals(wordCheck.get(wordCheck.size() - 1))){//checks if word about to be entered is equal to most recent word
                    map.put(wordCheck.get(wordCheck.size() - 2).toLowerCase(),userList);
                    userList = new ArrayList<>();
                }
            }
            userList.add(unparsedString);
            ++counter;
            if(counter == Definitions.values().length - 1){//used for last value of Definitions
                map.put(wordCheck.get(wordCheck.size() - 2).toLowerCase(),userList);
            }
        }//end of dictionary creation

        int searchCounter = 1;
        int definitionCounter = Definitions.values().length;
        System.out.println("! Loading data. . . ");
        if(!map.isEmpty()){
            System.out.println("! Loading completed . . .");
        }
        System.out.println("==== DICTIONARY 340 JAVA ====");
        System.out.println("---- Keywords: " + map.keySet().size());
        System.out.println("---- Definitions: " + definitionCounter);
        System.out.print("Search [" + searchCounter + "]: ");//code startup output

        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        String[] split = userInput.split(" ");
        String[][][] defOutput;
        boolean validInput = true;//used to pass through loop in case of invalid input

        do{//need to parse userInput
            String wordEntry = split[0].toLowerCase(Locale.ROOT);
            System.out.println(" |");
            if(split[0].equals("!help")){//!help case
                helpFunction();
            }
            else if(wordEntry.equals("")){//no entry case
                helpFunction();
            }
            else if(map.get(wordEntry) == null){// entry not found case
                System.out.println("<NOT FOUND> To be considered for the next release. Thank you. \n | \n |");
                helpFunction();
                validInput = false;
            }
            ArrayList<String[]> finalOutput = new ArrayList<>();
            if(map.get(wordEntry) != null) {//entry found case
                ArrayList userDef = map.get(wordEntry);
                for (int i = 0; i < userDef.size(); ++i) {
                    Object definitionString = userDef.get(i);
                    String userString = definitionString.toString();
                    String[] parsedString = userString.split(";");
                    finalOutput.add(parsedString);
                }
            }
            if(split.length > 1 && validInput == true) {
                if (split.length > 4) {
                    helpFunction();
                    validInput = false;
                } else {
                    if (!split[1].equalsIgnoreCase("reverse") && !split[1].equalsIgnoreCase(("distinct")) && (!split[1].toLowerCase().equalsIgnoreCase("noun") && !split[1].toLowerCase().equalsIgnoreCase("adjective") &&
                            !split[1].toLowerCase().equalsIgnoreCase("verb") && !split[1].toLowerCase().equalsIgnoreCase("adverb") && !split[1].toLowerCase().equalsIgnoreCase("conjunction")
                            && !split[1].toLowerCase().equalsIgnoreCase("preposition") && !split[1].toLowerCase().equalsIgnoreCase("pronoun"))) {//for "noun" input
                        System.out.println("<The entered 2nd parameter '" + split[1] + "' is NOT a part of speech>");
                        System.out.println("<The entered 2nd parameter '" + split[1] + "' is NOT 'distinct'>");
                        System.out.println("<The entered 2nd parameter '" + split[1] + "' is NOT 'reverse'>");
                        System.out.println("<The 2nd parameter should be a part of speech or 'distinct' or 'reverse'> \n | \n |");
                    }
                    if ((split.length > 2) && (!split[2].equalsIgnoreCase("reverse") && !split[2].equalsIgnoreCase(("distinct")))) {//for "noun" input
                        System.out.println("The entered 3rd parameter '" + split[2] + "' is NOT 'distinct'");
                        System.out.println("The entered 3rd parameter '" + split[2] + "' is NOT 'reverse'");
                        System.out.println("<The 3rd parameter should 'distinct' or 'reverse'> \n | \n |");
                    }
                    if(split[1].equalsIgnoreCase("reverse") && split[2].equalsIgnoreCase("reverse")){ // in the case of back to back distinct
                        System.out.println("The entered 3rd parameter '" + split[2] + "' is NOT 'reverse'\n | \n |");
                    }
                    if(split.length > 2 && (split[1].equalsIgnoreCase("distinct") && split[2].equalsIgnoreCase("distinct"))) {
                        System.out.println("The entered 3rd parameter '" + split[2] + "' is NOT 'distinct'\n | \n |");
                    }
                    if ((split.length > 3) && (!split[3].equalsIgnoreCase("reverse"))) {
                        System.out.println("The entered 4th parameter '" + split[3] + "' is NOT 'reverse'");
                        System.out.println("The entered 4th parameter '" + split[3] + "' was disregarded");
                        System.out.println("<The 4th parameter should be 'reverse'> \n | \n |");
                    }
                    if (split[1].equalsIgnoreCase("reverse") || (split.length > 2 && split[2].equalsIgnoreCase("reverse")) || (split.length > 3 && split[3].equalsIgnoreCase("reverse"))) {//reversing output
                        ArrayList<String[]> temp = new ArrayList<>();
                        for (int j = finalOutput.size() - 1; j >= 0; --j) {
                            temp.add(finalOutput.get(j));
                        }
                        finalOutput = temp;
                    }
                    if (split[1].equalsIgnoreCase("distinct") || (split.length > 2) && split[2].equalsIgnoreCase("distinct") || (split.length > 3 && split[3].equalsIgnoreCase("distinct"))) {
                        ArrayList<String[]> temp = new ArrayList<>();
                        ArrayList<String> tenseCheck = new ArrayList<>();
                        wordCheck.clear();
                        for (int i = 0; i < finalOutput.size(); ++i) {
                            String userString = Arrays.toString(finalOutput.get(i));
                            String[] parsedString = userString.split(",");
                            String word = parsedString[0];
                            String tense = parsedString[1];
                            String wordDef = parsedString[2];
                            wordDef = wordDef.replaceFirst(" ", "");  //Output of EX: " A book of pages" to "A book of pages"
                            wordDef = wordDef.replaceFirst("]", "");  //Output of EX: "A book of pages] to "A book of pages"
                            tense = tense.replace(" ", "");
                            word = word.replaceFirst("\\[", "");
                            String[] unspacedString = new String[3];
                            unspacedString[0] = word;
                            unspacedString[1] = tense;
                            unspacedString[2] = wordDef;
                            wordCheck.add(wordDef);
                            tenseCheck.add(tense);
                            if (temp.size() > 0) {
                                if (wordCheck.get(wordCheck.size() - 2).equals(wordCheck.get(wordCheck.size() - 1)) && tenseCheck.get(wordCheck.size() - 2).equals(tenseCheck.get(wordCheck.size() - 1))) {
                                } else {
                                    temp.add(unspacedString);
                                }
                            } else {
                                temp.add(unspacedString);
                            }
                        }
                        finalOutput = temp;
                    }
                    if (split.length > 1 && (split[1].toLowerCase().equals("noun") || split[1].toLowerCase().equals("adjective") || split[1].toLowerCase().equals("verb")
                            || split[1].toLowerCase().equals("adverb") || split[1].toLowerCase().equals("conjunction")
                            || split[1].toLowerCase().equals("preposition") || split[1].toLowerCase().equals("pronoun"))) {//for "noun" input

                        ArrayList<String[]> temp = new ArrayList<>();//will be used to send to finalOutput
                        wordCheck.clear();
                        for (int i = 0; i < finalOutput.size(); ++i) {
                            String userString = Arrays.toString(finalOutput.get(i));
                            String[] parsedString = userString.split(",");
                            String word = parsedString[0];
                            String wordTense = parsedString[1];
                            String wordDef = parsedString[2];
                            word = word.replaceFirst("\\[", "");
                            wordTense = wordTense.replaceFirst(" ", "");
                            wordDef = wordDef.replaceFirst(" ", "");
                            wordDef = wordDef.replaceFirst("]", "");
                            wordCheck.add(wordTense);
                            if (wordTense.equalsIgnoreCase(split[1])) {
                                parsedString[0] = word;
                                parsedString[1] = wordTense;
                                parsedString[2] = wordDef;
                                temp.add(parsedString);
                            }
                        }
                        finalOutput = temp;
                        if(finalOutput.isEmpty()){
                            System.out.println("<NOT FOUND> To be considered for the next release. Thank you. \n | \n |");
                            helpFunction();
                            validInput = false;
                        }
                    }
                }
            }
            if(validInput == true){
                for(int i = 0; i < finalOutput.size(); ++i){
                    String[] finalString = finalOutput.get(i);
                    finalString[0] = finalString[0].substring(0,1).toUpperCase() + finalString[0].substring(1);
                    System.out.println(finalString[0] + " [" + finalString[1] + "] : " + finalString[2]);

                }
            }
            ++searchCounter;
            System.out.print(" |\nSearch [" + searchCounter + "]: ");
            userInput = sc.nextLine();
            split = userInput.split(" ");
            validInput = true;
            }while(split[0] != "!q");
        }

    public static void helpFunction() {
        System.out.println("PARAMETER HOW-TO,  please enter: \n " +
                "1. A search key -then 2. An optional part of speech -then \n " +
                "3. An optional 'distinct' -then 4. An optional 'reverse'");

    }
}

