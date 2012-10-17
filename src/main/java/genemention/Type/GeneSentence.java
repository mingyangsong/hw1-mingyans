

/* First created by JCasGen Wed Oct 17 12:08:18 EDT 2012 */
package genemention.Type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Oct 17 12:08:18 EDT 2012
 * XML source: C:/Users/s/Desktop/11791HomeWork/hw1-mingyans/src/main/resources/descriptors/ner/GeneMentionType.xml
 * @generated */
public class GeneSentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeneSentence.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected GeneSentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public GeneSentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public GeneSentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public GeneSentence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: SentenceID

  /** getter for SentenceID - gets 
   * @generated */
  public String getSentenceID() {
    if (GeneSentence_Type.featOkTst && ((GeneSentence_Type)jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "genemention.Type.GeneSentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneSentence_Type)jcasType).casFeatCode_SentenceID);}
    
  /** setter for SentenceID - sets  
   * @generated */
  public void setSentenceID(String v) {
    if (GeneSentence_Type.featOkTst && ((GeneSentence_Type)jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "genemention.Type.GeneSentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneSentence_Type)jcasType).casFeatCode_SentenceID, v);}    
   
    
  //*--------------*
  //* Feature: GeneMention

  /** getter for GeneMention - gets 
   * @generated */
  public String getGeneMention() {
    if (GeneSentence_Type.featOkTst && ((GeneSentence_Type)jcasType).casFeat_GeneMention == null)
      jcasType.jcas.throwFeatMissing("GeneMention", "genemention.Type.GeneSentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneSentence_Type)jcasType).casFeatCode_GeneMention);}
    
  /** setter for GeneMention - sets  
   * @generated */
  public void setGeneMention(String v) {
    if (GeneSentence_Type.featOkTst && ((GeneSentence_Type)jcasType).casFeat_GeneMention == null)
      jcasType.jcas.throwFeatMissing("GeneMention", "genemention.Type.GeneSentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneSentence_Type)jcasType).casFeatCode_GeneMention, v);}    
  }

    