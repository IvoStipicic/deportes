package com.crud.deportes.utils.response;

public class ApiResponse<T> {

    private String glosa;
    private String detailMsg;
    private transient T data;

    public ApiResponse(String glosa, String detailMsg) {
        this.glosa = glosa;
        this.detailMsg = detailMsg;
    }

    public ApiResponse(String glosa, String detailMsg, T data) {
        this.glosa = glosa;
        this.detailMsg = detailMsg;
        this.data = data;
    }

    public ApiResponse() {
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "glosa='" + glosa + '\'' +
                ", detailMsg='" + detailMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
