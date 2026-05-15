import java.util.ArrayList;
import java.util.List;

class Bob {
    List<String> sentence = new ArrayList<>();
    List<String> withoutWhiteSpace = new ArrayList<>();

    String hey(String input) {
        listCreator(input);
        if (fullCapsSentence(sentence)
                && hasQuestionMarkAtEnd(sentence)) {
            return "Calm down, I know what I'm doing!";
        }

        else if (hasQuestionMarkAtEnd((withoutWhiteSpace))) {
            return "Sure.";
        }

        else if (fullCapsSentence(sentence)) {
            return "Whoa, chill out!";
        }

        else if (withoutWhiteSpace.isEmpty()) {
            return "Fine. Be that way!";
        } else {
            return "Whatever.";
        }
    }

    void listCreator(String input) {

        for (int i = 0; i < input.length(); i++) {
            sentence.add(input.substring(i, i + 1));
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isWhitespace(c)) {
                withoutWhiteSpace.add(String.valueOf(c));
            }
        }

    }

    boolean isUpperCaseLetter(String s) {
        return s.matches("[A-Z]") ? true : false;
    }

    boolean isLowerCaseLetter(String s) {
        return s.matches("[a-z]") ? true : false;
    }

    boolean fullCapsSentence(List<String> sentence) {
        boolean sentenceHasCapitalLetter = false;
        boolean sentenceHasLowerCaseLetter = false;
        for (int i = 0; i < sentence.size(); i++) {
            if (isUpperCaseLetter(sentence.get(i))) {
                sentenceHasCapitalLetter = true;
            }
            if (isLowerCaseLetter(sentence.get(i))) {
                sentenceHasLowerCaseLetter = true;
            }

        }
        return sentenceHasCapitalLetter
                && !sentenceHasLowerCaseLetter ? true : false;

    }

    boolean hasQuestionMarkAtEnd(List<String> sentence) {
        boolean sentenceIsQuestion = false;
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence.getLast().contains("?")) {
                sentenceIsQuestion = true;
            }
        }
        return sentenceIsQuestion ? true : false;
    }

}