/* First created by JCasGen Mon Oct 15 13:59:44 EDT 2012 */
package genemention.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/**
 * Updated by JCasGen Mon Oct 15 13:59:46 EDT 2012
 * 
 * @generated
 */
public class GeneModel_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {
    return fsGenerator;
  }

  /** @generated */
  private final FSGenerator fsGenerator = new FSGenerator() {
    @Override
    public FeatureStructure createFS(int addr, CASImpl cas) {
      if (GeneModel_Type.this.useExistingInstance) {
        // Return eq fs instance if already created
        FeatureStructure fs = GeneModel_Type.this.jcas.getJfsFromCaddr(addr);
        if (null == fs) {
          fs = new GeneModel(addr, GeneModel_Type.this);
          GeneModel_Type.this.jcas.putJfsFromCaddr(addr, fs);
          return fs;
        }
        return fs;
      } else
        return new GeneModel(addr, GeneModel_Type.this);
    }
  };

  /** @generated */
  @SuppressWarnings("hiding")
  public final static int typeIndexID = GeneModel.typeIndexID;

  /**
   * @generated
   * @modifiable
   */
  @SuppressWarnings("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("genemention.type.GeneModel");

  /** @generated */
  final Feature casFeat_SentenceID;

  /** @generated */
  final int casFeatCode_SentenceID;

  /** @generated */
  public String getSentenceID(int addr) {
    if (featOkTst && casFeat_SentenceID == null)
      jcas.throwFeatMissing("SentenceID", "genemention.type.GeneModel");
    return ll_cas.ll_getStringValue(addr, casFeatCode_SentenceID);
  }

  /** @generated */
  public void setSentenceID(int addr, String v) {
    if (featOkTst && casFeat_SentenceID == null)
      jcas.throwFeatMissing("SentenceID", "genemention.type.GeneModel");
    ll_cas.ll_setStringValue(addr, casFeatCode_SentenceID, v);
  }

  /** @generated */
  final Feature casFeat_GeneMention;

  /** @generated */
  final int casFeatCode_GeneMention;

  /** @generated */
  public String getGeneMention(int addr) {
    if (featOkTst && casFeat_GeneMention == null)
      jcas.throwFeatMissing("GeneMention", "genemention.type.GeneModel");
    return ll_cas.ll_getStringValue(addr, casFeatCode_GeneMention);
  }

  /** @generated */
  public void setGeneMention(int addr, String v) {
    if (featOkTst && casFeat_GeneMention == null)
      jcas.throwFeatMissing("GeneMention", "genemention.type.GeneModel");
    ll_cas.ll_setStringValue(addr, casFeatCode_GeneMention, v);
  }

  /**
   * initialize variables to correspond with Cas Type and Features
   * 
   * @generated
   */
  public GeneModel_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl) this.casType, getFSGenerator());

    casFeat_SentenceID = jcas.getRequiredFeatureDE(casType, "SentenceID", "uima.cas.String",
            featOkTst);
    casFeatCode_SentenceID = (null == casFeat_SentenceID) ? JCas.INVALID_FEATURE_CODE
            : ((FeatureImpl) casFeat_SentenceID).getCode();

    casFeat_GeneMention = jcas.getRequiredFeatureDE(casType, "GeneMention", "uima.cas.String",
            featOkTst);
    casFeatCode_GeneMention = (null == casFeat_GeneMention) ? JCas.INVALID_FEATURE_CODE
            : ((FeatureImpl) casFeat_GeneMention).getCode();

  }
}
