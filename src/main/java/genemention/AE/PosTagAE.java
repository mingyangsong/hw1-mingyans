package genemention.AE;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import genemention.Type.GeneDoc;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

/**
 * This is for class example PosTagNamedEntityRecognizer. This annotator will not be used in final
 * program.
 * 
 * @author mingyans
 * 
 */
public class PosTagAE extends JCasAnnotator_ImplBase {
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    JCas jcas = aJCas;
    String input = jcas.getDocumentText();
    String ID = null;

    // 正则表达式
    Pattern SentenceIDPattern = Pattern.compile("P[0-9]{8}\\w{5}");

    Matcher matcher = SentenceIDPattern.matcher(input);
    if (matcher.find())
      ID = matcher.group(0);
    input = input.replace(ID, "");

    // ////BaseLine
    Map<Integer, Integer> begin2end = new HashMap<Integer, Integer>();
    PosTagNamedEntityRecognizer NER = null;
    try {
      NER = new PosTagNamedEntityRecognizer();
    } catch (ResourceInitializationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    begin2end = NER.getGeneSpans(input);

    Set<Entry<Integer, Integer>> allSet = begin2end.entrySet();
    Iterator<Entry<Integer, Integer>> iter = allSet.iterator();
    while (iter.hasNext()) {
      Entry<Integer, Integer> me = iter.next();

      GeneDoc annotation = new GeneDoc(aJCas);
      annotation.setSentenceID(ID);
      annotation.setGeneText(input.substring(me.getKey(), me.getValue()));
      annotation.setBegin(me.getKey());
      annotation.setEnd(me.getValue());
      annotation.addToIndexes();
    }
  }
}
