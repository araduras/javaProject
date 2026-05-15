    import java.util.ArrayList;
    import java.util.List;

    class LargestSeriesProductCalculator {
        List<Long> integerList = new ArrayList<>();

        LargestSeriesProductCalculator(String inputNumber) {
            for (int i = 0; i < inputNumber.length(); i++) {
                if (!inputNumber.substring(i, i + 1)
                        .matches("\\d")) {
                    throw new IllegalArgumentException("String to search may only contain digits.");
                }
                integerList.add(Long.valueOf(inputNumber.substring(i, i + 1)));
            }

        }

        long calculateLargestProductForSeriesLength(int numberOfDigits) {
            long returnValue = 0;

            if (numberOfDigits > integerList.size()) {
                throw new IllegalArgumentException(
                        "Series length must be less than or equal to the length of the string to search.");
            }
            if (numberOfDigits < 0){throw new IllegalArgumentException("Series length must be non-negative.");}
            
                /// 1234 2
                for (int i = 0; i <= integerList.size() - numberOfDigits; i++) {
                    if (returnValue < tempIntCalc(i, numberOfDigits)) {
                        returnValue = tempIntCalc(i, numberOfDigits);
                    }

                }
            

                
            return returnValue;
        }

        // 1234 2
        long tempIntCalc(int where, long length) {
            long start = integerList.get(where);
            for (int i = 1; i < length; i++) {

                start = start * integerList.get(where + i);
            }
            return start;

        }
    }
