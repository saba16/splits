package com.spendsplits.dao;

import java.util.List;

import com.spendsplits.model.splits;

/**
 * @author saba
 *
 */

public interface splitsDao {
	
	
	 public List<splits> listnames();
	public void splited(String s, String amt);

}
