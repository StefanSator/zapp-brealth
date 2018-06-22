
package com.example.stefansator.brealth.naehrstoffzentrale.apiobjects;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ENERC_KCAL",
    "FAT",
    "FASAT",
    "FAMS",
    "FAPU",
    "CHOCDF",
    "FIBTG",
    "SUGAR",
    "PROCNT",
    "NA",
    "CA",
    "MG",
    "K",
    "FE",
    "ZN",
    "P",
    "VITA_RAE",
    "VITC",
    "THIA",
    "RIBF",
    "NIA",
    "VITB6A",
    "FOLDFE",
    "FOLFD",
    "TOCPHA",
    "VITK1"
})
public class TotalNutrients {

    @SerializedName("ENERC_KCAL")
    private ENERCKCAL eNERCKCAL;
    @SerializedName("FAT")
    private FAT fAT;
    @SerializedName("FASAT")
    private FASAT fASAT;
    @SerializedName("FAMS")
    private FAMS fAMS;
    @SerializedName("FAPU")
    private FAPU fAPU;
    @SerializedName("CHOCDF")
    private CHOCDF cHOCDF;
    @SerializedName("FIBTG")
    private FIBTG fIBTG;
    @SerializedName("SUGAR")
    private SUGAR sUGAR;
    @SerializedName("PROCNT")
    private PROCNT pROCNT;
    @SerializedName("NA")
    private NA nA;
    @SerializedName("CA")
    private CA cA;
    @SerializedName("MG")
    private MG mG;
    @SerializedName("K")
    private K k;
    @SerializedName("FE")
    private FE fE;
    @SerializedName("ZN")
    private ZN zN;
    @SerializedName("P")
    private P p;
    @SerializedName("VITA_RAE")
    private VITARAE vITARAE;
    @SerializedName("VITC")
    private VITC vITC;
    @SerializedName("THIA")
    private THIA tHIA;
    @SerializedName("RIBF")
    private RIBF rIBF;
    @SerializedName("NIA")
    private NIA nIA;
    @SerializedName("VITB6A")
    private VITB6A vITB6A;
    @SerializedName("FOLDFE")
    private FOLDFE fOLDFE;
    @SerializedName("FOLFD")
    private FOLFD fOLFD;
    @SerializedName("TOCPHA")
    private TOCPHA tOCPHA;
    @SerializedName("VITK1")
    private VITK1 vITK1;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("ENERC_KCAL")
    public ENERCKCAL getENERCKCAL() {
        return eNERCKCAL;
    }

    @SerializedName("ENERC_KCAL")
    public void setENERCKCAL(ENERCKCAL eNERCKCAL) {
        this.eNERCKCAL = eNERCKCAL;
    }

    @SerializedName("FAT")
    public FAT getFAT() {
        return fAT;
    }

    @SerializedName("FAT")
    public void setFAT(FAT fAT) {
        this.fAT = fAT;
    }

    @SerializedName("FASAT")
    public FASAT getFASAT() {
        return fASAT;
    }

    @SerializedName("FASAT")
    public void setFASAT(FASAT fASAT) {
        this.fASAT = fASAT;
    }

    @SerializedName("FAMS")
    public FAMS getFAMS() {
        return fAMS;
    }

    @SerializedName("FAMS")
    public void setFAMS(FAMS fAMS) {
        this.fAMS = fAMS;
    }

    @SerializedName("FAPU")
    public FAPU getFAPU() {
        return fAPU;
    }

    @SerializedName("FAPU")
    public void setFAPU(FAPU fAPU) {
        this.fAPU = fAPU;
    }

    @SerializedName("CHOCDF")
    public CHOCDF getCHOCDF() {
        return cHOCDF;
    }

    @SerializedName("CHOCDF")
    public void setCHOCDF(CHOCDF cHOCDF) {
        this.cHOCDF = cHOCDF;
    }

    @SerializedName("FIBTG")
    public FIBTG getFIBTG() {
        return fIBTG;
    }

    @SerializedName("FIBTG")
    public void setFIBTG(FIBTG fIBTG) {
        this.fIBTG = fIBTG;
    }

    @SerializedName("SUGAR")
    public SUGAR getSUGAR() {
        return sUGAR;
    }

    @SerializedName("SUGAR")
    public void setSUGAR(SUGAR sUGAR) {
        this.sUGAR = sUGAR;
    }

    @SerializedName("PROCNT")
    public PROCNT getPROCNT() {
        return pROCNT;
    }

    @SerializedName("PROCNT")
    public void setPROCNT(PROCNT pROCNT) {
        this.pROCNT = pROCNT;
    }

    @SerializedName("NA")
    public NA getNA() {
        return nA;
    }

    @SerializedName("NA")
    public void setNA(NA nA) {
        this.nA = nA;
    }

    @SerializedName("CA")
    public CA getCA() {
        return cA;
    }

    @SerializedName("CA")
    public void setCA(CA cA) {
        this.cA = cA;
    }

    @SerializedName("MG")
    public MG getMG() {
        return mG;
    }

    @SerializedName("MG")
    public void setMG(MG mG) {
        this.mG = mG;
    }

    @SerializedName("K")
    public K getK() {
        return k;
    }

    @SerializedName("K")
    public void setK(K k) {
        this.k = k;
    }

    @SerializedName("FE")
    public FE getFE() {
        return fE;
    }

    @SerializedName("FE")
    public void setFE(FE fE) {
        this.fE = fE;
    }

    @SerializedName("ZN")
    public ZN getZN() {
        return zN;
    }

    @SerializedName("ZN")
    public void setZN(ZN zN) {
        this.zN = zN;
    }

    @SerializedName("P")
    public P getP() {
        return p;
    }

    @SerializedName("P")
    public void setP(P p) {
        this.p = p;
    }

    @SerializedName("VITA_RAE")
    public VITARAE getVITARAE() {
        return vITARAE;
    }

    @SerializedName("VITA_RAE")
    public void setVITARAE(VITARAE vITARAE) {
        this.vITARAE = vITARAE;
    }

    @SerializedName("VITC")
    public VITC getVITC() {
        return vITC;
    }

    @SerializedName("VITC")
    public void setVITC(VITC vITC) {
        this.vITC = vITC;
    }

    @SerializedName("THIA")
    public THIA getTHIA() {
        return tHIA;
    }

    @SerializedName("THIA")
    public void setTHIA(THIA tHIA) {
        this.tHIA = tHIA;
    }

    @SerializedName("RIBF")
    public RIBF getRIBF() {
        return rIBF;
    }

    @SerializedName("RIBF")
    public void setRIBF(RIBF rIBF) {
        this.rIBF = rIBF;
    }

    @SerializedName("NIA")
    public NIA getNIA() {
        return nIA;
    }

    @SerializedName("NIA")
    public void setNIA(NIA nIA) {
        this.nIA = nIA;
    }

    @SerializedName("VITB6A")
    public VITB6A getVITB6A() {
        return vITB6A;
    }

    @SerializedName("VITB6A")
    public void setVITB6A(VITB6A vITB6A) {
        this.vITB6A = vITB6A;
    }

    @SerializedName("FOLDFE")
    public FOLDFE getFOLDFE() {
        return fOLDFE;
    }

    @SerializedName("FOLDFE")
    public void setFOLDFE(FOLDFE fOLDFE) {
        this.fOLDFE = fOLDFE;
    }

    @SerializedName("FOLFD")
    public FOLFD getFOLFD() {
        return fOLFD;
    }

    @SerializedName("FOLFD")
    public void setFOLFD(FOLFD fOLFD) {
        this.fOLFD = fOLFD;
    }

    @SerializedName("TOCPHA")
    public TOCPHA getTOCPHA() {
        return tOCPHA;
    }

    @SerializedName("TOCPHA")
    public void setTOCPHA(TOCPHA tOCPHA) {
        this.tOCPHA = tOCPHA;
    }

    @SerializedName("VITK1")
    public VITK1 getVITK1() {
        return vITK1;
    }

    @SerializedName("VITK1")
    public void setVITK1(VITK1 vITK1) {
        this.vITK1 = vITK1;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
