import java.util.ArrayList;
import java.util.List;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> rnaList = new ArrayList<>();
        List<String> codonList = new ArrayList<>();

        if (rnaSequence.length() < 3 && rnaSequence.length() > 0) {
            throw new IllegalArgumentException("Invalid codon");
        }

        // rna "UUC"
        for (int i = 0; i < rnaSequence.length(); i += 3) {
            String trimmedSequence = "";
            if(rnaSequence.length()%3==0){
                rnaList.add(rnaSequence.substring(i, i + 3));
            }
            //4 - 1 = 3 AUG A 
            //5 - 2 = 3 AUG AU

            else if(rnaSequence.length()%3==1 && 
            codons(rnaSequence.substring((rnaSequence.length()-3),rnaSequence.length()-1))=="STOP"){
                trimmedSequence = rnaSequence.substring(0,rnaSequence.length()-1);
                rnaList.add(trimmedSequence.substring(i, i + 3));
            }

            else if(rnaSequence.length()%3==2 && 
            codons(rnaSequence.substring((rnaSequence.length()-4),rnaSequence.length()-2))=="STOP"){
                trimmedSequence = rnaSequence.substring(0,rnaSequence.length()-2);
                rnaList.add(trimmedSequence.substring(i, i + 3));
            }

                else{
                 throw new IllegalArgumentException("Invalid codon");
            }
            
            
        }
        // "UUC" -> "Methionine"
        try {
            for (int i = 0; i < rnaList.size(); i++) {
                if (codons(rnaList.get(i)) == "STOP") {
                    break;

                }
                else if(rnaList.get(i).length()<3){
                    break;
                }
                 else {
                    codonList.add(codons(rnaList.get(i)));
                }

            }

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid codon");
        }

        return codonList;
    }

    String codons(String codon) {

        switch (codon) {

            case "AUG" -> {
                return "Methionine";
            }
            case "UUU", "UUC" -> {
                return "Phenylalanine";
            }
            case "UUA", "UUG" -> {
                return "Leucine";
            }
            case "UCU", "UCC", "UCA", "UCG" -> {
                return "Serine";
            }
            case "UAU", "UAC" -> {
                return "Tyrosine";
            }
            case "UGU", "UGC" -> {
                return "Cysteine";
            }
            case "UGG" -> {
                return "Tryptophan";
            }
            case "UAA", "UAG", "UGA" -> {
                return "STOP";
            }
            default -> {
                throw new IllegalArgumentException("Invalid codon");
            }

        }
    }

}
