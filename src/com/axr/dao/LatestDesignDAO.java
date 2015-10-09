package com.axr.dao;

import java.util.List;

import com.axr.model.LatestDesign;

public interface LatestDesignDAO {

	public boolean findLatestDesignById(int latestDesignId);
	public List<LatestDesign> getLatestDesigns();
	public int createLatestDesign(LatestDesign latestDesign);
	public boolean deleteLatestDesignById(int latestDesignId);
}
