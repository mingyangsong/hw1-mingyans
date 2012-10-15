package genemention.AE;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import genemention.type.GeneModel;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

public class ModelAE extends JCasAnnotator_ImplBase {
  // *************************************************************
  // * process *
  // *************************************************************
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    JCas jcas = aJCas;

    String Sentence = jcas.getDocumentText();
    String ID = null;
    // 正则表达式分离句子ID
    Pattern SentenceIDPattern = Pattern.compile("P[0-9]{8}\\w{5}");

    Matcher matcher = SentenceIDPattern.matcher(Sentence);
    if (matcher.find())
      ID = matcher.group(0);
    Sentence = Sentence.replace(ID, "");

    //lingpipe分析GeneTag
    ConfidenceChunker chunker = null;

    try {
      chunker = (ConfidenceChunker) AbstractExternalizable.readObject(new File(
              ".\\src\\main\\resources\\ne-en-bio-genetag.HmmChunker"));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    char[] cs = Sentence.toCharArray();
    Iterator<Chunk> it = chunker.nBestChunks(cs, 0, cs.length, 20);
    while (it.hasNext()) {
      Chunk chunk = it.next();
      if (Math.pow(2.0, chunk.score()) < 0.6)
        continue;
      GeneModel annotation = new GeneModel(jcas);
      annotation.setSentenceID(ID);
      annotation.setBegin(chunk.start());
      annotation.setEnd(chunk.end());
      annotation.setGeneMention(Sentence.substring(chunk.start(), chunk.end()));
      annotation.addToIndexes();
    }
  }
}
