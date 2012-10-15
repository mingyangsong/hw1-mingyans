
/* First created by JCasGen Mon Oct 15 13:59:44 EDT 2012 */
package genemention.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;

/**
 * Updated by JCasGen Mon Oct 15 13:59:46 EDT 2012 XML source:
 * C:/Users/s/Desktop/11791HomeWork/hw1-mingyans/src/main/resources/Descriptor/GeneMentionType.xml
 * 
 * @generated
 */
public class GeneModel extends Annotation {
  /**
   * @generated
   * @ordered
   */
  @SuppressWarnings("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeneModel.class);

  /**
   * @generated
   * @ordered
   */
  @SuppressWarnings("hiding")
  public final static int type = typeIndexID;

  /** @generated */
  @Override
  public int getTypeIndexID() {
    return typeIndexID;
  }

  /**
   * Never called. Disable default constructor
   * 
   * @generated
   */
  protected GeneModel() {/* intentionally empty block */
  }

  /**
   * Internal - constructor used by generator
   * 
   * @generated
   */
  public GeneModel(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }

  /** @generated */
  public GeneModel(JCas jcas) {
    super(jcas);
    readObject();
  }

  /** @generated */
  public GeneModel(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }

  /**
   * <!-- begin-user-doc --> Write your own initialization here <!-- end-user-doc -->
   * 
   * @generated modifiable
   */
  private void readObject() {/* default - does nothing empty block */
  }

  // *--------------*
  // * Feature: SentenceID

  /**
   * getter for SentenceID - gets
   * 
   * @generated
   */
  public String getSentenceID() {
    if (GeneModel_Type.featOkTst && ((GeneModel_Type) jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "genemention.type.GeneModel");
    return jcasType.ll_cas.ll_getStringValue(addr,
            ((GeneModel_Type) jcasType).casFeatCode_SentenceID);
  }

  /**
   * setter for SentenceID - sets
   * 
   * @generated
   */
  public void setSentenceID(String v) {
    if (GeneModel_Type.featOkTst && ((GeneModel_Type) jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "genemention.type.GeneModel");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneModel_Type) jcasType).casFeatCode_SentenceID, v);
  }

  // *--------------*
  // * Feature: GeneMention

  /**
   * getter for GeneMention - gets
   * 
   * @generated
   */
  public String getGeneMention() {
    if (GeneModel_Type.featOkTst && ((GeneModel_Type) jcasType).casFeat_GeneMention == null)
      jcasType.jcas.throwFeatMissing("GeneMention", "genemention.type.GeneModel");
    return jcasType.ll_cas.ll_getStringValue(addr,
            ((GeneModel_Type) jcasType).casFeatCode_GeneMention);
  }

  /**
   * setter for GeneMention - sets
   * 
   * @generated
   */
  public void setGeneMention(String v) {
    if (GeneModel_Type.featOkTst && ((GeneModel_Type) jcasType).casFeat_GeneMention == null)
      jcasType.jcas.throwFeatMissing("GeneMention", "genemention.type.GeneModel");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneModel_Type) jcasType).casFeatCode_GeneMention, v);
  }
}
