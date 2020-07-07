package models;

public class FacilityModel {

    private String name;
    private String facilityAddress;
    private String zipCode;
    private String pmName;
    private String pmPhone;
    private String pmEmail;
    private String typeOfConstruction;
    private String companyId;
    private String unitName;
    private String groupA;
    private String groupB;

    public String getPmEmail() {
        return pmEmail;
    }

    public void setPmEmail(String pmEmail) {
        this.pmEmail = pmEmail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    public String getPmPhone() {
        return pmPhone;
    }

    public void setPmPhone(String pmPhone) {
        this.pmPhone = pmPhone;
    }

    public String getTypeOfConstruction() {
        return typeOfConstruction;
    }

    public void setTypeOfConstruction(String typeOfConstruction) {
        this.typeOfConstruction = typeOfConstruction;
    }

    public String getName() {
        return name;
    }

    public void setName(String facilityName) {
        this.name = facilityName;
    }

    public String getFacilityAddress() {
        return facilityAddress;
    }

    public void setFacilityAddress(String facilityaddress) {
        this.facilityAddress = facilityaddress;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getGroupA(boolean add) {
        return groupA;
    }

    public void setGroupA(String groupA) {
        this.groupA = groupA;
    }

    public String getGroupB(boolean add) {
        return groupB;
    }

    public void setGroupB(String groupB) {
        this.groupB = groupB;
    }
}
