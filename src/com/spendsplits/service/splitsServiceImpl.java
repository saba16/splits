package com.spendsplits.service;

import com.spendsplits.model.splits;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spendsplits.dao.splitsDao;

/**
 * @author saba
 *
 */

@Service("splitsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class splitsServiceImpl implements splitsService {

	@Autowired
	private splitsDao splitsDao;

	public List<splits> getList() {
		return splitsDao.listnames();
	}

	public void splitedamount(String s, String amt) {
		splitsDao.splited(s, amt);
	}

}
