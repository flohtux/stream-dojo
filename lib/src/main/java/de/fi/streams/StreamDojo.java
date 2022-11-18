package de.fi.streams;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDojo implements IStreamDojo {

    @Override
    public Stream<String> streamOfNames() {
        return List.of("Homer Simpson", "Bart Simpson", "Lisa Simpson").stream();
    }

    @Override
    public IntStream streamOfInts(int... i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Integer> listOfPowersOfTwo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String findByName(List<String> names, String nameToFind) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean containsName(List<String> names, String nameToFind) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsNamePart(List<String> names, String namePartToFind) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsKontoNummer_LambdaFunction(List<Konto> konten, Long kontoNrToFind) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsKontoNummer_MethodReference(List<Konto> konten, Long kontoNrToFind) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<String> collectKontoInhaber(List<Konto> konten) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> collectKontoInhaberSorted(List<Konto> konten) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String collectKontoInhaberAsString(List<Konto> konten) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Konto> collectUeberzogeneKonten(List<Konto> konten) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Konto> collectUeberzogeneKontenSorted(List<Konto> konten) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double computeAnzahlUnterkonten(List<Konto> konten) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public BigDecimal computeSummeSaldo(List<Konto> konten) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BigDecimal computeSummeSaldoParallel(List<Konto> konten) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BigDecimal computeSummeSaldoNichtUeberzogene(List<Konto> konten) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BigDecimal computeSummeSaldoNichtUeberzogeneMitUnterkonten(List<Konto> konten) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, List<Konto>> collectKontenZuPersonen(List<Konto> konten) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
