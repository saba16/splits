package com.spendsplits.service;

import java.util.List;

import com.spendsplits.model.splits;

/**
 * @author saba
 *
 */

public interface splitsService {

	
	public List<splits> getList();

	public void splitedamount(String s, String amt);
	
	

}
