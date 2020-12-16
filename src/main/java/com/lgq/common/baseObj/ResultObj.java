package com.lgq.common.baseObj;

public class ResultObj {

	public int resultCode = 200;
	public String message;
	public Object data;

	public ResultObj(Integer resultCode, String message) {
        this.setResultCode(resultCode);
        this.setMessage(message);
    }

	public ResultObj(Object data) {
		this.setData(data);
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
