package com.safeway.safeway.models.response;

import com.google.gson.annotations.SerializedName;

public class ApiResponse<T> {
    @SerializedName("response_data")
    private T responseData;
    @SerializedName("response_code")
    private String responseCode;
    @SerializedName("response_message")
    private String responseMessage;
    @SerializedName("response_status")
    private String responseStatus;

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseStatus() {
        return responseStatus;
    }
}
