
package com.example.stefansator.brealth.health.naehrstoffzentrale.nahrungsmittel.apiclasses;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ENERC_KCAL",
    "FAT",
    "FASAT",
    "CHOCDF",
    "FIBTG",
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
    "TOCPHA",
    "VITK1"
})
public class TotalDaily {

    @SerializedName("ENERC_KCAL")
    private ENERCKCAL_ eNERCKCAL;
    @SerializedName("FAT")
    private FAT_ fAT;
    @SerializedName("FASAT")
    private FASAT_ fASAT;
    @SerializedName("CHOCDF")
    private CHOCDF_ cHOCDF;
    @SerializedName("FIBTG")
    private FIBTG_ fIBTG;
    @SerializedName("PROCNT")
    private PROCNT_ pROCNT;
    @SerializedName("NA")
    private NA_ nA;
    @SerializedName("CA")
    private CA_ cA;
    @SerializedName("MG")
    private MG_ mG;
    @SerializedName("K")
    private K_ k;
    @SerializedName("FE")
    private FE_ fE;
    @SerializedName("ZN")
    private ZN_ zN;
    @SerializedName("P")
    private P_ p;
    @SerializedName("VITA_RAE")
    private VITARAE_ vITARAE;
    @SerializedName("VITC")
    private VITC_ vITC;
    @SerializedName("THIA")
    private THIA_ tHIA;
    @SerializedName("RIBF")
    private RIBF_ rIBF;
    @SerializedName("NIA")
    private NIA_ nIA;
    @SerializedName("VITB6A")
    private VITB6A_ vITB6A;
    @SerializedName("FOLDFE")
    private FOLDFE_ fOLDFE;
    @SerializedName("TOCPHA")
    private TOCPHA_ tOCPHA;
    @SerializedName("VITK1")
    private VITK1_ vITK1;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("ENERC_KCAL")
    public ENERCKCAL_ getENERCKCAL() {
        return eNERCKCAL;
    }

    @SerializedName("ENERC_KCAL")
    public void setENERCKCAL(ENERCKCAL_ eNERCKCAL) {
        this.eNERCKCAL = eNERCKCAL;
    }

    @SerializedName("FAT")
    public FAT_ getFAT() {
        return fAT;
    }

    @SerializedName("FAT")
    public void setFAT(FAT_ fAT) {
        this.fAT = fAT;
    }

    @SerializedName("FASAT")
    public FASAT_ getFASAT() {
        return fASAT;
    }

    @SerializedName("FASAT")
    public void setFASAT(FASAT_ fASAT) {
        this.fASAT = fASAT;
    }

    @SerializedName("CHOCDF")
    public CHOCDF_ getCHOCDF() {
        return cHOCDF;
    }

    @SerializedName("CHOCDF")
    public void setCHOCDF(CHOCDF_ cHOCDF) {
        this.cHOCDF = cHOCDF;
    }

    @SerializedName("FIBTG")
    public FIBTG_ getFIBTG() {
        return fIBTG;
    }

    @SerializedName("FIBTG")
    public void setFIBTG(FIBTG_ fIBTG) {
        this.fIBTG = fIBTG;
    }

    @SerializedName("PROCNT")
    public PROCNT_ getPROCNT() {
        return pROCNT;
    }

    @SerializedName("PROCNT")
    public void setPROCNT(PROCNT_ pROCNT) {
        this.pROCNT = pROCNT;
    }

    @SerializedName("NA")
    public NA_ getNA() {
        return nA;
    }

    @SerializedName("NA")
    public void setNA(NA_ nA) {
        this.nA = nA;
    }

    @SerializedName("CA")
    public CA_ getCA() {
        return cA;
    }

    @SerializedName("CA")
    public void setCA(CA_ cA) {
        this.cA = cA;
    }

    @SerializedName("MG")
    public MG_ getMG() {
        return mG;
    }

    @SerializedName("MG")
    public void setMG(MG_ mG) {
        this.mG = mG;
    }

    @SerializedName("K")
    public K_ getK() {
        return k;
    }

    @SerializedName("K")
    public void setK(K_ k) {
        this.k = k;
    }

    @SerializedName("FE")
    public FE_ getFE() {
        return fE;
    }

    @SerializedName("FE")
    public void setFE(FE_ fE) {
        this.fE = fE;
    }

    @SerializedName("ZN")
    public ZN_ getZN() {
        return zN;
    }

    @SerializedName("ZN")
    public void setZN(ZN_ zN) {
        this.zN = zN;
    }

    @SerializedName("P")
    public P_ getP() {
        return p;
    }

    @SerializedName("P")
    public void setP(P_ p) {
        this.p = p;
    }

    @SerializedName("VITA_RAE")
    public VITARAE_ getVITARAE() {
        return vITARAE;
    }

    @SerializedName("VITA_RAE")
    public void setVITARAE(VITARAE_ vITARAE) {
        this.vITARAE = vITARAE;
    }

    @SerializedName("VITC")
    public VITC_ getVITC() {
        return vITC;
    }

    @SerializedName("VITC")
    public void setVITC(VITC_ vITC) {
        this.vITC = vITC;
    }

    @SerializedName("THIA")
    public THIA_ getTHIA() {
        return tHIA;
    }

    @SerializedName("THIA")
    public void setTHIA(THIA_ tHIA) {
        this.tHIA = tHIA;
    }

    @SerializedName("RIBF")
    public RIBF_ getRIBF() {
        return rIBF;
    }

    @SerializedName("RIBF")
    public void setRIBF(RIBF_ rIBF) {
        this.rIBF = rIBF;
    }

    @SerializedName("NIA")
    public NIA_ getNIA() {
        return nIA;
    }

    @SerializedName("NIA")
    public void setNIA(NIA_ nIA) {
        this.nIA = nIA;
    }

    @SerializedName("VITB6A")
    public VITB6A_ getVITB6A() {
        return vITB6A;
    }

    @SerializedName("VITB6A")
    public void setVITB6A(VITB6A_ vITB6A) {
        this.vITB6A = vITB6A;
    }

    @SerializedName("FOLDFE")
    public FOLDFE_ getFOLDFE() {
        return fOLDFE;
    }

    @SerializedName("FOLDFE")
    public void setFOLDFE(FOLDFE_ fOLDFE) {
        this.fOLDFE = fOLDFE;
    }

    @SerializedName("TOCPHA")
    public TOCPHA_ getTOCPHA() {
        return tOCPHA;
    }

    @SerializedName("TOCPHA")
    public void setTOCPHA(TOCPHA_ tOCPHA) {
        this.tOCPHA = tOCPHA;
    }

    @SerializedName("VITK1")
    public VITK1_ getVITK1() {
        return vITK1;
    }

    @SerializedName("VITK1")
    public void setVITK1(VITK1_ vITK1) {
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
