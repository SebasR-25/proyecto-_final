package pojo;

import java.util.List;

public class Response{
	private License license;
	private List<DataItem> data;
	private String lastUpdate;
	private String repository;

	public License getLicense(){
		return license;
	}

	public List<DataItem> getData(){
		return data;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public String getRepository(){
		return repository;
	}
}