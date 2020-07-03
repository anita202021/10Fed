package models.apiModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class VendorModel {

    private String companyId;
    private String vendorTypeId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String bankAccount;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }


    public String getVendorTypeId() {
        return vendorTypeId;
    }

    public void setVendorTypeId(String vendorTypeId) {
        this.vendorTypeId = vendorTypeId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }


}