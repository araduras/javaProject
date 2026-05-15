import java.util.ArrayList;
import java.util.List;


class BracketChecker {

 List<String> expressionList = new ArrayList<>();
int endIndex = 0;

    BracketChecker(String expression) {       
        for (int i = 0; i < expression.length(); i++) {
            expressionList.add(expression.substring(i,i+1));
        }        
    }
 

    boolean openingBracketFinder(int startIndex){
         for (int i = startIndex; i < expressionList.size(); i++) {
             if (expressionList.get(i).matches("[\\{\\[\\(]")) {
                return true;
            }            
        }
        return false;    
}

    boolean closingBracketFinder(int startIndex){
        for (int i = startIndex; i < expressionList.size(); i++) {
             if (expressionList.get(i).matches("[\\}\\]\\)]")) {
                endIndex = startIndex;
                return true;
            }            
        }
        return false;
    }

    boolean bracketCompleteCheck(int startIndex){
         boolean bracketIsComplete = false;
            for (int j = startIndex; j < expressionList.size(); j++) {
                 if(openingBracketFinder(j) && j+1 <= expressionList.size()){
                    if (closingBracketFinder(j+1)){
                        bracketIsComplete = true;
                    }
                 }
            }
            return bracketIsComplete;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        for (int i = 0; i < expressionList.size(); i++) {
            if(!bracketCompleteCheck(endIndex)){
                return false;
            }
        }
            return true;
    }

}