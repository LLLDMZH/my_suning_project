package com.suning.common.entity;

import java.io.Serializable;

public class PictureUploadResult implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1205631978108586039L;
	
	//校验图片是否有误 0为正确 1为错误
	private Integer error;
    
    private String url;
    
    private String width;
    
    private String height;
    
    

	@Override
	public String toString() {
		return "PictureUploadResult [error=" + error + ", url=" + url
				+ ", width=" + width + ", height=" + height + "]";
	}

	public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    
    

}
