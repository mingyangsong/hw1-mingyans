package genemention.AE;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import genemention.Type.GeneDoc;
import genemention.Type.GeneSentence;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

/**
 * 
 * GeneTagAe is used to get Gene Tag from each Gene Text. It use Lingpipe HMM model. There are two
 * inputs: File input is HMM model path, and TypeSystem input is GeneDoc. Output is TypeSystem
 * GeneSentence.
 * 
 * @author mingyans
 * 
 */
public class GeneTagAE extends JCasAnnotator_ImplBase {
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    JCas jcas = aJCas;

    String ModelFile = (String) getContext().getConfigParameterValue("ModelFile");
    /*
     * Get all the text from TypeSystem GeneDoc to spilt Gene Tag. Then input into TypeSystem
     * GeneSentence for future output.
     */
    Iterator<Annotation> it1 = jcas.getAnnotationIndex(GeneDoc.type).iterator();
    while (it1.hasNext()) {

      GeneDoc annotation1 = (GeneDoc) it1.next();
      String Sentence = annotation1.getGeneText();

      String ID = annotation1.getSentenceID();
      /*
       * Lingpipe to get GeneTag
       */
      ConfidenceChunker chunker = null;

      try {
        chunker = (ConfidenceChunker) AbstractExternalizable.readObject(new File(ModelFile));
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      char[] cs = Sentence.toCharArray();
      Iterator<Chunk> it2 = chunker.nBestChunks(cs, 0, cs.length, 20);
      while (it2.hasNext()) {
        Chunk chunk = it2.next();
        /*
         * Choose a threshold to leave the tag which is not Gene Tag.
         */
        if (Math.pow(2.0, chunk.score()) < 0.75)
          continue;
        /*
         * Input the result into TypeSystem GeneSentence
         */
        GeneSentence annotation2 = new GeneSentence(jcas);
        annotation2.setSentenceID(ID);
        annotation2.setBegin(chunk.start());
        annotation2.setEnd(chunk.end());
        annotation2.setGeneMention(Sentence.substring(chunk.start(), chunk.end()));
        annotation2.addToIndexes();
      }
    }
  }
}
