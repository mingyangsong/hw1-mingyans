package genemention.Annotator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

/**
 * 
 * FillCollection is a collection which get the input file(hw1.in).
 * Use Scanner to get each line which is a sentence from the file and 
 * input each sentence into each CAS for future process.
 * 
 * @author mingyans
 * 
 */
public class FileCollection extends CollectionReader_ImplBase {

  public static final String PARAM_INPUTPATH = "InputPath";

  /*
   * New build a sentence ArrayList object, so that each sentence can be put into a CAS List.
   */
  private ArrayList<String> mSentence;

  private int mCurrentIndex;

  @Override
  public void initialize() throws ResourceInitializationException {
    /*
     * Input File Path, which is hw1.in. The path is defined in FileCollection.xml
     */
    File directory = new File(((String) getConfigParameterValue(PARAM_INPUTPATH)).trim());
    mCurrentIndex = 0;

    mSentence = new ArrayList<String>();
    addSentencesFromDir(directory);
  }

  /*
   * Read File and get each line by a Scanner
   */
  private void addSentencesFromDir(File dir) {
    Scanner sentence = null;
    try {
      sentence = new Scanner(dir);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    while (sentence.hasNext())
      mSentence.add(sentence.nextLine());
  }

  @Override
  public boolean hasNext() {
    return mCurrentIndex < mSentence.size();
  }

  @Override
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }

    /*
     * Get each sentence from Sentence ArrayList and input into line 
     */
    String line = mSentence.get(mCurrentIndex++);
    /*
     *  Put sentence into CAS
     */
    jcas.setDocumentText(line);
  }

  @Override
  public void close() throws IOException {
  }

  @Override
  public Progress[] getProgress() {
    return new Progress[] { new ProgressImpl(mCurrentIndex, mSentence.size(), Progress.ENTITIES) };
  }
}
