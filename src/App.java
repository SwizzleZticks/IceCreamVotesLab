import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class App {
    public static Set<String> iceCreamFlavors = new HashSet<String>();
    public static Map<String, Integer> flavorVotes = new HashMap<String, Integer>();
    public static List<String> familyMemberNames = new ArrayList<String>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        initializeValues();

        for (int i = 0; i < familyMemberNames.size(); i++){
            getFamilyMemberVote(i, scanner);
        }

        printHighestVotes();
        scanner.close();
    }
    static void printHighestVotes(){
        int highestVoteCount = 0;

        for(int votes : flavorVotes.values()){
            if(votes > highestVoteCount){
                highestVoteCount = votes;
            }
        }

        System.out.println("\nFlavors with the highest votes: ");
        for(Map.Entry<String, Integer> entry : flavorVotes.entrySet()){
            if (entry.getValue() == highestVoteCount){
                System.out.println("- " + entry.getKey());
            }
        }
    }
    static void getFamilyMemberVote(int index, Scanner scanner){
        while(true){
            System.out.println("\nLet's vote on ice cream flavors. Here are your options:\n");
            printFlavors();

            System.out.println("\nWhich flavor do you want to vote for " + familyMemberNames.get(index) + ".\n");
            String userChoice = scanner.nextLine().trim().toLowerCase();

            if(iceCreamFlavors.contains(userChoice)){
                flavorVotes.put(userChoice, flavorVotes.getOrDefault(userChoice,0) + 1);
                break;
            } else{
                System.out.println("----------------------------------------------------------------");
                System.out.println("------That flavor is not a valid flavor, please try again.------");
                System.out.println("----------------------------------------------------------------");
                iceCreamFlavors.add(userChoice);
                flavorVotes.put(userChoice,1);
            }
        }
    }
    static void printFlavors(){
        System.out.println("--------------------------");
        for (String flavor : iceCreamFlavors){
        System.out.println(flavor);
        }
        System.out.println("--------------------------");
    }
    static void initializeValues(){
        iceCreamFlavors.add("strawberry");
        iceCreamFlavors.add("mint chocolate chip");
        iceCreamFlavors.add("vanilla");
        iceCreamFlavors.add("chocolate");
        iceCreamFlavors.add("cookie dough");

        for (String flavor : iceCreamFlavors){
            flavorVotes.put(flavor, 0);
        }

        familyMemberNames.add("Elizabeth");
        familyMemberNames.add("Charles");
        familyMemberNames.add("Anne");
        familyMemberNames.add("Andrew");
        familyMemberNames.add("Edward");
    }
}
