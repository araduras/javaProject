import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        List<String> returnList = new ArrayList<>();
        int whiteSpace = 0;
        if (a == 'a'){
            returnList.add("A");
            return returnList;
        }
  
       
       
        for(int i = 65; i< (int)a;i++){
            returnList.add(alphabetStrings.get(i));
            
            for (int k = 0; k<whiteSpace; k++){
                returnList.add(" ");
            }
            whiteSpace ++;
        }
        return returnList;
    }

    
    void alphabetReturner (){
    List<String> alphabetStrings = new ArrayList<>();

        for (char letter = 'A'; letter < 'Z'; letter++){
            String letterString = letter + "";
            alphabetStrings.add(letterString);
        }
   }

}
