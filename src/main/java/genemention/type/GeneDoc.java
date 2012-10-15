
/* First created by JCasGen Sun Oct 14 15:57:53 EDT 2012 */
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
public class GeneDoc extends Annotation {
  /**
   * @generated
   * @ordered
   */
  @SuppressWarnings("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeneDoc.class);

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
  protected GeneDoc() {/* intentionally empty block */
  }

  /**
   * Internal - constructor used by generator
   * 
   * @generated
   */
  public GeneDoc(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }

  /** @generated */
  public GeneDoc(JCas jcas) {
    super(jcas);
    readObject();
  }

  /** @generated */
  public GeneDoc(JCas jcas, int begin, int end) {
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
    if (GeneDoc_Type.featOkTst && ((GeneDoc_Type) jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "genemention.type.GeneDoc");
    return jcasType.ll_cas
            .ll_getStringValue(addr, ((GeneDoc_Type) jcasType).casFeatCode_SentenceID);
  }

  /**
   * setter for SentenceID - sets
   * 
   * @generated
   */
  public void setSentenceID(String v) {
    if (GeneDoc_Type.featOkTst && ((GeneDoc_Type) jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "genemention.type.GeneDoc");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneDoc_Type) jcasType).casFeatCode_SentenceID, v);
  }

  // *--------------*
  // * Feature: GeneTag

  /**
   * getter for GeneTag - gets
   * 
   * @generated
   */
  public String getGeneTag() {
    if (GeneDoc_Type.featOkTst && ((GeneDoc_Type) jcasType).casFeat_GeneTag == null)
      jcasType.jcas.throwFeatMissing("GeneTag", "genemention.type.GeneDoc");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneDoc_Type) jcasType).casFeatCode_GeneTag);
  }

  /**
   * setter for GeneTag - sets
   * 
   * @generated
   */
  public void setGeneTag(String v) {
    if (GeneDoc_Type.featOkTst && ((GeneDoc_Type) jcasType).casFeat_GeneTag == null)
      jcasType.jcas.throwFeatMissing("GeneTag", "genemention.type.GeneDoc");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneDoc_Type) jcasType).casFeatCode_GeneTag, v);
  }
}
