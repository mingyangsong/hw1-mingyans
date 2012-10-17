package genemention.AE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import genemention.Type.GeneDoc;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

/**
 * SentenceAE is used to split SentenceID from the sentence in the CAS.
 * Then input these ID and text into TypeSystem GeneDoc for future process.
 * 
 * @author mingyans
 */
public class SentenceAE extends JCasAnnotator_ImplBase {
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    JCas jcas = aJCas;

    String Sentence = jcas.getDocumentText();
    String ID = null;
    // Regular Express to split SentenceID from the Sentence
    Pattern SentenceIDPattern = Pattern.compile("P[0-9]{8}\\w{5}");

    Matcher matcher = SentenceIDPattern.matcher(Sentence);
    if (matcher.find())
      ID = matcher.group(0);
    Sentence = Sentence.replace(ID, "");

    // Input SentenceID and Sentence text into TypeSystem GeneDoc
    GeneDoc annotation = new GeneDoc(jcas);
    annotation.setSentenceID(ID);
    annotation.setGeneText(Sentence);
    annotation.addToIndexes();
  }
}
