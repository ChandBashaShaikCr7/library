package com.konic.library.model;

import java.util.List;

public class PopulationResponse {
    private boolean error;
    private String msg;
    private List<CityData> data;

    public boolean isError() { return error; }
    public void setError(boolean error) { this.error = error; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public List<CityData> getData() { return data; }
    public void setData(List<CityData> data) { this.data = data; }
}
