package br.com.sistema.Bean;

import java.io.Serializable;


import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CalendarBean implements Serializable {
	private Date data;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}