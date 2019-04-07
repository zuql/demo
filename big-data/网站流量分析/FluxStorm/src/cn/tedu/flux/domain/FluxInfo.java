package cn.tedu.flux.domain;

import java.util.Random;

public class FluxInfo {
	private String url;
	private String urlname;
	private String ref;
	private String uagent;
	private String uvid;
	private String ssid;
	private String sscount;
	private String sstime;
	private String cip;
	
	public FluxInfo() {
	}

	public FluxInfo(String url, String urlname, String ref, String uagent, String uvid, String ssid, String sscount,
			String sstime, String cip) {
		this.url = url;
		this.urlname = urlname;
		this.ref = ref;
		this.uagent = uagent;
		this.uvid = uvid;
		this.ssid = ssid;
		this.sscount = sscount;
		this.sstime = sstime;
		this.cip = cip;
	}



	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlname() {
		return urlname;
	}
	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getUagent() {
		return uagent;
	}
	public void setUagent(String uagent) {
		this.uagent = uagent;
	}
	public String getUvid() {
		return uvid;
	}
	public void setUvid(String uvid) {
		this.uvid = uvid;
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public String getSscount() {
		return sscount;
	}
	public void setSscount(String sscount) {
		this.sscount = sscount;
	}
	public String getSstime() {
		return sstime;
	}
	public void setSstime(String sstime) {
		this.sstime = sstime;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	
	private String getRand(int len){
		Random rand = new Random();
		String result = "";
		for(int i = 0;i<len;i++){
			result = result + rand.nextInt(10);
		}
		return result;
	}
	
	public String getRk(){
		String rk = sstime+"_"+uvid+"_"+ssid+"_"+cip+"_";
		rk = rk + getRand(64 - rk.length());
		return rk;
	}
	
}
