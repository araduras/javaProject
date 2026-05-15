    import java.util.ArrayList;
    import java.util.List;

    class LuhnValidator {
        List<Character> formattedCharList = new ArrayList<>();
        List<Integer> luhnList = new ArrayList<>();

        boolean isValid(String candidate) {
            
            try{
                charListCreator(candidate);
            }

            catch(IllegalArgumentException e){
                return false;
            }
            if (luhnAlgorithmCorrect()%10>0) {
                return false;
            }
            else{
                return true;
            }

        

        }

        void charListCreator (String candidate){        
            for (int i = 0; i < candidate.length(); i++) {
                if(candidate.charAt(i)==' '){
                    continue;
                }
                formattedCharList.add(candidate.charAt(i));
            }
            letterCheck();
            lengthCheck();
            
        }

        void letterCheck (){
            for (int i = 0; i < formattedCharList.size(); i++) {
                if (!Character.isDigit(formattedCharList.get(i))) {
                    throw new IllegalArgumentException();
                }
            }
        }

        void lengthCheck(){
            if(formattedCharList.size()<=1){
                throw new IllegalArgumentException();
            }
        }

  
        int luhnAlgorithmCorrect (){
            int sum = 0;
            // 1 , 2 , 3 , 4
           for (int j = 0; !formattedCharList.isEmpty(); j++) {
                int last = Character.getNumericValue(formattedCharList.getLast());
                if(j%2==0){
                    sum+= last;
                }
                else{
                    int luhnInt = last*2;
                    if(luhnInt>9){
                        luhnInt-=9;
                    }
                    sum+=luhnInt;
                }
                formattedCharList.remove(formattedCharList.size()-1);
            }
            return sum;

            
        }

    }
