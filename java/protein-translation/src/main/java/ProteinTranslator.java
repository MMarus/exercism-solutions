
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProteinTranslator {

    private static final HashSet<String> stopCodons = Stream.of("UAA", "UAG", "UGA").collect(Collectors.toCollection(HashSet::new));
    private static final HashMap<String, String> codons;
    static {
        codons = new HashMap<>();
        codons.put("AUG", "Methionine");
        codons.put("UUU", "Phenylalanine"); codons.put("UUC", "Phenylalanine");
        codons.put("UUA", "Leucine"); codons.put("UUG", "Leucine");
        codons.put("UCU", "Serine");codons.put("UCC", "Serine");codons.put("UCA", "Serine");codons.put("UCG", "Serine");
        codons.put("UAU", "Tyrosine");codons.put("UAC", "Tyrosine");
        codons.put("UGU", "Cysteine");codons.put("UGC", "Cysteine");
        codons.put("UGG", "Tryptophan");
        codons.put("UAA", "STOP");codons.put("UAG", "STOP");codons.put("UGA", "STOP");
    }

    //    AUG	Methionine
    //    UUU, UUC	Phenylalanine
    //    UUA, UUG	Leucine
    //    UCU, UCC, UCA, UCG	Serine
    //    UAU, UAC	Tyrosine
    //    UGU, UGC	Cysteine
    //    UGG	Tryptophan
    //    UAA, UAG, UGA	STOP


    public List<String> translate(String rnaSequence) {
        final ArrayList<String> aminoAcids = new ArrayList<>();

        if (rnaSequence.length() % 3 != 0)
            throw new InvalidParameterException("The lenght of RNA sequence must be divisible by 3");

        for(int i = 3; i <= rnaSequence.length(); i+=3) {
            String codon = rnaSequence.substring(i-3, i);
            String aminoAcid = codons.get(codon);

            if (aminoAcid == null || aminoAcid.isEmpty())  {
                throw new InvalidParameterException("Unrecognised codon!");
            }
            if(aminoAcid.equals("STOP")) {
                return aminoAcids;
            }
            aminoAcids.add(aminoAcid);
        }

        return aminoAcids;
    }
}