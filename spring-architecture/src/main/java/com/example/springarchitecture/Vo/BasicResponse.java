package com.example.springarchitecture.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BasicResponse {
    private String code;
    private String msg;
    private String errorMsg = "";
    private Object data;
    private long timestamp;

    public BasicResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public BasicResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public BasicResponse setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public BasicResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public BasicResponse setTimestamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public static BasicResponse ok() {
        BasicResponse response = new BasicResponse();
        return response.setCode("200")
            .setTimestamp()
            .setMsg("successful");
    }

    public static BasicResponse badRequest(String errorMsg) {
        BasicResponse response = new BasicResponse();
        return response.setCode("400")
            .setTimestamp()
            .setMsg("bad request")
            .setErrorMsg(errorMsg);
    }

    public static BasicResponse systemError(String errorMsg) {
        BasicResponse response = new BasicResponse();
        return response.setCode("500")
            .setTimestamp()
            .setMsg("system error")
            .setErrorMsg(errorMsg);
    }

    public static BasicResponse notFound() {
        BasicResponse response = new BasicResponse();
        return response.setCode("404")
            .setTimestamp()
            .setMsg("not found.");
    }

    public static BasicResponse dataDuplicate() {
        BasicResponse response = new BasicResponse();
        return response.setCode("409")
            .setTimestamp()
            .setMsg("duplicated data.");
    }
}
