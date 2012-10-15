package genemention.annotator;

import genemention.type.GeneModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.collection.base_cpm.CasObjectProcessor;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;

public class AnnotationPrinter extends CasConsumer_ImplBase implements CasObjectProcessor {
  File outFile;

  FileWriter fileWriter;

  public AnnotationPrinter() {
  }

  @Override
  public void initialize() throws ResourceInitializationException {

    // extract configuration parameter settings
    String oPath = (String) getUimaContext().getConfigParameterValue("outputFile");

    // Output file should be specified in the descriptor
    if (oPath == null) {
      throw new ResourceInitializationException(
              ResourceInitializationException.CONFIG_SETTING_ABSENT, new Object[] { "outputFile" });
    }
    // If specified output directory does not exist, try to create it
    outFile = new File(oPath.trim());
    if (outFile.getParentFile() != null && !outFile.getParentFile().exists()) {
      if (!outFile.getParentFile().mkdirs())
        throw new ResourceInitializationException(
                ResourceInitializationException.RESOURCE_DATA_NOT_VALID, new Object[] { oPath,
                    "outputFile" });
    }
    try {
      fileWriter = new FileWriter(outFile);
    } catch (IOException e) {
      throw new ResourceInitializationException(e);
    }
  }

  @Override
  public synchronized void processCas(CAS aCAS) throws ResourceProcessException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    Iterator<Annotation> it = jcas.getAnnotationIndex(GeneModel.type).iterator();
    while (it.hasNext()) {
      // ///编辑自己的输出格式
      GeneModel annotation = (GeneModel) it.next();
      String input = annotation.getSentenceID();

      int begin = annotation.getBegin();
      int end = annotation.getEnd();
      String noun = annotation.getGeneMention();

      // 定义输出格式
      try {
        fileWriter.write(input + "|" + begin + " " + end + "|" + noun + "\n\r\n\r");
        fileWriter.flush();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  @Override
  public void batchProcessComplete(ProcessTrace aTrace) throws ResourceProcessException,
          IOException {
    // nothing to do in this case as AnnotationPrinter doesnot do
    // anything cumulatively
  }

  @Override
  public void collectionProcessComplete(ProcessTrace aTrace) throws ResourceProcessException,
          IOException {
    if (fileWriter != null) {
      fileWriter.close();
    }
  }

  @Override
  public void reconfigure() throws ResourceConfigurationException {
    super.reconfigure();
    // extract configuration parameter settings
    String oPath = (String) getUimaContext().getConfigParameterValue("outputFile");
    File oFile = new File(oPath.trim());
    // if output file has changed, close exiting file and open new
    if (!oFile.equals(this.outFile)) {
      this.outFile = oFile;
      try {
        fileWriter.close();

        // If specified output directory does not exist, try to create it
        if (oFile.getParentFile() != null && !oFile.getParentFile().exists()) {
          if (!oFile.getParentFile().mkdirs())
            throw new ResourceConfigurationException(
                    ResourceInitializationException.RESOURCE_DATA_NOT_VALID, new Object[] { oPath,
                        "outputFile" });
        }
        fileWriter = new FileWriter(oFile);
      } catch (IOException e) {
        throw new ResourceConfigurationException();
      }
    }
  }

  @Override
  public void destroy() {
    if (fileWriter != null) {
      try {
        fileWriter.close();
      } catch (IOException e) {
        // ignore IOException on destroy
      }
    }
  }

}
