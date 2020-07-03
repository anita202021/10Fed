
package models.apiModel;


import com.google.gson.annotations.SerializedName;

public class JwtToken {

    @SerializedName("aud")
    private String mAud;
    @SerializedName("company_id")
    private String mCompanyId;
    @SerializedName("exp")
    private Long mExp;
    @SerializedName("given_name")
    private String mGivenName;
    @SerializedName("iat")
    private Long mIat;
    @SerializedName("iss")
    private String mIss;
    @SerializedName("nameid")
    private String mNameid;
    @SerializedName("nbf")
    private Long mNbf;
    @SerializedName("profile_photo")
    private String mProfilePhoto;
    @SerializedName("role")
    private String mRole;
    @SerializedName("unique_name")
    private String mUniqueName;

    public String getAud() {
        return mAud;
    }

    public void setAud(String aud) {
        mAud = aud;
    }

    public String getCompanyId() {
        return mCompanyId;
    }

    public void setCompanyId(String companyId) {
        mCompanyId = companyId;
    }

    public Long getExp() {
        return mExp;
    }

    public void setExp(Long exp) {
        mExp = exp;
    }

    public String getGivenName() {
        return mGivenName;
    }

    public void setGivenName(String givenName) {
        mGivenName = givenName;
    }

    public Long getIat() {
        return mIat;
    }

    public void setIat(Long iat) {
        mIat = iat;
    }

    public String getIss() {
        return mIss;
    }

    public void setIss(String iss) {
        mIss = iss;
    }

    public String getNameid() {
        return mNameid;
    }

    public void setNameid(String nameid) {
        mNameid = nameid;
    }

    public Long getNbf() {
        return mNbf;
    }

    public void setNbf(Long nbf) {
        mNbf = nbf;
    }

    public String getProfilePhoto() {
        return mProfilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        mProfilePhoto = profilePhoto;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }

    public String getUniqueName() {
        return mUniqueName;
    }

    public void setUniqueName(String uniqueName) {
        mUniqueName = uniqueName;
    }

}
