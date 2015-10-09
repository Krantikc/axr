package com.axr.dao;

import java.util.List;

import com.axr.model.Block;
import com.axr.model.Dealer;

public interface DealersDAO {
	public boolean updateDealer(Dealer dealer);
	public int createDealer(Dealer dealer);
	public boolean deleteDealer(int dealerId);
	public List<Dealer> getDealers();
	
}
