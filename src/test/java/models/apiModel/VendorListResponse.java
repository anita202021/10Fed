
package models.apiModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class VendorListResponse {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("draw")
    private Long mDraw;
    @SerializedName("error")
    private String mError;
    @SerializedName("recordsFiltered")
    private Long mRecordsFiltered;
    @SerializedName("recordsTotal")
    private Long mRecordsTotal;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

    public Long getDraw() {
        return mDraw;
    }

    public void setDraw(Long draw) {
        mDraw = draw;
    }

    public String getError() {
        return mError;
    }

    public void setError(String error) {
        mError = error;
    }

    public Long getRecordsFiltered() {
        return mRecordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        mRecordsFiltered = recordsFiltered;
    }

    public Long getRecordsTotal() {
        return mRecordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        mRecordsTotal = recordsTotal;
    }

}
